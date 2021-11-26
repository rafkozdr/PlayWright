package test.pw.m3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TextSelector {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void textSelectorTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false). setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);

            page.click("text=More info");
            Assertions.assertEquals(page.title(), "Advantages");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "text=More Info",
            "text=more info",
            "'More info'"})
    public void textSelectorParametrized(String stringSelector) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1500));
            Page page = browser.newPage();
            page.navigate(home);

            page.click(stringSelector);
            Assertions.assertEquals(page.title(), "Advantages");
        }
    }
}
