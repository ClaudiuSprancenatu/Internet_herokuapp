package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private Integer timeout = 10; // number of tries
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
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }

    public void clickLink(String text){
        waitForThePageToBeLoaded();
        driver.findElement(By.linkText(text)).click();
    }

    public void ImagestoCheck(){
        List<WebElement> list = driver.findElements(By.tagName("img"));
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
                e.printStackTrace();
            }
        }
    }

    public void getMessage(By selector){
        driver.findElement(selector).getText();
    }
}
