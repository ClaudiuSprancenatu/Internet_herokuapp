package pages;

import org.openqa.selenium.By;

public class CheckboxPages {
    private BasePage driver;
    private By checkboxfind = By.id("checkboxes");

    public CheckboxPages(BasePage driver){
        this.driver = driver;
    }

    public void iVerifyCheckboxes(){
        driver.theCheckboxClick(checkboxfind);
    }
    public void open(){
        driver.visit("http://the-internet.herokuapp.com/broken_images");
    }
}
