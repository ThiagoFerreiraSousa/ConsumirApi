package com.cosumirapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityUpdateDto {
	
	private String context;
	
	private List<ValueDto> values;
	
	public String getContext() {
		return context;
	}
	
	@JsonProperty("@odata.context")	
	public void setContext(String context) {
		this.context = context;
	}
	
	public List<ValueDto> getValues() {
		return values;
	}
	
	@JsonProperty("value")
	public void setValues(List<ValueDto> values) {
		this.values = values;
	}
	
}
