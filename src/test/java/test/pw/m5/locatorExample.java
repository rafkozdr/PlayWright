package test.pw.m5;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class locatorExample extends ScriptBase {

    @Test
    public void locatorExample() {

        page.navigate(home);
        Locator input = page.locator(".form-control");

        System.out.println(input.count());

        input.first().fill("first");
        input.last().fill("last");
        input.nth(1).fill("second");
    }
}
