/**
 * 
 */
package Calendar;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author md shahajada imran TestSet contains native app automation of
 *         "Calendar"
 *
 */
public class TestSetOne {
	// declaring driver as field variable (class level) so that it can be accessed by all
	// TestNG tests.
	WebDriver driver = null;

	@BeforeTest
	public void BeforTest() {
		System.out.println("before test");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AndS");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calendar");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calendar.AllInOneActivity");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Requirement 101: Verify that Today, Week, Calendar objects display on the native app. 
	@Test(enabled = false)
	public void TC_101_Verify3Objects() throws InterruptedException {
		System.out.println("Hello Test 101");
		System.out.println(driver.toString());
		Thread.sleep(10000);
		
		WebElement objToday=driver.findElement(By.name("Today"));
		WebElement objWeek=driver.findElement(By.name("Week"));
		WebElement objCalendarImage=driver.findElement(By.id("android:id/home"));
		
		//checkpoint
		boolean isobjTodayPresent=objToday.isDisplayed();
		Assert.assertTrue(isobjTodayPresent);
		
		//checkpoint
		boolean isobjWeekPresent=objWeek.isDisplayed();
		Assert.assertTrue(isobjWeekPresent);
		
		//chckpont
		boolean isobjCalendarImagePresent=objCalendarImage.isDisplayed();
		Assert.assertTrue(isobjCalendarImagePresent);
		
		
	}
	
	//Requirement 102: Verify that users are able to refresh the app.
	@Test(enabled=false)
	public void TC_102_RefreshApp() throws InterruptedException{
		System.out.println("Hello Test 102");
		System.out.println(driver.toString());
		Thread.sleep(10000);
		
		WebElement objMoreOptions=driver.findElement(By.xpath("//*[@content-desc = 'More options']"));
		objMoreOptions.click();
		Thread.sleep(4000);
		WebElement objRefresh=driver.findElement(By.name("Refresh"));
		objRefresh.click();
		
		//Checkpoint
		boolean isobjRefreshPresent=objRefresh.isDisplayed();
		//System.out.println(isobjRefreshPresent);
		Assert.assertFalse(isobjRefreshPresent);
		
		
	}
	
	//Requirement 103: Users are able to search text on the native app.
	@Test(enabled=true)
	public void TC_103_SearchText() throws InterruptedException, AWTException{
		System.out.println("Hello Test 103");
		System.out.println(driver.toString());
		Thread.sleep(10000);
		
		WebElement objMoreOptions=driver.findElement(By.xpath("//*[@content-desc = 'More options']"));
		objMoreOptions.click();
		Thread.sleep(4000);
		WebElement objSearch=driver.findElement(By.name("Search"));
		objSearch.click();
		Thread.sleep(4000);
		WebElement objSearchText=driver.findElement(By.id("android:id/search_src_text"));
		objSearchText.sendKeys("imran");
		
		//Hit enter from keyboard
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}
