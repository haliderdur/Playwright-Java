package com.halid.tests.day02.pac_01_multipleElements_checkbox_radio;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04_checkbox_radio {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");




        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
