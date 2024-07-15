import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebForm {
    WebDriver driver;
    List<WebElement> infos;
    WebDriverWait wait;
    @BeforeAll
    public void setUp()
    {
       System.setProperty("webdriver.gecko.driver","/Users/faria/Downloads/geckodriver");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
        //  driver = new SafariDriver();
        driver.manage().window().maximize();




    }
    @Test
    public void openUrl() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");

    }
   @Test
   public void acceptCookies()
   {
       driver.findElement(By.id("onetrust-accept-btn-handler")).sendKeys(Keys.ENTER);

   }

   @Test
   public void testNameField()
   {
      WebElement  name = driver.findElement(By.id("edit-name"));
       name.sendKeys("Faria Hasan");

   }
    @Test
    public void testNumberField()
    {       WebElement  number = driver.findElement(By.id("edit-number"));
        number.sendKeys("01572173764");
    }
    @Test
    public void testDateField()
    {      WebElement  date = driver.findElement(By.id("edit-date"));
        date.sendKeys(Keys.ENTER);
        date.sendKeys("15");
        date.sendKeys("07");
        date.sendKeys("2024");

    }
    @Test
    public void testEmailField() {

        WebElement  email = driver.findElement(By.id("edit-email"));
        email.sendKeys("faria@gmail.com");
        Utils.ScrollDown(driver,700);
    }
    //@Test
    public void scrollDown()
    {
        Utils.ScrollDown(driver,700);
    }
    @Test
    public void testTextAreaField()
    {       WebElement  textbox = driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-"));
        textbox.sendKeys("Hi I am Faria. I am learning Junit.");
    }



    @Test
    public void uploadFile()
    {
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/sampleImage.png");
         wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.name("uploadocument_remove_button")));


    }

    @Test
    public void testCheckBox()
    {   wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("edit-age")));
        WebElement we = driver.findElement(By.id("edit-age"));
        we.click();
    }
    @Test
    public void submitFile()
    { wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("edit-submit")));
        driver.findElement(By.id("edit-submit")).sendKeys(Keys.ENTER);
    }

    @Test
     public void nextPage() {
         wait.until(ExpectedConditions.urlContains("https://www.digitalunite.com/node/5932/webform/confirmation"));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Thank you for your submission!']")));
     }

     @Test
     public void SuccessMessage()
     {
        String message = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your submission!']")).getText();
        Assertions.assertEquals(message,"Thank you for your submission!");
    }



//@AfterAll

    public void browserClose()
    {

        driver.quit();
    }


}
