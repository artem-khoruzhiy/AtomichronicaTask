package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MessageElement {

    private String messageText = "//div[contains(text(), 'message')]";

    public void verifyCorrectBody(String body){
        $(By.xpath(messageText)).shouldBe(visible);
    }
}
