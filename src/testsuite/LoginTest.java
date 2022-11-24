package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on Sign in link
        driver.findElement(By.xpath("//div[@class='header__wrapper']//a[contains(text(),'Sign')]")).click();

        //Verify the text 'Welcome Back '
        String expectedMessage = "Welcome Back!";
        WebElement message = driver.findElement(By.xpath("//div[@class='sign-in__wrapper']//h1[contains(text(),'Welcome')]"));
        String actualMessage = message.getText();//converting webElement into string
        Assert.assertEquals(expectedMessage, actualMessage);//verifying using the assert method
    }

    @Test
    public void verifyTheErrorMessage() {
        //Click on Sign in link
        driver.findElement(By.xpath("//div[@class='header__wrapper']//a[contains(text(),'Sign')]")).click();

        //Find username and Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("abcd");

        //Enter invalid password in password field
        driver.findElement(By.id("user[password]")).sendKeys("abc123");

        //Click on Login button
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        //verify the error message
        String expectedMessage = "Invalid email or password.";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@id='notice']//ul[1]//li[1]"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Error message not found", actualMessage1, expectedMessage);

    }

    @After
    public void TearDown() {
        closeBrowser();
    }


}


