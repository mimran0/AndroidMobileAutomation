import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FunTestNG {

	
	@Test(enabled=true)
	public void TC() throws MalformedURLException{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("BROWSER_NAME", "Android");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "And1");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		
		
		WebDriver driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		System.out.println("Hello");
		System.out.println(driver.toString());
		
		driver.findElement(By.name("4")).click();
		driver.findElement(By.name("+")).click();
		driver.findElement(By.name("6")).click();
		driver.findElement(By.name("=")).click();
		Assert.assertEquals("4", "4");
	}
}
