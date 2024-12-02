import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;

public class IngredientsTest {
    private WebDriver driver;
    @Before
    public void setUp () {
        //driver = new ChromeDriver();
        driver = createWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    @DisplayName("Click of Bun button and check that Bun block became active")
    public void bunBlockTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        String classValue = objHomePageStellarBurgers.findBunBlock();
        System.out.println(classValue);
        assertTrue(classValue.contains("current"));
    }

    @Test
    @DisplayName("Click of Sauce button and check that Sauce block became active")
    public void sauceBlockTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        String classValue = objHomePageStellarBurgers.findSauceBlock();
        System.out.println(classValue);
        assertTrue(classValue.contains("current"));
    }

    @Test
    @DisplayName("Click of Filling button and check that Filling block became active")
    public void fillingBlockTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);
        String classValue = objHomePageStellarBurgers.findFillingBlock();
        System.out.println(classValue);
        assertTrue(classValue.contains("current"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
