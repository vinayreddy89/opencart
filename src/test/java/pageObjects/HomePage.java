package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// To click my account in Home Page
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement accountLink;

	public void clickAccountLink() {
		try {
			accountLink.click();
			System.out.println("clicking on MyAccount :");
		} catch (Throwable t) {
			System.out.println("Unable to click	MyAccount" + t);
			driver.quit();
			Assert.fail();
		}

	}

	// To click on register in Home Page
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
	WebElement registerlink;

	public void clickRegisterLink() {
		try {
			registerlink.click();
			System.out.println("click on register:");
		} catch (Throwable t) {
			System.out.println("Unable to click on register" + t);
			driver.quit();
			Assert.fail();
		}
	}

}
