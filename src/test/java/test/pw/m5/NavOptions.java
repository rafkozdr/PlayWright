package test.pw.m5;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class NavOptions extends ScriptBase {

    @Test
    public void navOptions() {
        page.navigate(home, new Page.NavigateOptions()
                .setTimeout(0)
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
        );

        Assertions.assertEquals(page.title(),"Home Page");
    }
}
