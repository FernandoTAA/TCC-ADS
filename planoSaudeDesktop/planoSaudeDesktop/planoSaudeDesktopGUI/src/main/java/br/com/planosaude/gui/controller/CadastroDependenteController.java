package br.com.planosaude.gui.controller;

import org.springframework.stereotype.Component;

import br.com.planosaude.dao.entity.Dependente;
import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.gui.constant.FXConstants;
import br.com.planosaude.gui.util.DateUtils;
import br.com.planosaude.gui.util.FXUtils;
import br.com.planosaude.gui.util.SpringFxmlLoader;
import br.com.planosaude.gui.vo.SpringFxmlLoaderVO;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class CadastroDependenteController {

	@FXML
	private TextField nome;

	@FXML
	private DatePicker dataNascimento;

	private Pessoa pessoa;
	private Dependente dependente;
	private boolean saveProcess;
	private CadastroPessoaController cadastroPessoaController;
	private Stage dialogStage;
	
	public static void show(CadastroPessoaController cadastroPessoaController, Pessoa pessoa, Dependente dependente, boolean saveProcess) {
		SpringFxmlLoaderVO springFxmlLoaderVO = SpringFxmlLoader.LOADER.load(FXConstants.CADASTRO_DEPENDENTE);
		Parent root = springFxmlLoaderVO.getParent();
		CadastroDependenteController controller = (CadastroDependenteController) springFxmlLoaderVO.getController();

		Stage dialogStage = FXUtils.generateDialogStage("Cadastro de Dependente", root, SpringFxmlLoader.primaryStage);

		controller.setPessoaAndDependente(pessoa, dependente);
		controller.setSaveProcess(saveProcess);
		controller.setCadastroPessoaController(cadastroPessoaController);
		controller.setDialogStage(dialogStage);

		dialogStage.showAndWait();
	}

	@FXML
	public void handleSalvar() {
		atualizarDependentes();
		if (isSaveProcess()) {
			dependente.setPessoa(pessoa);
			pessoa.getDependentes().add(dependente);
		}
		cadastroPessoaController.atualizarTabelaDependente();
		dialogStage.close();
	}

	@FXML
	public void handleCancelar() {
		dialogStage.close();
	}
	
	private void atualizarDependentes() {
		if (pessoa != null && dependente != null) {
			dependente.setNome(nome.getText());
			if (dataNascimento.getValue() != null) {
				dependente.getDataNascimento().setDate(DateUtils.parseDate(dataNascimento.getValue()));
			}
		}
	}

	private void preencheCampos(Pessoa pessoa, Dependente dependente) {
		if (pessoa != null && dependente != null) {
			nome.setText(dependente.getNome());
			if (dependente.getDataNascimento() != null && dependente.getDataNascimento().getDate() != null) {
				dataNascimento.setValue(DateUtils.parseLocalDate(dependente.getDataNascimento().getDate()));
			}
		}
	}

	private boolean isSaveProcess() {
		return saveProcess;
	}

	private void setSaveProcess(boolean saveProcess) {
		this.saveProcess = saveProcess;
	}

	private void setCadastroPessoaController(CadastroPessoaController cadastroPessoaController) {
		this.cadastroPessoaController = cadastroPessoaController;
	}

	private void setPessoaAndDependente(Pessoa pessoa, Dependente dependente) {
		this.pessoa = pessoa;
		this.dependente = dependente;
		preencheCampos(pessoa, dependente);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
