package test.pw.m6;

import com.microsoft.playwright.Dialog;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class Dialogs extends ScriptBase {

    @Test
    public void alertTest() {
        page.navigate(home);
        page.fill("#donation", "50");

       /* page.onDialog(dialog -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dialog.accept();
        });*/

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you!"));
    }



    @Test
    public void confirmTestAccept() {
        page.navigate(home);
        page.fill("#donation", "200");

        page.onDialog(Dialog::accept);

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thanks for confirming"));
    }



    @Test
    public void confirmTestDismiss() {
        page.navigate(home);
        page.fill("#donation", "200");

        page.onDialog(dialog -> dialog.dismiss());

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=It's OK to change one's mind"));
    }

    @Test
    public void confirmTestPrompt() {
        page.navigate(home);
        page.fill("#donation", "2000");

        page.onDialog(dialog -> dialog.accept("Yes"));

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you for your generosity"));
    }

    /*@Test
    public void hangingTestAccept() {
        page.navigate(home);
        page.fill("#donation", "200");

        page.onDialog(dialog -> System.out.println("Dialog type found:" + dialog.type()));

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thanks for confirming"));
    }*/
}
