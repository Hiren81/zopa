package com.zopa.technical.test.utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

import static com.jayway.restassured.RestAssured.given;

public class User {

    private Faker faker;

    private Helpers helpers;

    private String email;

    private String title;

    private String firstName;

    private String lastName;

    private String phoneNumber;


    private String dataOfBirth;

    private String loanReason;

    private String postCode;

    private String financial;

    private String salary;

    private String home;

    private String contribution;

    private String password;

    public User() {

        // using faker api to Randamize fake data

        faker = new Faker(new Locale("en-GB"));
        helpers = new Helpers();
        setUserEmail();
        setUserTitle();
        setUserFirstName();
        setUserLastName();
        setPhoneNumber();
        setDataOfBirthOver20();
        setUserLoanReason();
        setUserPostCode();
        setUserFinancial();
        setUserSalary();
        setUserHome();
        setUserMonthlyContribution();
        setUserPassword();
    }

    private void setUserEmail() {
        email = faker.internet().emailAddress();
    }

    private void setUserTitle() {
        String titlePrefix = faker.name().prefix();
        if (titlePrefix.contains("Dr.")) {
            titlePrefix = "Mr";
        }
        title = titlePrefix.replace(".", "");
    }

    private void setUserFirstName() {
        firstName = faker.name().fullName();
    }

    private void setUserLastName() {
        lastName = faker.name().lastName();
    }

    private void setPhoneNumber() {
        phoneNumber = faker.phoneNumber().cellPhone();
    }

    private void setDataOfBirthOver20() {
        this.dataOfBirth = helpers.dobOver20();
    }

    private void setUserLoanReason() {
        ArrayList<String> reason = new ArrayList<String>();
        reason.add("Car");
        reason.add("Home improvements");
        reason.add("Debt consolidation");
        loanReason = helpers.randomValuesFromList(reason);
    }

    private void setUserPostCode() {

        // Using post code checker Api to validate post code
        postCode = given()
                .when()
                .get("http://api.postcodes.io/random/postcodes")
                .then()
                .extract().path("result.postcode").toString();
    }

    private void setUserFinancial() {
        ArrayList<String> financialOptions = new ArrayList<String>();
        financialOptions.add("Employed full-time");
        financialOptions.add("Self employed");
        financialOptions.add("Director of a limited company");
        financialOptions.add("Employed part-time");
        financialOptions.add("Currently unemployed");
        financialOptions.add("Retired, not working");
        financialOptions.add("Housewife, househusband or homemaker");
        financial = helpers.randomValuesFromList(financialOptions);
    }

    private void setUserSalary() {
        salary = String.valueOf(helpers.randomNumberInRange(100000, 10000));
    }

    private void setUserHome() {
        ArrayList<String> homeOptions = new ArrayList<String>();
        homeOptions.add("Yes, outright owner");
        homeOptions.add("Yes, with a mortgage");
        homeOptions.add("No");
        home = helpers.randomValuesFromList(homeOptions);
    }

    private void setUserMonthlyContribution() {
        contribution = String.valueOf(helpers.randomNumberInRange(1000, 100));
    }

    private void setUserPassword() {
        password = helpers.generateString();
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDataOfBirthOver20() {
        return dataOfBirth;
    }

    public String getLoanReason() {
        return loanReason;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getFinancial() {
        return financial;
    }

    public String getSalary() {
        return salary;
    }

    public String getHome() {
        return home;
    }

    public String getContribution() {
        return contribution;
    }

    public String getPassword() {
        return password;
    }
}
