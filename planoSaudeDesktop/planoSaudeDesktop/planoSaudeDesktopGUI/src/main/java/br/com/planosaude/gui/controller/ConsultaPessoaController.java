package br.com.planosaude.gui.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.gui.vo.PessoaVO;
import br.com.planosaude.service.PessoaService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

@Component
public class ConsultaPessoaController {

	@Autowired
	private PessoaService pessoaService;

	@FXML
	private TableView<PessoaVO> tableView;

	@FXML
	private TableColumn<PessoaVO, String> tableColumnNome;

	@FXML
	private TableColumn<PessoaVO, String> tableColumnTipoPlano;

	@FXML
	private TableColumn<PessoaVO, String> tableColumnCidade;

	@FXML
	private TableColumn<PessoaVO, String> tableColumnUF;

	@FXML
	private TableColumn<PessoaVO, String> tableColumnVencimento;

	private ObservableList<PessoaVO> listPessoa;

	@FXML
	private void initialize() {
		tableColumnNome.setCellValueFactory(cellData -> cellData.getValue().getNome());
		tableColumnTipoPlano.setCellValueFactory(cellData -> cellData.getValue().getTipoPlano());
		tableColumnCidade.setCellValueFactory(cellData -> cellData.getValue().getCidade());
		tableColumnUF.setCellValueFactory(cellData -> cellData.getValue().getUf());
		tableColumnVencimento.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getDataVencimento() != null
						&& cellData.getValue().getDataVencimento().getDate() != null
								? new SimpleDateFormat("dd/MM/yyyy")
										.format(cellData.getValue().getDataVencimento().getDate())
								: ""));
		handleAtualizarTabela();
	}

	@FXML
	public void handleAtualizarTabela() {
		if (listPessoa == null) {
			listPessoa = FXCollections.observableArrayList();
		} else {
			listPessoa.clear();
		}
		for (Pessoa pessoa : pessoaService.obterTodasPessoas()) {
			listPessoa.add(new PessoaVO(pessoa));
		}
		tableView.setItems(listPessoa);
	}

	@FXML
	public void handleAdcionar() {
		CadastroPessoaController.show(this, new Pessoa(), true);
	}

	@FXML
	public void handleEditar() {
		if (tableView.getSelectionModel() != null && tableView.getSelectionModel().getSelectedItem() != null) {
			CadastroPessoaController.show(this, tableView.getSelectionModel().getSelectedItem().getPessoa(), false);
		}
	}

}
