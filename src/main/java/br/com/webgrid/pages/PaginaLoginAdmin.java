package br.com.webgrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaLoginAdmin {

    private static final String EMAIL_CSS = "body > div > form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div:nth-child(1) > input:nth-child(2)";
    private static final String EMAIL_NAME = "username";

    private static final String PASSWORD_CSS = "body > div > form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div:nth-child(1) > input:nth-child(3)";
    private static final String PASSWORD_NAME = "password";

    private static final String LOGIN_BUTTON_CSS = "body > div > form.form-signin.form-horizontal.wow.fadeIn.animated.animated > button";

    private static final String LOGIN_RESULT_MESSAGE_CLASS_NAME = "alert";

    @FindBy(how = How.CSS, using = EMAIL_CSS)
    private WebElement email;

    @FindBy(how = How.CSS, using = PASSWORD_CSS)
    private WebElement password;

    @FindBy(how = How.CSS, using = LOGIN_BUTTON_CSS)
    private WebElement loginButton;

    @FindBy(how = How.CLASS_NAME, using = LOGIN_RESULT_MESSAGE_CLASS_NAME)
    private WebElement loginMessage;

    private WebDriver driver;

    public PaginaLoginAdmin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.driver.get("https://www.phptravels.net/admin");
        driver.manage().window().maximize();
    }

    public void preencherEmail(String valor){
        email.sendKeys(valor);
    }

    public void preencherPassword(String valor){
        password.sendKeys(valor);
    }

    public void pressLogin(){ loginButton.click(); }

    public WebElement validateLoginMessage(){ return loginMessage; }
}
