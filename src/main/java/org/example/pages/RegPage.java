package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegPage {
    private WebDriver driver;

    @FindBy(id = "signupEmailFullName")
    private WebElement fullNameInput;

    @FindBy(id = "signupEmailUsername")
    private WebElement usernameInput;

    @FindBy(id = "signupEmailEmail")
    private WebElement emailInput;

    @FindBy(id = "signupEmailZipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "signupEmailGender")
    private WebElement genderSelect;

    @FindBy(id = "signupEmailPassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@placeholder='MM']")
    private WebElement birthMonth;

    @FindBy(xpath = "//input[@placeholder='DD']")
    private WebElement birthDay;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    private WebElement birthYear;

    @FindBy(xpath = "//input[@type='checkbox' and @name='terms']")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement recaptchaCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Create Account')]")
    private WebElement createAccountButton;

    public RegPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String fullName) {
        fullNameInput.sendKeys(fullName);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterZipcode(String zipcode) {
        zipcodeInput.sendKeys(zipcode);
    }

    public void selectGender(String genderValue) {
        Select genderDropdown = new Select(genderSelect);
        genderDropdown.selectByValue(genderValue);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterDateOfBirth(String month, String day, String year) {
        birthMonth.sendKeys(month);
        birthDay.sendKeys(day);
        birthYear.sendKeys(year);
    }

    public void acceptTerms() {
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    public void clickCaptcha() {
        recaptchaCheckbox.click();
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
