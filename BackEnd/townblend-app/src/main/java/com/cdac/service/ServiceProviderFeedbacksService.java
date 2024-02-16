package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.ServiceProviderFeedbacks;
import com.cdac.repository.ServiceProviderFeedbacksRepository;

@Service
public class ServiceProviderFeedbacksService {
	
	@Autowired
	private ServiceProviderFeedbacksRepository feedbacksRepository;
	
	public void save(ServiceProviderFeedbacks feedback) {
        feedbacksRepository.save(feedback);
    }
    
    public ServiceProviderFeedbacks findById(int id) {
        return feedbacksRepository.findById(id).orElse(null);
    }
    
    public List<ServiceProviderFeedbacks> findByServiceProviderId(int serviceProviderId) {
        return feedbacksRepository.findByServiceProviderId(serviceProviderId);
    } 
}
