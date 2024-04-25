package com.halid.tests.day01.pac_01_playwrightIntro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P02_BasicNavigations {

    public static void main(String[] args) {

        // create playwright object
        Playwright playwright = Playwright.create();
        // set Browser object
        BrowserType chromium = playwright.chromium(); // playwright.firefox();.....
        // start Browser
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        // start new tab
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");
        page.waitForTimeout(2000);

        page.navigate("https://google.com");
        page.waitForTimeout(2000);

        page.goBack();
        page.waitForTimeout(2000);

        page.goForward();
        page.waitForTimeout(2000);

        // refresh oage
        page.reload();

        page.close();
        browser.close();
        playwright.close();


    }

}
