package com.halid.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;

public class CRMUtils {

    public static void login(@NotNull Page page) {

        Locator usernameInputBox = page.locator("[name=USER_LOGIN]");
        usernameInputBox.fill("invalidEmail@gmail.com");

        Locator passwordInputBox = page.getByPlaceholder("password");
        passwordInputBox.fill("invalidPassword");

        //  Locator rememberMeCheckBox = page.locator("#USER_REMEMBER"); // used id
        //  rememberMeCheckBox.click();

        Locator loginButton = page.locator(".login-btn"); // used class
        loginButton.click();
    }

    public static void login(@NotNull Page page, String username, String password) {

        Locator usernameInputBox = page.locator("[name=USER_LOGIN]");
        usernameInputBox.fill(username);

        Locator passwordInputBox = page.getByPlaceholder("password");
        passwordInputBox.fill(password);

        //  Locator rememberMeCheckBox = page.locator("#USER_REMEMBER"); // used id
        //  rememberMeCheckBox.click();

        Locator loginButton = page.locator(".login-btn"); // used class
        loginButton.click();
    }

}
