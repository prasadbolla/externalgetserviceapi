package com.api.getservices.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("adapter")
public class AdapterConf {
	private Map<String, AdapterProperties> property;
	/**
	 * @return the property
	 */
	public Map<String, AdapterProperties> getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(Map<String, AdapterProperties> property) {
		this.property = property;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdapterConf [property=" + property + "]";
	}
	
	/**
	 * @param adapterName
	 * @return AdapterServiceProperties
	 */
	public AdapterProperties retrieveAdapterProperties(String adapterName){
		if(adapterName != null){
			return property.get(adapterName);
		}
		return null;
	}
}