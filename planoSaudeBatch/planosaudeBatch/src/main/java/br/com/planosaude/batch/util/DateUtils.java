package br.com.planosaude.batch.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

public class DateUtils {

	private static final Logger LOGGER = Logger.getLogger(DateUtils.class);

	public static XMLGregorianCalendar parseXMLGregorianCalendar(final Date date) {
		XMLGregorianCalendar xMLGregorianCalendar = null;
		if (date != null) {
			try {
				final GregorianCalendar gregorianCalendar = new GregorianCalendar();
				gregorianCalendar.setTime(date);
				xMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
			} catch (final Exception e) {
				LOGGER.error("Erro ao converter Date para XMLGregorianCalendar.", e);
			}
		}
		return xMLGregorianCalendar;
	}
	
}
