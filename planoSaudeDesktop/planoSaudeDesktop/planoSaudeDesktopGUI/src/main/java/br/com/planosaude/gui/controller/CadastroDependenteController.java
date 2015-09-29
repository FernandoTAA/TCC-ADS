package br.com.planosaude.gui.controller;

import org.springframework.stereotype.Component;

import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.gui.constant.FXConstants;
import br.com.planosaude.gui.util.FXUtils;
import br.com.planosaude.gui.util.SpringFxmlLoader;
import br.com.planosaude.gui.util.SpringFxmlLoaderVO;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;

@Component
public class CadastroDependenteController {

	private Pessoa pessoa;
	
	private Stage dialogStage;
	
	public static void show(Pessoa pessoa) {
		SpringFxmlLoaderVO springFxmlLoaderVO = SpringFxmlLoader.LOADER.load(FXConstants.CADASTRO_DEPENDENTE);
		Parent root = springFxmlLoaderVO.getParent();
		CadastroDependenteController controller = (CadastroDependenteController) springFxmlLoaderVO.getController();

		Stage dialogStage = FXUtils.generateDialogStage("Cadastro de Dependente", root, SpringFxmlLoader.primaryStage);

		controller.setPessoa(pessoa);
		controller.setDialogStage(dialogStage);

		dialogStage.showAndWait();
	}

	@FXML
	public void handleAdicionar() {
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
