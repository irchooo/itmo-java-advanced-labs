package ru.itmo.JavaAdvanced.lesson2.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.JavaAdvanced.lesson2.service.TemperatureConverterService;

@Component
@RequiredArgsConstructor
public class TemperatureConverterRunner implements CommandLineRunner {

    private final TemperatureConverterService demoService;

    @Override
    public void run(String... args) throws Exception {
        demoService.demonstrate();
    }
}
