package br.com.webgrid.apiconversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorTemperatura {

    private final static Integer SCALE = 6;
    private static Double valor = null;

    public static Double aplicarSacala(Double valor){
        BigDecimal bd = new BigDecimal(valor).setScale(SCALE, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }

    public static String celsiusParaFahrenheit(String celsius){
        valor = Double.parseDouble(celsius);
        return String.valueOf(aplicarSacala(1.8 * valor + 32.0));
    }

    public static String fahrenheitParaCelsius(String fahrenheit){
        valor = Double.parseDouble(fahrenheit);
        return String.valueOf(aplicarSacala(5.0 * (valor - 32.0) /9.0));
    }
}
