package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MessageElement {

    private String messageText = "//div/div[contains(text(), '%s')]";

    public void verifyCorrectBody(String body){
        $(By.xpath(String.format(messageText, body))).shouldBe(visible);
    }
}
