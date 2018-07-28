import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class GoogleChromeMobile {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "And1");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.launcher3");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.launcher3.Launcher");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello");
		System.out.println(driver.toString());
		Thread.sleep(1000);

		WebElement oGoogleChrome = driver.findElement(By.id("com.android.quicksearchbox:id/search_widget_text"));
		oGoogleChrome.click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.quicksearchbox:id/search_src_text")).sendKeys("Rose");
		Thread.sleep(5000);
		driver.findElement(By.id("com.android.quicksearchbox:id/search_go_btn")).click();
		Thread.sleep(2000);
		
	}

	public static void HighLight_Element(WebDriver driver, WebElement object) {
		// highlight only one element.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", object);
	}
}