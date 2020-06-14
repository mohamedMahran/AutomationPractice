package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertisFile {
	static File file = new File("../Task1/data.properties");
	private static Properties prop = new Properties();
	static FileInputStream fis;
	private ReadPropertisFile()
	{
		
	}
	public static String getURL() throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("url");
		
	}
	
	public static String getExistingUserEmail() throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("existingUserEmail");
		
	}
	
	public static String getExistingPassword() throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty("existingUserPassword");
		
	}

}
