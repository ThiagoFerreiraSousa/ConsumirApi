package com.api.comsumirapiexterna.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.api.comsumirapiexterna.models.ConsumirModel;
import com.api.comsumirapiexterna.repositories.ConsumirRepository;

@Service
public class ConsumirService {
	
	@Autowired
	ConsumirRepository repository;
	
//	public ConsumirModel salvar(ConsumirModel consumir) {
//		return repository.saveAndFlush(consumir);
//	}
	
	public void buscarApiExterna() {
	
	RestTemplate restTemplate = new RestTemplate();
	RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
	restTemplate = restTemplateBuilder.build();
	
	
	ConsumirModel consumir = restTemplate.getForObject("https://api.msrc.microsoft.com/cvrf/v2.0/updates", ConsumirModel.class);
	
	}
	
	
//	public ConsumirModel salvar(ConsumirModel consumir) {
//		Assert.isTrue(consumir != null, "Dados não informados.");
//
//		return repository.saveAndFlush(consumir);
//	}

//	public List<EmprestimoDto> listar() {
//
//		List<EmprestimoDto> emprestimoList = dao.pesquisarEmprestimos();
//		
//
//		if (emprestimoList == null || emprestimoList.isEmpty()) {
//			throw new RuntimeException("Nenhum registro encontrado para a pesquisa.");
//		}
//
//		return emprestimoList;
//	}
	
			
			//url:"https://api.msrc.microsoft.com/cvrf/v2.0/updates", ConsumirModel.class);
	
}
