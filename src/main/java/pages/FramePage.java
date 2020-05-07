package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {

    private BasePage browser;
    private By result = By.xpath("/html/body");

    public FramePage(BasePage browse){
        this.browser = browse;
    }

    public FramePage open (){
        browser.visit("/nested_frames");
        return this;
    }

    public void frameIdentifier(){
        browser.waitForThePageToBeLoaded();
        browser.frame( "frame-top", "frame-left");

    }

    public String frameMessage(){
        return browser.getMessage(result);
    }

}
