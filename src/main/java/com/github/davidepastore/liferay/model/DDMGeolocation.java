package com.github.davidepastore.liferay.model;

/**
 * 
 * @author Christian Palombella
 * 
 */
public class DDMGeolocation {

	private Double latitude;
	private Double longitude;
	
	public DDMGeolocation() {
		super();
	}
	
	public DDMGeolocation(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}

}