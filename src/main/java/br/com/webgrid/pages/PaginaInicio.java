package br.com.webgrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {

    private static final String MENU_MY_ACCOUNT_CSS = "#li_myaccount > a";

    private static final String MENU_LOGIN_BUTTON_CSS = "#li_myaccount > ul > li:nth-child(1) > a";

    private static final String LOGIN_BUTTON_CLASS = "login";

    @FindBy(how = How.CSS, using = MENU_MY_ACCOUNT_CSS)
    private WebElement botaoMyAccount;

    @FindBy(how = How.CSS, using = MENU_LOGIN_BUTTON_CSS)
    private WebElement botaoLogin;

    private WebDriver driver;

    public PaginaInicio(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get("https://www.phptravels.net");
        driver.manage().window().maximize();
    }

    public PaginaLoginUser irParaPaginaLogin() {
        botaoMyAccount.click();
        botaoLogin.click();
        return new PaginaLoginUser(driver);
    }
}
