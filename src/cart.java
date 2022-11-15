import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cart {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Darmolyn\\Desktop\\Projects\\Drivers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // implicit wait

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5000)); // declaring explicit wait

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" }; // arrays to be converted to array list
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		// wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); // using explicit
																									// wait
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();

		// wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"promoInfo\"])"))); // using
																											// explicit
																											// wait
		System.out.println(driver.findElement(By.xpath("//span[@class=\"promoInfo\"]")).getText());
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			// Brocolli - 1 Kg
			// Brocolli, 1 kg

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// format it to get actual vegetable name
			// convert array into array list for easy search...array list is used to
			// validate complicated list
			// and also saves memory
			// check whether the name you extracted is present in arrayList or not-

			List itemsNeededList = Arrays.asList(itemsNeeded); // converted array to array list
			if (itemsNeededList.contains(formattedName)) {
				j++;
				// click on Add to cart of exact item on the list
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
