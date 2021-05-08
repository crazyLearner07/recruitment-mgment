package com.hr.recruitment.api.controllers;

import java.util.List;

import com.hr.recruitment.api.dto.BaseDTO;
import com.hr.recruitment.api.dto.OfferDTO;
import com.hr.recruitment.api.exception.BusinessValidationException;
import com.hr.recruitment.api.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/offer")
@Api(tags="Recruitment APIs")
public class OfferController {
	
	@Autowired
    OfferService offerService;
	
	@PostMapping(value="/create")
	public OfferDTO createOffer(@RequestBody BaseDTO baseDto){
		return offerService.saveOffer(baseDto);	
	}
	
	@GetMapping(value="/offerdetail/{offerId}")
	public OfferDTO getOfferDetail(@PathVariable(value="offerId") Long offerId) throws BusinessValidationException {
		return offerService.getOfferDetail(offerId);	
	}
	
	@GetMapping(value="/offerdetails/all")
	public List<OfferDTO> getAllOfferDetails(){
		return offerService.getAllOfferDetails();	
	}

}
