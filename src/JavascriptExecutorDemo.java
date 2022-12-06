import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver; // change to java script executor
		js.executeScript("window.scrollBy(0,600)"); // go to browser, then console and type window.scrollBy(0,600) to
													// check if it is scrolling to where you want to test
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> datas = driver.findElements(By.xpath("//tr/td[4]"));
		System.out.println(driver.findElements(By.xpath("//tr")).size()); //counting number of tables.

		int sum = 0;
		for (int i = 0; i < datas.size(); i++) {
			// var currentdata = datas.get(i);
			try {
				sum = sum + Integer.parseInt(datas.get(i).getText());
			} catch (NumberFormatException e) {
				System.out.println("not a number");
			}
		}
		System.out.println("total sum calculated is " + sum);
		
		int totalAmount = Integer
				.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		
		System.out.println("total amount on screen is " + totalAmount);
		
		if (totalAmount == sum)
			System.out.println("Sum is equal to total amount");
		else
			System.out.println("Sum is not equal to total amount");
		// or
		Assert.assertEquals(sum,  totalAmount); //same as if statement above
	}
}
