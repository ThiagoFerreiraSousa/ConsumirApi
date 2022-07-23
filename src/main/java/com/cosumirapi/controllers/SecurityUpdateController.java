package com.cosumirapi.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosumirapi.domain.SecurityUpdate;
import com.cosumirapi.dto.ValueDto;
import com.cosumirapi.services.SecurityUpdateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("updates")
public class SecurityUpdateController {

	private SecurityUpdateService securityUpdateService;

	@GetMapping
	public List<ValueDto> getAllUpdates() {
		return securityUpdateService.getNewUpdates();
	}
	
	@GetMapping("/filter")
	public List<SecurityUpdate> filter (@RequestParam(required = false) String id,
								  @RequestParam(required = false) String alias,
								  @RequestParam(required = false) String documentTitle,
								  @RequestParam(required = false) String severity,
								  @RequestParam(required = false) LocalDateTime initialReleaseDate,
								  @RequestParam(required = false) LocalDateTime currentReleaseDate,
								  @RequestParam(required = false) String cvrfUrl){
		
		return securityUpdateService.filter(id, alias, documentTitle, severity, initialReleaseDate, currentReleaseDate, cvrfUrl);
	}

}
