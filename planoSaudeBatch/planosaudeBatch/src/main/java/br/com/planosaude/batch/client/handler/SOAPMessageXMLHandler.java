package br.com.planosaude.batch.client.handler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import br.com.planosaude.batch.util.FileUtils;

/**
 * Classe resposavel por monitorar os Requests e Responses e extrair o XML.
 * 
 * @author FernandoTAA
 *
 */
public class SOAPMessageXMLHandler implements LogicalHandler<LogicalMessageContext> {

	private final static Logger LOGGER = Logger.getLogger(SOAPMessageXMLHandler.class);

	/**
	 * @see LogicalHandler#handleMessage(MessageContext)
	 */
	@Override
	public boolean handleMessage(LogicalMessageContext context) {
		boolean direction = ((Boolean) context.get(LogicalMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue();
		String service = ((QName) context.get(LogicalMessageContext.WSDL_SERVICE)).getLocalPart();
		try {
			LogicalMessage lm = context.getMessage();
			if (lm != null) {
				LOGGER.info(String.format("SOAPMessage[Servico: %s; tipo: %s; xml: %s]", service,
						direction ? "Response" : "Request", getSourceAsString((Source) lm.getPayload())));
				FileUtils.salvarArquivo(
						String.format("C:/SoapXML/%s-%s[%s].xml", service, direction ? "Request" : "Response",
								new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss.SSS").format(new Date())),
						getSourceAsString((Source) lm.getPayload()));
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
	public boolean handleFault(LogicalMessageContext messageContext) {
		return true;
	}

	/**
	 * @see SOAPMessageXMLHandler#close(MessageContext)
	 */
	@Override
	public void close(MessageContext messageContext) {
	}

	/**
	 * Metodo responsavel por extrair a {@link String} do XML do objeto
	 * {@link Source}.
	 * 
	 * @param source
	 *            - {@link Source} que representa o XML.
	 * @return - {@link String} com a extração do XML
	 * @throws Exception
	 */
	private String getSourceAsString(Source source) throws Exception {

		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		OutputStream outputStream = new ByteArrayOutputStream();
		StreamResult streamResult = new StreamResult();
		streamResult.setOutputStream(outputStream);
		transformer.transform(source, streamResult);

		return streamResult.getOutputStream().toString();
	}

}
