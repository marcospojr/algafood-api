package com.marcosjr.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.marcosjr.algafood.AlgafoodApiApplication;
import com.marcosjr.algafood.domain.model.Permissao;
import com.marcosjr.algafood.domain.repository.PermissaoRepository;

// 	Classe utilizada para poder rodar a aplicação sem a necessidade de subir um
// 	aplicação web que fica esperando requisições

public class ConsultaPermissaoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		List<Permissao> permissoes = permissaoRepository.listar();
		
		for (Permissao permissao : permissoes) {
			System.out.println(permissao.getNome() + " - " + permissao.getDescricao());
		}
		
	}

}
