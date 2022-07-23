package com.cosumirapi.schedules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cosumirapi.dto.SecurityUpdateDto;
import com.cosumirapi.services.SecurityUpdateService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VerificarUpdateSchedule {
	
	private final SecurityUpdateService securityUpdateService;
	
	@Scheduled(fixedRate = 300000)
	public void verificarUpdates() {
		SecurityUpdateDto security = securityUpdateService.getSecurityUpdate();
		securityUpdateService.saveSecurities(security.getValues());
	}
	
}
