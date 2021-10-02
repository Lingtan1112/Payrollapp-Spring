//package in.lingtan.demounittesting.controller;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import in.lingtan.controller.EmployeeController;
//import in.lingtan.model.Employee;
//import in.lingtan.service.EmployeeService;
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//
//
//public class WebLayerTest {
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	EmployeeService employeeService;
//
//	@InjectMocks
//	EmployeeController employeeController;
//
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.openMocks(employeeController);
//	}
//
//	@Test
//	public void testLogin() throws Exception {
//		Employee userObj = new Employee();
//		userObj.setName("Lingtan Navis Anthoni samy");
//		userObj.setFirstName("Lingtan");
//
//		when(employeeService.addEmployee(any(Employee.class))).thenReturn(true);
//
//		String userJson = new ObjectMapper().writeValueAsString(userObj);
//
//		mockMvc.perform(
//				post("/employee/v1/RegisterEmployee").contentType(MediaType.APPLICATION_JSON).content(userJson))
//		.andExpect(status().isOk()).andExpect(jsonPath("$.infoMessage").value("Login successfuly"));
//	}
//
//	private Employee any(Class<Employee> class1) {
//
//		return null;
//	}
//
//	@Test
//	public void testInvalidLogin() throws Exception {
//		Employee userObj = new Employee();
//		userObj.setName("Lingtan Navis Anthoni samy");
//		userObj.setFirstName("Lingtan");
//		String userJson = new ObjectMapper().writeValueAsString(userObj);
//		mockMvc.perform(post("/api/v1/user/login").contentType(MediaType.APPLICATION_JSON).content(userJson))
//		.andExpect(status().isBadRequest()).andExpect(jsonPath("$.errorMessage").value("Invalid user"));
//	}
//
//
//
//}
