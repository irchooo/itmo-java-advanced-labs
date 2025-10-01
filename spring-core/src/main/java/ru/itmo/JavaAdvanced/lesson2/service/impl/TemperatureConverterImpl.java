package ru.itmo.JavaAdvanced.lesson2.service.impl;

import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer;
import org.springframework.stereotype.Component;
import ru.itmo.JavaAdvanced.lesson2.service.CelsiusConverter;
import ru.itmo.JavaAdvanced.lesson2.service.FahrenheitConverter;
import ru.itmo.JavaAdvanced.lesson2.service.KelvinConverter;
import ru.itmo.JavaAdvanced.lesson2.service.UniversalConverter;

@Component
public class TemperatureConverterImpl implements
                                                CelsiusConverter,
                                                FahrenheitConverter,
                                                KelvinConverter,
                                                UniversalConverter {

    //CelsiusConverter realisation
    @Override
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    @Override
    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    //FahrenheitConverter realisation
    @Override
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    @Override
    public double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    //KelvinConverter realisation
    @Override
    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    @Override
    public double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    //UniversalConverter realisation (Adapter pattern)
    @Override
    public double universalConverter(double value, String from, String to) {
        if (from.equalsIgnoreCase(to)) {
            return value;
        }

        double celsius;
            switch (from.toUpperCase()) {
                case "C": case "CELSIUS": celsius = value;
                break;
                case "F": case "FAHRENHEIT": celsius = fahrenheitToCelsius(value);
                break;
                case "K": case "KELVIN": celsius = kelvinToCelsius(value);
                break;
                default: throw new IllegalArgumentException("Unknown system: " + from);
            }

            switch (to.toUpperCase()) {
                case "C": case "CELSIUS": return celsius;
                case "F": case "FAHRENHEIT": return celsiusToFahrenheit(celsius);
                case "K": case "KELVIN": return celsiusToKelvin(celsius);
                default: throw new IllegalArgumentException("Unknown system: " + to);
            }
    }
}
