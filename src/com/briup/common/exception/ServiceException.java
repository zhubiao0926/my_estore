package com.briup.common.exception;

/**
 * 自定义异常类
 * */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
