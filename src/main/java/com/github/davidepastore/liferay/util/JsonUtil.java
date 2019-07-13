package com.github.davidepastore.liferay.util;

import com.github.davidepastore.liferay.model.DDMDocumentAndMedia;
import com.github.davidepastore.liferay.model.DDMGeolocation;
import com.github.davidepastore.liferay.model.DDMImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * @author Christian Palombella
 *
 */
public class JsonUtil {

	/**
	 * Get a DDMGeolocation instance from the given String.
	 * @param ddmGeolocationString The String to convert into a DDMGeolocation object.
	 * @return Returns the DDMGeolocation object.
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 */
	public static DDMGeolocation getDDMGeolocation(String ddmGeolocationString) throws JsonSyntaxException, JsonIOException, JsonParseException {
		Gson gson = new GsonBuilder().create();
		DDMGeolocation ddmGeolocation = gson.fromJson(ddmGeolocationString, new TypeToken<DDMGeolocation>(){}.getType());

		return ddmGeolocation;
	}

	/**
	 * Get a DDMImage instance from the given String.
	 * @param ddmImageString The String to convert into a DDMImage object.
	 * @return Returns the DDMImage object.
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 */
	public static DDMImage getDDMImage(String ddmImageString) throws JsonSyntaxException, JsonIOException, JsonParseException {
		Gson gson = new GsonBuilder().create();
		DDMImage ddmImage = gson.fromJson(ddmImageString, new TypeToken<DDMImage>(){}.getType());

		return ddmImage;
	}

	/**
	 * Get a DDMDocumentAndMedia instance from the given String.
	 * @param ddmDocumentAndMediaString The String to convert into a DDMDocumentAndMedia object.
	 * @return Returns the DDMDocumentAndMedia object.
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 */
	public static DDMDocumentAndMedia getDDMDocumentAndMedia(String ddmDocumentAndMediaString) throws JsonSyntaxException, JsonIOException, JsonParseException {
		Gson gson = new GsonBuilder().create();
		DDMDocumentAndMedia ddmDocumentAndMedia = gson.fromJson(ddmDocumentAndMediaString, new TypeToken<DDMDocumentAndMedia>(){}.getType());

		return ddmDocumentAndMedia;
	}
}
