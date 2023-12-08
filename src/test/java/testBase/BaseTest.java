package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {

		rb = ResourceBundle.getBundle("config"); // TO READ DATA FRROM PROP FILE
		logger = LogManager.getLogger(this.getClass());
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();

		} else if (browser.equals("safari")) {
			driver = new SafariDriver();

		}

		// driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(rb.getString("AppURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;

	}

	public String randomNumber() {

		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumber() {

		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		return generatedString;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	public static Object[][] getTestData(File jsonfilepath, String testCaseName) {
		Gson gson = new GsonBuilder().create();
		JsonObject job = null;
		try {
			job = gson.fromJson(new FileReader(jsonfilepath), JsonObject.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JsonElement cate = job.getAsJsonArray(testCaseName);
		int trows = job.getAsJsonArray(testCaseName).size();
		System.out.println("Row 1: " + job.getAsJsonArray(testCaseName).get(0));
		System.out.println("Total Rows: " + trows);

		Hashtable<String, String> table = null;
		int index = 0;
		Object data[][] = new Object[trows][1];

		System.out.println(
				"============================================================================================================================");
		table = new Hashtable<String, String>();
		for (int rowNum = 0; rowNum < trows; rowNum++) {
			JsonElement rowdata = job.getAsJsonArray(testCaseName).get(rowNum);
			String values = rowdata.toString().substring(1, rowdata.toString().length() - 1);
			String[] splitvalues = values.split("\",");
			int tcols = splitvalues.length;
			System.out.println("Total Columns: " + splitvalues.length);
			table = new Hashtable<String, String>();
			for (int c = 0; c < splitvalues.length; c++) {
				if (c < splitvalues.length - 1) {
					table.put(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length()),
							splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()));
					// System.out.println(splitvalues[c].split(":")[0].substring(1,
					// splitvalues[c].split(":")[0].length()-1)+"=="+splitvalues[c].split(":")[1].substring(1,
					// splitvalues[c].split(":")[1].length()));
					System.out.println(splitvalues[c].split("\":")[0].substring(1,
							splitvalues[c].split("\":")[0].length()) + "=="
							+ splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()));
				} else {
					table.put(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length()),
							splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length() - 1));
					System.out.println(splitvalues[c].split("\":")[0].substring(1,
							splitvalues[c].split("\":")[0].length()) + "=="
							+ splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length() - 1));
				}
			}
			System.out.println("Row Data: " + table);
			data[index][0] = table;
			index++;
			System.out.println();
		}
		System.out.println(
				"===========================================================================================================================");
		return data;
	}

}
