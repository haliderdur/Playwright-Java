package com.halid.tests.day03.pac_01_alerts_frames_windows;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class P02_Frames {


    // to use same playwright object in every test cases
    static private Playwright playwright;

    // to use same browser object in every test cases
    static private Browser browser;

    private Page page;


    // initiate playwright and browser instances before all tests
    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
    }

    // closing playwirght and broswer objects
    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setup() {
        page = browser.newPage();

        // Since I deal with the same url, i can place navigate() method inside beforeEach srtup method
        page.navigate("https://practice.cydeo.com/iframe");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    public void test1() {

        // Unlike Selenium, No need to switch between iframes
        // Just use frameLocator() method to locate iframe instead of locator() method and reach all elements inside that iframe
        // Instead of using page. for iframe; use FrameLocator name

        FrameLocator firstIframe = page.frameLocator("#mce_0_ifr");
        Locator textBox = firstIframe.locator("#tinymce");
        textBox.clear();
        textBox.fill("Playwright is cool");
        Locator textBoxValue = firstIframe.locator("//p");
        Assertions.assertEquals("Playwright is cool", textBoxValue.textContent());

        System.out.println(page.locator("//h3").textContent());

    }


}
