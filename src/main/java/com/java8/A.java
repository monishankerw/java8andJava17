package com.java8;

import java.util.*;
import java.util.function.Function;
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

        List<String> startWith = Arrays.asList("1212", "2313", "1234", "4321", "1234");
        long countWithPrefix1 = startWith.stream().filter(s -> s.startsWith("1")).count();
        System.out.println("Count of strings with prefix '1': " + countWithPrefix1);
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
        String str = "swiss";
        Optional<Character> firstNonRepeated = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst();
        System.out.println("First non-repeated character: " + firstNonRepeated.orElse(null));
        // TODO: even and odd numbers
        Map<Boolean, List<Integer>> evenOddMap = list.stream()
                .collect(Collectors.partitioningBy(e -> e % 2 == 0));

        System.out.println("Even numbers: " + evenOddMap.get(true));
        System.out.println("Odd numbers: " + evenOddMap.get(false));
    }
    // TODO ##################################### Map Java 8  ############################################################

    // TODO : FREQUENCY OCCURENCES
    public static class FreOccurences {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9, 1};
            String str = "treweerwertqw";
            Map<Integer, Long> map = freOccurences(arr);
            System.out.println("frequency of each element" + map);
            Map<Character, Long> map1 = freOccurencesString(str);
            System.out.println("frequency of each string" + map1);
            Map<Character, Long> mostFreqElements = mostFreqElementss(str);
            System.out.println("most freq elements" + mostFreqElements);
            Map<Integer, Long> mostFreqssElements = mostFreqssElementss(arr);
            System.out.println("most freq elements" + mostFreqssElements);

        }


        private static Map<Integer, Long> freOccurences(int[] arr) {
            return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        }

        private static Map<Character, Long> freOccurencesString(String str) {
            return str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        }

        private static Map<Character, Long> mostFreqElementss(String str) {
            // First, create the frequency map
            Map<Character, Long> freqMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            c -> c,
                            Collectors.counting()
                    ));

            // Find and print the most frequent character
            freqMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(entry ->
                            System.out.println("Most frequent: " + entry.getKey() + " → " + entry.getValue())
                    );

            return freqMap;
        }
    }

    private static Map<Integer, Long> mostFreqssElementss(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Print the most frequent element
        map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println("Most frequent: " + entry.getKey() + " → " + entry.getValue())
                );

        return map;  // Return the frequency map
    }

    //TODO : First NoN-Repeat Number
    public static class FirstNonRepeatNumber {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9, 1};
            OptionalInt firstNonRepeat = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .mapToInt(e -> e.getKey())
                    .findFirst();
            System.out.println("First non-repeated number: " + firstNonRepeat.orElse(-1));
        }
    }

    //TODO : All Non-repeated Character
    public static class AllNonRepeatCharacter {
        public static void main(String[] args) {
            String str = "hello world java";

            // Count frequency of characters
            Map<Character, Long> frequencyMap = str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,   // maintain insertion order
                            Collectors.counting()
                    ));

            System.out.print("Non-repeated characters: ");
            frequencyMap.entrySet().stream()
                    .filter(e -> e.getValue() == 1)  // only non-repeated
                    .forEach(e -> System.out.print(e.getKey() + " "));
        }
    }

    //TODO : First Repeated Word
    public static class FirstRepeatedWord {
        public static void main(String[] args) {
            String str = "Java is fun and java is popular";
            String[] words = str.split(" ");
            Map<String, Long> frequencyMap = Arrays.stream(words)
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
            System.out.println("First repeated word: " + frequencyMap.entrySet().stream()
                    .filter(e -> e.getValue() == 2)
                    .map(e -> e.getKey())
                    .findFirst()
                    .orElse(null));
        }
    }

    // TODO: First Non-Repeated Word
    public static class FirstNonRepeatedWord {
        public static void main(String[] args) {
            String str = "Java is fun and java is popular";

            // Split sentence into words
            String[] words = str.split(" ");

            // Count frequency of words (ignoring case for duplicate words)
            Map<String, Long> wordCount = Arrays.stream(words)
                    .map(String::toLowerCase)  // normalize case
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,  // preserve order
                            Collectors.counting()
                    ));

            System.out.println("Word frequencies: " + wordCount);

            // Find the first non-repeated word
            Optional<String> firstNonRepeated = wordCount.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst();

            if (firstNonRepeated.isPresent()) {
                System.out.println("First non-repeated word: " + firstNonRepeated.get());
            } else {
                System.out.println("No non-repeated word found.");
            }
        }
    }

    //TODO: Anagram Number
    public  static class AnagramNumber {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {3, 2, 1};

            // Sort both arrays
            int[] sorted1 = Arrays.stream(arr1).sorted().toArray();
            int[] sorted2 = Arrays.stream(arr2).sorted().toArray();

            // Compare contents
            boolean isAnagram = Arrays.equals(sorted1, sorted2);

            System.out.println("Are the arrays anagrams? " + isAnagram);
        }
    }
    // Anagram String
    public static class AnagramString {
        public static void main(String[] args) {
            String str1 = "listen";
            String str2 = "silent";
            // Remove spaces and convert to lowercase
           boolean result=getFreqMap(str1).equals(getFreqMap(str2));
            System.out.println("Are the strings anagrams? " + result);
        }

        private static Map<Character,Long> getFreqMap(String str1) {
            return str1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(e->e,Collectors.counting()));
        }
    }
}
