import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import user.User;
import user.UserClient;
import user.UserToken;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class HomePageStellarBurgersTest {

    private UserClient userClient;
    private String token;

    private WebDriver driver;
    @Before
    public void setUp () {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

    }



    @Test
    public void registrationProcessTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Войти", objHomePageStellarBurgers.registrationProcess());
    }



    @Test
    public void loginThroughEnterAccButtonTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughEnterAccButton());

    }

    @Test
    public void loginThroughPersonalAccButtonTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughPersonalAccButton());
    }

    @Test
    public void loginThroughRegisterFormTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughRegisterForm());
    }
    @Test
    public void loginThroughPasswordRestoreFormTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughPasswordRestoreForm());
    }


    @Test
    public void personalAccEnterTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Профиль", objHomePageStellarBurgers.personalAccEnter());
    }

    @Test
    public void transferToConstructorTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Соберите бургер", objHomePageStellarBurgers.transferToConstructor());
    }

    @Test
    public void transferToHomePageTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Соберите бургер", objHomePageStellarBurgers.transferToHomePage());
    }

    @Test
    public void exitFromPersonalAccTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess();

        Assert.assertEquals("Войти", objHomePageStellarBurgers.exitFromPersonalAcc());
    }



    @After
    public void tearDown() {
        driver.quit();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        User user = new User("test222222@test.com", "222222");
        userClient = new UserClient();

        Response response = userClient.login(user);
        response.then().assertThat().statusCode(200)
                .and()
                .body("success", equalTo(true));

        token = response.as(UserToken.class).getAccessToken();
        userClient.delete(token);

    }

}