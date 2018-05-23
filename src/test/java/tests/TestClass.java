package tests;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.*;
import pages.*;

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
        open("/");

        StartPage startPage = new StartPage();
        startPage.setLoginField("test.incytes4@gmail.com");
        startPage.clickNext();

        PasswordPage passwordPage = new PasswordPage();
        passwordPage.setPasswordField("222222qwe");
        passwordPage.clickNext();
    }

    @Test(dataProvider = "data")
    public void sendMessageTest(Message message){
        GmailMainPage gmailMainPage = new GmailMainPage();

        NewMessageModalWindow newMessageModalWindow = gmailMainPage.clickComposeButton();
        newMessageModalWindow.setMessageFields(message.getAddressee(), message.getSubject(), message.getMessage());
        newMessageModalWindow.sendMessage();

        System.out.println(1);

        gmailMainPage.openInbox();
        System.out.println(2);
        gmailMainPage.verifyDeliveredMessage(message.getSubject());
        System.out.println(3);
        MessageElement messageElement = gmailMainPage.openMessageBySubject(message.getSubject());
        messageElement.verifyCorrectBody(message.getMessage());
    }
}
