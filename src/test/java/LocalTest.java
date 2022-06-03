import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LocalTest {
    private LogIn logIn = null;
    public ChromeDriver driver;

    @BeforeEach
    public void SetUp() {
        logIn = new LogIn();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        //options.addArguments("--remote-debugging-port=9222"); //debug mód
        //options.addArguments("user-data-dir=src/main/resources/user-data"); //saját user-datás loging
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    //Nem működő Google login (biztonsági okok miatt)
    @Test
    @Disabled
    public void TestLogin() {
        String email = logIn.getEmail();
        String password = logIn.getPassword();
        driver.navigate().to("https://www.youtube.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@aria-label=\"Bejelentkezés\"]"));
        loginBtn.click();
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        emailInput.sendKeys(email);
        WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
        nextBtn.click();
        WebElement pwInput = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pwInput.sendKeys(password);
    }

        @Test
        public void PlayListTest() {
            driver.navigate().to("https://www.youtube.com/watch?v=4GMpo4kePP0");
            // Videó mentése gomb
            WebElement findAddListButton = driver.findElement(By.xpath("//*[@id=\"top-level-buttons-computed\"]/ytd-button-renderer[3]/a"));
            findAddListButton.click();
            // Felugró ablak első checkbox
            WebElement findFirstCheckbox = driver.findElement(By.xpath("//*[@id=\"checkboxContainer\"]"));
            findFirstCheckbox.click();
            // Lista létrehozása (+ gomb)
            WebElement findPlusButton = driver.findElement(By.xpath("//*[@id=\"content-icon\"]/yt-icon"));
            findPlusButton.click();
            // Lista neve
            WebElement findNameField = driver.findElement(By.xpath("//*[@id=\"input-2\"]/input"));
            findNameField.sendKeys("Testlist");
            //TODO Láthatóság legördülő lista nyíl xpath
            //WebElement findArrow = driver.findElement(By.xpath("//*[@id=\"privacy-input\"]"));
            //findArrow.click();
            //TODO Nem listázott kiválasztása xpath
            //WebElement findNotListed = driver.findElement(By.xpath("//*[@id=\"entries\"]/ytd-privacy-dropdown-item-renderer[2]"));
            //findNotListed.click();
            // Létrehozó gomb
            WebElement findCreateButton = driver.findElement(By.xpath("//*[@id=\"actions\"]/ytd-button-renderer/a"));
            findCreateButton.click();
            // Lista elérése
            // Három vízszintes vonal a bal felső sarokban
            WebElement findThreeLines = driver.findElement(By.xpath("//*[@id=\"guide-button\"]"));
            findThreeLines.click();
            // Testlist kiválasztása
            WebElement findTestList = driver.findElement(By.xpath("//*[@id=\"section-items\"]/ytd-guide-entry-renderer[4]"));
            findTestList.click();
            //TODO A listában szereplő első videó törlése
            // A videó címe mellett megjelenő három pont xpath
            //WebElement findThreeDot = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[3]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-playlist-video-list-renderer/div[3]/ytd-playlist-video-renderer/div[3]/ytd-menu-renderer/yt-icon-button/button"));
            //findThreeDot.click();
            //TODO Törlés kiválasztása xpath
            //WebElement findDelete = driver.findElement(By.xpath("//*[@id=\"items\"]/ytd-menu-service-item-renderer[4]/tp-yt-paper-item"));
            //findDelete.click();
    }

}
