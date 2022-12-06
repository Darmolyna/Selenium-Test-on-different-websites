import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qaclickacademy.com/practice.php");

		JavascriptExecutor js = (JavascriptExecutor) driver; // change to java script executor
		js.executeScript("window.scrollBy(0,500)"); // go to browser, then console and type window.scrollBy(0,600) to
													// check if it is scrolling to where you want to test

		System.out.println(
				"table row count = " + driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
		System.out.println(
				"table column count = " + driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size());
		System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr [3]")).getText());
	}
}
