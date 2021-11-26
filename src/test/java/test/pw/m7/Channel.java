package test.pw.m7;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.pw.ScriptBase;

public class Channel extends ScriptBase {

    Playwright pw;
    Browser browser;

    @ParameterizedTest
    @ValueSource(strings = {
            "chrome",
            "msedge"
    })
    public void channel(String channel) {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel(channel)
                .setHeadless(false)
                .setSlowMo(2137)
        );

        Page page = browser.newContext().newPage();
        page.navigate(home);
    }
}
