package testCases;

public class ForLoop {
	public String s = "scorecard";

	public static void main(String[] args) {

		int b[] = new int[10];
		b[0] = 100;
		System.out.println(b[0]);

		int a[] = { 10, 20, 30, 40, 50 };

		// System.out.println(Arrays.toString(a));

		for (int i = 0; i <= a.length - 1; i++) {
			System.out.println(a[i]);
		}

		/*
		 * WebDriver driver = new ChromeDriver();
		 * 
		 * driver.get("https://www.cricbuzz.com/"); driver.manage().window().maximize();
		 * driver.findElement(By.xpath(
		 * "//a[@title='India v South Africa - 3rd T20I']//div[@class='cb-hmscg-bat-txt']//div[@class='cb-col-50 cb-ovr-flo cb-hmscg-tm-name']"
		 * )) .click();
		 * 
		 * 
		 * List<WebElement> element =
		 * driver.findElements(By.xpath("//nav[contains(@class,'cb-nav-bar')]/a"));
		 * 
		 * for (int i = 0; i <= element.size(); i++) {
		 * 
		 * System.out.println(element.get(i).getText());
		 * 
		 * }
		 * 
		 * driver.findElement(By.xpath("//a[normalize-space()='Scorecard']")).click();
		 * 
		 * List<WebElement> table = driver .findElements(By.
		 * xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']/child::div")); for (int
		 * i = 0; i < table.size(); i++) {
		 * 
		 * System.out.println(table.get(i).getText());
		 * 
		 * }
		 */

		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("Enter a Number");
		 * int num = sc.nextInt();
		 */

		/*
		 * StringBuffer sb = new StringBuffer(String.valueOf(num)); // StringBuffer
		 * rev=sb.append(num); StringBuffer rev = sb.reverse(); System.out.println(rev);
		 */
		/*
		 * StringBuilder sb1 = new StringBuilder(); sb1.append(num); sb1.reverse();
		 * System.out.println(sb1);
		 */

	}

}
