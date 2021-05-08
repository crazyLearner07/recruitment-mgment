package com.hr.recruitment.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import com.hr.recruitment.api.mock.factory.MockDataFactory;
import org.junit.Test;

public class OfferDTOTest {
	
	@Test
	public void testOfferDTO(){
		OfferDTO offerDto = MockDataFactory.populateOfferDtoValues();
		assertNotNull(offerDto);
		assertEquals("project manager", offerDto.getJobDescription());
		assertEquals("PM", offerDto.getJobTitle());
		assertEquals(23, offerDto.getNoOfApplicants());
		assertEquals(Long.valueOf(1001), offerDto.getOfferId());
		assertEquals(new Date(), offerDto.getStartDate());
		
	}
	
	
	
	
}
