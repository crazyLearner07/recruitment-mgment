package com.hr.recruitment.api.dto;

import java.io.Serializable;
import java.util.Date;

public class OfferDTO extends BaseDTO implements Serializable{
	
	private static final long serialVersionUID = 4399606090845613184L;

	private Long offerId;
	
	private Date startDate;
	
	private int noOfApplicants;
	
	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public int getNoOfApplicants() {
		return noOfApplicants;
	}

	public void setNoOfApplicants(int noOfApplicants) {
		this.noOfApplicants = noOfApplicants;
	}
	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	

	
	
	
}
