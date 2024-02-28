package com.example.demo.exception;

public class AdminNotUpdatedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotUpdatedException() {
	}
	public AdminNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AdminNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}
	public AdminNotUpdatedException(String message) {
		super(message);
	}
	public AdminNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	public AdminNotUpdatedException(Long id) {
		super("Admin not updated with id ---"+id);
	}

}
