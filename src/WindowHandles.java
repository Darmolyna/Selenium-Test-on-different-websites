import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click(); // after clicking, it opens another tab...
																			// Tab is referred to as window in Selenium
		Set<String> windows = driver.getWindowHandles(); // stores parent URL id and child URL id... [parentid, childid]
		Iterator<String> it = windows.iterator(); // iterating into windows
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId); // switcHinG into chiLd URL

		String emailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim()
				.split(" ")[0];

		System.out.println(emailId);
		driver.switchTo().window(parentId); // switching to parent ID
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailId);
	}

}
