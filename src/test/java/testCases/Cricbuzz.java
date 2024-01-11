package testCases;

import java.io.File;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class Cricbuzz extends BaseTest {
	@Test(dataProvider = "getaccountdata")
	public void batmanstcount(Hashtable<String, String> data) {
		// TODO Auto-generated method stub

		driver.findElement(
				By.xpath("//a[@title='Zimbabwe v Sri Lanka - 2nd ODI']//div[@class='cb-mtch-crd-hdr cb-font-10']"))
				.click();
		driver.findElement(By.xpath("//a[normalize-space()='Scorecard']")).click();

		List<WebElement> batsmenList = driver.findElements(By.xpath("//div[@class='cb-col cb-col-25 ']"));

		System.out.println(batsmenList.size());

	}

	@DataProvider
	public Object[][] getaccountdata() {
		return getTestData(new File("testData/logindata.json"), "TestCase_01");
	}
}
