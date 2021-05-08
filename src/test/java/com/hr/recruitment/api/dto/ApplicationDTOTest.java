package com.hr.recruitment.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.hr.recruitment.api.mock.factory.MockDataFactory;
import org.junit.Test;

public class ApplicationDTOTest {
	

	@Test
	public void testOfferDTO(){
		ApplicationDTO appDto = MockDataFactory.populateApplicationDtoValues();
		assertNotNull(appDto);
		assertEquals(Long.valueOf(1001), appDto.getApplicationId());
		assertEquals("himanshu@heavenhr.com", appDto.getCandidateEmail());
		assertEquals(Long.valueOf(2001), appDto.getOfferId());
		assertEquals("myresumeForHeavenHr", appDto.getResumeText());
		assertEquals("SUCCESS", appDto.getStatus());
		
	}
}
