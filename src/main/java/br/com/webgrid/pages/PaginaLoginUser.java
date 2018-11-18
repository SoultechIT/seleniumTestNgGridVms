package br.com.webgrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaLoginUser {

    private static final String EMAIL_CSS = "#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > div > div:nth-child(1) > input";
    private static final String EMAIL_NAME = "username";
    private static final String PASSWORD_CSS = "#loginfrm > div.panel.panel-default > div.wow.fadeIn.animated > div > div:nth-child(2) > input";
    private static final String PASSWORD_NAME = "password";
    private static final String LOGIN_BUTTON_CSS = "#loginfrm > button";
    private static final String LOGIN_RESULT_MESSAGE_CSS = "#loginfrm > div.panel.panel-default > div.resultlogin > div";
    private static final String PAGE_URL = "https://www.phptravels.net/login";

    @FindBy(how = How.CSS, using = EMAIL_CSS)
    private WebElement email;

    @FindBy(how = How.CSS, using = PASSWORD_CSS)
    private WebElement password;

    @FindBy(how = How.CSS, using = LOGIN_BUTTON_CSS)
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = LOGIN_RESULT_MESSAGE_CSS)
    private WebElement loginMessage;

    private WebDriver driver;

    public PaginaLoginUser(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.driver.get(PAGE_URL);
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
