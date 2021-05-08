package com.hr.recruitment.api.service;

import java.util.List;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.exception.BusinessValidationException;

public interface ApplicationService {

	ApplicationDTO applyOffer(Long offerId, ApplicationDTO applicationDto) throws BusinessValidationException;

	int findApplicationCount(Long offerId);

	List<ApplicationDTO> findApplicationsPerOffer(Long offerId);

	String workFlow(Long applicationId, String status) throws BusinessValidationException;

}
