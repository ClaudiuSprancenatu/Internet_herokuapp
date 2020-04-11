package pages;

import org.openqa.selenium.By;

public class HomePage {
    private BasePage browser;

    public HomePage(BasePage browser){
        this.browser = browser;
    }

    public BrokenImagesPage clickBrokenImage(){
        browser.clickLink("Broken Images");
        return new BrokenImagesPage(browser);
    }

}
