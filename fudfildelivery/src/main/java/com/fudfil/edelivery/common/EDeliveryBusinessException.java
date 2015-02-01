package com.fudfil.edelivery.common;

public class EDeliveryBusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public EDeliveryBusinessException() {
		super();
	}

	public EDeliveryBusinessException(Throwable cause) {
		super(cause);
	}

	public EDeliveryBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public EDeliveryBusinessException(String message) {
		super(message);
	}

	public EDeliveryBusinessException(String errorKey, String message,
			Throwable cause) {
		super(message, cause);

	}

	public EDeliveryBusinessException(String errorKey, String message) {
		this(errorKey, message, null);
	}
}
