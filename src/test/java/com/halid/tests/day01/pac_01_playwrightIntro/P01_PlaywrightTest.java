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
        Page page = browser.newPage();

        // open google page
        page.navigate("https://www.google.com");

        // accept cookies
        page.click("id=L2AGLb");
        // click search input box
        page.click("textarea[title='Search']");
        // type apple
        page.keyboard().insertText("apple");
        // press enter
        page.keyboard().press("Enter");
        // assert page title
        assertThat(page).hasTitle("apple - Google Search");
        // wait for new page load
        page.waitForTimeout(1000);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("google_AppleSearch_screenshot1.png")));

        // close tab
        page.close();
        // close browser
        browser.close();
        // close Playwright
        playwright.close();

    }
}
