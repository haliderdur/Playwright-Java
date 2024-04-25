package com.halid.tests.day01.pac_01_playwrightIntro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class P01_PlaywrightTest {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        // set Browser object
        BrowserType chromium = playwright.chromium(); // playwright.firefox();.....
        // start Browser - to see the browser during execution, setHeadless(false)
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
        // assert page title
        assertThat(pageTab).hasTitle("apple - Google Search");
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
