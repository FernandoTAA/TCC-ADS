package br.com.planosaude.gui.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static LocalDate parseLocalDate(Date date) {
		if (date != null) {
			return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		} else {
			return null;
		}

	}

	public static java.util.Date parseDate(LocalDate date) {
		if (date != null) {
			return java.util.Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} else {
			return null;
		}
	}
}
