import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompleteDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qaclickacademy.com/practice.php");
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).click();
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys("ind");
		Thread.sleep(3000);

		List<WebElement> Countryoptions = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));

		for (WebElement option : Countryoptions) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		// or
		// driver.findElement(By.id("autocomplete")).sendKeys("ind");

		// Thread.sleep(2000);
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); //can be used to click a web element if it is not clickable

	}
}
