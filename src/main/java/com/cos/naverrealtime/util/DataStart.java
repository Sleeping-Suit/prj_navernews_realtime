package com.cos.naverrealtime.util;

import java.time.LocalDateTime;	
import java.time.format.DateTimeFormatter;

public class DataStart {
	
	public static int urlStart = 277990;
	
	public static String sDay() {
		LocalDateTime ldt = LocalDateTime.now().minusDays(1).plusHours(9);
		DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String standardday = ldt.format(dtFmt) + " 00:00:00";

		return standardday;
	}

	public static String eDay() {
		LocalDateTime ldt = LocalDateTime.now().plusHours(9);
		DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String endday = ldt.format(dtFmt) + " 00:00:00";
		return endday;
	}
}
