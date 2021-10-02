package in.lingtan.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.time.LocalDate;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@JsonInclude(value = Include.NON_NULL)
@Table(value = "employee_data")
public class Employee {

	
	
	
	private String name;
	
	
	@NotNull(message="FirstName cannot be Null")
	@NotEmpty(message="FirstName cannot be Empty")
	@Column("first_name")
	private String firstName;
	
	
	@NotEmpty(message="LastName cannot be Empty")
	@NotNull(message="LastName cannot be Null")
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
	
	@Min(value=0000000000L,message="Mobile Number must be 10-Digits") @Max(value=9999999999L,message="Mobile Number must be 10-Digits")
	@Column("mobile_number")
	private long mobileNumber;
	
	
	@Past(message="Joining Date cannot be a Future Date")
	@Column("joined_date")
	private LocalDate joiningDate;
	
	
	@Column("active_status")
	private int activeStatus;
	
	
}
