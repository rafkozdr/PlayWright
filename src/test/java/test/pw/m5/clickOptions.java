package test.pw.m5;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class clickOptions extends ScriptBase {

    @Test
    public void clickOptions() {

        page.navigate(home);
        page.click("#clap-image", new Page.ClickOptions().setClickCount(2));

        Assertions.assertTrue(page.isVisible("#thank-you-2"));

        Assertions.assertTrue((page.isVisible("text=You can only clap once, but thanks for your enthusiasm")));
    }
}
