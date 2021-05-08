package com.hr.recruitment.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hr.recruitment.api.dto.ApplicationDTO;
import com.hr.recruitment.api.mock.factory.MockDataFactory;
import com.hr.recruitment.api.service.ApplicationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApplicationControllerTest {

	@InjectMocks
	ApplicationController appController;

	@Mock
	ApplicationService applicationServiceImpl;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
	}


	@Test
	public void testApplyOffer() throws Exception {
		PowerMockito.when(applicationServiceImpl.applyOffer(Matchers.anyLong(), Matchers.<ApplicationDTO>any())).thenReturn(MockDataFactory.getApplicationDTO());
		ApplicationDTO appDto = appController.applyOffer(10001L, MockDataFactory.getApplicationDTO());
		assertNotNull(appDto);
		assertEquals("himanshu@heavenhr.com",appDto.getCandidateEmail());
	}

	@Test
	public void testFindApplicationCount() throws Exception {
		PowerMockito.when(applicationServiceImpl.findApplicationCount(Matchers.anyLong())).thenReturn(1);
		int applicationCount = appController.findApplicationCount(10001L);
		assertNotNull(applicationCount);
		assertEquals(1, applicationCount);
	}

	@Test
	public void testFindApplicationCount_statusCheck() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/v1/application/applicationcount/0")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testFindApplicationsPerOffer() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/v1/application/applications-per-offer/0")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}



}
