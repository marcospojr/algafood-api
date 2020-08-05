package com.marcosjr.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.marcosjr.algafood.AlgafoodApiApplication;
import com.marcosjr.algafood.domain.model.Cidade;
import com.marcosjr.algafood.domain.repository.CidadeRepository;

// 	Classe utilizada para poder rodar a aplicação sem a necessidade de subir um
// 	aplicação web que fica esperando requisições

public class ConsultaCidadeMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		List<Cidade> cidades = cidadeRepository.listar();
		
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " - " + cidade.getEstado().getNome());
		}
		
	}

}
