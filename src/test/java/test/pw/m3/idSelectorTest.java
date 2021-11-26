package test.pw.m3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class idSelectorTest {
    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void idSelectorTest() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);

            page.fill("id=surnameInput", "John");
            page.fill("data-test-id=surnameInput", "Sarah");
            page.fill("my-id=surnameInput", "Mike");
        }
    }

    @Test
    public void multipleIdSelectors() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
            Page page = browser.newPage();
            page.navigate(home);

            page.fill("input", "first input box that PW finds");
            page.fill(".form-control", "first box with this class");
            page.fill("form #exampleFormControlInput1", "Hello there!");
            page.fill(":nth-match(.form-control, 2)", "General Kenobi!");
        }
    }
}
