package pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PasswordPage {
    private String passwordField = "//*[@name='password']";
    private String nextButton = "//*[@id='passwordNext']";

    public void setPasswordField(String password) {
        $(byXpath(passwordField)).setValue(password);
    }

    public void clickNext(){
        $(byXpath(nextButton)).click();
    }
}
