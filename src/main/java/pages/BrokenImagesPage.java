package pages;

import org.openqa.selenium.By;

public class BrokenImagesPage {

    private BasePage driver;

    public BrokenImagesPage(BasePage driver){

        this.driver = driver;
    }

    public void VerifyImages(){

        driver.ImagestoCheck();
    }
}
