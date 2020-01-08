package com.api.getservices.configuration;

import java.io.Serializable;

public class AdapterProperties implements Serializable{
	private static final long serialVersionUID = 7155671194564966674L;
	private String serverUrl;
	private Integer readTimeout;
	private Integer connectTimeout;
	private String urlVersion;

	/**
	 * @return the urlVersion
	 */
	public String getUrlVersion() {
		return urlVersion;
	}

	/**
	 * @param urlVersion the urlVersion to set
	 */
	public void setUrlVersion(String urlVersion) {
		this.urlVersion = urlVersion;
	}

	/**
	 * @return the serverUrl
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * @param serverUrl the serverUrl to set
	 */
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	/**
	 * @return the readTimeout
	 */
	public Integer getReadTimeout() {
		return readTimeout;
	}

	/**
	 * @param readTimeout the readTimeout to set
	 */
	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}

	/**
	 * @return the connectTimeout
	 */
	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * @param connectTimeout the connectTimeout to set
	 */
	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdapterProperties [serverUrl=" + serverUrl + ", readTimeout=" + readTimeout + ", connectTimeout="
				+ connectTimeout + ",urlVersion="+ urlVersion+ "]";
	}
}
