package ru.itmo.JavaAdvanced.lesson3.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itmo.JavaAdvanced.lesson3.config.FibonacciCache;
import ru.itmo.JavaAdvanced.lesson3.service.FibonacciService;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class FibonacciServiceImpl implements FibonacciService {
    private final FibonacciCache cache;

    @Override
    public long calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative :)");
        }

        if (cache.contains(n)) {
            log.debug("Cache hit for n = {}", n);
            return cache.get(n);
        }

        //для базовых случаев
        if (n == 0) {
            cache.put(0, 0L);
            return 0;
        }

        if (n == 1) {
            cache.put(1, 1L);
            return 1;
        }

        long result;
        int closestCached = findClosestCached(n);

        if (closestCached >= 0) {
            log.debug("Calculating from cached value n = {}", closestCached);
            result = calculateFromCache(n, closestCached);
        } else {
            result = calculateStandard(n);
        }

        cache.put(n, result);
        return result;
    }

    private int findClosestCached(int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (cache.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private long calculateFromCache(int n, int startFrom) {
        long a = cache.get(startFrom);
        long b;

        if (cache.contains(startFrom + 1)) {
            b = cache.get(startFrom + 1);
        } else {
            b = calculateStandard(startFrom + 1);
            cache.put(startFrom + 1, b);
        }

        for (int i = startFrom + 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
            cache.put(i, b);
        }

        return b;
    }

    private long calculateStandard(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }

        return b;
    }

    @Override
    public void clearFibonacciCache() {

    }

    @Override
    public Map<Integer, Long> getFibonacciCacheContent() {
        return cache.getAll();
    }
}
