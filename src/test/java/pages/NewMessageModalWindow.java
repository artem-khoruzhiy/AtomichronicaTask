package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class NewMessageModalWindow {
    private String addresseeField = "//*[@name='to']";
    private String subjectField = "//*[@name='subjectbox']";
    private String messageField = "//*[@role='textbox']";
    private String sendButton = "//*[contains(@aria-label, 'Send')]";

    public void setMessageFields(String addressee, String subject, String message){
        $(byXpath(addresseeField)).setValue(addressee);
        $(byXpath(subjectField)).setValue(subject);
        $(byXpath(messageField)).setValue(message);
    }

    public void sendMessage(){
        $(byXpath(sendButton)).click();
    }
}
