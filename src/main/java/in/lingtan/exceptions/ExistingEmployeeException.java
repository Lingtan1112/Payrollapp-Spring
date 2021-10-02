//package in.lingtan.exceptions;
//
//public class ExistingEmployeeException extends Exception {
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public ExistingEmployeeException(String message) {
//		super(message);
//
//	}
//
//
//}
/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package in.lingtan.exceptions;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import in.lingtan.model.Message;

/**
 * Exception to be thrown when validation on an argument annotated with
 * {@code @Valid} fails. Extends {@link BindException} as of 5.3.
 *
 * @author Rossen Stoyanchev
 * @author Juergen Hoeller
 * @since 3.1
 */
@SuppressWarnings("serial")
public class ExistingEmployeeException extends Exception {

	private final Message message;

	/**
	 * Constructor for {@link MethodArgumentNotValidException}.
	 *
	 * @param parameter     the parameter that failed validation
	 * @param bindingResult the results of the validation
	 */
	public ExistingEmployeeException(Message message) {
		super();
		this.message = message;
	}

	/**
	 * Return the method parameter that failed validation.
	 */
	public final Message getParameter() {
		return this.message;
	}

	@Override
	public String getMessage() {
		return message.toString();
	}

}
