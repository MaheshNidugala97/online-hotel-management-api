package com.sdp.hms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Entity
@Table(name = "parking")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vehicle_type", nullable = false)
	private String vehicleType;

	@Column(nullable = false)
	private Double price;

	public Parking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parking(String vehicleType) {
		super();
		this.vehicleType = vehicleType;
	}

	public Parking(Long id, String vehicleType, Double price) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Parking [id=" + id + ", vehicleType=" + vehicleType + ", price=" + price + "]";
	}

}
