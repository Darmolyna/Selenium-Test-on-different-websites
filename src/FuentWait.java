import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FuentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)) // waiting for the
																										// total of 30
																										// sec's
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class); // checks at interval of 3
																								// sec's

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() { // wait until function of web-driver returns
																			// web-element
			public WebElement apply(WebDriver driver) { // this aaply method is expecting return type of web element...
														// if it returns null, then is waits for 3 sec's again and
														// then research untill it returns a web element.
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} else
					return null;
			}
		});

		System.out.println(driver.findElement(By.cssSelector("[id = 'finish'] h4")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("[id = 'finish'] h4")).getText());
	}
}
