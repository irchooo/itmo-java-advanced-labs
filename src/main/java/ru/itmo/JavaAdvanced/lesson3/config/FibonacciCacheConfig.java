package ru.itmo.JavaAdvanced.lesson3.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class FibonacciCacheConfig {
    private Cache cache = new Cache();
    private String exitCommand = "exit";

    @Getter
    @Setter
    public static class Cache {
        private int maxSize = 13;
    }
}
