import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static driver.WebDriverCreator.createWebDriver;

public class IngredientsTest {
    private WebDriver driver;
    @Before
    public void setUp () {
        driver = new ChromeDriver();
        //driver = createWebDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    public void bunBlockTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Булки", objHomePageStellarBurgers.findBunBlock());
    }

    @Test
    public void sauceBlockTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Соусы", objHomePageStellarBurgers.findSauceBlock());
    }

    @Test
    public void fillingBlockTest () {
        HomePageStellarBurgers objHomePageStellarBurgers = new HomePageStellarBurgers(driver);

        Assert.assertEquals("Начинки", objHomePageStellarBurgers.findFillingBlock());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
