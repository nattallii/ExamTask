package org.example;

import org.example.pages.RegPage;
import org.example.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExamTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://myspace.com/signup");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            
            StartPage startPage = new StartPage(driver);
            startPage.clickNext();

            RegPage regPage = new RegPage(driver);

            regPage.enterFullName("Natalia Test");
            regPage.enterUsername("natalia.test123");
            regPage.enterEmail("natttaliaa6@gmail.com");
            regPage.enterZipcode("12345");
            regPage.selectGender("Female");
            regPage.enterPassword("TestPassword123!");
            regPage.enterDateOfBirth("05", "21", "1999");
            regPage.acceptTerms();

            Thread.sleep(5000);

            regPage.clickCaptcha();
            regPage.clickCreateAccount();

            

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
