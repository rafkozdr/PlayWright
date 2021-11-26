package test.pw.m8;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SetHttpAuthentication {

    Playwright pw;
    Browser browser;
    String token = "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";
    @Test
    public void setHttpAuthentication() {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

        //UI
        BrowserContext uiContext = browser.newContext();

        Page uiPage = uiContext.newPage();
        uiPage.navigate("https://github.com/rafkozdr");
        assertTrue(uiPage.isVisible("text=Repositories 2"));

        // Web API part - cross-check

        BrowserContext apiContext = browser.newContext(new Browser.NewContextOptions()
                .setExtraHTTPHeaders(Map.of("Authorization", "token " + token))
        );

        Page webApiPage = apiContext.newPage();
        Response response = webApiPage.navigate("https://api.github.com/user");
        System.out.println(response.text());
        assertEquals(200, response.status());
        assertTrue(response.text().contains("\"public_repos\": 3"));
    }


    @AfterEach
    public void cleanup() {
        pw.close();
    }
}
