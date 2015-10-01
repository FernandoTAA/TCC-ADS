package br.com.planosaude.batch.client.handler;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;

public class SOAPMessageXMLHandler implements LogicalHandler<LogicalMessageContext> {

	private final static Logger LOGGER = Logger.getLogger(SOAPMessageXMLHandler.class);

	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}

	public boolean handleMessage(LogicalMessageContext context) {
		boolean direction = ((Boolean) context.get(LogicalMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue();
		String service = ((QName) context.get(LogicalMessageContext.WSDL_SERVICE)).getLocalPart();
		try {
			LogicalMessage lm = context.getMessage();
			if (lm != null) {
				LOGGER.info(String.format("SOAPMessage[Servico: %s; tipo: %s; xml: %s]", service,
						direction ? "Response" : "Request", getSourceAsString((Source) lm.getPayload())));
				salvarArquivo(String.format("C:/SoapXML/%s-%s[%s].xml", service, direction ? "Request" : "Response",
						new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss.SSS").format(new Date())),
						getSourceAsString((Source) lm.getPayload()));
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}

		return true;
	}

	private String getSourceAsString(Source s) throws Exception {

		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		OutputStream out = new ByteArrayOutputStream();
		StreamResult streamResult = new StreamResult();
		streamResult.setOutputStream(out);
		transformer.transform(s, streamResult);

		return streamResult.getOutputStream().toString();
	}

	public boolean handleFault(LogicalMessageContext messageContext) {
		return true;
	}

	public void close(MessageContext messageContext) {
	}

	private void salvarArquivo(String fileName, String fileContent) {
		BufferedWriter bw = null;
		try {

			// escreve no arquivo
			FileWriter fw = new FileWriter(new File(fileName), true);

			bw = new BufferedWriter(fw);
			bw.write(fileContent);
			bw.newLine();

		} catch (IOException e) {
			LOGGER.error("ERRO ao salvar o arquivo.", e);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					LOGGER.error("ERRO ao fechar o arquivo.", e);
				}
			}
		}
	}

}
