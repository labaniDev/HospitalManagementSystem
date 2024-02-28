package com.example.demo.exception;

public class AdminNotDeletedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotDeletedException() {
	}
	public AdminNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AdminNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}
	public AdminNotDeletedException(String message) {
		super(message);
	}
	public AdminNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	public AdminNotDeletedException(Long id) {
		super("Admin not deleted with id ---"+id);
	}

}
