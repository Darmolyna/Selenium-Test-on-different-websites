import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		
		//month name and date
		Thread.sleep(5000);
		
		//driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10000));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#form-field-travel_comp_date")));
		//driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();
		
		WebElement element = driver.findElement(By.cssSelector("#form-field-travel_comp_date"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();
		
		for(int i=0; i<count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("30")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
			
		}
	}
}
