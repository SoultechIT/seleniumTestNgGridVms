package br.com.webgrid.config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverStart {

    WebDriver obterObjetoWebDriver(DesiredCapabilities desiredCapabilities);

    WebDriver obterObjetoWebDriverRemoto(DesiredCapabilities desiredCapabilities,
                                         Platform platform, String enderecoRemoto);

    DesiredCapabilities obterCapacidadesDesejadas();
}
