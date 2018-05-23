package pages;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginVerificationPage {

    private String loginField = "//*[@id='identifierId']";
    private String nextButton = "//*[@id='identifierNext']";

    public void setLoginField(String login){
        $(byXpath(loginField)).setValue(login);
    }

    public void clickNext(){
        $(byXpath(nextButton)).click();
    }
}
