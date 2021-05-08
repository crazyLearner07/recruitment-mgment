package com.hr.recruitment.api.enums;

public enum ApplicationStatus {

	APPLIED("Applied"), INVITED("Invited"), REJECTED("Rejected"),  HIRED("Hired");
	
	private String taskStatus;
	
	private ApplicationStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public String getStatus() {
		return taskStatus;
	}
}
