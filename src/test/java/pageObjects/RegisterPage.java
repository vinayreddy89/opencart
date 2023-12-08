package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends BaseClass {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// To click submit in Home Page
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement textFirstName;

	public void enterFirstName(String FirstName) {
		try {
			textFirstName.sendKeys(FirstName);
			System.out.println("unable to click");
		} catch (Throwable t) {
			System.out.println("Unable to click" + t);
			driver.quit();
			Assert.fail();
		}
	}

	// To click submit in Home Page
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement textLastName;

	public void enterLastName(String LastName) {
		try {
			textLastName.sendKeys(LastName);
			System.out.println("unable to click");
		} catch (Throwable t) {
			System.out.println("Unable to click" + t);
			driver.quit();
			Assert.fail();
		}
	}

	// To enter email in Home Page
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement textEmailName;

	public void enterEmailName(String Email) {
		try {
			textEmailName.sendKeys(Email);
			System.out.println("unable to click");
		} catch (Throwable t) {
			System.out.println("Unable to click" + t);
			driver.quit();
			Assert.fail();
		}
	}

	// To enter phone in Home Page
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement textPhone;

	public void enterPhone(String Phone) {
		try {
			textPhone.sendKeys(Phone);
			System.out.println("unable to enter phone");
		} catch (Throwable t) {
			System.out.println("Unable to enter phone" + t);
			driver.quit();
			Assert.fail();
		}
	}

	// To enter phone in Home Page
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement textPassword;

	public void enterPassword(String Pass) {
		try {
			textPassword.sendKeys(Pass);
			System.out.println("unable to enter pass");
		} catch (Throwable t) {
			System.out.println("Unable to enter pass" + t);
			driver.quit();
			Assert.fail();
		}
	}

	// To enter phone in Home Page
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement textConfirmPassword;

	public void enterConfirmPassword(String confPass) {
		try {
			textConfirmPassword.sendKeys(confPass);
			System.out.println("unable to enter pass");
		} catch (Throwable t) {
			System.out.println("Unable to enter pass" + t);
			driver.quit();
			Assert.fail();
		}
	}

	// To enter phone in Home Page
	@FindBy(xpath = "//input[@name='agree']")
	WebElement clickPrivacy;

	public void clickPrivacy() {
		try {
			clickPrivacy.click();
			System.out.println("unable to enter pass");
		} catch (Throwable t) {
			System.out.println("Unable to enter pass" + t);
			driver.quit();
			Assert.fail();
		}
	}

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clickContinue;

	public void clickContinue() {
		try {
			clickContinue.click();
			System.out.println("unable to enter pass");
		} catch (Throwable t) {
			System.out.println("Unable to enter pass" + t);
			driver.quit();
			Assert.fail();
		}
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement getConfirmation;

	public String getConfirmation() {
		try {
			return (getConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
