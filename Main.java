package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.readOrProcessing();
    }

    public void readOrProcessing() {
        Scanner scn = new Scanner(System.in, "UTF-8");
        String[] strings = scn.nextLine().split("[\\p{Punct}\\s]+");
        Arrays.stream(strings)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> new Comparator().compare(o1, o2))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
