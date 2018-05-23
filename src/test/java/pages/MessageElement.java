package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class MessageElement {

    private String messageTextPattern = "//*[@role='presentation']//*[contains(text(), '%s')]";

    public void verifyCorrectBody(String body){
        $(byXpath(String.format(messageTextPattern, body))).shouldBe(visible);
    }
}
