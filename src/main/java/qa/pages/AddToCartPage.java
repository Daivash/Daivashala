package qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.utils.CommonUtils;

public class AddToCartPage {

	private WebDriver driver;
	private CommonUtils comUtils;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@class='s-suggestion-container']")
	private List<WebElement> suggList;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	private WebElement mobile;

	@FindBy(xpath = "//span//input[@value='submit']")
	private WebElement addCartBtn;

	@FindBy(xpath = "(//h4[contains(text(),\"Added to Cart\")])[1]")
	private WebElement addCartVerification;

/////////////////////////////////////////////////
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement ragister;

	@FindBy(xpath = "//a[@id='createAccountSubmit']")
	private WebElement crateAccBtn;

	@FindBy(xpath = "//h1[@class='a-spacing-small moa_desktop_signup']")
	private WebElement title;

	@FindBy(xpath = "//input[@id='ap_customer_name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='ap_phone_number']")
	private WebElement phoneNo;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement passWard;

	public void searchIphone() throws InterruptedException {

		searchBox.sendKeys("iphone");
		Thread.sleep(3000);

		for (int i = 0; i < suggList.size() - 1; i++) {
			System.out.println(suggList.get(i).getText());
		}

		for (int i = 0; i < suggList.size() - 1; i++) {
			if (suggList.get(i).getText().contains("iphone 15 pro max")) {
				suggList.get(i).click();
			}
			mobile.click();
			driver.navigate().refresh();
			Thread.sleep(3000);
			addCartBtn.click();
			addCartVerification.isDisplayed();
		}
		driver.quit();

	}

	public void ragister() throws InterruptedException {
		ragister.click();
		Thread.sleep(3000);
		crateAccBtn.click();
		title.isDisplayed();
		firstName.sendKeys(comUtils.generateAlphaNumericString(6));
		String moblieNo = Long.toString(comUtils.generateMobileNumber());
		phoneNo.sendKeys(moblieNo);
		email.sendKeys(comUtils.generateNewEmail(9));
		passWard.sendKeys(comUtils.generateAlphaNumericStringIncludingSpecialChar(14));
		driver.quit();
	}

	public void searchPhoneAndFilter() throws InterruptedException {

		searchBox.sendKeys("phone");
		Thread.sleep(3000);

		for (int i = 0; i < suggList.size() - 1; i++) {
			System.out.println(suggList.get(i).getText());
		}
		comUtils.verifyListOfElement(suggList, driver);
		driver.quit();
	}

}
