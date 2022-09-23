import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JumiaSignInTest {
    //Import the Selenium WebDriver
    private WebDriver driver;

    @Test
    public void start() {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
    }

    @Test (priority = 0)
    public void url () throws InterruptedException {
        //2. Input your Jumia demo page URL (https://www.jumia.com.ng)
        driver.get("https://www.jumia.com.ng");
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng"))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void maximize () {
        // 3.Maximize the browser
        driver.manage().window().maximize();

    }

    @Test (priority =2 )
    public void Title () throws InterruptedException {
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
    }

    @Test (priority =3)
    public void Signin () throws InterruptedException {
        // 4.Click on account button to display the login button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

        //5. Click on the login button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        Thread.sleep(5000);

        //6.Input your email address
        driver.findElement(By.id("fi-email")).sendKeys("kem@testify.com");

        //7. Input your password
        driver.findElement(By.id("fi-password")).sendKeys("Odun123");

        //8. Click on the Sign in/login/Continue button
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void  account ()  {

        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
    }

    @Test (priority = 5)
    public void logout () {
        //9. Logout from the account
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
        String expectedUrl = "https://www.jumia.com.ng";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");
    }

    @AfterTest
    public void closeBrowser() {
        //10. Quit the browser
        driver.quit();
    }
}
