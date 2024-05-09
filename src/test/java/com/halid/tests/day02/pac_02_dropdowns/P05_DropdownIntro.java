package com.halid.tests.day02.pac_02_dropdowns;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P05_DropdownIntro {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/dropdown");

        // How to get selected option

        ElementHandle simpleDropdown = page.querySelector("[id=dropdown]");

        // javaScript expression el=>el.selectedOptions[0].text
        String selectedOption = page.evaluate("el=>el.selectedOptions[0].text", simpleDropdown).toString();
        // String selectedOption = simpleDropdown.evaluate("el=>el.selectedOptions[0].text").toString();

        System.out.println("selectedOption = " + selectedOption);


        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
