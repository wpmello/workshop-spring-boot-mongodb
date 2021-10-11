package com.example.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class URL {

	// esse método vai pegar a string codificada do na url e decodificar
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
		try {
			return LocalDate.parse(textDate);
		} catch (DateTimeParseException  e) {
			return defaultValue;
		}		
	}
}
