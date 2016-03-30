package vroon;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProvider {
	private static Properties prop = new Properties();
	private static String fileName = "config.properties";
	
	public static String GetProperty(String key){
		if(prop.isEmpty()){
			InputStream input = ConfigurationProvider.class.getClassLoader().getResourceAsStream(fileName);
			
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		
		String retVal = prop.getProperty(key);
		return retVal ==  null? "": retVal;
	}
}
