package pages;

import BasePackage.BaseTest;
import BasePackage.TLMobileDriverFactory;
import BasePackage.TLWebDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class create_account_page extends BaseTest {
    //elements for web
    public static By LoginBtn;
    public static By CreatAccount;
    public static By FirstName;
    public static By LastName;
    public static By mail;
    public static By Password;
    public static By PhoneNumber;
    public static By Terms;
    public static By Newsletter;
    public static By CreateAccountbtn;

    //elements for nativeAndroid
    public static By Country;
    public static By language;
    public static By Account;
    public static By login;
    public static By createaccount;
    public static By firstname;
    public static By lastname;
    public static By radio_btn;
    public static By email;
    public static By password;
    public static By mobile;
    public static By checkbox;
    public static By create_btn;
    public static By home_btn;

//     create_account_page ca =new create_account_page(driver);
//     create_account_page cp =new create_account_page(mobileDriver);


    public create_account_page(WebDriver driver, AppiumDriver<?> mobileDriver) {
        switch (platform) {
            case "web":
                BaseTest.driver=driver;
                PageFactory.initElements( TLWebDriverFactory.getInstance().getDriver(), this);
                web();
                break;
            case "mobile":
                BaseTest.mobileDriver = mobileDriver;
                PageFactory.initElements( TLMobileDriverFactory.getInstance().getDriver(), this);
                switch (PLATFORM_NAME) {
                    case "Android":
                        nativeAndroid();
                        break;
                    case "iOS":
                        nativeIOS();
                        break;
                }
        }
    }

//    public create_account_page(WebDriver driver) {
//        PageFactory.initElements(driver,ca);
//    }
//    public create_account_page(AppiumDriver<?> mobileDriver) {
//        PageFactory.initElements(mobileDriver,cp);
//    }


//    public create_account_page(WebDriver driver){
//        PageFactory.initElements(driver,this);
//        web();
//    }
//    public create_account_page(AppiumDriver<?> mobileDriver){
//        PageFactory.initElements(mobileDriver,this);
//        switch (PLATFORM_NAME) {
//            case "Android":
//                nativeAndroid();
//                break;
//            case "iOS":
//                nativeIOS();
//                break;
//        }
//    }


    private static void web() {
        LoginBtn = By.xpath("//*[text()='Login']");
//    @FindBy(xpath = "//a[@href='/customer/account/create/']")
//    @FindBy(xpath = "//*[text()='CREATE AN ACCOUNT']")
        CreatAccount = By.xpath("//a[@href='/customer/account/create/']");
        FirstName = By.id("fi-firstName");
        LastName = By.id("fi-lastName");
        mail = By.id("fi-email");
        Password = By.id("fi-password");
        PhoneNumber = By.id("fi-phone");
        // fi-terms
        Terms = By.xpath("//*[@for='fi-terms']");
        // fi-newsletter
        Newsletter = By.xpath("//*[@for='fi-newsletter']");
        // Click on CreateAccPage button
        CreateAccountbtn = By.xpath("//*[@class='btn _prim -fw']");
    }

    private static void nativeAndroid() {

        Country = By.xpath("//android.widget.TextView[@text='Egypt']");
        language = By.xpath("//android.widget.TextView[@text='English']");
        Account = By.id("com.jumia.android:id/navigation_account");
        login = By.id("com.jumia.android:id/button_bottom_login_logout");
        createaccount = By.id("com.jumia.android:id/login_email_create_account");
        firstname = By.xpath("//android.widget.EditText[@content-desc=\"first_name\"]");
        lastname = By.xpath("//android.widget.EditText[@content-desc=\"last_name\"]");
        radio_btn = By.xpath("//android.widget.RadioButton[@text='Male']");
        email = By.xpath("//android.widget.EditText[@content-desc=\"email\"]");
        password = By.xpath("//android.widget.EditText[@content-desc=\"password\"]");
        mobile = By.xpath("//android.widget.EditText[@content-desc=\"phone\"]");
        checkbox = By.id("com.jumia.android:id/checkbox_terms");
        create_btn = By.id("com.jumia.android:id/login_button_continue");
        home_btn = By.id("com.jumia.android:id/navigation_home");

    }

    private static void nativeIOS() {

    }
}
