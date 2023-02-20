package com.place.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "loc_dtls")
public class Location {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "place_name")
	private String placeName;
	
	@Column(name = "place_description")
	private String placeDesc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceDesc() {
		return placeDesc;
	}

	public void setPlaceDesc(String placeDesc) {
		this.placeDesc = placeDesc;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", placeName=" + placeName + ", placeDesc=" + placeDesc + "]";
	}
	
	
	
	
}
