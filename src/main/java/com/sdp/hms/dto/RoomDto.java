package com.sdp.hms.dto;


/**
 * 
 * @author mahesh nidugala
 *
 */


public class RoomDto {
	
    private Integer roomNo;
	
	private Boolean isActive;

	private Boolean isInventoryAvailable;

	private Boolean isCleaned;

	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDto(Integer roomNo, Boolean isActive, Boolean isInventoryAvailable, Boolean isCleaned) {
		super();
		this.roomNo = roomNo;
		this.isActive = isActive;
		this.isInventoryAvailable = isInventoryAvailable;
		this.isCleaned = isCleaned;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsInventoryAvailable() {
		return isInventoryAvailable;
	}

	public void setIsInventoryAvailable(Boolean isInventoryAvailable) {
		this.isInventoryAvailable = isInventoryAvailable;
	}

	public Boolean getIsCleaned() {
		return isCleaned;
	}

	public void setIsCleaned(Boolean isCleaned) {
		this.isCleaned = isCleaned;
	}

	@Override
	public String toString() {
		return "RoomDto [roomNo=" + roomNo + ", isActive=" + isActive + ", isInventoryAvailable=" + isInventoryAvailable
				+ ", isCleaned=" + isCleaned + "]";
	}
	
	


}
