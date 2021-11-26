package test.pw.m8;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class RouteAbort {

    Playwright pw;
    Browser browser;

    @Test
    public void imageBlock() {

        pw=Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext ctx = browser.newContext();
        Page page = ctx.newPage();

        page.route("**/*.{png,jpg,jpeg,svg}", Route::abort);
        page.navigate("https://playwright.dev/");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("blockedImages.png")));

    }


    @Test
    public void jsBlock() {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        BrowserContext ctx = browser.newContext();

        Page page = ctx.newPage();

        page.navigate("https://playwright.dev");

        String theme = page.getAttribute("html", "data-theme");
        Assertions.assertEquals("dark", theme);

        page.click(".react-toggle-track");
        String theme2 = page.getAttribute("html", "data-theme");
        Assertions.assertEquals("light", theme2);

    }


    @Test
    public void jsBlock2() {

        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        BrowserContext ctx = browser.newContext();

        Page page = ctx.newPage();

        page.route("**/*",  route -> {
            if ("script".equalsIgnoreCase(route.request().resourceType()))
                route.abort();
            else
                route.resume();
        });

        page.navigate("https://playwright.dev");

        String theme = page.getAttribute("html", "data-theme");
        Assertions.assertEquals("dark", theme);

        page.click(".react-toggle-track");
        String theme2 = page.getAttribute("html", "data-theme");
        Assertions.assertEquals("dark", theme2);
    }
}
