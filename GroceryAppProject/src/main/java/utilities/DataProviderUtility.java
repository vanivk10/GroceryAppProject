package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	public static Properties prop;
	static FileInputStream ip;
	public static void testBasic()  {
		prop=new Properties();		
		//FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Excception" + e);
		}	
		try {
			prop.load(ip);
		} catch (IOException e) {
			System.out.println("Excception" + e);
		}	
	}
	
	ExcelReadUtility er=new ExcelReadUtility();

	@DataProvider(name = "dataProvider")
	public Object[][] dpMethod() throws IOException {
		testBasic();
		return new Object[][] { { er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 1, 0), er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 1, 1)}, { er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 2, 0), er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("DataProviderSheet"), 2, 1) } };
	}

}
