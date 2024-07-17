package com.amsidh.mvc.repository;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountRepository {
    private static final Map<Integer, Integer> IN_MEMORY_MAP = IntStream.rangeClosed(1, 100)
            .boxed()
            .collect(Collectors.toConcurrentMap(Function.identity(), v -> 100));

    public static Integer getAccountBalance(Integer accountNumber) {
        return IN_MEMORY_MAP.get(accountNumber);
    }

    public static void withdrawMoney(Integer accountNumber, Integer withdrawAmount) {
        IN_MEMORY_MAP.computeIfPresent(accountNumber, (k, v) -> v - withdrawAmount);
    }

    public static Map<Integer, Integer> getAccounts() {
        return IN_MEMORY_MAP;
    }

}
