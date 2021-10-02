package in.lingtan.advice;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import in.lingtan.exceptions.CannotGetCredentialException;
import in.lingtan.exceptions.CannotRegisterEmployeeException;
import in.lingtan.exceptions.EmployeeAlreadyActiveException;
import in.lingtan.exceptions.EmployeeInactiveException;
import in.lingtan.exceptions.EmployeeNotFoundException;
import in.lingtan.exceptions.EmptyStringException;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.exceptions.InValidEmailIDException;
import in.lingtan.exceptions.InvalidCredentialsException;
import in.lingtan.exceptions.InvalidEmployeeIdException;
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
import in.lingtan.model.Message;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Message> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		Message error = new Message("validation error", null);
		for (FieldError fieldError : fieldErrors) {
			error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Message> mapException(Exception e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		e.printStackTrace();
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Message> mapUnexpectedTypeException(UnexpectedTypeException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<Message> mapUnexpectedTypeException(InvalidEmployeeIdException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ExistingEmployeeException.class)
	public ResponseEntity<Message> mapExistingEmployeeException(ExistingEmployeeException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeAlreadyActiveException.class)
	public ResponseEntity<Message> mapEmployeeAlreadyActiveException(EmployeeAlreadyActiveException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeInactiveException.class)
	public ResponseEntity<Message> mapEmployeeInactiveException(EmployeeInactiveException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidMobileNumberException.class)
	public ResponseEntity<Message> mapInvalidMobileNumberException(InvalidMobileNumberException e) {

		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidLongNumberTypeException.class)
	public ResponseEntity<Message> mapInvalidLongNumberTypeException(InvalidLongNumberTypeException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidIntegerException.class)
	public ResponseEntity<Message> mapInvalidIntegerException(InvalidIntegerException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidNumberLengthException.class)
	public ResponseEntity<Message> mapInvalidNumberLengthException(InvalidNumberLengthException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CannotRegisterEmployeeException.class)
	public ResponseEntity<Message> mapCannotRegisterEmployeeException(CannotRegisterEmployeeException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<Message> mapInvalidFieldException(InvalidFieldException e) {

		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Message> mapEmployeeNotFoundException(EmployeeNotFoundException e) {

		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(EmptyStringException.class)
	public ResponseEntity<Message> mapEmptyStringException(EmptyStringException e) {

		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Message> mapInvalidCredentialsException(InvalidCredentialsException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidPasswordFormatException.class)
	public ResponseEntity<Message> mapInvalidPasswordFormatException(InvalidPasswordFormatException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InValidEmailIDException.class)
	public ResponseEntity<Message> mapInValidEmailIDException(InValidEmailIDException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(InvalidEmployeeIdFormatException.class)
	public ResponseEntity<Message> mapInvalidEmployeeIdFormatException(InvalidEmployeeIdFormatException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(PasswordDoNotMatchWithOldPasswordException.class)
	public ResponseEntity<Message> mapPasswordDoNotMatchWithOldPasswordException(
			PasswordDoNotMatchWithOldPasswordException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CannotGetCredentialException.class)
	public ResponseEntity<Message> mapCannotGetCredentialException(CannotGetCredentialException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}
	

	@ExceptionHandler(InvalidEmployeeIdLengthException.class)
	public ResponseEntity<Message> mapInvalidEmployeeIdLengthException(InvalidEmployeeIdLengthException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NumberCannotBeNegativeException.class)
	public ResponseEntity<Message> mapNumberCannotBeNegativeException(NumberCannotBeNegativeException e) {
		Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(DbActionExecutionException.class)
	public ResponseEntity<Message> mapDuplicateKeyException(DbActionExecutionException e) {
	
		Message message = new Message(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		
		return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<Message> mapDuplicateKeyException(DuplicateKeyException e) {
		
		Message message = new Message(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		
		return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Message> mapDataIntegrityViolationException(DataIntegrityViolationException e) {
		
		Message message = new Message(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	
		return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
	}
	

}