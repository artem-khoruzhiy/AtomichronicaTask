package tests;

import entities.Message;
import pages.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.*;

public class TestClass {

    @DataProvider(name = "data")
    public Object[][] getTestData(){
        return new Object[][]{
                {new Message("test.incytes4@gmail.com", "test", "Hello world")}
        };
    }

    @BeforeTest
    public void settings(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://gmail.com";
        Configuration.timeout = 7000;

        open("/");

        LoginVerificationPage loginVerificationPage = new LoginVerificationPage();
        loginVerificationPage.setLoginField("test.incytes4@gmail.com");
        loginVerificationPage.clickNext();

        PasswordVerificationPage passwordVerificationPage = new PasswordVerificationPage();
        passwordVerificationPage.setPasswordField("222222qwe");
        passwordVerificationPage.clickNext();
    }

    @Test(dataProvider = "data")
    public void sendMessageTest(Message message){
        GmailMainPage gmailMainPage = new GmailMainPage();

        NewMessageModalWindow newMessageModalWindow = gmailMainPage.clickComposeButton();
        newMessageModalWindow.setMessageFields(message.getAddressee(), message.getSubject(), message.getMessage());
        newMessageModalWindow.sendMessage();

        gmailMainPage.openInbox();
        gmailMainPage.verifyDeliveredMessage(message.getSubject());

        MessageElement messageElement = gmailMainPage.openMessageBySubject(message.getSubject());
        messageElement.verifyCorrectBody(message.getMessage());
    }
}
