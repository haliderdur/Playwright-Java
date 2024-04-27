package com.halid.tests.day01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_InnerText_VS_TextContent {

    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("http://localhost:63342/Playwright-Java/src/test/resources/getText.html?_ijt=ssvlbcf2lfqnita55m066qo6h8&_ij_reload=RELOAD_ON_SAVE");

        String textContent = page.querySelector("#example").textContent();
        String innerText = page.querySelector("#example").innerText();

        System.out.println("textContent = " + textContent);
        System.out.println("innerText = " + innerText);


        page.waitForTimeout(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
