package com.hr.recruitment.api.mock.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.dto.OfferDTO;
import com.hr.recruitment.api.entity.ApplicationEntity;
import com.hr.recruitment.api.entity.OfferEntity;
import com.hr.recruitment.api.enums.ApplicationStatus;

/**
 * This class takes care of all dummy data required for Junit test cases
 * @author Himanshu
 *
 */
public class MockDataFactory {
	
	public static OfferEntity getOfferEntity(){
		OfferEntity offerEntity = new OfferEntity();
		offerEntity.setJobDescription("Technical lead");
		offerEntity.setJobTitle("TL");
		offerEntity.setOfferId(Long.valueOf(1234));
		offerEntity.setStartDate(new Date());
		return offerEntity;
	}
	
	public static Long getNoOfApplicants(){
		return Long.valueOf(20);
	}
	
	public static List<ApplicationEntity> getByOfferId(){
		List<ApplicationEntity> appList = new ArrayList<>();
		OfferEntity offerEntity = new OfferEntity();
		offerEntity.setOfferId(10023L);
		ApplicationEntity appEntity = new ApplicationEntity();
		appEntity.setApplicationId(10023L);
		appEntity.setCandidateEmail("himanshu@myhr.com");
		appEntity.setResumeText("my resume text");
		appEntity.setStatus(ApplicationStatus.APPLIED);
		appEntity.setOffer(offerEntity);
		appList.add(appEntity);
		return appList;
	}
	
	public static List<OfferEntity> getAllOfferEntityData(){
		List<OfferEntity> offerList = new ArrayList<>();
		OfferEntity offerEntity = new OfferEntity();
		offerEntity.setOfferId(10023L);
		offerEntity.setJobDescription("Senior Engineer");
		offerEntity.setJobTitle("SE");
		offerEntity.setStartDate(new Date());
		offerList.add(offerEntity);
		return offerList;
	}
	
	
		public static ApplicationEntity  getApplicationEntityData(){
			ApplicationEntity appEntity = new ApplicationEntity();
			appEntity.setApplicationId(10023L);
			appEntity.setCandidateEmail("himanshu@myhr.com");
			appEntity.setResumeText("my resume text");
			appEntity.setStatus(ApplicationStatus.APPLIED);
			return appEntity;
		}
		
		public static OfferDTO populateOfferDtoValues() {
			OfferDTO offerDto = new OfferDTO();
			offerDto.setJobDescription("project manager");
			offerDto.setJobTitle("PM");
			offerDto.setNoOfApplicants(23);
			offerDto.setOfferId(1001L);
			offerDto.setStartDate(new Date());
			return offerDto;
		}
		
		
		public static ApplicationDTO populateApplicationDtoValues() {
			ApplicationDTO appDto = new ApplicationDTO();
			appDto.setApplicationId(1001L);
			appDto.setCandidateEmail("himanshu@heavenhr.com");
			appDto.setOfferId(2001L);
			appDto.setResumeText("myresumeForHeavenHr");
			appDto.setStatus("SUCCESS");
			return appDto;
		}
		
		
		public static ApplicationDTO getApplicationDTO(){
			ApplicationDTO appDTO = new ApplicationDTO();
			appDTO.setApplicationId(10001L);
			appDTO.setCandidateEmail("himanshu@heavenhr.com");
			appDTO.setResumeText("Resume");
			appDTO.setStatus("Applied");
			return appDTO;
		}
		
		

}
