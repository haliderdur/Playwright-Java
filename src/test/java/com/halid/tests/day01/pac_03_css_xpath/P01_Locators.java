package com.halid.tests.day01.pac_03_css_xpath;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_Locators {

    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://login1.nextbasecrm.com/");

        page.querySelector("[name=USER_LOGIN]").fill("incorrectUser");
        page.querySelector("[name=USER_PASSWORD]").fill("incorrectPassword");
        page.querySelector("[type=submit]").click();

        String errorMessage = page.querySelector("[class=errortext]").textContent();
        Assertions.assertEquals("Incorrect login or password", errorMessage);

        page.waitForTimeout(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
