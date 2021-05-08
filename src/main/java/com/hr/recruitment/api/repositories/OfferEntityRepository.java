package com.hr.recruitment.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.recruitment.api.entity.OfferEntity;

@Repository
public interface OfferEntityRepository extends JpaRepository<OfferEntity, Long>{
	
	OfferEntity findByJobTitle(String jobTitle);
	
}
