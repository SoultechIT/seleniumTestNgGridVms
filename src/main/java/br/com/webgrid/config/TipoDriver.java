package br.com.webgrid.config;

import br.com.webgrid.config.DriverStart;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

public enum TipoDriver implements DriverStart {

    FIREFOX {
        @Override
        public DesiredCapabilities obterCapacidadesDesejadas() {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
            return desiredCapabilities;
        }

        @Override
        public WebDriver obterObjetoWebDriver(DesiredCapabilities desiredCapabilities) {
            return new FirefoxDriver(desiredCapabilities);
        }

        @Override
        public WebDriver obterObjetoWebDriverRemoto(DesiredCapabilities desiredCapabilities, Platform platform, String enderecoRemoto) {
            desiredCapabilities.setPlatform(platform);

            WebDriver driver = null;
            try{
                driver = new RemoteWebDriver(new URL(enderecoRemoto), desiredCapabilities);
            } catch (MalformedURLException e){
                e.printStackTrace();
            }

            return driver;
        }
    },

    CHROME {
        @Override
        public DesiredCapabilities obterCapacidadesDesejadas() {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check", "--kiosk"));

            HashMap<String,String> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            desiredCapabilities.setCapability("chrome.prefs", chromePreferences);

            return desiredCapabilities;
        }

        @Override
        public WebDriver obterObjetoWebDriver(DesiredCapabilities desiredCapabilities) {
            return new ChromeDriver(desiredCapabilities);
        }

        @Override
        public WebDriver obterObjetoWebDriverRemoto(DesiredCapabilities desiredCapabilities, Platform platform, String enderecoRemoto) {
            desiredCapabilities.setPlatform(platform);

            WebDriver driver = null;
            try{
                driver = new RemoteWebDriver(new URL(enderecoRemoto), desiredCapabilities);
            } catch (MalformedURLException e){
                e.printStackTrace();
            }

            return driver;
        }
    }
    ;



}
