package com.hr.recruitment.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.recruitment.api.entity.ApplicationEntity;

@Repository
public interface ApplicationEntityRepository extends JpaRepository<ApplicationEntity,Long>{
	
	ApplicationEntity findByOfferOfferIdAndCandidateEmail(Long offerId, String email);
	
	Long countByOfferOfferId(Long offerId);
	
	List<ApplicationEntity> findByOfferOfferId(Long offerId);
}
