package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
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

    public void waitForThePageToBeLoaded() {
        new WebDriverWait(driver, 5).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
       // new WebDriverWait(driver, timeout)
         //       .until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
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

    public WebElement waitUntilIsClickable(By element){
        try {
            waitFor(ExpectedConditions.elementToBeClickable(find(element)), timeout);
        } catch (Exception e) {

        }
        return find(element);
    }

/*
    public void waitUntilContainsText(By element, String text) {
        int i = 0;
        waitForElement(element);
        while (i < timeout) {
            String et = find(element).getText();
            if (et.contains(text)) {
                break;
            }
            i++;
            sleep(waitPerTry);
        }
    }
*/
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

    public WebElement waitForElement(By selector) {
        waitFor(ExpectedConditions.presenceOfElementLocated(selector), timeout);
        return driver.findElement(selector);
    }

    public void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : this.timeout;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
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

    public String getMessage(By selector){

        return driver.findElement(selector).getText();
    }

    public void typeIn(String text, By selector) {
//        waitForThePageToBeLoaded();
        waitUntilIsVisible(selector);
        waitForThePageToBeLoaded();
        find(selector).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));
        find(selector).clear();
        find(selector).sendKeys(text);
//        jsType(text, extractSelector(selector));
    }

    public WebElement waitUntilIsVisible(By selector) {
        // TODO - to do some more testing
//        waitFor(ExpectedConditions.visibilityOfElementLocated(selector), 10);
//        return find(selector);

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
