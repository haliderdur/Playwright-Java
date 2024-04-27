package com.halid.tests.day01.pac_02_locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P05_GetText_GetAttribute {


    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/registration_form");

        String expectedHeader = "Registration form";
        String actualHeader = page.getByRole(AriaRole.HEADING).textContent();
        Assertions.assertEquals(expectedHeader, actualHeader);

        String placeholder = page.querySelector("//input[@name='firstname']").getAttribute("placeholder");
        System.out.println("placeholder = " + placeholder);
        Assertions.assertEquals("first name",placeholder);

        page.waitForTimeout(2000);
        page.close();
        browser.close();
        playwright.close();

    }
}
