package com.java8;

import java.util.*;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {

        //TODO : FILTER EVEN NUMBER

        List<Integer> list = Arrays.asList(1, 2, 4, 5, 3, 2, 1, 6, 5);
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        // TODO: MAX NUMBER
        list.stream().max(Integer::compare).ifPresent(max -> System.out.println("Max Number: " + max));
        // TODO: MIN NUMBER
        list.stream().min(Integer::compare).ifPresent(min -> System.out.println("Min Number: " + min));

        // TODO: COUNT
        long count = list.stream().count();
        System.out.println("Count: " + count);

        // TODO: SUM
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // TODO: AVERAGE
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + average);
       // TODO: THIRD LARGEST NUMBER
       list.stream().sorted((a, b) -> b - a).skip(2).findFirst().ifPresent(thirdLargest -> System.out.println("Third largest number: " + thirdLargest));
       // TODO: THIRD SMALLEST NUMBER
       list.stream().sorted().skip(2).findFirst().ifPresent(thirdSmallest -> System.out.println("Third smallest number: " + thirdSmallest));
        // TODO: FIND UNIQUE ELEMENTS
        Set<Integer> uniqueElements = new HashSet<>();
        list.stream().filter(n -> uniqueElements.add(n)).forEach(num -> System.out.print(num + " "));
        System.out.println();
        // TODO: DISTINCT
        System.out.print("Distinct: ");
        list.stream().distinct().forEach(num -> System.out.print(num + " "));
        System.out.println();

        // TODO: SORT
        System.out.print("Sorted Accending Order: ");
        list.stream().sorted().forEach(num -> System.out.print(num + " "));
        System.out.println();

        // TODO: SORT DESCENDING
        System.out.print("Sorted Descending Order: ");
        list.stream().sorted((a, b) -> b - a).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // TODO: LIMIT
        System.out.print("First 3 elements: ");
        list.stream().limit(3).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // TODO: SKIP
        System.out.print("After skipping first 2 elements: ");
        list.stream().skip(2).forEach(num -> System.out.print(num + " "));
        System.out.println();

        // TODO: COUNTING STRINGS WITH SPECIFIC PREFIX
        List<String> strings = Arrays.asList("apple", "bAnana", "apricot", "cherry", "Blueberry");
        long countWithPrefix = strings.stream().filter(s -> s.startsWith("a")).count();
        System.out.println("Count of strings with prefix 'a': " + countWithPrefix);

        // TODO: CONVERT LIST OF ELEMENTS TO UPPERCASE
        List<String> upperCaseStrings = strings.stream().map(String::toUpperCase).toList();
        System.out.println("Upper case strings: " + upperCaseStrings);

        //TODO: FIND DUPLICATE ELEMENTS IN A LIST
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9, 1);
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !uniqueNumbers.add(n)) // add returns false if element already exists
                .collect(Collectors.toSet());
        System.out.println("Duplicate elements: " + duplicates);

        // TODO: FIND FIRST NON-REPEATED CHARACTER IN A STRING
        String str="swiss";
        Optional<Character> firstNonRepeated = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst();
        System.out.println("First non-repeated character: " + firstNonRepeated.orElse(null));
    }
}
