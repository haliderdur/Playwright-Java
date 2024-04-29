package com.halid.tests.day02.pac_01_multipleElements_checkbox_radio;

import com.halid.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class P05_RadioButtons {

    @Test
    public void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/radio_buttons");


        ElementHandle redRadio = page.querySelector("[id=red]");
        redRadio.click();
        ElementHandle blueRadio = page.querySelector("[id=blue]");
        blueRadio.click();


        /*
        <div class="radio">
            <input type="radio" id="hockey" name="sport">
            <label class="form-check-label" for="hockey">Hockey</label>
        </div>

        This getByRole() method works cuz in html element, label tag designed to be connected with input tag.
        see id="hockey" and for="hockey"
         */
        Locator hockeyRadioBtn = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Hockey"));
        hockeyRadioBtn.click();

         /*
         <div class="radio">
            <input type="radio" id="red" name="color">
            <label class="form-check-label">Red</label>
        </div>

        This getByRole() method does not work cuz in html element, label tag designed NOT to be connected with input tag.
        see id="red" but there must be for="red" in label tag as well
         */
        // Locator redRadioBtn = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Red"));
        // redRadioBtn.click();


        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
