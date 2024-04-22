package com.halid.tests.day01.playwrightIntro;

import com.microsoft.playwright.*;

import java.util.List;

public class PlaywrightTests_P01 {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext contexts = browser.newContext();
        Page page = browser.newPage();
        page.navigate("https://www.google.com");

        page.click("id=L2AGLb");
        page.click("textarea[title='Search']");
        page.keyboard().insertText("apple");
        page.keyboard().press("Enter");

        page.waitForTimeout(1000);


        page.close();
        browser.close();
        playwright.close();

    }
}
