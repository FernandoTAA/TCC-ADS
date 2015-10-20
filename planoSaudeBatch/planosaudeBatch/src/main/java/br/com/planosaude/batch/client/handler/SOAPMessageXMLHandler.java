package br.com.planosaude.batch.client.handler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;

import br.com.planosaude.batch.util.FileUtils;
import br.com.planosaude.batch.util.WSHandlerUtils;

/**
 * Classe resposavel por monitorar os Requests e Responses e extrair o XML.
 * 
 * @author FernandoTAA
 *
 */
public class SOAPMessageXMLHandler implements SOAPHandler<SOAPMessageContext> {

	private final static Logger LOGGER = Logger.getLogger(SOAPMessageXMLHandler.class);

	/**
	 * @see LogicalHandler#handleMessage(MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean direction = ((Boolean) context.get(LogicalMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue();
		String service = ((QName) context.get(LogicalMessageContext.WSDL_SERVICE)).getLocalPart();
		try {
			SOAPMessage soapMessage = context.getMessage();
			if (soapMessage != null) {
				LOGGER.info(String.format("SOAPMessage[Servico: %s; tipo: %s; xml: %s]", service,
						direction ? "Response" : "Request", WSHandlerUtils.getSourceAsString(soapMessage)));
				FileUtils.salvarArquivo(
						String.format("C:/SoapXML/%s-%s[%s].xml", service, direction ? "Request" : "Response",
								new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss.SSS").format(new Date())),
						WSHandlerUtils.getSourceAsString(soapMessage));
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}

		return true;
	}

	/**
	 * @see SOAPMessageXMLHandler#handleFault(LogicalMessageContext)
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	/**
	 * @see SOAPMessageXMLHandler#close(MessageContext)
	 */
	@Override
	public void close(MessageContext messageContext) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
