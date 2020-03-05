package com.pitang.sms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ExceptionConflict extends Exception {
	private static final long serialVersionUID = 1l;
	public ExceptionConflict(String msg) {
		super(msg);
	}
}
