/**
 * 
 */
package com.api.getservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.getservices.configuration.AdapterConf;
import com.api.getservices.configuration.ConfigurationManager;
import com.api.getservices.domain.Category;
import com.api.getservices.domain.GetServiceInfoResponse;
import com.api.getservices.domain.ResourceGroupList;
import com.api.getservices.domain.ResourceInfo;

/**
 * @author PRASADBolla
 *
 */
@Service
public class GetServiceInfoService {

/*	@Autowired
	public GetSubscriptionService getSubscriptionService;*/
	
	@Autowired
	public ConfigurationManager configurationManager;
	@Autowired
	public AdapterConf adapterConf;
	
	final String ROOT_URI = "https://management.azure.com/subscriptions?api-version=2019-06-01";
	public static RestTemplate restTemplate = new RestTemplate();
	public static List<GetServiceInfoResponse> getServiceInfoList = new ArrayList<GetServiceInfoResponse>();
	public static List<Category> categories = new ArrayList<Category>();
	public void getAvailableResourceList() {
		
		categories.add(new Category("Compute",
		configurationManager
				.getComputelist()
				.stream()
				.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
						"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Networking",
				configurationManager
						.getNetworkinglist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Storage",
				configurationManager
						.getStoragelist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Web+Mobile",
				configurationManager
						.getWebmobilelist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Containers",
				configurationManager
						.getContainerslist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Databases",
				configurationManager
						.getDatabaseslist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Data+Analytics",
				configurationManager
						.getDataAnalysticslist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("AI+CognitiveServices",
				configurationManager
						.getAlcongintiveservicelist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("InternetofThings",
				configurationManager
						.getInternetofThingslist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("EnterpriseIntegration",
				configurationManager
						.getEnterpriseIntegrationlist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Security+Identity",
				configurationManager
						.getSecurityIdentityList()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("DeveloperTools",
				configurationManager
						.getDeveloperToolslist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		categories.add(new Category("Monitoring+Management",
				configurationManager
						.getMonitoringmanagementlist()
						.stream()
						.map(resource -> new com.api.getservices.domain.Service("", resource.trim(), "",
								"","NotRegistered")).collect(Collectors.toList())));
		System.out.println("hello");
	}
	
	/**
	 * @return the getServiceInfoList
	 */
	public GetServiceInfoResponse getGetServiceInfoList(String tenentId) {
		
		if(categories.isEmpty())
			getAvailableResourceList();
		
		return new GetServiceInfoResponse(categories);
	}

	public ResourceInfo getGetServiceInformation(String subscriptionId,
			String authorizationCode) {

		String uri = "https://management.azure.com/subscriptions/"
				+ subscriptionId + "/resources?api-version=2019-08-01";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authorizationCode);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);

		ResponseEntity<ResourceInfo> result = restTemplate.exchange(uri,
				HttpMethod.GET, entity, ResourceInfo.class);

		return result.getBody();
	}
	
	public ResourceGroupList getResourceGroups(String subscriptionId,
			String authorizationCode) {

		String uri = "https://management.azure.com/subscriptions/"
				+ subscriptionId + "/resourcegroups?api-version=2019-08-01";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authorizationCode);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);

		ResponseEntity<ResourceGroupList> result = restTemplate.exchange(uri,
				HttpMethod.GET, entity, ResourceGroupList.class);

		return result.getBody();
	}
	
	
	//implementation required to return selected and available services
	public ResourceInfo getServices(String subscriptionId,
			String authorizationCode) {

		String uri = "https://management.azure.com/subscriptions/"
				+ subscriptionId + "/resources?api-version=2019-08-01";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authorizationCode);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);

		ResponseEntity<ResourceInfo> result = restTemplate.exchange(uri,
				HttpMethod.GET, entity, ResourceInfo.class);

		return result.getBody();
	}
	public static void main(String a[]){
		GetServiceInfoService getServiceInfoService = new GetServiceInfoService();
		getServiceInfoService.getAvailableResourceList();
	}
}
