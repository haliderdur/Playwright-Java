package com.halid.tests.day01.pac_02_locators;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P03_GoogleSearch {

    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.google.com");
        Locator acceptCookiesElement = page.locator("id=L2AGLb");
        acceptCookiesElement.click();

        Locator searchBoxElement = page.locator("textarea[name='q']");
        // searchBoxElement.type("Playwright"); // deprecated method
        // searchBoxElement.pressSequentially("Selenium",new Locator.PressSequentiallyOptions().setDelay(100)); // types in sequentially
        searchBoxElement.fill("Playwright");  // fills in input place with given string

        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");


        page.close();
        browser.close();
        playwright.close();


    }
}
