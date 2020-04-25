package pages;

import org.openqa.selenium.By;

public class CheckboxPages {
    private BasePage browser;
    private By checkboxfind = By.cssSelector("#checkboxes input");

    public CheckboxPages(BasePage browser){
        this.browser = browser;
    }

    public void open(){

        browser.visit("/checkboxes");
    }

    public void iVerifyCheckboxes(){
        browser.theCheckboxClick(checkboxfind);
    }
}
