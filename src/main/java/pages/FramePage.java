package pages;

import org.openqa.selenium.By;

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

    public void frameTopIdentifier(String text1, String text2){
        browser.waitForThePageToBeLoaded();
        browser.frameTop( text1, text2);
    }

    public void frameBottomIdentifier(String text){
        browser.waitForThePageToBeLoaded();
        browser.frameBottom(text);
    }

    public String frameMessage(){
        return browser.getMessage(result);
    }

}
