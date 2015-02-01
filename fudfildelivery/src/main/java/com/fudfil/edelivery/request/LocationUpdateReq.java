package com.fudfil.edelivery.request;

import java.io.Serializable;

import com.fudfil.edelivery.common.Location;

public class LocationUpdateReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String emailId;
	Location location;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
