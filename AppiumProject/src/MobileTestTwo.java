import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class MobileTestTwo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("BROWSER_NAME", "Android");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AndS");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");

		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Hello");
		System.out.println(driver.toString());
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.contacts:id/expansion_view")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Name prefix")).sendKeys("Mr");
		Thread.sleep(1000);
		driver.findElement(By.name("First name")).sendKeys("md");
		Thread.sleep(1000);
		driver.findElement(By.name("Middle name")).sendKeys("shahajada");
		Thread.sleep(1000);
		driver.findElement(By.name("Last name")).sendKeys("imran");
		Thread.sleep(1000);
		driver.findElement(By.name("Name suffix")).sendKeys("Sr");
		Thread.sleep(1000);
		//HitEnter(1); //Hit enter from keyboard once
		//driver.findElement(By.name("Phone")).sendKeys("3474846905");
		//Thread.sleep(1000);
		//HitEnter(1); //hit enter from keyboard once
		//driver.findElement(By.name("Email")).sendKeys("imranlimon01@gmail.com");

		driver.findElement(By.id("com.android.contacts:id/menu_save")).click();
		Thread.sleep(7000);
		String vContactName=driver.findElement(By.id("com.android.contacts:id/large_title")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(vContactName, "Mr md shahajada imran, Sr.");
		//finding native mobile app element using content-desc property
		driver.findElement(By.xpath("//*[@content-desc = 'More options']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/title")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		
	}

	public static void HitEnter(int NumberOfEnter) {
		int i = 0;
		while (i < NumberOfEnter) {
			// Hit enter from the keyboard starts here
			Robot r = null;
			try {
				r = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			// Hit enter from the keyboard Ends here
			i++;
		}

	}

}
