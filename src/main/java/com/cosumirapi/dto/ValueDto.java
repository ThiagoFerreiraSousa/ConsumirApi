package com.cosumirapi.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //se vier coluna a mais ou a menos ele vai ignorar //payload
public class ValueDto {

	private String id;

	private String alias;

	private String documentTitle;

	private String severity;

	private LocalDateTime initialReleaseDate;

	private LocalDateTime currentReleaseDate;

	private String cvrfUrl;

	public String getId() {
		return id;
	}

	@JsonProperty("ID")
	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	@JsonProperty("Alias")
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDocumentTitle() {
		return documentTitle;
	}

	@JsonProperty("DocumentTitle")
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	public String getSeverity() {
		return severity;
	}

	@JsonProperty("Severity")
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public LocalDateTime getInitialReleaseDate() {
		return initialReleaseDate;
	}

	@JsonProperty("InitialReleaseDate")
	public void setInitialReleaseDate(LocalDateTime initialReleaseDate) {
		this.initialReleaseDate = initialReleaseDate;
	}

	public LocalDateTime getCurrentReleaseDate() {
		return currentReleaseDate;
	}

	@JsonProperty("CurrentReleaseDate")
	public void setCurrentReleaseDate(LocalDateTime currentReleaseDate) {
		this.currentReleaseDate = currentReleaseDate;
	}

	public String getCvrfUrl() {
		return cvrfUrl;
	}

	@JsonProperty("CvrfUrl")
	public void setCvrfUrl(String cvrfUrl) {
		this.cvrfUrl = cvrfUrl;
	}

}
