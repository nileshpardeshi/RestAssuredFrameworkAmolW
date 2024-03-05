package com.demo.constants;

import java.io.File;

import lombok.Getter;

@Getter
public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static FrameworkConstants constants = null;

	public static FrameworkConstants getFCInstance() {
		if (constants == null) {
			constants = new FrameworkConstants();
		}
		return constants;

	}

	private final String mainResPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources";

	private final String testResPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources";

	private final String configPropPath = testResPath + File.separator + "config.properties";

	private final String requestJsonPath = testResPath + File.separator + "request.json";

	private final String outputJsonResponsePath = System.getProperty("user.dir") + File.separator + "output"
			+ File.separator + "jsonresponse.json";
}
