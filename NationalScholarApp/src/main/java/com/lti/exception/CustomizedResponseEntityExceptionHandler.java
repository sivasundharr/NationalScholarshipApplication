package com.lti.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler 
	   extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> 
	handleAllExceptions(Exception ex,WebRequest request) throws Exception{
		HttpStatus statusEnum = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(new Date().getTime());
		errorDetails.setStatus(statusEnum.value());
		errorDetails.setTitle("Internal Server error");
		errorDetails.setDetail(ex.getMessage());
		errorDetails.setDeveloperMessage(ex.getClass().getName());
		if(ex instanceof ResponseStatusException) {
			var e = (ResponseStatusException)ex;
			statusEnum = e.getStatus();
			errorDetails.setStatus(statusEnum.value());
			errorDetails.setTitle(e.getReason());
		}
		return new ResponseEntity<ErrorDetails>(errorDetails,statusEnum);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<?> 
	handleUserNotFoundExceptions(ResourceNotFoundException resourceNotFound,
			HttpServletRequest request) throws Exception{
		
		ErrorDetails errorDetail = new ErrorDetails();
		errorDetail.setTimeStamp(new Date().getTime());
		errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetail.setTitle("User Not Found");
		errorDetail.setDetail(resourceNotFound.getMessage());
		errorDetail.setDeveloperMessage(resourceNotFound.getClass().getName());
		return new ResponseEntity<>(errorDetail,null,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, 
			HttpStatus status, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(new Date().getTime());
		errorDetails.setTitle("Validation Failed");
		errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
		String  requestPath  = (String) request.getAttribute("javax.servlet.error.request_uri",0);
		if(requestPath==null) {
			requestPath = ((ServletWebRequest)request).getRequest().getRequestURI();
		}
		errorDetails.setDetail("Input Validation Failed");
		errorDetails.setDeveloperMessage(ex.getClass().getName());
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for(FieldError fieldError:fieldErrors) {
			
			List<ValidationError> validationErrorList = errorDetails.getErrors()
					.get(fieldError.getField());
			if(validationErrorList == null) {
				validationErrorList = new ArrayList<ValidationError>();
			}
			
			errorDetails.getErrors()
			.put(fieldError.getField(),validationErrorList);
		
			ValidationError validationError = new ValidationError();
			validationError.setCode(fieldError.getCode());
			validationError.setMessage(fieldError.getDefaultMessage());
			validationErrorList.add(validationError);
		}
		return handleExceptionInternal(ex,errorDetails,headers,status,request);
	}
	

}
