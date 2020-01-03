/**
 * 
 */
package com.api.getservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.api.getservices.domain.GetServiceInfoResponse;
import com.api.getservices.domain.ResourceInfo;
import com.api.getservices.service.GetServiceInfoService;
import com.api.getservices.service.GetSubscriptionService;

/**
 * @author PRASADBolla
 *
 */
@RestController
@CrossOrigin
public class GetServiceInfoController {
	@Autowired
	public GetServiceInfoService getServiceInfoService;

	@Autowired
	public GetSubscriptionService getSubscriptionService;

	@GetMapping(value = "/services/{tenentId}")
	public ResponseEntity<GetServiceInfoResponse> getServiceInfo(
			@PathVariable String tenentId) {
		return ResponseEntity.ok(getServiceInfoService.getGetServiceInfoList(tenentId));

	}
//Added for future use
	@GetMapping(value = "/services/{tenentId}/{serviceType}")
	public ResponseEntity<ResourceInfo> getSubscriptionIdBasedOnAuth(
			@RequestHeader String authorizationCode) {
		return ResponseEntity.ok(getSubscriptionService
				.getSubscriptionId(authorizationCode));

	}
	@GetMapping(value = "/subscriptions/{tenentId}")
	public ResponseEntity<ResourceInfo> getSubscriptionId(
			@PathVariable String tenentId) {
		ResourceInfo resourceInfo = getSubscriptionService
				.getSubscriptionId(tenentId);
		if(resourceInfo != null)
		return ResponseEntity.ok(resourceInfo);
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);

	}
}
