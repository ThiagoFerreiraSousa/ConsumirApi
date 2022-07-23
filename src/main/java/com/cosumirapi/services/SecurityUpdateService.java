package com.cosumirapi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cosumirapi.client.SecurityUpdateClient;
import com.cosumirapi.domain.SecurityUpdate;
import com.cosumirapi.dto.SecurityUpdateDto;
import com.cosumirapi.dto.ValueDto;
import com.cosumirapi.repositories.SecurityUpdateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityUpdateService {

	private final SecurityUpdateClient securityUpdateClient;

	private final SecurityUpdateRepository securityUpdateRepository;

	public List<ValueDto> getNewUpdates() {
		SecurityUpdateDto security = getSecurityUpdate();
		saveSecurities(security.getValues());

		return security.getValues();
	}

	public SecurityUpdateDto getSecurityUpdate() {
		try {
			return securityUpdateClient.get();
		} catch (Exception e) {
			throw e;
		}
	}

	//percorrer dentro de uma lista de values
	//Optional serve para evitar  null point exception
	
	//salvar os itens novos, primeiro procuro se já existe
	
	public void saveSecurities(List<ValueDto> values) {
		for (ValueDto value : values) {
			Optional<SecurityUpdate> securityUpdate = securityUpdateRepository.findById(value.getId());

			if (securityUpdate.isEmpty()) {
				SecurityUpdate newConsumir = new SecurityUpdate();
				newConsumir.setId(value.getId());
				newConsumir.setAlias(value.getAlias());
				newConsumir.setDocumentTitle(value.getDocumentTitle());
				newConsumir.setSeverity(value.getSeverity());
				newConsumir.setInitialReleaseDate(value.getInitialReleaseDate());
				newConsumir.setCurrentReleaseDate(value.getCurrentReleaseDate());
				newConsumir.setCvrfUrl(value.getCvrfUrl());
				securityUpdateRepository.save(newConsumir);
			}
		}
	}

	public List<SecurityUpdate> listSecurities() {
		return securityUpdateRepository.findAll();
	}

	public List<SecurityUpdate> filter(
			String id, 
			String alias, 
			String documentTitle, 
			String severity,
			LocalDateTime initialReleaseDate, 
			LocalDateTime currentReleaseDate, 
			String cvrfUrl) {

		return securityUpdateRepository
				.findAllByIdOrAliasOrDocumentTitleOrSeverityOrInitialReleaseDateOrCurrentReleaseDateOrCvrfUrlContaining(
						id,
						alias,
						documentTitle, 
						severity, 
						cvrfUrl);		
	}

}
