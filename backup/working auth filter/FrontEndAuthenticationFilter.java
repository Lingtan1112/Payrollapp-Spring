package in.lingtan.servlet;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This Java filter demonstrates how to intercept the request
 * and transform the response to implement authentication feature
 * for the website's front-end.
 *
 */
@WebFilter("/*")
public class FrontEndAuthenticationFilter implements Filter {

	private HttpServletRequest httpRequest;

	public FrontEndAuthenticationFilter() {
	}


	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	private static final String[] loginRequiredURLs = { "/employeePortal.jsp",
			"/registerEmployee.jsp", "/adminPortal.jsp", "/displayAllEmployees.jsp",
			"/displayIndividualEmployeeData.jsp", "/addSalary.jsp",
			"/changePassword.jsp", "/paySlipOfEmployee.jsp" };

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		httpRequest = (HttpServletRequest) request;

		System.out.println("doFilter");
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (path.startsWith("/AdminLogin")) {
			System.out.println("pathStartsWith");
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = httpRequest.getSession(false);

		boolean isLoggedIn = (session != null && session.getAttribute("ADMIN_ID") != null);

		String loginURI = httpRequest.getContextPath() + "/adminLogin.jsp";
		boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean isLoginPage = httpRequest.getRequestURI().endsWith("adminLogin.jsp");

		if (isLoggedIn && (isLoginRequest || isLoginPage)) {
			System.out.println("Already Logged in");
			httpRequest.getRequestDispatcher("/adminPortal.jsp").forward(request, response);

		} else if (!isLoggedIn && isLoginRequired()) {
			System.out.println("Not Logged in");
			String loginPage = "/adminLogin.jsp";
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		} else {

			chain.doFilter(request, response);
		}
	}

	private boolean isLoginRequired() {
		String requestURL = httpRequest.getRequestURL().toString();

		for (String loginRequiredURL : loginRequiredURLs) {
			System.out.println("Login required");
			if (requestURL.contains(loginRequiredURL)) {
				return true;
			}
		}
		return false;
	}


}