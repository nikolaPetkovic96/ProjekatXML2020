package com.team32.AgentApp.security.exception;

public class ResourceConflictException extends RuntimeException {
	private static final long serialVersionUID = 1791564636123821405L;

	private Long resourceId;

	public ResourceConflictException(Long resourceId, String message) {
		super(message);
		this.setResourceId(resourceId);
		System.out.println("Usao u resourceConflictException!");
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

}
