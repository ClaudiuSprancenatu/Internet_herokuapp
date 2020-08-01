package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private BasePage browser;
    private By dropdown = By.id("dropdown");
    private By option = By.cssSelector("#dropdown option[selected]");

    public DropdownPage(BasePage browser){
        this.browser = browser;
    }

    public DropdownPage open (){
        browser.visit("/dropdown");
        return this;
    }

    public void getDropdown(String text){
       browser.getSelectDropdown(dropdown).selectByVisibleText(text);
    }

    public String getOption(){
        return browser.getMessage(option);
    }


}
