package com.halid.tests.day03.pac_02_usingUtilityMethods;

import com.halid.utils.CRMUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class P01_CRMLoginTask {


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
                .setHeadless(false));
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
        page.navigate("https://login1.nextbasecrm.com/");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    public void test1() {
        CRMUtils.login(page);
    }

    @Test
    public void test2() {
        CRMUtils.login(page, "marketing1@cydeo.com", "UserUser");
    }
}
