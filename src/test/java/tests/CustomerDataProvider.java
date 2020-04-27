package tests;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name="LoginDataProvider")
    public Object [] [] getData(){
        Object [] [] data = { {"tomsmith","SuperSecretPassword!"},{"sprancenatuc@yahoo.com","SuperSecretPassword!"},{" "," "}};
        return data;
    }
}
