package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	//Method to read from config.properties file
	public static String readPropertiesFile(String key) {
		
		try { // Giving the config.properties file location                                      
			InputStream input = new FileInputStream("\\Users\\jyoth\\Numpy Ninja\\eclipse-workspace\\UserAPIRestAssured\\src\\test\\java\\Config\\config.properties");			        
			prop.load(input); //Loading the config.properties file
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);// Getting the required property from the config.properties file
	}
	
	//Method to write to config.properties file
	public static void writePropertiesFile(String key, String value) {
		
		try {
			OutputStream output = new FileOutputStream("\\Users\\jyoth\\git\\repository\\Ds_algo_Achievers\\Ds_algo_Achievers\\src\\test\\java\\Config\\config.properties");
			prop.setProperty(key, value);
			prop.store(output, null);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

//	public static void main(String[] args) {
//		String str = readPropertiesFile("getStartedPageUrl");
//		System.out.println(str);
////		writePropertiesFile("url","pageLink");
//
//	}

}
