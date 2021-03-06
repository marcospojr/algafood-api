package com.marcosjr.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.marcosjr.algafood.AlgafoodApiApplication;
import com.marcosjr.algafood.domain.model.Cozinha;
import com.marcosjr.algafood.domain.repository.CozinhaRepository;

// 	Classe utilizada para poder rodar a aplicação sem a necessidade de subir um
// 	aplicação web que fica esperando requisições

public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		List<Cozinha> cozinhas = cozinhaRepository.listar();
		
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNome());
		}
		
	}

}
