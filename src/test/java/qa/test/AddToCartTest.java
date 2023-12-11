package qa.test;

import org.testng.annotations.Test;
import qa.base.Base_Test;

public class AddToCartTest extends Base_Test {

	@Test(enabled = true, description = "Search iphone -> select from the list -> go to product details page -> select and store price in a variable -> add to cart")

	public void searchIphoneTest() throws InterruptedException {
		addCartPage.searchIphone();
	}

	@Test(enabled = true, description = "Register user")
	public void ragisterUserTest() throws InterruptedException {
		addCartPage.ragister();
	}

	@Test(enabled = true, description = "Search phone -> apply filters -> validate the filtered list")
	public void searchPhoneAndFilterTest() throws InterruptedException {
		addCartPage.searchPhoneAndFilter();
	}

}