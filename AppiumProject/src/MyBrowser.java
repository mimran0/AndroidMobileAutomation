
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 */

/**
 * @author md shahajada imran
 *
 */
public class MyBrowser {

	public static void main(String Args[]) throws InterruptedException {
		WebDriver driver = null;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.browser");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.browser.BrowserActivity");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "BROWSER");
		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Hello");
		System.out.println(driver.toString());
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(20000);
		//WebElement objCreateNewAccount = driver
			//	.findElement(By.xpath("//android.widget.Spinner[@content-desc='Enter your search term']"));
		//WebElement objCreateNewAccount = driver.findElement(By.name("Enter your search term"));
		//WebElement objCreateNewAccount=driver.findElementByAndroidUIAutomator("UiSelector().description(\"Enter your search term\")");
	
		//objCreateNewAccount.sendKeys("md shahajada");;
		
		//List<WebElement> MyFuckenList=driver.findElements(By.xpath("//android.widget.EditText[@content-desc='Email or Phone']"));
		//List<WebElement> MyFuckenList=driver.findElements(By.cssSelector("Spinner[content-desc*='Enter your search term']"));
		//"//*[@content-desc = 'Create New Account']"
		driver.findElement(By.xpath("//*[@content-desc = 'Go back']")).click();
		List<WebElement> MyFuckenList=driver.findElements(By.xpath("//*[@content-desc='Create New Account']"));
		//List<WebElement> MyFuckenList=driver.findElements(By.tagName("content-desc"));
		System.out.println(MyFuckenList.size());
		for(WebElement v:MyFuckenList){
			System.out.println(v.getAttribute("content-desc"));
		}
	}

}
