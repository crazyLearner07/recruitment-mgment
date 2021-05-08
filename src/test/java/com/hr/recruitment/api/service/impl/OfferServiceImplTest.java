package com.hr.recruitment.api.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.hr.recruitment.api.dto.OfferDTO;
import com.hr.recruitment.api.exception.BusinessValidationException;
import com.hr.recruitment.api.mock.factory.MockDataFactory;
import com.hr.recruitment.api.repositories.ApplicationEntityRepository;
import com.hr.recruitment.api.repositories.OfferEntityRepository;

@RunWith(PowerMockRunner.class)
public class OfferServiceImplTest {
	
	@InjectMocks
	OfferServiceImpl  offerService;
	
	
	@Mock
	OfferEntityRepository offerRepository;
	
	@Mock
	ApplicationEntityRepository applicationRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testGetOfferDetail() throws BusinessValidationException {
		PowerMockito.when(offerRepository.findOne(Matchers.anyLong())).thenReturn(MockDataFactory.getOfferEntity());
		OfferDTO offerDto = offerService.getOfferDetail(Long.valueOf(1234));
		assertEquals("Technical lead", offerDto.getJobDescription());
		assertEquals("TL", offerDto.getJobTitle());
	}
	
	/**
	 * check for exception scenario
	 * @throws BusinessValidationException
	 */
	@Test(expected = BusinessValidationException.class)
	public void testGetOfferDetail_Exception() throws BusinessValidationException {
		offerService.getOfferDetail(null);
		
	}
	
	
	@Test
	public void testGetAllOfferDetails() {
		PowerMockito.when(offerRepository.findAll()).thenReturn(MockDataFactory.getAllOfferEntityData());
		List<OfferDTO> offerDtoList = offerService.getAllOfferDetails();
		OfferDTO offerDto = offerDtoList.get(0);
		assertEquals("Senior Engineer", offerDto.getJobDescription());
		assertEquals("SE", offerDto.getJobTitle());
	}
	
	/**
	 * Junit for private method
	 * @throws Exception
	 */
	@Test
	public void testGetOfferDtoDetails() throws Exception {
		PowerMockito.when(applicationRepository.countByOfferOfferId(Matchers.anyLong())).thenReturn(1l);
		OfferDTO offerDto = Whitebox.invokeMethod(offerService, MockDataFactory.getOfferEntity());
		Assert.assertNotNull(offerDto);
		assertEquals("TL", offerDto.getJobTitle());
	}
	
}
