import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
        		"/Users/blessingolaiya/Desktop/SeleniumAutomation/drivers/chromedriver-mac-x64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise");
		
		////a[@value='MAA)']
		//
		//a[@value='ATQ']

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //ALTERNATIVE XPATH IS USED BELOW.		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	}
}
