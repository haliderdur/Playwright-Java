package com.halid.tests.day01.playwrightIntro;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.nio.file.Paths;
import java.util.List;

public class PlaywrightTests_P01 {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        // set Browser object
        BrowserType chromium = playwright.chromium();
        // start Browser
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(0));

        /*
        // start new window
         BrowserContext window = browser.newContext();
        */

        // start new tab
        Page pageTab = browser.newPage();

        // open google page
        pageTab.navigate("https://www.google.com");

        // accept cookies
        pageTab.click("id=L2AGLb");
        // click search input box
        pageTab.click("textarea[title='Search']");
        // type apple
        pageTab.keyboard().insertText("apple");
        // press enter
        pageTab.keyboard().press("Enter");
        // wait for new page load
        pageTab.waitForTimeout(1000);

        pageTab.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("google_AppleSearch_screenshot1.png")));

        // close tab
        pageTab.close();
        // close browser
        browser.close();
        // close Playwright
        playwright.close();

    }
}
