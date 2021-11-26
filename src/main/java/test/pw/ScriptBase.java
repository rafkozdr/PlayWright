package test.pw;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class ScriptBase {
    private static final String webDir = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";
    public static final String home = webDir + "home.html";
    public static String advantages = webDir + "advantages.html";


    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(750));
    }

    @BeforeEach
    protected void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1680, 1000);
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }


}
