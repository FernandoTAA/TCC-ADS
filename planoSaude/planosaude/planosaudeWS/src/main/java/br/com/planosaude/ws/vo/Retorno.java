package br.com.planosaude.ws.vo;

import java.io.Serializable;

public class Retorno implements Serializable {

	private static final long serialVersionUID = 7414793011956462319L;
	
	private Integer codigoStatus;
	private String status;

	public Integer getCodigoStatus() {
		return codigoStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setCodigoStatus(Integer codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
