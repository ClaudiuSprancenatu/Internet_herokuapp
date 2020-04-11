package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private BasePage basePage;
    private HomePage homePage;
    private BrokenImagesPage brokenImagesPage;

    public PageObjectManager(WebDriver driver){
        basePage = new BasePage(driver);
    }

    public BrokenImagesPage getBrokenImagesPage(){
        return (brokenImagesPage == null) ? brokenImagesPage = new BrokenImagesPage(basePage) : brokenImagesPage;
    }

    public HomePage getHomePage() {

        return (homePage == null) ? homePage = new HomePage(basePage) : homePage;
    }

}
