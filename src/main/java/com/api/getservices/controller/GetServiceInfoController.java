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

import com.api.getservices.domain.ClientInfo;
import com.api.getservices.domain.GetServiceInfoResponse;
import com.api.getservices.domain.ResourceGroupList;
import com.api.getservices.domain.ResourceInfo;
import com.api.getservices.service.ClientInfoService;
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
	
	@Autowired
	public ClientInfoService clientInfoService;
	
	//dummy
	/*
	 * @GetMapping(value = "/services/{tenentId}") public
	 * ResponseEntity<GetServiceInfoResponse> getServiceInfo(
	 * 
	 * @PathVariable String tenentId) { return
	 * ResponseEntity.ok(getServiceInfoService.getGetServiceInfoList(tenentId));
	 * 
	 * }
	 */
	//real api's
	@GetMapping(value = "/subscriptions/subscription")
	public ResponseEntity<ResourceInfo> getSubscriptionIdBasedOnAuth(
			@RequestHeader String authorizationCode) {
		return ResponseEntity.ok(getSubscriptionService
				.getSubscription(authorizationCode));

	}
	//real api's
	@GetMapping(value = "/clientInfos/clientInfo/{emailId}")
	public ResponseEntity<ClientInfo> getClientInfo(
			@PathVariable String emailId) {
		return ResponseEntity.ok(clientInfoService
				.getClinetInfo(emailId));

	}
	//real api's
	@GetMapping(value = "/services/service/{subscriptionId}")
	public ResponseEntity<ResourceInfo> getServiceInfoBySubscriptionId(
			@PathVariable String subscriptionId, @RequestHeader String authorizationCode) {
		return ResponseEntity.ok(getServiceInfoService.getGetServiceInformation(subscriptionId,authorizationCode));

	}
	
	@GetMapping(value = "/services/service/{subscriptionId}/resourceGroups")
	public ResponseEntity<ResourceGroupList> getResourcesGroupsBySubscriptionId(
			@PathVariable String subscriptionId, @RequestHeader String authorizationCode) {
		return ResponseEntity.ok(getServiceInfoService.getResourceGroups(subscriptionId,authorizationCode));

	}
	
	//real api.. 
	@GetMapping("/services/{subscriptionIdentifier}")
	public ResponseEntity<ResourceInfo> getServicesBySubscriptionIdentifier(
			@PathVariable String subscriptionIdentifier, @RequestHeader String authorizationCode) {
		return ResponseEntity.ok(getServiceInfoService.getServices(subscriptionIdentifier,authorizationCode));
	}
	
	//dummy
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
