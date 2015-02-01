package com.fudfil.edelivery.common;

public class EDeliverySystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** flag to avoid multiple logging */
	protected boolean logged = false;

	/** associates the exception with an error key; */
	protected String errorKey = null;

	/**
	 * Exception Data.
	 */
	// protected ExceptionData exceptionData;

	/**
	 * Default Constructor
	 */
	public EDeliverySystemException() {
		super();
	}

	public EDeliverySystemException(Throwable cause) {
		super(cause);
	}

	public EDeliverySystemException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Tells if the exception has been logged or not.
	 * 
	 * @return <code>true</code> if the error has been logged <code>false</code>
	 *         otherwise
	 */
	public boolean isLogged() {
		return this.logged;
	}

	/**
	 * Marks the exception as logged.
	 * 
	 * @param logged
	 *            <code>true</code> for marking the exception as logged
	 *            <code>false</code> for marking the exception as not-logged.
	 */
	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder(this.getClass().getName() + ":");

		return sb.toString();
	}

	public EDeliverySystemException(String message) {
		super(message);
	}

}
