package tests;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name="SuccessfulLogin")
    public Object [] [] testSuccessfullyLogin(){
        Object [] [] data = { {"tomsmith","SuperSecretPassword!"}};
        return data;
    }

    @DataProvider(name="UnsuccessfulLogin")
    public Object [] [] testInvalidLogin(){
        Object [] [] data = { {"sprancenatuc@yahoo.com","SuperSecretPassword!"},{"tomsmith","12345"}};
        return data;
    }
}
