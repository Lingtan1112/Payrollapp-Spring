package in.lingtan.model;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "user_data")
@JsonInclude(value = Include.NON_NULL)

public class User {

	@Id
	private Long id;

	@NotEmpty(message = "Username Cannot be Empty")
	@NotNull(message = "Username Cannot be Empty")
	@Column("username")
	private String userName;


	@NotEmpty(message = "Username Cannot be Empty")
	@NotNull(message = "Password Cannot be Empty")
	@Column("password")
	private String password;

	private String confirmPassword;
	@Column("modifiedDate")
	private LocalDate passwordModifiedDate;
}
