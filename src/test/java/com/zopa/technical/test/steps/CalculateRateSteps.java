package com.zopa.technical.test.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zopa.technical.test.pages.HomePage;
import com.zopa.technical.test.pages.LoanPage;
import com.zopa.technical.test.pages.SignUpPage;
import com.zopa.technical.test.utils.User;
import com.zopa.technical.test.utils.Helpers;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class CalculateRateSteps {

    HomePage homePage;
    LoanPage loanPage;
    SignUpPage signUpPage;
    User user;

    public CalculateRateSteps(HomePage diHomePage, LoanPage diLoanPage, SignUpPage diSignUpPage, User diUser) {
        this.homePage = diHomePage;
        this.loanPage = diLoanPage;
        this.signUpPage = diSignUpPage;
        this.user = diUser;
    }


    @Given("^I fill the application form with random data$")
    public void i_fill_the_application_form_with_random_data() {
        signUpPage.enterEmailId(user.getEmail());
        signUpPage.selectRadioBtn(user.getTitle());
        signUpPage.enterFirstName(user.getFirstName());
        signUpPage.enterLastName(user.getLastName());
        signUpPage.enterPhoneNumber(user.getPhoneNumber());
        signUpPage.enterDataOfBirth(user.getDataOfBirthOver20());
        signUpPage.selectRadioBtn(user.getLoanReason());
        signUpPage.enterPostCode(user.getPostCode());
        signUpPage.selectRadioBtn(user.getFinancial());
        signUpPage.enterSalary(user.getSalary());
        signUpPage.selectRadioBtn(user.getHome());
        signUpPage.enterMonthlyContribution(user.getContribution());
        signUpPage.enterPassword(user.getPassword());

    }

    @Given("^I set up mock User data for application$")
    public void mockUserData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(user);
        new Helpers().storeTestDataToFile(jsonInString);
    }

    @Given("^I navigate to Get a Zopa loan$")
    public void iNavigateToGetAZopaLoan() {
        homePage.clickGetLoan();
    }

    @And("^I navigate to Get my personalised rates$")
    public void iNavigateToGetMyPersonalisedRates() {
       loanPage.goToQuotes();
    }
}
