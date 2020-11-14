package BasePackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.APPIUM_VERSION;

public class TLMobileDriverFactory extends DeviceConfig {

    public static String host;
    private static TLMobileDriverFactory MobileDriverFactoryInstance=null;
//    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
public static ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<AppiumDriver<MobileElement>>();

    public static TLMobileDriverFactory getInstance(){
        if (MobileDriverFactoryInstance==null){
            MobileDriverFactoryInstance=new TLMobileDriverFactory();
        }
        return MobileDriverFactoryInstance;
    }

    public synchronized static void mobsetupdriver() throws IOException, ParseException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        deviceConfig = readConfig();
        // JsonFileDataGetterSetter deviceConfig = readConfig();
//        .getplatformtype();
        capabilities.setCapability(APPIUM_VERSION, deviceConfig.getAPPIUMVERSION());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,deviceConfig.getPLATFORMVERSION() );
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,deviceConfig.getPLATFORMNAME());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, deviceConfig.getAUTOMATIONNAME());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceConfig.getDEVICENAME());
        capabilities.setCapability("udid", deviceConfig.getUdid());
        capabilities.setCapability("appActivity", deviceConfig.getAppActivity());
        capabilities.setCapability("appPackage", deviceConfig.getAppPackage());
        capabilities.setCapability("bundleId", deviceConfig.getBundleId());
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetkeyboard", false);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("newCommandTimeout", 9000);
        capabilities.setCapability("adbExecTimeout", 15000);
        driver.set(new AppiumDriver(new URL(deviceConfig.getHosthost()), capabilities));
    }


    public synchronized static AppiumDriver<MobileElement> getDriver(){
        return driver.get();
    }

/**https://stackoverflow.com/questions/53290266/what-are-the-best-practices-for-appium-framework-using-page-opject-model
 * **/

}
