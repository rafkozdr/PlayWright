package test.pw.m6;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadTest extends ScriptBase {

    @BeforeEach
    @Override
    protected void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
//        context = browser.newContext(); // won't work without setAcceptDownloads()
        page = context.newPage();
        page.setViewportSize(1800,1080);
    }

    @Test
    public void downloadTestWithHandler() {

        page.navigate(home);

        page.onDownload(download -> {
            System.out.println(download.path());
            download.saveAs(Paths.get(new File("C:\\Users\\Rafał\\IdeaProjects\\PlayWrightDownloads\\downloaded.zip").toURI()));
        });

        page.click("text=Download ZIP");
    }

    @Test
    public void downloadTestWithWaitForEvent() {
        page.navigate(home);

        Download download = page.waitForDownload(() -> {
           page.click("text=Download ZIP");
        });

        Path path = download.path();
        System.out.println(path);
    }
}
