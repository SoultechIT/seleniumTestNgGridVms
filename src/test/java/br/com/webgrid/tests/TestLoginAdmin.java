package br.com.webgrid.tests;

import br.com.webgrid.config.TipoDriver;
import br.com.webgrid.pages.PaginaLoginAdmin;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLoginAdmin {

    WebDriver driver;

    @BeforeClass
    public void iniciarDriver(){
        TipoDriver driverSelecionado = TipoDriver.FIREFOX;

        DesiredCapabilities desiredCapabilities = driverSelecionado.obterCapacidadesDesejadas();

        driver = driverSelecionado.obterObjetoWebDriverRemoto(desiredCapabilities, Platform.LINUX, "http://192.168.0.29:1921/wd/hub");

        /**
         * driver =
         * selecionadoTipoDriver.obterObjetoWebDriver(capacidadesDesejadas);
         */
    }

    @AfterClass
    public void fecharDriver(){
        if(driver !=null){
            driver.quit();
        }
    }

    @Parameters({"email", "invalidPassword"})
    @Test
    public void testeLoginAdminInvalido(String email, String password) throws InterruptedException {
        PaginaLoginAdmin paginaLoginAdmin = new PaginaLoginAdmin(driver);

        paginaLoginAdmin.preencherEmail(email);
        paginaLoginAdmin.preencherPassword(password);
        paginaLoginAdmin.pressLogin();

        Thread.sleep(1000);

        String message = paginaLoginAdmin.validateLoginMessage().getText();

        Assert.assertEquals(message, "Invalid Login Credentials");
    }
}
