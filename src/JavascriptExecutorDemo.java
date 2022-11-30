import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		List <WebElement> datas = driver.findElements(By.xpath("//tr/td[4]"));
		
		int sum = 0;
		for (int i =0; i<datas.size(); i++)
		{
			//var currentdata = datas.get(i);
			sum = sum + Integer.parseInt(datas.get(i).getText());
		}
		System.out.println(sum);
		
	}
}
