package com.halid.tests.day02.pac_01_multipleElements_checkbox_radio;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.Element;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P04_checkbox_radio {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");

        List<ElementHandle> mainPageLinks = page.querySelectorAll(".container li a");

        /*
        ElementHandle checkboxes = mainPageLinks.stream().filter(p -> p.textContent().equals("Checkboxes")).collect(Collectors.toList()).get(0);
        */

        // another way to fetch an element from the List of Elements
        ElementHandle checkboxes = mainPageLinks
                .stream()
                .filter(p ->
                        p.isEnabled() && p.textContent().equals("Checkboxes"))
                .collect(Collectors.toList())
                .get(0);

        checkboxes.click();

        Locator checkbox1 = page.locator("#box1");
        // ElementHandle checkbox1 = page.querySelector("input[id='box1']");
        // ElementHandle checkbox1 = page.querySelector("[id='box1']");
        Locator checkbox2 = page.locator("#box2");
        // click(), check() or uncheck() methods can be used
        checkbox1.click(); // changes the checked or unchecked status of the box
        checkbox2.uncheck(); // makes checked
        checkbox1.check(); // makes unchecked

        System.out.println("checkbox1.isChecked() = " + checkbox1.isChecked());
        System.out.println("checkbox2.isChecked() = " + checkbox2.isChecked());

        Assertions.assertTrue(checkbox1.isChecked());


        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
