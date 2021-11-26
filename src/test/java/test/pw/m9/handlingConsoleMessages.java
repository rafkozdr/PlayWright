package test.pw.m9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class handlingConsoleMessages extends ScriptBase {

    @Test
    public void handlingConsoleMessages() {

        page.onConsoleMessage(msg -> {
            System.out.println("Console message found: \n" + msg.type() + ": " + msg.text());
        });

        page.onConsoleMessage(msg -> {
            if ("error".equals(msg.type())) {
                System.out.println("Error text: " + msg.text());
                Assertions.fail("Error found. Failing the test");
            }
        });

        page.navigate("https://github.com/rafkozdrr"); // with typo
    }
}
