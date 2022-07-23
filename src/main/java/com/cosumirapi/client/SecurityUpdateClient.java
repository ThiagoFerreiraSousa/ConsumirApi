package com.cosumirapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cosumirapi.dto.SecurityUpdateDto;

//fazer requisições extarnas
@FeignClient(name = "update", url = "https://api.msrc.microsoft.com/cvrf/v2.0")
public interface SecurityUpdateClient {
	
	@GetMapping(value = "/updates")
	SecurityUpdateDto get();
	
}
