package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.ServiceProviderFeedbacks;

@Repository
public interface ServiceProviderFeedbacksRepository extends JpaRepository<ServiceProviderFeedbacks, Integer> {
	 List<ServiceProviderFeedbacks> findByServiceProviderId(int serviceProviderId);
}