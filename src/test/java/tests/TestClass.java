package tests;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.*;
import pages.*;


public class TestClass {

    @BeforeTest
    public void settings(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://gmail.com";
        open("/");

        StartPage startPage = new StartPage();
        startPage.setLoginField("test.incytes4@gmail.com");
        startPage.clickNext();

        PasswordPage passwordPage = new PasswordPage();
        passwordPage.setPasswordField("222222qwe");
        passwordPage.clickNext();
    }

    @Test
    public void sendMessageTest(){
        GmailMainPage gmailMainPage = new GmailMainPage();

        NewMessageModalWindow newMessageModalWindow = gmailMainPage.clickComposeButton();
        newMessageModalWindow.setMessageFields("test.incytes4@gmail.com", "test", "Hello world");
        newMessageModalWindow.sendMessage();

        gmailMainPage.openInbox();
        gmailMainPage.verifyDeliveredMessage("test");
        MessageElement messageElement = gmailMainPage.openMessageBySubject("test");
        messageElement.verifyCorrectBody("Hello world");
    }
}
