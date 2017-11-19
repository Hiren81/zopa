package com.zopa.technical.test.pages;

import com.zopa.technical.test.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class SignUpPage extends DriverManager {

    @FindBy(css = "#member_email")
    private WebElement emailTxtBox;

    @FindBy(css = "#applications_loan_apply_first_name")
    private WebElement firstNameTxt;

    @FindBy(css = "#applications_loan_apply_last_name")
    private WebElement lastNameTxtBox;

    @FindBy(css = "#applications_loan_apply_home_phone")
    private WebElement phoneNumber;

    @FindBy(id = "date_of_birth_day")
    private WebElement dataOfBirthDay;

    @FindBy(id = "date_of_birth_month")
    private WebElement dataOfBirthMonth;

    @FindBy(id = "date_of_birth_year")
    private WebElement dataOfBirthYear;

    @FindBy(css = "#address_postcode")
    private WebElement postcodeTxtBox;

    @FindBy(css = ".minor")
    private WebElement loopUpAddressBtn;

    @FindBy(css = "#address_possible_address>option")
    private List<WebElement> selectAddress;

    @FindBy(css = ".select-group>select")
    private List<WebElement> moveInDdl;

    @FindBy(name = "select_address")
    private WebElement useAddressBtn;

    @FindBy(id = "applications_loan_apply_salary")
    private WebElement salaryTxtBox;

    @FindBy(id = "applications_loan_apply_rent")
    private WebElement montlyContibutionTxtBox;

    @FindBy(id = "member_password")
    private WebElement passwordTxtBox;

    // This locator will handle all the radio button on the form

    @FindBy(css = ".radiocheck>label")
    private List<WebElement> genricRadioBtn;

    public void enterEmailId(String email) {
        emailTxtBox.sendKeys(email);
    }

    public void enterFirstName(String name) {
        firstNameTxt.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        lastNameTxtBox.sendKeys(lastName);
    }

    public void enterPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }

    public void enterDataOfBirth(String dob) {
        List<String> items = Arrays.asList(dob.split("-"));
        dataOfBirthYear.sendKeys(items.get(0));
        dataOfBirthMonth.sendKeys(items.get(1));
        dataOfBirthDay.sendKeys(items.get(2));
    }

    public void selectRadioBtn(String using) {
        for (WebElement option : genricRadioBtn) {
            String txt = option.getText();
            if (txt.equalsIgnoreCase(using)) {
                option.click();
            }
        }
    }

    public void enterPostCode(String postcode) {
        postcodeTxtBox.sendKeys(postcode);
        loopUpAddressBtn.click();
        if (selectAddress.size() == 0) {
            throw new RuntimeException(String.format("invalid postcode %s -> please supply valid postcode", postcode));
        }
        selectAddress.get(0).click();

        for (WebElement element : moveInDdl) {
            element.click();
            new Select(element).selectByIndex(11);
        }
        useAddressBtn.click();
    }

    public void enterSalary(String salary) {
        salaryTxtBox.sendKeys(salary);
    }

    public void enterMonthlyContribution(String monthExp) {
        montlyContibutionTxtBox.sendKeys(monthExp);
    }

    public void enterPassword(String password) {
        passwordTxtBox.sendKeys(password);
    }
}
