package in.lingtan.advice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.lingtan.model.EmployeeError;

public class HibernateExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ResponseBody
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<EmployeeError> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
	        EmployeeError error = new EmployeeError("validation error", null);
	        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
	            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
	        }
	    	return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
}
