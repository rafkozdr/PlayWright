package test.pw.m9;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class TraceViewerRefactored {

    Playwright pw;
    Browser browser;
    BrowserContext ctx;

    @Test
    public void traceViewer() {

        pw = Playwright.create();
        browser = pw.chromium().launch();

        ctx = browser.newContext();

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



    }

    @AfterEach
    public void cleanup() {
        ctx.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip"))
        );
        pw.close();

    }
}
