package data;

public class Properties {
    private String browser = System.getProperty("browser", "chrome");
    private static String browser_size = System.getProperty("browser_size", "1920x1080");
    private static String browser_version = System.getProperty("browser_version", "120.0");
    private String rwdriver = System.getProperty("rwdriver",
            "https://user1:1234@selenoid.autotests.cloud/wd/hub");

    public String getBrowser() {
        return browser;
    }

    public String getBrowser_size() {
        return browser_size;
    }

    public String getBrowser_version() {
        return browser_version;
    }

    public String getRwdriver() {
        return rwdriver;
    }
}
