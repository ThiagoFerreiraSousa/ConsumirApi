package com.cosumirapi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "security_update")
@Entity
@Builder
public class SecurityUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "alias")
	private String alias;
	
	@Column(name = "document_title")
	private String documentTitle;
	
	@Column(name = "severity")
	private String severity;
	
	@Column(name = "initial_release_date")
	private LocalDateTime initialReleaseDate;
	
	@Column(name = "current_release_date")
	private LocalDateTime currentReleaseDate;
	
	@Column(name = "cvrf_url")
	private String cvrfUrl;

}
