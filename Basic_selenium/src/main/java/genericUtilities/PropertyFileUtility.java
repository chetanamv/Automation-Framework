/**
 * 
 */
package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Chetana M V
 */
public class PropertyFileUtility {
	/**
	 * This method is used to read data from property file and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException

	{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataProperties");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
			
	

	
}
}
