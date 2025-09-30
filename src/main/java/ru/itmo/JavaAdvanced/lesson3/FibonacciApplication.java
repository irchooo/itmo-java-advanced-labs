package ru.itmo.JavaAdvanced.lesson3;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.itmo.JavaAdvanced.lesson3.config.FibonacciCache;
import ru.itmo.JavaAdvanced.lesson3.config.FibonacciCacheConfig;

@SpringBootApplication
@EnableConfigurationProperties(FibonacciCacheConfig.class)
public class FibonacciApplication {

    public static void main(String[] args) {
        SpringApplication.run(FibonacciApplication.class, args);
    }

    @Bean
    public FibonacciCache fibonacciCache(FibonacciCacheConfig config) {
        return new FibonacciCache(config.getCache().getMaxSize());
    }

    @Bean
    public String exitCommand(FibonacciCacheConfig config) {
        return config.getExitCommand();
    }
}
