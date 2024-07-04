package com.halid.tests.day03.pac_01_alerts_frames_windows;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class P01_AlertPractice {

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
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    public void test1() {
        // Since I deal with the same url, i can place navigate() method inside beforeEach srtup method
        // page.navigate("https://practice.cydeo.com/javascript_alerts");

        // need to use dialog(alert) handle before clicking
        // Playwright is using auto-dismiss functionality therefore to accept alert, need to use dialog handler
        page.onceDialog(d -> d.accept());

        page.locator("button")
                //.nth(0)
                .first().click();

        Locator messageJSAlert = page.locator("#result");
        Assertions.assertEquals("You successfully clicked an alert", messageJSAlert.textContent());

    }


    @Test
    public void test2() {

        Locator messageJSAlert = page.locator("#result");

        // to click cancel(dismiss) in alert, no need to handle alert. Playwright will use auto-dismiss functionality
        page.locator("button[onclick='jsConfirm()']").click();
        System.out.println(messageJSAlert.textContent());
        Assertions.assertEquals("You clicked: Cancel", messageJSAlert.textContent());


        // to accept the alert, need to handle alert with onceDialog handler
        page.onceDialog(d -> d.accept());
        // page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
        page.locator("//button[.='Click for JS Confirm']").click();
        System.out.println(messageJSAlert.textContent());
        Assertions.assertEquals("You clicked: Ok", messageJSAlert.textContent());

    }

    @Test
    public void test3() {
        Locator messageJSAlert = page.locator("#result");

        page.onDialog(d -> d.accept("Playwright is cool"));
        page.locator("//button[.='Click for JS Prompt']").click();

        System.out.println(messageJSAlert.textContent());

    }
}
