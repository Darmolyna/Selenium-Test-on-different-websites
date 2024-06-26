import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingHeightAndWidthOfWebElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
        		"/Users/blessingolaiya/Desktop/SeleniumAutomation/drivers/chromedriver-mac-x64/chromedriver");
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        WebElement name = driver.findElement(By.cssSelector("[name = 'name']"));
        
        System.out.println(name.getRect().getDimension().getHeight());

        System.out.println(name.getRect().getDimension().getWidth());
	}
}
