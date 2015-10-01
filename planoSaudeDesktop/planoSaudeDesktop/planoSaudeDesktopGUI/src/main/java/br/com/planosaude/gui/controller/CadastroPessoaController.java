package br.com.planosaude.gui.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.planosaude.dao.entity.Dependente;
import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.dao.enums.TipoPlano;
import br.com.planosaude.gui.constant.FXConstants;
import br.com.planosaude.gui.util.DateUtils;
import br.com.planosaude.gui.util.FXUtils;
import br.com.planosaude.gui.util.SpringFxmlLoader;
import br.com.planosaude.gui.vo.DependenteVO;
import br.com.planosaude.gui.vo.SpringFxmlLoaderVO;
import br.com.planosaude.service.PessoaService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class CadastroPessoaController {

	@Autowired
	private PessoaService pessoaService;

	@FXML
	private TextField codigo;

	@FXML
	private TextField nome;

	@FXML
	private DatePicker dataNascimento;

	@FXML
	private ComboBox<TipoPlano> tipoPlano;

	@FXML
	private DatePicker dataVencimento;

	@FXML
	private TextField logradouro;

	@FXML
	private TextField numero;

	@FXML
	private TextField complemento;

	@FXML
	private TextField cep;

	@FXML
	private TextField cidade;

	@FXML
	private ComboBox<String> uf;

	@FXML
	private TextField contato;

	@FXML
	private TextField telefone;
	
	@FXML
	private TableView<DependenteVO> tableView;
	
	@FXML
	private TableColumn<DependenteVO, String> tableColumnNome;

	@FXML
	private TableColumn<DependenteVO, String> tableColumnDataNascimento;

	private ConsultaPessoaController consultaPessoaController;	
	private Pessoa pessoa;
	private boolean saveProcess;
	private ObservableList<DependenteVO> listDependente;
	private Stage dialogStage;

	public static void show(ConsultaPessoaController consultaPessoaController, Pessoa pessoa, boolean saveProcess) {
		SpringFxmlLoaderVO springFxmlLoaderVO = SpringFxmlLoader.LOADER.load(FXConstants.CADASTRO_PESSOA);
		Parent root = springFxmlLoaderVO.getParent();
		CadastroPessoaController controller = (CadastroPessoaController) springFxmlLoaderVO.getController();

		Stage dialogStage = FXUtils.generateDialogStage("Cadastro de Pessoas", root, SpringFxmlLoader.primaryStage);

		controller.setPessoa(pessoa);
		controller.setConsultaPessoaController(consultaPessoaController);
		controller.setSaveProcess(saveProcess);
		controller.setDialogStage(dialogStage);

		dialogStage.showAndWait();
	}

	@FXML
	private void initialize() {
		tipoPlano.setItems(FXCollections.observableArrayList(TipoPlano.values()));
		uf.setItems(FXCollections.observableArrayList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG",
				"MT", "MS", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"));

		tableColumnNome.setCellValueFactory(cellData -> cellData.getValue().getNome());
		tableColumnDataNascimento.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getDataNascimento() != null
						&& cellData.getValue().getDataNascimento().getDate() != null
								? new SimpleDateFormat("dd/MM/yyyy")
										.format(cellData.getValue().getDataNascimento().getDate())
								: ""));
	}

	@FXML
	public void handleAdicionarDependente() {
		CadastroDependenteController.show(this, pessoa, new Dependente(), true);
	}

	@FXML
	public void handleEditarDependente() {
		if (tableView.getSelectionModel().getSelectedItem() != null 
				&& tableView.getSelectionModel().getSelectedItem() != null 
				&& tableView.getSelectionModel().getSelectedItem().getDependete() != null) {
			CadastroDependenteController.show(this, pessoa, tableView.getSelectionModel().getSelectedItem().getDependete(), false);
		}
	}

	@FXML
	public void handleRemoverDependente() {
		tableView.getItems().remove(tableView.getSelectionModel().getSelectedIndex());
	}

	@FXML
	public void handleSalvar() {
		atualizarPessoa();
		if (isSaveProcess()) {
			pessoaService.save(pessoa);
		} else {
			pessoaService.update(pessoa);
		}
		consultaPessoaController.handleAtualizarTabela();
		dialogStage.close();
	}

	@FXML
	public void handleCancelar() {
		dialogStage.close();
	}


	private void atualizarPessoa() {
		if (pessoa != null) {
			if (codigo.getText() != null && !codigo.getText().isEmpty()) {
				pessoa.setId(Long.parseLong(codigo.getText()));
			}
			
			pessoa.setNome(nome.getText());
			pessoa.setTipoPlano(tipoPlano.getValue());
			
			if (dataNascimento.getValue() != null) {
				pessoa.getDataNascimento().setDate(DateUtils.parseDate(dataNascimento.getValue()));
			}
			
			if (dataVencimento.getValue() != null) {
				pessoa.getDataVencimentoPlano().setDate(DateUtils.parseDate(dataVencimento.getValue()));
			}
			
			if (numero.getText() != null && !numero.getText().isEmpty()) {
				pessoa.getEndereco().setNumero(Integer.parseInt(numero.getText()));
			}
			
			pessoa.getEndereco().setLogradouro(logradouro.getText());
			pessoa.getEndereco().setComplemento(complemento.getText());
			pessoa.getEndereco().setCep(cep.getText());
			pessoa.getEndereco().setCidade(cidade.getText());
			pessoa.getEndereco().setUf(uf.getValue());
			pessoa.getTelefone().setContato(contato.getText());
			pessoa.getTelefone().setTelefone(telefone.getText());
	
			pessoa.getDependentes().clear();
			for (DependenteVO dependenteVO : tableView.getItems()) {
				pessoa.getDependentes().add(dependenteVO.getDependete());
			}
		}
	}

	private void preencheCampos(Pessoa pessoa) {
		if (pessoa != null) {
			if (pessoa.getId() != null) {
				codigo.setText(String.valueOf(pessoa.getId()));
			}

			nome.setText(pessoa.getNome());
			tipoPlano.setValue(pessoa.getTipoPlano());
		
			if (pessoa.getDataNascimento() != null && pessoa.getDataNascimento().getDate() != null) {
				dataNascimento.setValue(DateUtils.parseLocalDate(pessoa.getDataNascimento().getDate()));
			}
			
			if (pessoa.getDataVencimentoPlano() != null && pessoa.getDataVencimentoPlano().getDate() != null) {
				dataVencimento.setValue(DateUtils.parseLocalDate(pessoa.getDataVencimentoPlano().getDate()));
			}

			if (pessoa.getEndereco() != null) {
				logradouro.setText(pessoa.getEndereco().getLogradouro());
				complemento.setText(pessoa.getEndereco().getComplemento());
				cep.setText(pessoa.getEndereco().getCep());
				cidade.setText(pessoa.getEndereco().getCidade());
				uf.setValue(pessoa.getEndereco().getUf());
				if (pessoa.getEndereco().getNumero() != null) {
					numero.setText(String.valueOf(pessoa.getEndereco().getNumero()));
				}
			}

			if (pessoa.getTelefone() != null) {
				contato.setText(pessoa.getTelefone().getContato());
				telefone.setText(pessoa.getTelefone().getTelefone());
			}

			atualizarTabelaDependente();
		}
	}

	public void atualizarTabelaDependente() {
		if (listDependente == null) {
			listDependente = FXCollections.observableArrayList();
		} else {
			listDependente.clear();
		}
		for (Dependente dependente : pessoa.getDependentes()) {
			listDependente.add(new DependenteVO(dependente));
		}
		tableView.setItems(listDependente);
	}

	private void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		preencheCampos(pessoa);
	}

	private void setConsultaPessoaController(ConsultaPessoaController consultaPessoaController) {
		this.consultaPessoaController = consultaPessoaController;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isSaveProcess() {
		return saveProcess;
	}

	public void setSaveProcess(boolean saveProcess) {
		this.saveProcess = saveProcess;
	}

}
