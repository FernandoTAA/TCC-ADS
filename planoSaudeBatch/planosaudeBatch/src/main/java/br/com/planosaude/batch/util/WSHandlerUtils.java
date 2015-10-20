package br.com.planosaude.batch.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class WSHandlerUtils {


	/**
	 * Metodo responsavel por extrair a {@link String} do XML do objeto
	 * {@link Source}.
	 * 
	 * @param source
	 *            - {@link Source} que representa o XML.
	 * @return - {@link String} com a extração do XML
	 * @throws Exception
	 */
	public static String getSourceAsString(Source source) throws Exception {

		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		OutputStream outputStream = new ByteArrayOutputStream();
		StreamResult streamResult = new StreamResult();
		streamResult.setOutputStream(outputStream);
		transformer.transform(source, streamResult);

		return streamResult.getOutputStream().toString();
	}
	
	/**
	 * Metodo responsavel por extrair a {@link String} do XML do objeto
	 * {@link SOAPMessage}.
	 * 
	 * @param sm {@link SOAPMessage} que representa o XML
	 * @return - {@link String} com a extração do XML
	 * @throws Exception
	 */
	public static String getSourceAsString(SOAPMessage sm) throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		sm.writeTo(stream);
		return stream.toString();
		
	}
	
}
