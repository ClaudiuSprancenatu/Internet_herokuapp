package pages;

import org.openqa.selenium.By;

public class LoginPage {
    private BasePage browser;
    private By emailform = By.id("username");
    private By passform = By.id("password");
    private By buttonform = By.cssSelector("#login button");

    public LoginPage(BasePage browser){
        this.browser = browser;
    }

    public LoginPage open (){
        browser.visit("/login");
        return this;
    }

    public void iLogin(){
        browser.typeIn("tomsmith", emailform);
        browser.typeIn("SuperSecretPassword!", passform);
        browser.click(buttonform);
    }

}

