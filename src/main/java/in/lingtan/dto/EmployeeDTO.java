package in.lingtan.dto;


import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import in.lingtan.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@ToString
@JsonInclude(value = Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {

	@Id
	@GeneratedValue
	@Column("s_no")
	private int sNo;

	@Column("name")
	private String name;


	@NotNull(message = "First Name cannot be Null")
	@NotEmpty(message = "First Name cannot be Empty")
	@Size(min=3,message="Invalid First Name Length")
	@Column("first_name")
	private String firstName;


	@NotEmpty(message = "Last Name cannot be Empty")
	@NotNull(message = "Last Name cannot be Null")
	@Size(min=3,message="Invalid Last Name Length")
	@Column("last_name")
	private String lastName;

	@NotEmpty(message="Role cannot be Empty")
	@NotNull(message="Role cannot be Empty")
	private String role;


	@NotNull(groups = Employee.class)
	@Column("employee_id")
	@Id
	private String employeeID;


	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp = "^(?=.*[0-9])\" + \"(?=.*[a-z])(?=.*[A-Z])\" + \"(?=.*[@#$%^&+=])\" + \"(?=\\\\S+$).{8,15}$", message = "Invalid Password")
	@JsonIgnoreProperties("password")
	private String password;


	@Column("email_id")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Invalid Email-ID")
	private String email;


	@Past(message="DOB cannot be a Future Date")
	@Column("dob")
	private LocalDate dob;

	@NotNull(message="Gender cannot be Empty")
	private String gender;

	@Digits(integer = 10, fraction = 0, message = "Invalid Mobile Number Length")
	@Range(min = 1000000000L, max = 9999999999L, message = "Mobile Number must be 10-Digits")
	@Column("mobile_number")
	private long mobileNumber;

	@PastOrPresent(message="Joining Date cannot be a Future Date")
	@Column("joined_date")
	private LocalDate joiningDate;

	@Column("active_status")
	private int activeStatus;



}
