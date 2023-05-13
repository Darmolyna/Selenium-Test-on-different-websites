import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Darmolyn\\Desktop\\Projects\\Drivers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        WebElement name = driver.findElement(By.cssSelector("[name = 'name']"));
        name.sendKeys("Dami");
        File file = name.getScreenshotAs(OutputType.FILE);
        //fileutils will not be available until you import common-io apache file utils
        
        FileUtils.copyFile(file, new File("logo.png"));
        //right click on your project and refresh to see picture file generated
	}

}
