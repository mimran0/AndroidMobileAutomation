import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Love {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "AndS");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");
		dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		
		try {
			 driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello");
		System.out.println(driver.toString());

	}

}
