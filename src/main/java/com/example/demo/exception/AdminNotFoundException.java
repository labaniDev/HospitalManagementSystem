package com.example.demo.exception;

public class AdminNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException() {
	}

	public AdminNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdminNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdminNotFoundException(String message) {
		super(message);
	}

	public AdminNotFoundException(Throwable cause) {
		super(cause);
	}

	public AdminNotFoundException(Long id) {
		super("Admin not found with id ---" + id);
	}

}
