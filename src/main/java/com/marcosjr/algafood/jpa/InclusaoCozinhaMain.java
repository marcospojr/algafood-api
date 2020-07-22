package com.marcosjr.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.marcosjr.algafood.AlgafoodApiApplication;
import com.marcosjr.algafood.domain.model.Cozinha;

// 	Classe utilizada para poder rodar a aplicação sem a necessidade de subir um
// 	aplicação web que fica esperando requisições

public class InclusaoCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinhaBrasileira = new Cozinha();
		cozinhaBrasileira.setNome("Brasileira");
		
		Cozinha cozinhaJaponesa = new Cozinha();
		cozinhaJaponesa.setNome("Japonesa");
		
		cadastroCozinha.salvar(cozinhaBrasileira);
		cadastroCozinha.salvar(cozinhaJaponesa);
				
	}

}
