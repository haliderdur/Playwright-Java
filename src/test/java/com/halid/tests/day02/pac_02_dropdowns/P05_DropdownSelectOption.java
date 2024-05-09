package com.halid.tests.day02.pac_02_dropdowns;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;

public class P05_DropdownSelectOption {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/dropdown");

        // How to get selected option

        ElementHandle simpleDropdown = page.querySelector("[id=dropdown]");

        Locator yearDropdown = page.locator("[id=year]");
        Locator monthDropdown = page.locator("[id=month]");
        Locator dayDropdown = page.locator("[id=day]");

        String expectedYear = "1989";
        String expectedMonth = "October";
        int expectedDay = 16;

        // select with value
        yearDropdown.selectOption(new SelectOption().setValue(expectedYear));

        // select with label(text)
        monthDropdown.selectOption(new SelectOption().setLabel(expectedMonth));

        // select with Index
        dayDropdown.selectOption(new SelectOption().setIndex(expectedDay - 1)); // index starts from 0

        BrowserUtils.sleepWithPage(page, 2);

        String actualYear = page.evaluate("el=>el.selectedOptions[0].text", yearDropdown.elementHandle()).toString();
        String actualMonth = page.evaluate("el=>el.selectedOptions[0].text", monthDropdown.elementHandle()).toString();
        String actualDay = page.evaluate("el=>el.selectedOptions[0].text", dayDropdown.elementHandle()).toString();

        System.out.println("actualYear = " + actualYear);
        System.out.println("actualMonth = " + actualMonth);
        System.out.println("actualDay = " + actualDay);


        page.close();
        browser.close();
        playwright.close();
    }
}
