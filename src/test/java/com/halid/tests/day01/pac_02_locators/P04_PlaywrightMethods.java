package com.halid.tests.day01.pac_02_locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlaywrightMethods {


    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://library2.cybertekschool.com/login.html");

        // to find matching element by 'contains' value
        // page.getByPlaceholder("Email address").fill("incorrectEmail@gmail.com");
        Locator emailAddressInputBox = page.getByPlaceholder("Email address");
        emailAddressInputBox.fill("incorrectEmail@gmail.com");

        // to find matching element by 'exact' value
        // page.getByPlaceholder("Email address", new Page.GetByPlaceholderOptions().setExact(true));


        // page.getByLabel("Password").fill("incorrectPassword");
        // page.getByPlaceholder("Password").fill("incorrectPassword");
        page.querySelector("#inputPassword").fill("incorrectPassword");

        // page.getByRole(AriaRole.BUTTON).click(); // there is only 1 clickable button on DOM page
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in").setExact(true)).click(); // to specify which button to click on DOM page

        System.out.println(page.getByRole(AriaRole.ALERT).textContent());
        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());

        page.waitForTimeout(2000);

        page.close();
        browser.close();
        playwright.close();

    }
}
