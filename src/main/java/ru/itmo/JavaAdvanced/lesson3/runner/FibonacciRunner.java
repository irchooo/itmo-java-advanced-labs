package ru.itmo.JavaAdvanced.lesson3.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmo.JavaAdvanced.lesson3.config.FibonacciRequestHistory;
import ru.itmo.JavaAdvanced.lesson3.service.FibonacciService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
@Slf4j
public class FibonacciRunner implements CommandLineRunner {
    private final FibonacciService fibonacciService;
    private final FibonacciRequestHistory fibonacciRequestHistory;
    private final String exitCommand;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Fibonacci Calculator ===");
        System.out.println("Please enter numbers to calculate Fibonacci or '"
                + exitCommand + "' to exit");

        while (true) {
            System.out.print("Please enter your number: n = ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(exitCommand)) {
                break;
            }

            try {
                int n = Integer.parseInt(input);

                if (n < 0) {
                    System.out.println("Please enter non-negative number :)");
                    continue;
                }

                fibonacciRequestHistory.addRequest(n);
                long result = fibonacciService.calculateFibonacci(n);

                System.out.printf("F(%d) = %d%n", n, result);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or '"
                        + exitCommand + "' to exit");
            } catch (Exception e) {
                System.out.println("Oops! Error! " + e.getMessage());
                log.error("Oops! Calculation error", e);
            }
        }

        showStatistics();
        scanner.close();
    }

    private void showStatistics() {
        System.out.println("\n=== Session Summary ===");

        var history = fibonacciRequestHistory.getFibonacciRequests();
        var cache = fibonacciService.getFibonacciCacheContent();

        System.out.printf("Total requests: %d%n", history.size());
        System.out.printf("Cache size: %d%n", cache.size());

        if (!history.isEmpty()) {
            System.out.println("\nRequest history:");
            history.forEach(n -> System.out.printf(" F(%d)%n", n));
        }
    }
}
