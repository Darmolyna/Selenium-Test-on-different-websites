import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qaclickacademy.com/practice.php");
		
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount); //count of link in the entire page
		var footerLinksCount = driver.findElements(By.xpath("//tr/td/ul/li/a")).size();
		System.out.println(footerLinksCount);
	}

}
