package ru.itmo.JavaAdvanced.lesson3.service;

public interface FibonacciService {
    long calculateFibonacci(int n);
    void clearFibonacciCache();
    java.util.Map<Integer, Long> getFibonacciCacheContent();
}
