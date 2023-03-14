package com.lti.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class ErrorDetails {
	
	private String title;
	private int status;
	private String detail;
	private long timeStamp;
	private String developerMessage;
	
	private Map<String, List<ValidationError>> errors = new HashMap<>();
}
