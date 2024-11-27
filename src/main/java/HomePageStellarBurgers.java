import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageStellarBurgers {
    private WebDriver driver;

    private final By enterAccButton = By.className("button_button__33qZ0");
    private final By registerLink = By.xpath(".//a[@href='/register']");
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::*");
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::*");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");

    private final By enterEmailInput = By.xpath(".//input[@name='name']");
    private final By enterPasswordInput = By.xpath(".//input[@name='Пароль']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    private final By personalAcc = By.xpath(".//a[@href='/account']");
    private final By enterLink = By.xpath(".//a[@href='/login']");
    private final By profileLink = By.xpath(".//a[text()='Профиль']");
    private final By passwordRestore = By.xpath(".//a[text()='Восстановить пароль']");
    private final By restoreEnterButton = By.xpath(".//a[@href='/login']");

    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By constructorTitle = By.xpath(".//h1[text()='Соберите бургер']");

    private final By exitButton = By.xpath(".//button[text()='Выход']");

    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    private final By bunTitle = By.xpath(".//h2[text() = 'Булки']");
    private final By sauceTitle = By.xpath(".//h2[text() = 'Соусы']");
    private final By fillingTitle = By.xpath(".//h2[text() = 'Начинки']");


    private final By sauceButton = By.xpath(".//span[text() = 'Соусы']");
    private final By fillingButton = By.xpath(".//span[text() = 'Начинки']");

    private final By passwordError = By.xpath((".//p[text()='Некорректный пароль']"));


    public HomePageStellarBurgers (WebDriver driver){
        this.driver = driver;
    }



    public String findBunBlock () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunTitle));
        return driver.findElement(bunTitle).getText();
    }

    public String findSauceBlock () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sauceButton));
        driver.findElement(sauceButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sauceTitle));
        return driver.findElement(sauceTitle).getText();
    }

    public String findFillingBlock () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(fillingTitle));
        return driver.findElement(fillingTitle).getText();
    }


    //Нахождение кнопки "Войти в аккаунт" и клик по ней
    public void enterAccountButtonClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterAccButton));
        driver.findElement(enterAccButton).click();
    }

    public String registrationProcess () {

        enterAccountButtonClick();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();

                new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(nameInput));
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys("Testovy_2");

        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys("test222222@test.com");

        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys("222222");

        driver.findElement(registerButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterButton));

        return driver.findElement(enterButton).getText();
    }

    public String registrationWithWrongPassword () {
        enterAccountButtonClick();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(nameInput));
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys("Testovy_2");

        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys("test222222@test.com");

        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys("222");

        driver.findElement(registerButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(passwordError));

        return driver.findElement(passwordError).getText();

    }

    public void loginProcess () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterEmailInput));
        driver.findElement(enterEmailInput).click();
        driver.findElement(enterEmailInput).sendKeys("test222222@test.com");

        driver.findElement(enterPasswordInput).click();
        driver.findElement(enterPasswordInput).sendKeys("222222");

        driver.findElement(enterButton).click();
    }

    public String loginThroughEnterAccButton () {
        enterAccountButtonClick();

        loginProcess();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    public String loginThroughPersonalAccButton () {
        enterAccountButtonClick();

        loginProcess();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    public String loginThroughRegisterForm () {
        enterAccountButtonClick();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();

        driver.findElement(enterLink).click();

        loginProcess();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    public String loginThroughPasswordRestoreForm () {
        enterAccountButtonClick();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(passwordRestore));
        driver.findElement(passwordRestore).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(restoreEnterButton));
        driver.findElement(restoreEnterButton).click();

        loginProcess();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    public String personalAccEnter () {
        enterAccountButtonClick();
        loginProcess();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(personalAcc));
        driver.findElement(personalAcc).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(profileLink));
        return driver.findElement(profileLink).getText();
    }

    public String transferToConstructor () {
        personalAccEnter();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(constructorTitle));
        return driver.findElement(constructorTitle).getText();
    }

    public String transferToHomePage () {
        personalAccEnter();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(logoButton));
        driver.findElement(logoButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(constructorTitle));
        return driver.findElement(constructorTitle).getText();
    }

    public String exitFromPersonalAcc () {
        personalAccEnter();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterButton));

        return driver.findElement(enterButton).getText();

    }













}
