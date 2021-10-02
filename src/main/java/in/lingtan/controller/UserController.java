package in.lingtan.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.lingtan.model.User;
import in.lingtan.service.UserService;

@RestController
@Controller
@RequestMapping("user/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("ValidateUser")
	public boolean validateUser(@Valid @RequestBody User user, HttpSession session) {
		boolean isValid = userService.employeeLoginValidation(user);
		if(isValid) {
			session.setAttribute("ADMIN", user.getUserName());
		}

		return isValid;
	}

	@GetMapping("LogoutUser")
	public boolean logoutUser(HttpSession session) {
		session.invalidate();
		return true;
	}

}
