package com.zopa.technical.test.pages;

import com.zopa.technical.test.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {

    @FindBy(css = "a.button.button--fullWidth")
    private WebElement loanBtn;

    public void clickGetLoan(){
        loanBtn.click();
    }
}
