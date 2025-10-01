package ru.itmo.JavaAdvanced.lesson2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureConverterService {

    private final CelsiusConverter celsiusConverter;
    private final FahrenheitConverter fahrenheitConverter;
    private final KelvinConverter kelvinConverter;
    private final UniversalConverter universalConverter;

    public void demonstrate() {
        System.out.println("\n=== Temperature Converter Demo ===\n");

        demonstrateSpecificConverters();
        demonstrateUniversalConverter();

        System.out.println("========= The end =========");
    }

    private void demonstrateSpecificConverters() {
        System.out.println("1. Specific Converters:");
        System.out.printf("   0°C = %.2f°F (CelsiusConverter)%n", celsiusConverter.celsiusToFahrenheit(0));
        System.out.printf("   100°C = %.2fK (CelsiusConverter)%n", celsiusConverter.celsiusToKelvin(100));
        System.out.printf("   32°F = %.2f°C (FahrenheitConverter)%n", fahrenheitConverter.fahrenheitToCelsius(32));
        System.out.printf("   212°F = %.2fK (FahrenheitConverter)%n", fahrenheitConverter.fahrenheitToKelvin(212));
        System.out.printf("   273.15K = %.2f°C (KelvinConverter)%n", kelvinConverter.kelvinToCelsius(273.15));
        System.out.printf("   373.15K = %.2f°F (KelvinConverter)%n", kelvinConverter.kelvinToFahrenheit(373.15));
        System.out.println();
    }

    private void demonstrateUniversalConverter() {
        System.out.println("2. Universal Converter:");
        demonstrateConversion(100, "C", "F");
        demonstrateConversion(0, "C", "K");
        demonstrateConversion(32, "F", "C");
        demonstrateConversion(212, "F", "K");
        demonstrateConversion(273.15, "K", "C");
        demonstrateConversion(373.15, "K", "F");
        System.out.println();
    }

    private void demonstrateConversion(double value, String from, String to) {
        double result = universalConverter.universalConverter(value, from, to);
        System.out.printf("   %.2f° %s = %.2f° %s%n", value, from, result, to);
    }
}
