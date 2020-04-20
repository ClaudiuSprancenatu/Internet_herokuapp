package pages;

import org.openqa.selenium.By;

public class BrokenImagesPage {

    private BasePage driver;
    private By image = By.cssSelector(".example img");

    public BrokenImagesPage(BasePage driver){
        this.driver = driver;
    }

    public void iVerifyImages(){
        driver.waitForThePageToBeLoaded();
        driver.theImagesAreLoadedProperly(image);
    }

    public BrokenImagesPage open(){
        driver.visit("/broken_images");
        return this;
    }
}
