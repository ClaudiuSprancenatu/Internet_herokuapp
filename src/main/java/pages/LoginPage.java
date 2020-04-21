package pages;

import org.openqa.selenium.By;

public class LoginPage {
    private BasePage browser;
    private By emailform = By.id("username");
    private By passform = By.id("password");
    private By buttonLogin = By.cssSelector("#login button");
    private By buttonLogout = By.cssSelector(".example a");

    public LoginPage(BasePage browser){
        this.browser = browser;
    }

    public LoginPage open (){
        browser.visit("/login");
        return this;
    }

    public void iSuccessfullyLogin(){
        LoginFrom("tomsmith", "SuperSecretPassword!");
    }

    public void iUnssucessfllyLogin(){
        LoginFrom("sprancenatuc@yahoo.com", "123456");
    }

    public void iLogout(){
        browser.click(buttonLogout);
    }

    private void LoginFrom(String email, String pass){
        browser.typeIn(email, emailform);
        browser.typeIn(pass, passform);
        browser.click(buttonLogin);
    }

}

