package test.pw.m6;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Screenshot extends ScriptBase {

    @Test
    public void screenshotTest() {

        page.navigate(home);

        page.selectOption("select#contactReason", "Bored");
        assertTrue(page.isVisible("#boredOption"));

        page.selectOption("select#contactReason", "Question");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("box.png")));

        //this will fail - it's expected
        assertFalse(page.isVisible("#boredOptions"),
                "The blue box should've disappeared after selecting another option");
    }
}
