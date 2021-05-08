package com.hr.recruitment.api.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.exception.BusinessValidationException;
import com.hr.recruitment.api.mock.factory.MockDataFactory;
import com.hr.recruitment.api.repositories.ApplicationEntityRepository;

@RunWith(PowerMockRunner.class)
public class ApplicationServiceImplTest {
	
	@InjectMocks
	ApplicationServiceImpl  applicationService;
	
	@Mock
	ApplicationEntityRepository applicationRepository;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindApplicationCount() {
		PowerMockito.when(applicationRepository.countByOfferOfferId(Matchers.anyLong())).thenReturn(MockDataFactory.getNoOfApplicants());
		int count = applicationService.findApplicationCount(Long.valueOf(1234));
		assertEquals(20L, count);
	}
	
	
	@Test
	public void testFindApplicationsPerOffer() {
		PowerMockito.when(applicationRepository.findByOfferOfferId(Matchers.anyLong())).thenReturn(MockDataFactory.getByOfferId());
		List<ApplicationDTO> appList = applicationService.findApplicationsPerOffer(10023L);
		assertNotNull(appList);
		ApplicationDTO appDto = appList.get(0);
		assertEquals(Long.valueOf(10023), appDto.getApplicationId());
		assertEquals("himanshu@myhr.com", appDto.getCandidateEmail());
		
	}
	
	@Test
	public void testWorkFlow() throws BusinessValidationException {
		PowerMockito.when(applicationRepository.findOne(Matchers.anyLong())).thenReturn(MockDataFactory.getApplicationEntityData());
		String  workFlowMsg = applicationService.workFlow(Long.valueOf(1234), "APPLIED");
		assertEquals("Status successfully updated", workFlowMsg);
	}
	
	
}
