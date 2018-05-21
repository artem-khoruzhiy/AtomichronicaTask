package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class GmailMainPage {
    private String composeButton = "//div[text()='COMPOSE']";
    private String inboxButton = "//a[contains(., 'Inbox')]";
    private String messageButton = "//span/*[contains(text(), '%s')]";

    public NewMessageModalWindow clickComposeButton(){
        $(By.xpath(composeButton)).click();
        return new NewMessageModalWindow();
    }

    public void openInbox(){
        $(By.xpath(inboxButton)).click();
    }

    public void verifyDeliveredMessage(String subject){
        $(By.xpath(String.format(messageButton, subject))).shouldBe(Condition.visible);
    }

    public MessageElement openMessageBySubject(String subject){
        $(By.xpath(String.format(messageButton, subject))).click();

        return new MessageElement();
    }


}
