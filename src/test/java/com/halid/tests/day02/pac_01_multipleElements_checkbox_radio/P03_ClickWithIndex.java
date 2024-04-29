package com.halid.tests.day02.pac_01_multipleElements_checkbox_radio;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_ClickWithIndex {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");

        // page.locator(".container li a").first().click(); // to click first one on html list
        // page.locator(".container li a").last().click(); // to click last one on the html list
        page.locator(".container li a").nth(5).click(); // clicks nth link
        page.goBack();


        // to click all links in a webpage
        /*
        1.store them in a list with querySelectorAll() method
        2.create a for loop with the size of List
        3.with using locator().nth(i) method, click them one at a time and page.goBack()
         */
        List<ElementHandle> elementHandles = page.querySelectorAll(".container li a");
        for (int i = 0; i < elementHandles.size(); i++) {
            Locator link = page.locator(".container li a").nth(i);
            link.click();
            page.goBack();

            //  if (link.textContent().equals("Context Menu")) {
            //      link.click();
            //      page.goBack();
            // }

        }


        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
