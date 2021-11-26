package test.pw.m9;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class TraceViewer {

    Playwright pw;
    Browser browser;

    @Test
    public void traceViewer() {

        pw = Playwright.create();
        browser = pw.chromium().launch();

        BrowserContext ctx = browser.newContext();

        ctx.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
        );

        Page page = ctx.newPage();
        page.setDefaultTimeout(8000);
        page.navigate("https://playwright.dev/java/");
        page.click("text=Get Started");
        page.click("text=Trace Viewer");
        Assertions.assertTrue(page.isVisible("text=Recording a trace"));

        ctx.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip"))
        );
    }

    @AfterEach
    public void cleanup() {
        pw.close();
    }
}
