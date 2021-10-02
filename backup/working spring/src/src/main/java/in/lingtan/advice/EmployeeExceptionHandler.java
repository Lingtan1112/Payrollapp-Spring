package in.lingtan.advice;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import in.lingtan.exceptions.CannotGetCredentialException;
import in.lingtan.exceptions.CannotRegisterEmployeeException;
import in.lingtan.exceptions.EmployeeNotFoundException;
import in.lingtan.exceptions.EmptyStringException;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.exceptions.InValidEmailIDException;
import in.lingtan.exceptions.InvalidCredentialsException;
import in.lingtan.exceptions.InvalidEmployeeIdFormatException;
import in.lingtan.exceptions.InvalidEmployeeIdLengthException;
import in.lingtan.exceptions.InvalidFieldException;
import in.lingtan.exceptions.InvalidIntegerException;
import in.lingtan.exceptions.InvalidLongNumberTypeException;
import in.lingtan.exceptions.InvalidMobileNumberException;
import in.lingtan.exceptions.InvalidNumberLengthException;
import in.lingtan.exceptions.InvalidPasswordFormatException;
import in.lingtan.exceptions.NumberCannotBeNegativeException;
import in.lingtan.exceptions.PasswordDoNotMatchWithOldPasswordException;
import in.lingtan.model.EmployeeError;


@ControllerAdvice
public class EmployeeExceptionHandler {

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
	
    @ExceptionHandler(Exception.class)
	public ResponseEntity<EmployeeError> mapException(Exception e){
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		e.printStackTrace();
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);
	} 
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<EmployeeError> mapUnexpectedTypeException(UnexpectedTypeException e){
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ExistingEmployeeException.class)
	public ResponseEntity<EmployeeError> mapExistingEmployeeException(ExistingEmployeeException e){
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidMobileNumberException.class)
	public ResponseEntity<EmployeeError> mapInvalidMobileNumberException(InvalidMobileNumberException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidLongNumberTypeException.class)
	public ResponseEntity<EmployeeError> mapInvalidLongNumberTypeException(InvalidLongNumberTypeException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidIntegerException.class)
	public ResponseEntity<EmployeeError> mapInvalidIntegerException(InvalidIntegerException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidNumberLengthException.class)
	public ResponseEntity<EmployeeError> mapInvalidNumberLengthException(InvalidNumberLengthException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(CannotRegisterEmployeeException.class)
	public ResponseEntity<EmployeeError> mapCannotRegisterEmployeeException(CannotRegisterEmployeeException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<EmployeeError> mapInvalidFieldException(InvalidFieldException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeError> mapEmployeeNotFoundException(EmployeeNotFoundException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(EmptyStringException.class)
	public ResponseEntity<EmployeeError> mapEmptyStringException(EmptyStringException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<EmployeeError> mapInvalidCredentialsException(InvalidCredentialsException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidPasswordFormatException.class)
	public ResponseEntity<EmployeeError> mapInvalidPasswordFormatException(InvalidPasswordFormatException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InValidEmailIDException.class)
	public ResponseEntity<EmployeeError> mapInValidEmailIDException(InValidEmailIDException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidEmployeeIdFormatException.class)
	public ResponseEntity<EmployeeError> mapInvalidEmployeeIdFormatException(InvalidEmployeeIdFormatException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(PasswordDoNotMatchWithOldPasswordException.class)
	public ResponseEntity<EmployeeError> mapPasswordDoNotMatchWithOldPasswordException(PasswordDoNotMatchWithOldPasswordException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(CannotGetCredentialException.class)
	public ResponseEntity<EmployeeError> mapCannotGetCredentialException(CannotGetCredentialException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidEmployeeIdLengthException.class)
	public ResponseEntity<EmployeeError> mapInvalidEmployeeIdLengthException(InvalidEmployeeIdLengthException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(NumberCannotBeNegativeException.class)
	public ResponseEntity<EmployeeError> mapNumberCannotBeNegativeException(NumberCannotBeNegativeException e){
		
		EmployeeError employeeError = new EmployeeError(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(employeeError, HttpStatus.BAD_REQUEST);

	}
}