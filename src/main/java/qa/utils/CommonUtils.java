package qa.utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class CommonUtils {

	private static final int DEFAULT_TIME_OUT = 10;
	private WebDriver driver;
	private static String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"
			+ "abcdefghijklmnopqrstuvxyz";
	private static String alphaNumericStringIncludingSpecialCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"
			+ "abcdefghijklmnopqrstuvxyz" + ".,!@#$%&*_-";
	public CommonUtils(WebDriver driver) {
		this.driver = driver;

	}

////////////////////////////////////////

	// element is present or not
	public void assertEquals(Object actual, Object expected) throws RuntimeException {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(
					"Expected value: " + expected.toString() + " Actual value: " + actual.toString() + " - PASSED");
		} catch (Exception e) {
			System.out.println(
					"Expected value: " + expected.toString() + " Actual value: " + actual.toString() + " - FAILED");
			throw new RuntimeException(e);
		}
	}
	
	public static void verifyListOfElement(List<WebElement> web, WebDriver driver) {
		for (int i = 0; i < web.size(); i++) {
		
			try {
				Thread.sleep(2300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static String generateAlphaNumericString(int n) {
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (alphaNumericString.length() * Math.random());
			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static Long generateMobileNumber() {
		return (long) (Math.random() * 1000000 + 3333000000L);
	}
	

	public static String generateNewEmail(int n) {
		String email = generateAlphaNumericString(n).concat("@gmail.com");
		String[] emailList = email.split("@");
		int domainNameSize = emailList[1].length();
		if (emailList[0].length() <= 64 && domainNameSize <= 98) {
			if (email.length() <= 100) {
				return email;
			} else {
				int difference = email.length() - 100;
				return email.replaceAll(email.substring(0, difference), "").trim();
			}
		} else {
			int difference = emailList[0].length() - 64;
			String finalEmail = email.replaceAll(email.substring(0, difference), "").trim();
			if (finalEmail.length() <= 100) {
				return finalEmail;
			} else {
				int diff = finalEmail.length() - 100;
				return finalEmail.replaceAll(finalEmail.substring(0, diff), "").trim();
			}
		}
	}

	public static String generateAlphaNumericStringIncludingSpecialChar(int n) {
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (alphaNumericStringIncludingSpecialCharacters.length() * Math.random());
			sb.append(alphaNumericStringIncludingSpecialCharacters.charAt(index));
		}
		return sb.toString();
	}
}