package pages;

import org.openqa.selenium.By;

public class SecureAreaPage {

    private BasePage browser;
    private By loginMessage = By.id("flash");

    public SecureAreaPage(BasePage browser){
        this.browser = browser;
    }

    public String getLoginStatus(){
        return browser.getMessage(loginMessage);
    }
}

