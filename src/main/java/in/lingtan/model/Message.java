package in.lingtan.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value=Include.NON_NULL)
public class Message {


	private String employeeId;

	private String errorSource;

	private String errorMessage;

	private HttpStatus errorCode;

	private List<FieldError> errorMessages = new ArrayList<>();

	public void addFieldError(String field, String defaultMessage) {
		FieldError error = new FieldError(field, defaultMessage, defaultMessage);
		errorMessages.add(error);
	}

	public Message(String errorMessage, HttpStatus errorCode) {
		super();
		this.employeeId = "";
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public Message(String errorMessage, String employee, HttpStatus errorCode) {
		super();
		this.employeeId = employee;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}



}
