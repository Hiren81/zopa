package com.zopa.technical.test.pages;

import com.zopa.technical.test.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Loan Quote page

public class LoanPage extends DriverManager {

    @FindBy(css = "input[value='Get my personalised rates']")
    private WebElement getMyPersonisedRateBtn;

    public void goToQuotes() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,450)", "");
        getMyPersonisedRateBtn.click();
    }
}
