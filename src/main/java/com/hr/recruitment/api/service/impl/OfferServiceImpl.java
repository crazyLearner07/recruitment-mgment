package com.hr.recruitment.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.recruitment.api.dto.BaseDTO;
import com.hr.recruitment.api.dto.OfferDTO;
import com.hr.recruitment.api.entity.OfferEntity;
import com.hr.recruitment.api.exception.BusinessValidationException;
import com.hr.recruitment.api.mapper.ObjectMapper;
import com.hr.recruitment.api.repositories.ApplicationEntityRepository;
import com.hr.recruitment.api.repositories.OfferEntityRepository;
import com.hr.recruitment.api.service.OfferService;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferEntityRepository offerRepository;

	@Autowired
	ApplicationEntityRepository applicationRepository;

	@Override
	public OfferDTO saveOffer(BaseDTO baseDto) {
		ObjectMapper mapper = new ObjectMapper();
		OfferEntity offerEntity = mapper.mapDtoToOfferEntity(baseDto);
		offerRepository.save(offerEntity);
		return getOfferDtoDetails(offerEntity);
	}

	
	/**
	 * @param offerId
	 */
	@Override
	public OfferDTO getOfferDetail(Long offerId) throws BusinessValidationException {
		OfferDTO offerDTO = new OfferDTO();
		if (null != offerId) {
			OfferEntity offer = offerRepository.findOne(offerId);
			offerDTO = getOfferDtoDetails(offer);
		}else {
			throw new BusinessValidationException("OfferId can not be null");
		}
		return offerDTO;
	}
	/**
	 * 
	 */
	@Override
	public List<OfferDTO> getAllOfferDetails() {
		List<OfferDTO> dtos = new ArrayList<>();
		List<OfferEntity> offers = offerRepository.findAll();
		if (CollectionUtils.isNotEmpty(offers)) {
			dtos = offers.stream().map(this::getOfferDtoDetails).collect(Collectors.toList());
		}
		return dtos;
	}

	private OfferDTO getOfferDtoDetails(OfferEntity offer) {
		OfferDTO dto = new OfferDTO();
		dto.setOfferId(offer.getOfferId());
		dto.setJobDescription(offer.getJobDescription());
		dto.setJobTitle(offer.getJobTitle());
		dto.setStartDate(offer.getStartDate());
		Long noOfApplicantsForThisJobOffer = applicationRepository.countByOfferOfferId(offer.getOfferId());
		dto.setNoOfApplicants(null != noOfApplicantsForThisJobOffer ? noOfApplicantsForThisJobOffer.intValue() : 0);
		return dto;
	}

}
