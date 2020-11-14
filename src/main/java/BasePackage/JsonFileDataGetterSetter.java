package BasePackage;

public class JsonFileDataGetterSetter {
    private String url;
    private String browser;
    private String platform;
    private String APPIUM_VERSION;
    private String PLATFORM_VERSION;
    private String PLATFORM_NAME;
    private String AUTOMATION_NAME;
    private String DEVICE_NAME;
    private String udid;
    private String appActivity;
    private String appPackage;
    private String bundleId;
    private String host;
    private JsonFileDataGetterSetter deviceConfig;


    public JsonFileDataGetterSetter(JsonFileDataGetterSetter deviceConfig) {
        this.deviceConfig=deviceConfig;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAPPIUMVERSION() {
        return APPIUM_VERSION;
    }

    public void setAPPIUM_VERSION(String aPPIUMVERSION) {
        this.APPIUM_VERSION = aPPIUMVERSION;
    }

    public String getPLATFORMVERSION() {
        return PLATFORM_VERSION;
    }

    public void setPLATFORMVERSION(String pLATFORMVERSION) {
        this.PLATFORM_VERSION = pLATFORMVERSION;
    }

    public String getPLATFORMNAME() {
        return PLATFORM_NAME;
    }

    public void setPLATFORMNAME(String pLATFORMNAME) {
        this.PLATFORM_NAME = pLATFORMNAME;
    }

    public String getAUTOMATIONNAME() {
        return AUTOMATION_NAME;
    }

    public void setAUTOMATIONNAME(String aUTOMATIONNAME) {
        this.AUTOMATION_NAME = aUTOMATIONNAME;
    }

    public String getDEVICENAME() {
        return DEVICE_NAME;
    }

    public void setDEVICENAME(String dEVICENAME) {
        this.DEVICE_NAME = dEVICENAME;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getHosthost() {
        return host;
    }

    public void setHosthost(String hosthost) {
        this.host = hosthost;
    }

}


