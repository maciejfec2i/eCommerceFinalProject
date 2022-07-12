package com.twoitesting.utilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Scroller {

    public static void scrollToElement(WebDriver driver, WebElement element) {

        Actions scrollAction = new Actions(driver);
        scrollAction.scrollToElement(element).build();
    }
}
