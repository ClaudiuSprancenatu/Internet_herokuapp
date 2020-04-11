package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    private WebDriver driver;

    @BeforeClass
    public void SetUp(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
