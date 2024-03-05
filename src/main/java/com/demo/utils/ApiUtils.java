package com.demo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;

public final class ApiUtils {

	public ApiUtils() {
	}
	
	public static String readJsonAndGetAsString(String filePath) {
		String string = null;
		try {
			string= new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
	}
	
	public static void storeJsonAndGetAsString(String filePath, Response response) {
		try {
			Files.write(Paths.get(filePath), response.asByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
