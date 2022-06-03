import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PublicTest {
    public ChromeDriver driver;

    @BeforeEach
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void SearchTest() throws InterruptedException {
        driver.navigate().to("https://www.youtube.com/");
        WebElement findContractAcceptButton = driver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div/div[6]/div[1]/ytd-button-renderer[2]/a/tp-yt-paper-button/yt-formatted-string"));
        findContractAcceptButton.click();
        try{
            Thread.sleep(2000);
        }catch (Exception e){}
        WebElement findSearchBox = driver.findElement(By.xpath("//*[@class=\"gsfi ytd-searchbox\"]"));
        findSearchBox.click();
        findSearchBox.sendKeys("neverending story alphaville");
        findSearchBox.sendKeys(Keys.ENTER);

    }
    @AfterAll
    public void Terminate(){
        driver.quit();
    }
}
