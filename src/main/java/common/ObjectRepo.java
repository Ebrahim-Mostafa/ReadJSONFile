package common;

import org.openqa.selenium.By;

public class ObjectRepo {

    //elements for web
    public static By LoginBtn=By.xpath("//*[text()='Login']");
    public static By CreatAccount=By.xpath("//a[@href='/customer/account/create/']");
    public static By FirstName= By.id("fi-firstName");
    public static By LastName=By.id("fi-lastName");
    public static By mail=By.id("fi-email");
    public static By Password=By.id("fi-password");
    public static By PhoneNumber=By.id("fi-phone");
    public static By Terms= By.xpath("//*[@for='fi-terms']");
    public static By Newsletter=By.xpath("//*[@for='fi-newsletter']");
    public static By CreateAccountbtn=By.xpath("//*[@class='btn _prim -fw']");
}
