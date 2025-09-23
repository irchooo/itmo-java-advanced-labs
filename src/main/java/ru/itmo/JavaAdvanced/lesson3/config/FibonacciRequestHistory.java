package ru.itmo.JavaAdvanced.lesson3.config;

import lombok.Getter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class FibonacciRequestHistory {
    private final List<Integer> fibonacciRequests = new ArrayList<>();

    public void addRequest(int n) {
        fibonacciRequests.add(n);
    }

    public List<Integer> getFibonacciRequests() {
        return new ArrayList<>(fibonacciRequests);
    }
}
