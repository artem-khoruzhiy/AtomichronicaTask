package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class NewMessageModalWindow {

    private String addresseeField = "//textarea[@name='to']";
    private String subjectField = "//input[@name='subjectbox']";
    private String messageField = "//div[@aria-label='Message Body']";
    private String sendButton = "//div[contains(@aria-label, 'Send')]";

    public void setMessageFields(String addressee, String subject, String message){
        $(By.xpath(addresseeField)).setValue(addressee);
        $(By.xpath(subjectField)).setValue(subject);
        $(By.xpath(messageField)).setValue(message);
    }

    public void sendMessage(){
        $(By.xpath(sendButton)).click();
    }
}
