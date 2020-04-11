package pages;

public class HomePage {
    private BasePage driver;

    public HomePage(BasePage driver){
        this.driver = driver;
    }

    public BrokenImagesPage clickBrokenImage(){
        driver.clickLink("Broken Images");
        return new BrokenImagesPage(driver);
    }

}
