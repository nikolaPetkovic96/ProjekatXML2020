package com.example.LoginReg.model;

public class PermissionsDTO {
	
	private boolean allowedToCommend, allowedToMessage,allowedToMakeReservation=true;
	private String status;
	
	public PermissionsDTO() {
		super();
	}

	public PermissionsDTO(boolean allowedToCommend, boolean allowedToMessage, boolean allowedToMakeReservation,String status) {
		super();
		this.allowedToCommend = allowedToCommend;
		this.allowedToMessage = allowedToMessage;
		this.allowedToMakeReservation = allowedToMakeReservation;
		this.status = status;
	}

	public boolean isAllowedToCommend() {
		return allowedToCommend;
	}

	public void setAllowedToCommend(boolean allowedToCommend) {
		this.allowedToCommend = allowedToCommend;
	}

	public boolean isAllowedToMessage() {
		return allowedToMessage;
	}

	public void setAllowedToMessage(boolean allowedToMessage) {
		this.allowedToMessage = allowedToMessage;
	}

	public boolean isAllowedToMakeReservation() {
		return allowedToMakeReservation;
	}

	public void setAllowedToMakeReservation(boolean allowedToMakeReservation) {
		this.allowedToMakeReservation = allowedToMakeReservation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
