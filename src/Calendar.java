import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.manage().window().maximize();

		// driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10000));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#form-field-travel_comp_date")));
		driver.findElement(By.cssSelector("#form-field-travel_comp_date")).sendKeys("a");

		// WebElement element =
		// driver.findElement(By.cssSelector("#form-field-travel_comp_date"));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript(“arguments[0].click();”, element);

		// WebElement element =
		// driver.findElement(By.cssSelector("#form-field-travel_comp_date"));
		// Actions actions = new Actions(driver);
		// actions.moveToElement(element).click().build().perform();

		while (!driver.findElement(By.cssSelector("span[title='Scroll to increment']")).getText()
				.contains("April")) //if not April, click next
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']//*[name()='svg']")).click();
		}

		Thread.sleep(5000);
		List<WebElement> dates = driver.findElements(By.className("day"));

		// grab common attribute, put into lost and iterate
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("30")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}
}
