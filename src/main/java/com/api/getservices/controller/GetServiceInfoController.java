/**
 * 
 */
package com.api.getservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.getservices.domain.GetServiceInfoResponse;
import com.api.getservices.service.GetServiceInfoService;

/**
 * @author PRASADBolla
 *
 */
@RestController
public class GetServiceInfoController {
	@Autowired
	public GetServiceInfoService getServiceInfoService;

/*	@Autowired
	public GetSubscriptionService getSubscriptionService;*/

	@GetMapping(value = "/services/{tenentId}")
	public ResponseEntity<GetServiceInfoResponse> getServiceInfo(
			@PathVariable String tenentId) {
		return ResponseEntity.ok(getServiceInfoService.getGetServiceInfoList(tenentId));

	}

/*	@GetMapping(value = "/services/{tenentId}/{serviceType}")
	public ResponseEntity<ResourceInfo> getSubscriptionId(
			@RequestHeader String authorizationCode) {
		return ResponseEntity.ok(getSubscriptionService
				.getSubscriptionId(authorizationCode));

	}*/

}
