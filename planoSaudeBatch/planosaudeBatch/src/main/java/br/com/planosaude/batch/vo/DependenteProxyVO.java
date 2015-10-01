package br.com.planosaude.batch.vo;

import java.util.Date;

import br.com.planosaude.batch.client.atualizacaocadastral.Dependente;
import br.com.planosaude.batch.util.DateUtils;

/**
 * Objeto Proxy da pessoa para melhor preenchimento do objeto.
 * 
 * @author FernandoTAA
 *
 */
public class DependenteProxyVO extends Dependente {
	
	public void setDataNascimentoDate(Date dataNascimento) {
		if (super.getDataNascimento() == null) {
			super.setDataNascimento(new br.com.planosaude.batch.client.atualizacaocadastral.Date());
		}
		super.getDataNascimento().setDate(DateUtils.getXMLGregorianCalendar(dataNascimento));
	}

}
