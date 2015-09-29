package br.com.planosaude.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.gui.constant.FXConstants;
import br.com.planosaude.gui.util.FXUtils;
import br.com.planosaude.gui.util.SpringFxmlLoader;
import br.com.planosaude.gui.util.SpringFxmlLoaderVO;
import br.com.planosaude.service.PessoaService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

@Component
public class CadastroPessoaController {
	
	private Pessoa pessoa;
	private Stage dialogStage;
	
	@Autowired
	private PessoaService pessoaService;

	public static void show(Pessoa pessoa) {
		SpringFxmlLoaderVO springFxmlLoaderVO = SpringFxmlLoader.LOADER.load(FXConstants.CADASTRO_PESSOA);
		Parent root = springFxmlLoaderVO.getParent();
		CadastroPessoaController controller = (CadastroPessoaController) springFxmlLoaderVO.getController();

		Stage dialogStage = FXUtils.generateDialogStage("Cadastro de Pessoas", root, SpringFxmlLoader.primaryStage);

		controller.setPessoa(pessoa);
		controller.setDialogStage(dialogStage);

		dialogStage.showAndWait();
	}

	@FXML
	public void handleAdicionarDependente() {
		CadastroDependenteController.show(pessoa);
	}

	@FXML
	public void handleRemoverDependente() {

	}

	@FXML
	public void handleSalvar() {
		dialogStage.close();
	}

	@FXML
	public void handleCancelar() {
		dialogStage.close();
	}
	
	private void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
