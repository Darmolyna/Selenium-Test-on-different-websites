import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingRadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darmolyn\\Desktop\\Projects\\Drivers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		//driver.get("https://www.spicejet.com/");
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //getting the attribute of calender button before click and after click since the output of the calendar button above is enabled for the two instances
		//System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled()); //checking if calendar button is enabled before clicking radio button
		driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_1']")).click(); //clicking radio button
		//System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).isEnabled()); //checking if calendar button is enabled after clicking radio button
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //getting the attribute of calender button before click and after click since the output of the calendar button above is enabled for the two instances
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {//id of container wrapping calendar icon to check opacity after click
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

}
