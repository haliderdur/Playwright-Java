package com.halid.tests.day01.pac_02_locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_clickLinkWithText {

    @Test
    void test() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // page.setViewportSize(1920, 1080);
        page.navigate("https://practice.cydeo.com/");

        page.waitForTimeout(2000);
        page.click("text=Autocomplete");

        System.out.println(page.title());
        Assertions.assertTrue(page.title().contains("abc"));

        page.close();
        browser.close();
        playwright.close();
    }
}
