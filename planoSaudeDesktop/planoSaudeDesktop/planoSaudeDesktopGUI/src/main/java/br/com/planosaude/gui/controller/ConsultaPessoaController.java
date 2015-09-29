package br.com.planosaude.gui.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;

@Component
public class ConsultaPessoaController {

	@FXML
	public void handleAdcionar() {
		CadastroPessoaController.show(null);
	}

	@FXML
	public void handleEditar() {
		CadastroPessoaController.show(null);
	}

}
