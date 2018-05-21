package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PasswordPage {
    private String passwordField = "//div[@id='password']//input";
    private String nextButton = "//div[@id='passwordNext']";

    public void setPasswordField(String password) {
        $(By.xpath(passwordField)).setValue(password);
    }

    public void clickNext(){
        $(By.xpath(nextButton)).click();
    }
}
