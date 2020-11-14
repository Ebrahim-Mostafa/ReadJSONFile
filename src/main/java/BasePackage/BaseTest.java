package BasePackage;

import io.appium.java_client.AppiumDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest{
    public static WebDriver driver;
    public static ChromeDriverService service;
    public static AppiumDriver<?> mobileDriver;
    public static String platform;
    public static String browser;
    public static String url;
    public static String APPIUM_VERSION;
    public static String PLATFORM_VERSION;
    public static String PLATFORM_NAME;
    public static String AUTOMATION_NAME;
    public static String DEVICE_NAME;
    public static String udid;
    public static String appActivity;
    public static String appPackage;
    public static String bundleId;
    public static String host;

    public static WebElement element(By element) {
        return  TLMobileDriverFactory.getInstance().getDriver().findElement(element);

    }

    /**@BeforeTest(alwaysRun = true)
    public void setup() throws IOException {
    //todo ReadFromJson as Array []
    String filePath = System.getProperty("user.dir") + "/Data/data.json/";
    JsonReader reader = new JsonReader (new FileReader(filePath));
    Gson gson = new Gson();
    reader.beginArray();
    //        while(reader.hasNext()){
    JsonFileDataGetterSetter orgData = gson.fromJson(reader, JsonFileDataGetterSetter.class);
    //            JsonFileDataGetterSetter orgData = gson.fromJson(reader,new TypeToken<JsonFileDataGetterSetter>(){
    //            }.getType());
    platform = orgData.getPlatform();
    System.out.println(platform);
    browser = orgData.getBrowser();
    url = orgData.getUrl();
    APPIUM_VERSION = orgData.getAPPIUMVERSION();
    PLATFORM_VERSION = orgData.getPLATFORMVERSION();
    PLATFORM_NAME = orgData.getPLATFORMNAME();
    AUTOMATION_NAME = orgData.getAUTOMATIONNAME();
    DEVICE_NAME = orgData.getDEVICENAME();
    udid = orgData.getUdid();
    appActivity = orgData.getAppActivity();
    appPackage = orgData.getAppPackage();
    bundleId = orgData.getBundleId();
    host = orgData.getHosthost();
    //        }
    //        reader.endArray();
    //        reader.close();

    //todo: ReadFromJson as Objects {}

    //    JsonElement jsonData = new JsonParser().parse(new FileReader(filePath));
    // JsonElement deviceData = jsonData.getAsJsonObject().get("Device");
    // JsonElement deviceData = jsonData.getAsJsonObject();
    // JsonFileDataGetterSetter orgData = new Gson().fromJson(deviceData,new TypeToken<JsonFileDataGetterSetter>(){
    // }.getType());

    try {
    switch (platform) {
    case "web":
    switch (browser) {
    case "chrome":
    WebDriverManager.chromedriver().setup();
    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    driver = new ChromeDriver();
    break;
    case "firefox":
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    break;
    case "edge":
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    break;
    case "IE":
    WebDriverManager.iedriver().setup();
    driver = new InternetExplorerDriver();
    break;
    }
    driver.get(url);
    reader.hasNext();
    reader.beginObject();
    case "mobile":
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, APPIUM_VERSION);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
    capabilities.setCapability("udid", udid);
    capabilities.setCapability("appActivity", appActivity);
    capabilities.setCapability("appPackage", appPackage);
    capabilities.setCapability("bundleId", bundleId);
    capabilities.setCapability("unicodeKeyboard", true);
    capabilities.setCapability("resetkeyboard", false);
    capabilities.setCapability("noReset", false);
    capabilities.setCapability("newCommandTimeout", 9000);
    capabilities.setCapability("adbExecTimeout", 15000);
    mobileDriver = new AppiumDriver<>(new URL(host), capabilities);
    break;
    }
    } catch (Exception ex) {
    ex.getCause();
    }
    }**/

    @BeforeTest(alwaysRun = true)
    public static void newSetup() throws IOException, ParseException {
        JsonFileDataGetterSetter deviceConfig = DeviceConfig.readConfig();
        System.out.println(deviceConfig.getBrowser());
        if (deviceConfig.getPlatform().equalsIgnoreCase("web")) {
            TLWebDriverFactory.websetupdriver();
            TLWebDriverFactory.getInstance();
            url=deviceConfig.getUrl();
            TLWebDriverFactory.getDriver().get(url);
        } else {
            TLMobileDriverFactory.mobsetupdriver();
        }
    }


    @AfterTest
    public void teardown() {
        try {
            JsonFileDataGetterSetter deviceConfig = DeviceConfig.readConfig();
            if (deviceConfig.getPlatform().equalsIgnoreCase("web")){
                TLWebDriverFactory.getInstance();
                TLWebDriverFactory.getDriver().quit();
            }else {
                TLMobileDriverFactory.getInstance();
                TLMobileDriverFactory.getDriver().quit();
            }
        } catch (Exception ex) {
            ex.getCause();
        }
    }
}
