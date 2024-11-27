import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import user.UserClient;

public class RegistrationWithWrongPasswordTest {
    private UserClient userClient;
    private String token;

    private WebDriver driver;
    @Before
    public void setUp () {
        driver = new ChromeDriver();
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
