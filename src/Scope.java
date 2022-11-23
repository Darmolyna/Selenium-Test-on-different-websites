import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qaclickacademy.com/practice.php");
		
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkCount); //count of link in the entire page
		
		//var footerLinksCount = driver.findElements(By.xpath("//tr/td/ul/li/a")).size();
		//System.out.println(footerLinksCount);
		
		//or
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); 
		System.out.println(footerdriver.findElements(By.tagName("a")).size()); //count of links in the footer
		
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //tbody/tr/td[1]/ul[1]
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//click on each link in the column and verify if the links are opening
		
		for(int i =1; i<columndriver.findElements(By.tagName("a")).size(); i++ ) {
			//columndriver.findElements(By.tagName("a")).get(i).click();			
			String clickLinkAndOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkAndOpenInNewTab);
			Thread.sleep(5000);	
		}
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext()){ //has next checks if it is available or not and it also returns boolean value
			driver.switchTo().window(it.next()); //next actually moves to the next
			System.out.println(driver.getTitle());
		}
		
	}

}
