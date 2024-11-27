import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import user.UserClient;

import static driver.WebDriverCreator.createWebDriver;

public class RegistrationWithWrongPasswordTest {

    private WebDriver driver;
    @Before
    public void setUp () {
        driver = new ChromeDriver();
        //driver = createWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    public void registrationWithWrongPassword () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Некорректный пароль", objHomePageStellarBurgers.registrationWithWrongPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
