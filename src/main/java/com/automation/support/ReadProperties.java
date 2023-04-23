package com.automation.support;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	static String propertiesFilePath = "./config/config.properties";
	
	public static String getProperties(String key) throws IOException {
		FileReader reader = new FileReader(propertiesFilePath);
		Properties prop = new Properties();
		prop.load(reader);
		String value = prop.getProperty(key);
		reader.close();
		return value;
	}

}
