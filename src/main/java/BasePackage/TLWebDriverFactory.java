package BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

public class TLWebDriverFactory extends DeviceConfig{
    //    public static ChromeDriverService service;
    private static TLWebDriverFactory WebDriverFactoryInstance=null;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static TLWebDriverFactory getInstance(){
        if (WebDriverFactoryInstance==null){
            WebDriverFactoryInstance= new TLWebDriverFactory();
        }
        return WebDriverFactoryInstance;
    }
    /**   public synchronized static void websetupdriver() throws IOException, ParseException {
     //        JsonFileDataGetterSetter deviceConfig = readConfig();
     deviceConfig = readConfig();
     if (deviceConfig.getBrowser().equalsIgnoreCase("chrome")) {
     WebDriverManager.chromedriver().clearPreferences();
     WebDriverManager.chromedriver().setup();
     System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
     driver = ThreadLocal.withInitial(() -> new ChromeDriver());
     } else if (deviceConfig.getBrowser().equalsIgnoreCase("firefox")) {
     WebDriverManager.firefoxdriver().clearPreferences();
     WebDriverManager.firefoxdriver().setup();
     driver = ThreadLocal.withInitial(() -> new FirefoxDriver());
     } else if (deviceConfig.getBrowser().equalsIgnoreCase("edge")) {
     WebDriverManager.edgedriver().clearPreferences();
     WebDriverManager.edgedriver().setup();
     driver = ThreadLocal.withInitial(() -> new EdgeDriver());
     } else if (deviceConfig.getBrowser().equalsIgnoreCase("InternetExplorer")) {
     WebDriverManager.iedriver().clearPreferences();
     WebDriverManager.iedriver().setup();
     driver = ThreadLocal.withInitial(() -> new InternetExplorerDriver());
     }
     }**/

    public synchronized static WebDriver websetupdriver() throws IOException, ParseException {
        deviceConfig = readConfig();
        switch (deviceConfig.getBrowser().toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().clearPreferences();
                WebDriverManager.chromedriver().setup();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                driver = ThreadLocal.withInitial(() -> new ChromeDriver());
                return new ChromeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().clearPreferences();
                WebDriverManager.firefoxdriver().setup();
                driver = ThreadLocal.withInitial(() -> new FirefoxDriver());
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().clearPreferences();
                WebDriverManager.edgedriver().setup();
                driver = ThreadLocal.withInitial(() -> new EdgeDriver());
                return new EdgeDriver();

            case "IE":
                WebDriverManager.iedriver().clearPreferences();
                WebDriverManager.iedriver().setup();
                driver = ThreadLocal.withInitial(() -> new InternetExplorerDriver());
                return new InternetExplorerDriver();

            default:
                throw new RuntimeException("Unsupported browser! will not start any browser!");
        }
    }

    public synchronized static WebDriver getDriver(){
        return driver.get();
    }

}
