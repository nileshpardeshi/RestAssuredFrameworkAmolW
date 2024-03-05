package com.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.demo.customexception.FIFOException;
import com.demo.customexception.PropFileNotFoundException;

public final class PropertyBuilder {

	private PropertyBuilder() {
	}

	public static Properties getPropertyFile(String filePath) {
		FileInputStream fileInputStream = null;
		Properties properties = new Properties();
		try {
			fileInputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			throw new PropFileNotFoundException("File could not be found", e);
		}
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			throw new FIFOException("FIFO exception has occured", e);
		}
		return properties;

	}
}