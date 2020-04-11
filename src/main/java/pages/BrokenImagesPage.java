package pages;

public class BrokenImagesPage {

    private BasePage browser;

    public BrokenImagesPage(BasePage browser){
        this.browser = browser;
    }

    public void VerifyImages(){
        browser.ImagestoCheck();
    }
}
