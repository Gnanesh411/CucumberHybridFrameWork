package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties intializeProperties() {
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
