import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;



public class TextBoxDemoQA {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","C:/WebDrivers/chromedriver.exe/");
       WebDriver driver = new ChromeDriver();

      // @Test
       driver.get("https://demoqa.com/text-box");

       driver.manage().window().maximize();

        //Find and fill in userName, Email, currentAddress, permanentAddress inputs
        driver.findElement(By.id("userName")).sendKeys("Anna");
        driver.findElement(By.id("userEmail")).sendKeys("anna@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Yerevan");
        driver.findElement(By.id("permanentAddress")).sendKeys("Yerevan, Armenia");

        //Waits
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // WebElement submitButton = (new WebDriverWait(driver, Duration.ofSeconds(5))
       //     .until(ExpectedConditions.presenceOfElementLocated(By.id("submit"))));
       // submitButton.click();


        //Scroll the Page
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        submitButton.click();

       // @AfterTest

        SoftAssert softAssert = new SoftAssert();

        boolean textBoxCreated = driver.findElement(By.id("output")).isEnabled();
        softAssert.assertTrue(textBoxCreated);
        System.out.println("Text Box is created");

        String nameInput = driver.findElement(By.id("userName")).getText();
        System.out.println("Username is" + nameInput);

        String emailInput = driver.findElement(By.id("userEmail")).getText();
        System.out.println("Email is" + emailInput);

        String currentAddress = driver.findElement(By.id("currentAddress")).getText();
        System.out.println("Current Address is" + currentAddress);

        String permanentAddress = driver.findElement(By.id("permanentAddress")).getText();
        System.out.println("Permanent Address is" + permanentAddress);

        String boxNameInput = driver.findElement(By.id("name")).getText();
        String boxEmailInput = driver.findElement(By.id("email")).getText();
        String boxCurrentAddress = driver.findElement(By.id("currentAddress")).getText();
        String boxPermanentAddress = driver.findElement(By.id("permanentAddress")).getText();

        softAssert.assertTrue(boxNameInput.contains(nameInput));
        softAssert.assertTrue(boxEmailInput.contains(emailInput));
        softAssert.assertTrue(boxCurrentAddress.contains(currentAddress));
        softAssert.assertTrue(boxPermanentAddress.contains(permanentAddress));



        //softAssert.assertAll();

        driver.quit();
    }
}
