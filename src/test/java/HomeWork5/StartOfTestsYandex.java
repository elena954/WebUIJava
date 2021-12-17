package HomeWork5;


import static HomeWork5.AuthorizationAndNewMessageYandex.*;
import static HomeWork5.DataTest.*;
import static HomeWork5.DeleteASentMessageYandex.deleteSentMessages;

public class StartOfTestsYandex {
    public static void main(String[] args){
        registerDriver();
        setDriver();
        newMessage();
        deleteSentMessages();
        tearDown();

    }
}
