package com.hr.recruitment.api.mapper;

import java.util.Date;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.dto.BaseDTO;
import com.hr.recruitment.api.entity.ApplicationEntity;
import com.hr.recruitment.api.entity.OfferEntity;

public class ObjectMapper {
	
	/**
	 * 
	 * @param application
	 * @return
	 */
	public ApplicationDTO mapApplicationEntityToDto(ApplicationEntity application) {
		ApplicationDTO dto = new ApplicationDTO();
		dto.setApplicationId(application.getApplicationId());
		dto.setCandidateEmail(application.getCandidateEmail());
		dto.setOfferId(application.getOffer().getOfferId());
		dto.setResumeText(application.getResumeText());
		dto.setStatus(application.getStatus().getStatus());
		return dto;
	}
	
	/**
	 * 
	 * @param baseDto
	 * @return
	 */
	public OfferEntity mapDtoToOfferEntity(BaseDTO baseDto) {
		OfferEntity offerEntity = new OfferEntity();
		offerEntity.setJobDescription(baseDto.getJobDescription());
		offerEntity.setJobTitle(baseDto.getJobTitle());
		offerEntity.setStartDate(new Date());
		return offerEntity;
	}
	
	

}
