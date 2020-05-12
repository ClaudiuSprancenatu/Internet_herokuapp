package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownPage {
    private BasePage browser;
    private By dropdown = By.id("dropdown");

    public DropdownPage(BasePage browser){
        this.browser = browser;
    }

    public void SelectDropdown(){
        browser.getSelectDropdown(dropdown);
    }

    public DropdownPage open (){
        browser.visit("/dropdown");
        return this;
    }


}
