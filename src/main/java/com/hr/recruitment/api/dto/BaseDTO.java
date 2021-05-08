package com.hr.recruitment.api.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {
	
	
	private static final long serialVersionUID = -8523577042993262459L;
	

	private String jobTitle;

	private String jobDescription;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
}
