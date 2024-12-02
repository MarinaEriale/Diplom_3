import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageStellarBurgers {
    private WebDriver driver;

    private String name;
    private String email;
    private String password;
    private String wrongPassword;

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


    private final By bunButton = By.xpath(".//span[text() = 'Булки']");
    private final By bunButtonContainer = By.xpath(".//span[text() = 'Булки']/parent::div");
    private final By sauceButton = By.xpath(".//span[text() = 'Соусы']");
    private final By sauceButtonContainer = By.xpath(".//span[text() = 'Соусы']/parent::div");
    private final By fillingButton = By.xpath(".//span[text() = 'Начинки']");
    private final By fillingTitleContainer = By.xpath(".//span[text() = 'Начинки']/parent::div");

    private final By passwordError = By.xpath((".//p[text()='Некорректный пароль']"));


    public HomePageStellarBurgers (WebDriver driver){
        this.driver = driver;
    }


    @Step("looking for Bun block and getting attribute data of Bun button")
    public String findBunBlock () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sauceButton));
        driver.findElement(sauceButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunButton));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(bunTitle));
        return driver.findElement(bunButtonContainer).getAttribute("class");
    }

    @Step("looking for Sauce block and getting attribute data of Sauce button")
    public String findSauceBlock () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(sauceButton));
        driver.findElement(sauceButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(sauceTitle));
        return driver.findElement(sauceButtonContainer).getAttribute("class");
    }

    @Step("looking for Filling block and getting attribute data of Filling button")
    public String findFillingBlock () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(fillingTitle));
        return driver.findElement(fillingTitleContainer).getAttribute("class");
    }

    @Step("Looking for enter account button and clicking it")
    public void enterAccountButtonClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterAccButton));
        driver.findElement(enterAccButton).click();
    }

    @Step("Filling of the registration form")
    public void registrationFormFilling (String name, String email, String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(nameInput));
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys(name);

        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);

        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
    }


    @Step("The whole registration process")
    public String registrationProcess (String name, String email, String password) {

        enterAccountButtonClick();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();

        registrationFormFilling(name, email, password);

        driver.findElement(registerButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterButton));

        return driver.findElement(enterButton).getText();
    }

    @Step("The whole registration process with wrong password")
    public String registrationWithWrongPassword (String name, String email, String password) {
        enterAccountButtonClick();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();

        registrationFormFilling(name, email, password);

        driver.findElement(registerButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(passwordError));

        return driver.findElement(passwordError).getText();

    }

    @Step("Process of login of existing user")
    public void loginProcess (String email, String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterEmailInput));
        driver.findElement(enterEmailInput).click();
        driver.findElement(enterEmailInput).sendKeys(email);

        driver.findElement(enterPasswordInput).click();
        driver.findElement(enterPasswordInput).sendKeys(password);

        driver.findElement(enterButton).click();
    }

    @Step("Process of login of existing user using enter account button")
    public String loginThroughEnterAccButton (String email, String password) {
        enterAccountButtonClick();

        loginProcess(email, password);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    @Step("Process of login of existing user using enter personal account button")
    public String loginThroughPersonalAccButton (String email, String password) {
        enterAccountButtonClick();

        loginProcess(email, password);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    @Step("Process of login of existing user using register form")
    public String loginThroughRegisterForm (String email, String password) {
        enterAccountButtonClick();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();

        driver.findElement(enterLink).click();

        loginProcess(email, password);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    @Step("Process of login of existing user using password restore form")
    public String loginThroughPasswordRestoreForm (String email, String password) {
        enterAccountButtonClick();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(passwordRestore));
        driver.findElement(passwordRestore).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(restoreEnterButton));
        driver.findElement(restoreEnterButton).click();

        loginProcess(email, password);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).getText();
    }

    @Step("Login and transfer to personal account")
    public String personalAccEnter (String email, String password) {
        enterAccountButtonClick();
        loginProcess(email, password);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(personalAcc));
        driver.findElement(personalAcc).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(profileLink));
        return driver.findElement(profileLink).getText();
    }

    @Step("Transfer to constructor using Constructor button")
    public String transferToConstructor (String email, String password) {
        personalAccEnter(email, password);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(constructorTitle));
        return driver.findElement(constructorTitle).getText();
    }

    @Step("Transfer to constructor using Logo button")
    public String transferToHomePage (String email, String password) {
        personalAccEnter(email, password);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(logoButton));
        driver.findElement(logoButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(constructorTitle));
        return driver.findElement(constructorTitle).getText();
    }
    @Step("Log off of user")
    public String exitFromPersonalAcc (String email, String password) {
        personalAccEnter(email, password);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(enterButton));

        return driver.findElement(enterButton).getText();
    }
}
