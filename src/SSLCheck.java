import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		//options.addExtensions("link to file extension"); if you needed to add or access a plugin
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy); //to set proxy
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path"); //set where to download files
		
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GIFT\\eclipse-workspace\\drivers\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options); //pass the chromeoption into chrome driver class
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());
	}
}
