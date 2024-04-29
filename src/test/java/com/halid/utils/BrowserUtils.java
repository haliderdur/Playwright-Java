package com.halid.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserUtils {

    public static void setup() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
    }

    public static void tearDown(Page page, Browser browser, Playwright playwright) {
        page.close();
        browser.close();
        playwright.close();
    }

    public static void sleepWithThread(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sleepWithPage(Page page, int seconds) {
        page.waitForTimeout(seconds * 1000);
    }
}
