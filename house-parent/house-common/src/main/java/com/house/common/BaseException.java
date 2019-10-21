package com.house.common;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {
private String errorMessage;
public BaseException() {}
public BaseException(String errorMessage) {
	super();
	this.errorMessage = errorMessage;
}
}
