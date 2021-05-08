package com.hr.recruitment.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hr.recruitment.api.enums.ApplicationStatus;

@Entity
@Table(name="APPLICATION")
public class ApplicationEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPLICATION_ID")
	private Long applicationId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OFFER_ID")
	private OfferEntity offer;
	
	@Column(name="EMAIL")
	private String candidateEmail;
	
	@Lob
	@Column(name="RESUME_TEXT")
	private String resumeText;
	
	@Column(name="STATUS")
	private ApplicationStatus status;

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public OfferEntity getOffer() {
		return offer;
	}

	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getResumeText() {
		return resumeText;
	}

	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	
}
