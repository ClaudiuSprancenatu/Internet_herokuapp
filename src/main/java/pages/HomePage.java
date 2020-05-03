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

    public CheckboxPages clickCheckBoxs(){
        driver.clickLink("Checkboxes");
        return new CheckboxPages(driver);
    }

    public LoginPage clickFormAuthentication(){
        driver.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        driver.clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

}
