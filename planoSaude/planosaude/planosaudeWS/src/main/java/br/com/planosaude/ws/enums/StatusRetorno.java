package br.com.planosaude.ws.enums;

public enum StatusRetorno {

	SUCESSO(0), 
	EXCECAO(1);
	
	private Integer codigoStatus;
	
	private StatusRetorno(Integer codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	public Integer getCodigoStatus() {
		return codigoStatus;
	}
	
}
