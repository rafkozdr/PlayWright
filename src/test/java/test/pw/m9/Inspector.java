package test.pw.m9;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class Inspector {

    Playwright pw;
    Browser browser;

    @Test
    public void inspector() {

        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newContext().newPage();
        page.navigate("https://playwright.dev/java");

        page.pause();


        page.click("text=Get Started");
    }

    @AfterEach
    public void clenup() {
        pw.close();
    }
}
