package com.halid.tests.day02.pac_01_multipleElements_checkbox_radio;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class P05_RadioButtons {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/radio_buttons");

        ElementHandle blueRadio = page.querySelector("[id=blue]");
        ElementHandle redRadio = page.querySelector("[id=red]");

        redRadio.click();
        BrowserUtils.sleepWithThread(1);
        blueRadio.click();

        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
