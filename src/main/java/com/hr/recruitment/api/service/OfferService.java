package com.hr.recruitment.api.service;

import java.util.List;

import com.hr.recruitment.api.dto.BaseDTO;
import com.hr.recruitment.api.dto.OfferDTO;
import com.hr.recruitment.api.exception.BusinessValidationException;

public interface OfferService {

	public OfferDTO saveOffer(BaseDTO baseDto);

	public OfferDTO getOfferDetail(Long offerId) throws BusinessValidationException;

	public List<OfferDTO> getAllOfferDetails();
}
