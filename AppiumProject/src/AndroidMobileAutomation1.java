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

public class AndroidMobileAutomation1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AndS");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Hello");
		System.out.println(driver.toString());
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.contacts:id/expansion_view")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("Name prefix")).sendKeys("Mr");
		Thread.sleep(3000);
		driver.findElement(By.name("First name")).sendKeys("md");
		Thread.sleep(3000);
		driver.findElement(By.name("Middle name")).sendKeys("shahajada");
		Thread.sleep(3000);
		driver.findElement(By.name("Last name")).sendKeys("Imran");
		Thread.sleep(3000);
		driver.findElement(By.name("Name suffix")).sendKeys("Sr");
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.contacts:id/menu_save")).click();
		Thread.sleep(8000);
		// finding native mobile app element using content-desc property
		driver.findElement(By.xpath("//*[@content-desc = 'More options']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/title")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(5000);

		// dealing with the popup window of duplicate contacts check.
		// Popup window check starts here
		try {
			WebElement objPopUpWindow = driver.findElement(
					By.name("Switch to editing the selected contact? Information you entered so far will be copied."));
			if (objPopUpWindow.isDisplayed() == true) {
				driver.findElement(By.name("OK")).click();
				Thread.sleep(5000);
			}
		} catch (Exception e1) {
		}
		// Popup window check ends here

		// checkpoint starts here
		boolean vCheckpoint = false;
		try {
			vCheckpoint = driver.findElement(By.name("Me")).isDisplayed();
		} catch (Exception e) {
		}
		if (vCheckpoint == true) {
			System.out.println("All records are deleted");
		} else {
			// Assert.fail("All records are not deleted.");
		}
		// checkpoint ends here

	}

}
