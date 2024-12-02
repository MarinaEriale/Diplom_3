import io.qameta.allure.junit4.DisplayName;
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

import static driver.WebDriverCreator.createWebDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class HomePageStellarBurgersTest extends RootTest{

    private UserClient userClient;
    private String token;

    private WebDriver driver;
    @Before
    public void setUp () {
        //driver = new ChromeDriver();
        driver = createWebDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");
    }



    @Test
    @DisplayName("Implementation of register process with correct user data and check that user gets wright result")
    public void registrationProcessTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Войти", objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222"));
    }



    @Test
    @DisplayName("Implementation of login process and check that user gets to wright page")
    public void loginThroughEnterAccButtonTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughEnterAccButton("test222222@test.com", "222222"));

    }

    @Test
    @DisplayName("Implementation of login process through personal account button and check that user gets to wright page")
    public void loginThroughPersonalAccButtonTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughPersonalAccButton("test222222@test.com", "222222"));
    }


    @Test
    @DisplayName("Implementation of login process through register form and check that user gets to wright page")
    public void loginThroughRegisterFormTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughRegisterForm("test222222@test.com", "222222"));
    }

    @Test
    @DisplayName("Implementation of login process through password restore form and check that user gets to wright page")
    public void loginThroughPasswordRestoreFormTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Оформить заказ", objHomePageStellarBurgers.loginThroughPasswordRestoreForm("test222222@test.com", "222222"));
    }


    @Test
    @DisplayName("Check that user can enter personal account page")
    public void personalAccEnterTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Профиль", objHomePageStellarBurgers.personalAccEnter("test222222@test.com", "222222"));
    }

    @Test
    @DisplayName("Check that user can open Constructor page from personal account using Constructor button")
    public void transferToConstructorTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Соберите бургер", objHomePageStellarBurgers.transferToConstructor("test222222@test.com", "222222"));
    }

    @Test
    @DisplayName("Check that user can open Home page from personal account using Logo button")
    public void transferToHomePageTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Соберите бургер", objHomePageStellarBurgers.transferToHomePage("test222222@test.com", "222222"));
    }

    @Test
    @DisplayName("Check that user can log off from personal account using LogOff button")
    public void exitFromPersonalAccTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        objHomePageStellarBurgers.registrationProcess("Testovy_2", "test222222@test.com", "222222");

        Assert.assertEquals("Войти", objHomePageStellarBurgers.exitFromPersonalAcc("test222222@test.com", "222222"));
    }



    @After
    public void tearDown() {
        driver.quit();
        //RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
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