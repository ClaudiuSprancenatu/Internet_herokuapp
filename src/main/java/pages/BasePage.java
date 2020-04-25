package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private Integer timeout = 10; // number of tries
    private int waitPerTry = 500; // milliseconds to wait on each try
    private String baseUrl = System.getProperty("baseUrl", "System baseUrl is not defined");
    public BasePage(WebDriver driver){ this.driver = driver; }


    /**
     * Opens page
     * @param url relative or absolute url
     */
    public void visit(String url) {
        System.out.println("Navigating to: " + url);
        if (!url.contains("http")) {
            url = baseUrl + url;
        }
        System.out.println("<> " + url);
        driver.get(url);
    }

    public void clickLink(String text){
        waitForThePageToBeLoaded();
        driver.findElement(By.linkText(text)).click();
    }

    public void click(By selector) {
        try {
            waitUntilIsClickable(selector).click();
        } catch (StaleElementReferenceException s) {
            find(selector).click();
        }
    }

    public String getMessage(By selector){

        return driver.findElement(selector).getText();
    }

    public void typeIn(String text, By selector) {
        waitUntilIsVisible(selector);
        waitForThePageToBeLoaded();
        find(selector).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));
        find(selector).clear();
        find(selector).sendKeys(text);
    }

    public void theImagesAreLoadedProperly(By img_selector){
        waitForElement(img_selector);
        List<WebElement> list = driver.findElements(img_selector);
        System.out.println("Total number of Images on webpage are:...." + list.size());

        for(WebElement ele: list){
            try{
                HttpURLConnection conn = (HttpURLConnection) new URL(ele.getAttribute("src")).openConnection();
                conn.setRequestMethod("GET");
                int respondeCode = conn.getResponseCode();
                if(respondeCode != 200){
                    System.out.println("Broken Image :....." + ele.getAttribute("src"));
                }else{
                    System.out.println("Good Image :....." + ele.getAttribute("src"));
                }

            }catch (Exception e){
                System.out.println("No image found!");
                e.printStackTrace();
            }
        }
    }

    public WebElement find(By selector) {
        waitForThePageToBeLoaded();
        WebElement node;
        try {
            node = driver.findElement(selector);
            node.getTagName();
        } catch (StaleElementReferenceException s) {
            node = driver.findElement(selector);
        }
        return node;
    }

    public void sleep(Integer miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException in) {
        }
    }

    public String selectCheckbox(By selector){
        Boolean isChecked = false;
        List<WebElement> checkboxes = driver.findElements(selector);
        int size = checkboxes.size();
        System.out.println("The size of list is: " + size);

        for (int i=0; i<size; i++){
            isChecked = checkboxes.get(i).isSelected();
            if(isChecked == false){
                checkboxes.get(i).click();
            }
        }

        return null;
    }

    public String deSelectCheckbox(By selector){
        Boolean isChecked = false;
        List<WebElement> checkboxes = driver.findElements(selector);
        int size = checkboxes.size();
        System.out.println("The size of list is: " + size);

        for (int i=0; i<size; i++){
            isChecked = checkboxes.get(i).isSelected();
            if(isChecked == true){
                checkboxes.get(i).click();
            }
        }

        return null;
    }

    // WAITS METHODS

    public void waitForThePageToBeLoaded() {
        new WebDriverWait(driver, 5).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }


    public WebElement waitUntilIsClickable(By element){
        try {
            waitFor(ExpectedConditions.elementToBeClickable(find(element)), timeout);
        } catch (Exception e) {

        }
        return find(element);
    }

    public WebElement waitForElement(By selector) {
        waitFor(ExpectedConditions.presenceOfElementLocated(selector), timeout);
        return driver.findElement(selector);
    }

    public void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : this.timeout;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public WebElement waitUntilIsVisible(By selector) {
        // TODO - to do some more testing

        Integer i = 0;
        WebElement node;
        String stacktrace = null;
        while (i < timeout) {
            try {
                node = find(selector);
            } catch (Exception e) {
                node = null;
                stacktrace = e.getMessage();
                i++;
                sleep(waitPerTry);
            }
            if (node != null) {
                if (node.isDisplayed()) {
                    return node;
                }
            }
        }

        throw new NoSuchElementException(String.format("Element %s not found or not visible until %d seconds passed!",
                selector, timeout) + "\r\n" + stacktrace);
    }

}
