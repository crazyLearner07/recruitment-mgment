package com.hr.recruitment.api.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.entity.ApplicationEntity;
import com.hr.recruitment.api.enums.ApplicationStatus;
import com.hr.recruitment.api.exception.BusinessValidationException;
import com.hr.recruitment.api.mapper.ObjectMapper;
import com.hr.recruitment.api.repositories.ApplicationEntityRepository;
import com.hr.recruitment.api.repositories.OfferEntityRepository;
import com.hr.recruitment.api.service.ApplicationService;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	ApplicationEntityRepository applicationRepository;

	@Autowired
	OfferEntityRepository offerRepository;

	/**
	 * @param offerId
	 * @param applicationDto
	 * 
	 */
	@Override
	public ApplicationDTO applyOffer(Long offerId, ApplicationDTO applicationDto) throws BusinessValidationException {
		ApplicationDTO dto = null;
		ApplicationEntity applicationEntity = null;
		ObjectMapper mapper = new ObjectMapper();
		 applicationEntity = applicationRepository
				.findByOfferOfferIdAndCandidateEmail(offerId, applicationDto.getCandidateEmail());
		if (null == applicationEntity) {
			applicationEntity = setApplicationDetails(applicationDto);
			applicationEntity.setOffer(offerRepository.findOne(offerId));
			dto = mapper.mapApplicationEntityToDto(applicationRepository.save(applicationEntity));
		} else {
			throw new BusinessValidationException("user has already applied for this job offer");
		}
		return dto;
	}

	/**
	 * @param offerId
	 * 
	 */
	@Override
	public int findApplicationCount(Long offerId) {
		Long noOfApplicants = applicationRepository.countByOfferOfferId(offerId);
		return (null != noOfApplicants ? noOfApplicants.intValue() : 0);
	}
	/**
	 * @param offerId
	 * 
	 */
	@Override
	public List<ApplicationDTO> findApplicationsPerOffer(Long offerId) {
		List<ApplicationDTO> dtos = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		List<ApplicationEntity> applications = applicationRepository.findByOfferOfferId(offerId);
		for(ApplicationEntity application : applications){
			dtos.add(mapper.mapApplicationEntityToDto(application));
		}
		return dtos;
	}
	/**
	 * @param applicationId
	 * @param status
	 * @return String message after status update
	 */
	@Override
	public String workFlow(Long applicationId, String status) throws BusinessValidationException {
		if(null!= applicationId && null!= status){
			String mailId = null;
			for(ApplicationStatus appStatus : ApplicationStatus.values()){
				if(appStatus.getStatus().equalsIgnoreCase(status)){
					break;
				}else {
					throw new BusinessValidationException("Provided status does not belong to valid status category!");
				}
			}
			mailId = fetchApplicationMailById(applicationId);
			sendNotification(null!=mailId ? mailId : "hr@auto1.com");
		} else {
			new BusinessValidationException("application id and status can not be null!");
		}
		return "Status successfully updated";
	}

	private String fetchApplicationMailById(Long applicationId) throws BusinessValidationException {
		String mailId =null;
		Optional<ApplicationEntity> optionalAppEntity = Optional.ofNullable(applicationRepository.findOne(applicationId));
		if(optionalAppEntity.isPresent()){
			mailId = optionalAppEntity.get().getCandidateEmail();
		} else {
			throw new BusinessValidationException("Provided application Id does not exist!");
		}
		return mailId;
	}

	private void sendNotification(String emailId) {
		LOGGER.info("\n Mail sent to :-" + emailId + "candidate on appliation status change");
	}

	private ApplicationEntity setApplicationDetails(ApplicationDTO applicationDto) {
		ApplicationEntity application = new ApplicationEntity();
		application.setCandidateEmail(applicationDto.getCandidateEmail());
		application.setResumeText(applicationDto.getResumeText());
		application.setStatus(ApplicationStatus.APPLIED);
		return application;
	}

}
