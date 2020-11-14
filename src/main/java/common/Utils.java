package common;

import BasePackage.BaseTest;
import BasePackage.StreamGobbler;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Utils extends BaseTest {
    public static String utils = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "common" + File.separator;

    static boolean isWindows = System.getProperty("os.name")
            .toLowerCase().startsWith("windows");

    public static void scrollDownTo(By element, int timeout) {
        long TimeMillis = System.currentTimeMillis();
        long startTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
        long currentTime = startTime;
        boolean isDisplayed = false;
        int pressX = 0;
        int topY = 0;
        int bottomY = 0;
        while (currentTime < startTime + timeout) {
            try {
                pressX = BaseTest.mobileDriver.manage().window().getSize().width / 2;
                bottomY = BaseTest.mobileDriver.manage().window().getSize().height;
                topY = BaseTest.mobileDriver.manage().window().getSize().height;
                isDisplayed = BaseTest.mobileDriver.findElement(element).isDisplayed();
                if (!isDisplayed) {
                    throw new NoSuchElementException("Element Not Displayed");
                }
                currentTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
                if (isDisplayed) {
                    break;
                }
            } catch (NoSuchElementException e) {
                TouchAction touchAction = new TouchAction(BaseTest.mobileDriver);
                switch (PLATFORM_NAME) {
                    case "native-android": {
                        touchAction.press(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
                                .moveTo(PointOption.point(pressX, topY * 40 / 100)).release().perform();
                    }
                    break;
                    case "native-ios": {
                        touchAction.longPress(PointOption.point(pressX, bottomY * 4 / 5)).waitAction()
                                .moveTo(PointOption.point(pressX, (int) (topY * 45.7 / 100))).release().perform();
                    }
                    break;
                }
                currentTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
                if (currentTime > startTime + timeout) {
                    throw e;
                }
            }
        }
    }


    public static void scrollUpTo(By element, int timeout) {
        long TimeMillis = System.currentTimeMillis();
        long startTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
        long currentTime = startTime;
        boolean isDisplayed = false;
        int pressX = 0;
        int topY = 0;
        int bottomY = 0;
        while (currentTime < startTime + timeout) {
            try {
                pressX = BaseTest.mobileDriver.manage().window().getSize().width / 2;
                bottomY = BaseTest.mobileDriver.manage().window().getSize().height;
                topY = BaseTest.mobileDriver.manage().window().getSize().height;
                isDisplayed = BaseTest.mobileDriver.findElement(element).isDisplayed();
                if (!isDisplayed) {
                    throw new NoSuchElementException("Element Not Displayed");
                }
                currentTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
                if (isDisplayed) {
                    break;
                }
            } catch (NoSuchElementException e) {
                TouchAction touchAction = new TouchAction(BaseTest.mobileDriver);
                switch (PLATFORM_NAME) {
                    case "native-android": {
                        touchAction.press(PointOption.point(pressX, bottomY * 40 / 100)).waitAction()
                                .moveTo(PointOption.point(pressX, topY * 4 / 5)).release().perform();
                    }
                    break;
                    case "native-ios": {
                        touchAction.longPress(PointOption.point(pressX, bottomY * 46 / 100)).waitAction()
                                .moveTo(PointOption.point(pressX, topY * 4 / 5)).release().perform();
                    }
                    break;
                }
                currentTime = TimeUnit.MILLISECONDS.toSeconds(TimeMillis);
                if (currentTime > startTime + timeout) {
                    throw e;
                }
            }
        }
    }

    public static void screenSwipe() {
        TouchAction touchAction = new TouchAction(BaseTest.mobileDriver);
        int pressX = BaseTest.driver.manage().window().getSize().width / 2;
        int bottomY = BaseTest.driver.manage().window().getSize().height;
        int topY = BaseTest.driver.manage().window().getSize().height;
        switch (platform) {
            case "native-android": {
                touchAction.press(PointOption.point(pressX, bottomY * 3 / 4)).waitAction()
                        .moveTo(PointOption.point(pressX, topY * 1 / 4)).release().perform();
            }
            break;
            case "native-ios": {
                touchAction.longPress(PointOption.point(pressX, bottomY * 3 / 4)).waitAction()
                        .moveTo(PointOption.point(pressX, topY * 1 / 4)).release().perform();
            }
            break;
        }
    }

    public static void swipeHorizontal(By element, String direction) {

        int StartX = 0;
        int StartY = 0;
        int EndX = 0;
        int EndY = 0;
        TouchAction touchAction = new TouchAction(mobileDriver);
        switch (direction) {
            case "right":
                StartX = element(element).getLocation().getX();
                StartY = element(element).getLocation().getY();
                EndY = element(element).getLocation().getY();
                EndX = element(element).getLocation().getX() + 300;
                touchAction.longPress(PointOption.point(StartX, StartY))
                        .moveTo(PointOption.point(EndX, EndY)).release().perform();
                break;
            case "left":
                StartX = element(element).getLocation().getX();
                StartY = element(element).getLocation().getY();
                EndY = element(element).getLocation().getY();
                EndX = element(element).getLocation().getX() - 300;
                touchAction.longPress(PointOption.point(StartX, StartY))
                        .moveTo(PointOption.point(EndX, EndY)).release().perform();
                break;
        }
    }

    public static void wait(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public static void waitFor(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(BaseTest.mobileDriver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void checkInVisibleElement(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(BaseTest.mobileDriver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static void KillApp() {
        switch (PLATFORM_NAME) {
            case "native-android":
            case "native-ios": {
                BaseTest.mobileDriver.closeApp();
            }
            break;
            default:
                break;
        }
    }

    public static void ReOpenApp() throws InterruptedException {
        switch (PLATFORM_NAME) {
            case "native-android": {
                BaseTest.mobileDriver.activateApp("com.vfg.referenceapp.");
                Thread.sleep(2000);
            }
            break;
            case "native-ios": {
                BaseTest.mobileDriver.launchApp();
                wait(2);
            }
            break;
            default:
                break;
        }
    }

    public static void executeCMD(String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", command);
        } else {
            builder.command("sh", "-c", command);
        }
        try {
            Process process = builder.start();
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            int exitCode = process.waitFor();
            assert exitCode == 0;
        } catch (AssertionError error) {
            error.printStackTrace();
        }
    }

    //enable/disable Wifi &data on Android
    public static void setDataOn() throws IOException, InterruptedException {
        Utils.executeCMD("adb shell svc data enable");
    }

    public static void setDataOff() throws IOException, InterruptedException {
        Utils.executeCMD("adb shell svc data disable");
    }

    public static void setWifiOn() throws IOException, InterruptedException {
        //  Utils.executeCMD("adb shell am broadcast -a io.appium.settings.wifi --es setstatus enable");
        Utils.executeCMD("adb shell svc wifi enable");
    }

    public static void setWifiOff() throws IOException, InterruptedException {
//        Utils.executeCMD("adb shell svc wifi disable");
        Utils.executeCMD("adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings");
//        element(ObjectRepo.Wifi_toggle).click();
    }

    public static void setGPSOn() throws IOException, InterruptedException {
        Utils.executeCMD("adb shell settings put secure location_providers_allowed +gps");
    }
}
