import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class firstAppTest {

	public static void main(String[] args) throws IOException {
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
		String vResult=driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
		System.out.println(vResult);
		String[] arrResult=vResult.split("\\+");
		int v=0;
		for(String vs:arrResult){
			System.out.println(vs);
			int vt=Integer.parseInt(vs);
			v=v+vt;
			System.out.println(v);
		}
		Assert.assertEquals(10, v);
		driver.quit();
		
		/*WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities().android();

        capabilities.setCapability("no", true);
        capabilities.setCapability("newCommandTimeout", 100000);
        capabilities.setCapability("noReset", true);

        capabilities.setCapability("deviceName", "And1");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
        capabilities.setCapability("deviceName", "Venue7 3740 LTE");
         capabilities.setCapability("app", "com.android.calculator2");
        capabilities.setCapability("noRest", true);
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appActivity",
                "com.android.calculator2.Calculator");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/

	}

}
