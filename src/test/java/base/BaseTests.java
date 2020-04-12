package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.PageObjectManager;

public class BaseTests {
    private WebDriver driver;
    public PageObjectManager pages;


    @BeforeClass
    public void SetUp(){
        //System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/broken_images");
        driver.manage().window().maximize();
        pages = new PageObjectManager(driver);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
