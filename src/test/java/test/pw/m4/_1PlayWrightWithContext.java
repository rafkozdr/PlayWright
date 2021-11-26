package test.pw.m4;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import test.pw.ScriptBase;

public class _1PlayWrightWithContext extends ScriptBase {

    @Test
    public void firstPWTestWithContext() {

        page.navigate(home);
        Assertions.assertEquals(page.title(), "Home Page");
    }

    @Test
    public void secondPWTestWithContext() {

        page.navigate(home);
        String content = page.content();
        Assertions.assertTrue(content.contains("Cat In The Bag"));
    }
}
