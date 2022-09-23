import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;


public class SeleniumWebSignupTest {
    //Import the Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium demo page URL (https//selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1: Verify the user input the right url and his on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        // 3.Maximize the browser
        driver.manage().window().maximize();
        // 4.Click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(6000);
    }



    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        // 5. Input your username on the username field
        // Test7. Verify that user is successfully signed up when valid details are inputted.
        driver.findElement(By.id("user_username")).sendKeys("aminat019");
        // 6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("aminat019@testify.com");
        // 7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("odunayo");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //Test8. Verify that User1 item is present on the item list page.
        String expectedUrl = "/users.";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("User1 item present");
        else
            //Fail
            System.out.println("User1 item not present");
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickUser1item() throws InterruptedException {
        // 9. Click on user1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        // 10.Search for an item [12345using python with Selenium] and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();
        //Test9. Verify that User1 item is present on the item list page.
        String expectedUrl = "/users/1";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct user1Page");
        else
            //Fail
            System.out.println("Wrong user1Page");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void logoutSuccessfully() {
        // 11. click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct user1Page");
        else
            //Fail
            System.out.println("Wrong user1Page");
    }

    @Test (priority = 4)
    public void emptyFieldsSignup() throws InterruptedException {
        // 4.Click on signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(6000);
        // Test6. Verify user cannot signup with either/all of the fields blank
        // 5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ami");
        // 6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        // 7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void negativeSignup() throws InterruptedException {
        //to refresh the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        // 5. Input your username on the username field
        // Test3. Verify that user cannot signup with username less than 3 characters
        driver.findElement(By.id("user_username")).sendKeys("am");
        // 6. Input an email address on the email field
        //Test4. Verify user cannot signup with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("aminat002.com");
        // 7. Input your password on the password field
        //Test5. Verify user cannot login with password less than or equal to one character
        driver.findElement(By.id("user_password")).sendKeys("o");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}
