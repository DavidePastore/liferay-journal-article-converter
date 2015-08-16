package com.github.davidepastore.liferay.util;

import java.util.Locale;

/**
 * {@link Locale} util.
 * @author Davide Pastore
 *
 */
public class SimpleLocaleUtil {
	
	/**
	 * Splits the locale.
	 * @param locale The {@link Locale}.
	 * @return Returns an array of {@link String}.
	 */
	public static String[] splitsLocale(String locale){
		String[] splits = locale.split("_");
		return splits;
	}
	
	/**
	 * Build the locale from the given locale string.
	 * 
	 * @param localeString The locale string.
	 * @return Returns the {@link Locale}.
	 */
	public static Locale buildLocale(String localeString) {
		String[] splits = splitsLocale(localeString);
		String language = splits[0];
		String country = splits[1];
		return new Locale(language, country);
	}
}
