import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns_EditBoxes_ErrorValidation_Ass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Darmolyn\\Desktop\\Projects\\Drivers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// working with forms
		driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']"))
				.sendKeys("Olaiya Blessing");
		System.out.println(driver
				.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']")).getText());
		Thread.sleep(1000);

		// working with forms
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("olofinyokunblessing2232@gmail.com");
		System.out.println(driver.findElement(By.xpath("//input[@name='email']")).getText());
		Thread.sleep(1000);

		// working with forms
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("csc142232");
		Thread.sleep(1000);

		// working with check box1
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());
		Thread.sleep(1000);

		// working with drop-down
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);

		// working with drop-down
		dropdown.selectByVisibleText("Male");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);

		// working with drop-down
		dropdown.selectByVisibleText("Female");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);

		// working with radio button
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
		Thread.sleep(1000);

		// working with calendar
		driver.findElement(By.xpath("//input[@name='bday']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("21062000");

		// working with button
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
}
