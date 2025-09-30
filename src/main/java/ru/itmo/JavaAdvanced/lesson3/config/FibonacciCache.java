package ru.itmo.JavaAdvanced.lesson3.config;

import lombok.Getter;
import org.springframework.stereotype.Component;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Getter
public class FibonacciCache {
    private final Map<Integer, Long> fibonacciCacheMap;

    public FibonacciCache(int maxSize) {
        this.fibonacciCacheMap = new LinkedHashMap<>(maxSize, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Long> eldest) {
                return size() > maxSize;
            }
        };
    }

    public void put(int n, long value) {
        fibonacciCacheMap.put(n, value);
    }

    public Long get(int n) {
        return fibonacciCacheMap.get(n);
    }

    public boolean contains(int n) {
        return fibonacciCacheMap.containsKey(n);
    }

    public Map<Integer, Long> getAll() {
        return new LinkedHashMap<>(fibonacciCacheMap);
    }
}
