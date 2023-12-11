package qa.factory;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;

	public class Driver_factory {
		WebDriver driver;
		
		public WebDriver initDriver(Properties prop) {
			String browserName = prop.getProperty("browser");

			System.out.println("browser name is :" + browserName);

			switch (browserName.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("Please pass correct Driver name : " + browserName);
				break;}

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

			return driver;

		}
		
			
		public Properties initProp() {
			Properties prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("./src/test/resources/Config_properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			}

			return prop;

		}

}
