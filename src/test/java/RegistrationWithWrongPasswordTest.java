import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import user.UserClient;

import static driver.WebDriverCreator.createWebDriver;

public class RegistrationWithWrongPasswordTest {

    private WebDriver driver;
    @Before
    public void setUp () {

        //driver = new ChromeDriver();
        driver = createWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    @DisplayName("Implementation of register process with incorrect user data and check that registration is impossible")
    public void registrationWithWrongPassword () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Некорректный пароль", objHomePageStellarBurgers.registrationWithWrongPassword("Testovy_2", "test222222@test.com", "222"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
