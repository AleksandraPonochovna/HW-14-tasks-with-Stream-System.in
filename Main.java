package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.readOrProcessing();
    }

    private static Comparator<Map.Entry<String, Long>> comparatorForAlphabet() {
        return (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
    }

    public void readOrProcessing() {
        Scanner scn = new Scanner(System.in, "UTF-8");
        String[] strings = scn.nextLine().split("[\\p{Punct}\\s]+");
        Arrays.stream(strings)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(comparatorForAlphabet())
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
