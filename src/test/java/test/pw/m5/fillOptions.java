package test.pw.m5;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class fillOptions extends ScriptBase {

    @Test
    public void fillOptions() {

        page.navigate(home);
        page.fill("id=exampleMessage", "Siema eniu",
                new Page.FillOptions().setForce(true));
    }
}
