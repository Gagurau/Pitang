package com.pitang.sms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST)
public class ExceptionBadRequest extends Exception {
	private static final long serialVersionUID = 1l;
	public ExceptionBadRequest(String msg) {
		super(msg);
	}
}
