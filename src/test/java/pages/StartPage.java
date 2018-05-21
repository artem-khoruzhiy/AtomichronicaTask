package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class StartPage {
    private String loginField = "//input[@id='identifierId']";
    private String nextButton = "//div[@id='identifierNext']";


    public void setLoginField(String login){
        $(By.xpath(loginField)).setValue(login);
    }

    public void clickNext(){
        $(By.xpath(nextButton)).click();
    }
}
