package test.pw.m5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class checkScenario1 extends ScriptBase {

    @Test
    public void checkScenario1() {

        page.navigate(home);
        page.fill("#exampleFormControlInput1", "my@email.com");
        page.fill("#exampleMessage", "Not sure how to say this...");

        page.check("#sendCopy");
        page.click("#submit-contact");
        Assertions.assertTrue(page.isVisible("text=We sent you a copy of your message : Not sure how to say this..."));
    }
}
