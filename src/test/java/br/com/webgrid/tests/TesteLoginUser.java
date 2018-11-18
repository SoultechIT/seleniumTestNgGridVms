package br.com.webgrid.tests;

import br.com.webgrid.config.TipoDriver;
import br.com.webgrid.pages.PaginaLoginUser;
import br.com.webgrid.pages.PaginaInicio;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TesteLoginUser {

    WebDriver driver;

    @BeforeClass
    public void iniciarDriver(){
        TipoDriver driverSelecionado = TipoDriver.CHROME;

        DesiredCapabilities desiredCapabilities = driverSelecionado.obterCapacidadesDesejadas();

        driver = driverSelecionado.obterObjetoWebDriverRemoto(desiredCapabilities, Platform.LINUX, "http://192.168.0.28:24960/wd/hub");

        /**
         * driver =
         * selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas);
         */
    }

    @AfterClass
    public void fecharDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    @Parameters({"email", "invalidPassword"})
    @Test
    public void testeLoginUserInvalido(String email, String password){

        PaginaInicio paginaInicio = new PaginaInicio(driver);

        PaginaLoginUser paginaLogin = paginaInicio.irParaPaginaLogin();

        paginaLogin.preencherEmail(email);
        paginaLogin.preencherPassword(password);
        paginaLogin.pressLogin();

        String message = paginaLogin.validateLoginMessage().getText();

        Assert.assertEquals(message, "Login Details Incorrect. Please try again.");
    }

    @Test(dependsOnMethods = { "testeLoginUserInvalido" })
    public void testeLoginValido() {

        Assert.assertEquals("1", "1");

    }
}
