package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class GmailMainPage {
    private String composeButton = "//*[text()='COMPOSE']";
    private String inboxButton = "//a[contains(., 'Inbox')]";
    private String messageButton = "//span/*[contains(text(), '%s')]";

    public NewMessageModalWindow clickComposeButton(){
        $(byXpath(composeButton)).click();
        return new NewMessageModalWindow();
    }

    public void openInbox(){
        $(byXpath(inboxButton)).click();
    }

    public void verifyDeliveredMessage(String subject){
        $(byXpath(String.format(messageButton, subject))).shouldBe(Condition.visible);
    }

    public MessageElement openMessageBySubject(String subject){
        $(byXpath(String.format(messageButton, subject))).click();

        return new MessageElement();
    }


}
