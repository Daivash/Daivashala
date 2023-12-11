package qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import qa.factory.Driver_factory;
import qa.pages.AddToCartPage;
import qa.utils.CommonUtils;

public class Base_Test  {
	
		
		WebDriver driver;
		protected Driver_factory df;
		protected Properties proper;
		protected CommonUtils comUtils;
		protected AddToCartPage addCartPage ;
		
				
		@BeforeTest
		public void setup() 
		{
			df = new Driver_factory();
			proper = df.initProp();
			driver = df.initDriver(proper);
			
			comUtils = new CommonUtils(driver);
			addCartPage = new AddToCartPage(driver);		
			

						
		}	
		
		
		
}
