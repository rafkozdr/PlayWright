package test.pw.m5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

public class selectScenario extends ScriptBase {

    @Test
    public void selectScenario1() {
        page.navigate(home);
        page.selectOption("id=contactReason", "Bored");

        Assertions.assertTrue(page.isVisible("text=OK, But please make it interesting"));
    }
}
