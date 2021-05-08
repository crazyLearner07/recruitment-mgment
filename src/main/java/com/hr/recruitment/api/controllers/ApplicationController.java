package com.hr.recruitment.api.controllers;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.exception.BusinessValidationException;
import com.hr.recruitment.api.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/application")
@Api(tags="Recruitment APIs")
public class ApplicationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	ApplicationService applicationService;

	@PostMapping(value="/applyOffer/{offerId}")
	public ApplicationDTO applyOffer(@PathVariable(value="offerId") Long offerId, @RequestBody ApplicationDTO  applicationDto) throws BusinessValidationException {
		LOGGER.info("inside applyOffer method ");
		return applicationService.applyOffer(offerId, applicationDto);
	}
	
	@GetMapping(value="/applicationcount/{offerId}")
	public int findApplicationCount(@PathVariable(value="offerId") Long offerId){
		LOGGER.info("inside findApplicationCount method ");
		return applicationService.findApplicationCount(offerId);	
	}
	
	@GetMapping(value="/applications-per-offer/{offerId}")
	public List<ApplicationDTO> findApplicationsPerOffer(@PathVariable(value="offerId") Long offerId){
		LOGGER.info("inside findApplicationsPerOffer method ");
		return applicationService.findApplicationsPerOffer(offerId);	
	}
	
	@GetMapping(value="/workflow/{applicationId}")
	public String workFlow(@PathVariable(value="applicationId") Long applicationId, @RequestParam("status") String status) throws BusinessValidationException{
		LOGGER.info("inside workFlow method ");
		return applicationService.workFlow(applicationId, status);	
	}
	

}
