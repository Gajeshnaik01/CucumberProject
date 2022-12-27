package UtilityMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties properties;

	public void intializeConfigReader() throws IOException {
		FileInputStream file = new FileInputStream("./Configuration/config.properties");
		properties = new Properties();
		properties.load(file);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
