package com.fudfil.edelivery.common;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SLocation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2903600242689645148L;
	String latitude;
	String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
