package pages;

import org.openqa.selenium.By;

public class SecureAreaPage {

    private BasePage browser;
    private By loginmessage = By.id("flash");

    public SecureAreaPage(BasePage browser){
        this.browser = browser;
    }

    public void getsuccesfulLogin(){
        browser.getMessage(loginmessage);
    }
}
