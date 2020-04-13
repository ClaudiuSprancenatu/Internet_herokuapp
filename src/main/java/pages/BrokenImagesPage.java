package pages;

import org.openqa.selenium.By;

public class BrokenImagesPage {

    private BasePage driver;
    private By images = By.className(".example");

    public BrokenImagesPage(BasePage driver){

        this.driver = driver;
    }

    public void iVerifyImages(){

        driver.theImagesAreLoadedProperly(images);
    }

    public void open(){
        driver.visit("http://the-internet.herokuapp.com/broken_images");
    }
}
