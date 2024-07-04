package com.halid.tests.day03.pac_01_alerts_frames_windows;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class WindowsHandle {


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

        // Since I deal with the same url, I can place navigate() method inside beforeEach setup method
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    public void test1() {

        // to run playwright inspector
        // page.pause();

        System.out.println("current page title = " + page.title());
        Locator clickHereLink = page.locator("text=Click Here");
        clickHereLink.click();

        // get second window title
        // waitForPopup method waits any tab or window to be opened
        Page secondPage = page.waitForPopup(() -> {
            page.getByText("Click Here").click();
        });

        System.out.println("current page title = " + secondPage.title());

        // go back to the first page
        page.bringToFront();
        System.out.println("current page title = " + page.title());


    }

}
