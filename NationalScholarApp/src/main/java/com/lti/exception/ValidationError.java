package com.lti.exception;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ValidationError {
	 private String code;
	 private String message;
}
