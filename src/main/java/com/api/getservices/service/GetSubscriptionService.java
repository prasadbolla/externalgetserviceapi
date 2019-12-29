/**
 * 
 *//*
package com.api.getservices.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.getservices.domain.ResourceInfo;
import com.api.getservices.util.AuthenticationUtility;

*//**
 * @author PRASADBolla
 *
 *//*
@Service
public class GetSubscriptionService {
	public static String url = "https://management.azure.com/subscriptions?api-version=2019-06-01";
	public ResourceInfo getSubscriptionId(String authorizationCode) {
		//Temp code added to return auth code
		if(authorizationCode == null || authorizationCode.isEmpty())
			authorizationCode = AuthenticationUtility.getToken();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authorizationCode);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);

		ResponseEntity<ResourceInfo> resultt = restTemplate
				.exchange(url,
						HttpMethod.GET, entity, ResourceInfo.class);
		return (ResourceInfo) resultt.getBody();
	}
}
*/