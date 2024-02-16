package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.ServiceProvider;
import com.cdac.entity.ServiceProviderFeedbacks;
import com.cdac.service.ServiceProviderFeedbacksService;
import com.cdac.service.ServiceProviderService;

@RestController
@CrossOrigin
public class ServiceProviderFeedbacksController {
	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@Autowired 
	private ServiceProviderFeedbacksService feedbacksService;
	
	@PostMapping("/submit/{serviceProviderId}")
    public ResponseEntity<String> submitFeedback(@PathVariable int serviceProviderId, @RequestBody ServiceProviderFeedbacks feedback) {
        ServiceProvider serviceProvider = serviceProviderService.findByServiceProviderId(serviceProviderId);
        if (serviceProvider == null) {
            return ResponseEntity.notFound().build();
        }
        feedback.setServiceProvider(serviceProvider);
        feedbacksService.save(feedback);
        return ResponseEntity.ok("Feedback submitted successfully");
    }
   
    @GetMapping("/provider/{serviceProviderId}")
    public List<ServiceProviderFeedbacks> getFeedbackForProvider(@PathVariable int serviceProviderId) {
        return feedbacksService.findByServiceProviderId(serviceProviderId);
    }
}
