package com.github.davidepastore.liferay.util;

import com.github.davidepastore.liferay.model.DDMDocumentAndMedia;
import com.github.davidepastore.liferay.model.DDMGeolocation;
import com.github.davidepastore.liferay.model.DDMImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;

/**
 * @author Christian Palombella
 *
 */
public class JsonUtil {

	/**
	 *
	 * @param ddmGeolocationString
	 * @return
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws FileNotFoundException
	 */
	public static DDMGeolocation getDDMGeolocation(String ddmGeolocationString) throws JsonSyntaxException, JsonIOException, FileNotFoundException {

		Gson gson = new GsonBuilder().create();
		DDMGeolocation ddmGeolocation = gson.fromJson(ddmGeolocationString, new TypeToken<DDMGeolocation>(){}.getType());

		return ddmGeolocation;
	}

	/**
	 *
	 * @param ddmImageString
	 * @return
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws FileNotFoundException
	 */
	public static DDMImage getDDMImage(String ddmImageString) throws JsonSyntaxException, JsonIOException, FileNotFoundException {

		Gson gson = new GsonBuilder().create();
		DDMImage ddmImage = gson.fromJson(ddmImageString, new TypeToken<DDMImage>(){}.getType());

		return ddmImage;
	}

	/**
	 *
	 * @param ddmDocumentAndMediaString
	 * @return
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws FileNotFoundException
	 */
	public static DDMDocumentAndMedia getDDMDocumentAndMedia(String ddmDocumentAndMediaString) throws JsonSyntaxException, JsonIOException, FileNotFoundException {

		Gson gson = new GsonBuilder().create();
		DDMDocumentAndMedia ddmDocumentAndMedia = gson.fromJson(ddmDocumentAndMediaString, new TypeToken<DDMDocumentAndMedia>(){}.getType());

		return ddmDocumentAndMedia;
	}
}
