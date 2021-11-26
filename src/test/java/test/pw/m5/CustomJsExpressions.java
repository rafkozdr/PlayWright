package test.pw.m5;

import org.junit.jupiter.api.Test;
import test.pw.ScriptBase;

import static org.junit.jupiter.api.Assertions.*;

public class CustomJsExpressions extends ScriptBase {

    @Test
    public void localStorage() {

        page.navigate(home);
        Object obj = page.evaluate("() => window.localStorage.getItem('clapped')");
        assertNull(obj);

        page.click("#clap-image");
        String obj2 = (String) page.evaluate("() => window.localStorage.getItem('clapped')");
        assertTrue(Boolean.parseBoolean(obj2));
    }


    @Test
    public void evalOnSelector() {

        page.navigate(home);
        page.evalOnSelector("#hero-banner", "e => e.remove()");
        assertFalse(page.isVisible("#hero-banner"));
    }

    @Test
    public void evalOnSelectorAll() {

        page.navigate(advantages);
        Object obj = page.evalOnSelectorAll(".feature", "f => f.length");
        assertEquals(3, obj);
    }
}
