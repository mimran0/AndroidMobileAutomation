import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClockBaby {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AndS");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.deskclock");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.deskclock.DeskClock");
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
		
		WebElement OTime=driver.findElement(By.id("com.android.deskclock:id/digital_clock"));
		String vTime=OTime.getText();
		vTime=vTime.replace("?", " ");
		System.out.println("Time is "+vTime);
		
	
		WebElement ODate=driver.findElement(By.id("com.android.deskclock:id/date"));
		String vDate=ODate.getText();
		System.out.println("Date is "+vDate);
		
		/*driver.findElement(By.id("com.android.deskclock:id/menu_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Night mode")).click();
		*/

	}

}
