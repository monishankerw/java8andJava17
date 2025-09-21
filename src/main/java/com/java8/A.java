package com.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) {

        //TODO : FILTER EVEN NUMBER

        List<Integer> list = Arrays.asList(1, 2, 4, 5, 3, 2, 1, 6, 5);
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
        // reduce():Terminal Operation
        //Used to perform a reduction on the elements of a stream using an associative accumulation function and returning an optional with the reduced value.
        // TODO: SUM OF NUMBER
        System.out.println(list.stream().reduce(0,(a,b)->a+b).toString());
        // sum of even number
        System.out.println("Sum of even numbers: " +
                list.stream()
                        .filter(x -> x % 2 == 0)
                        .reduce(0, (a, b) -> a + b)
        );
        // Longest Words
        List<String>str=Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String s1 = str.stream().reduce((x, y) -> x.length() > y.length() ? x : y).get();
        System.out.println(s1);


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
        // 10. greater than 4 and then find their average
        System.out.println("Print Average Greater than 4::" + list.stream().filter(x -> x > 4).mapToInt(x -> x).average());

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
        // 9. Remove Duplicate in list
        System.out.println("Remove Duplicate numbers in List::" + list.stream().distinct().collect(Collectors.toList()));


        // TODO: SORT
        System.out.print("Sorted Accending Order: ");
        List<Integer> num = Arrays.asList(2,4,1,3,6,7,5,9,8);
        System.out.println("Orginal Number:"+num);
        List<Integer> num1 = num.stream().sorted().collect(Collectors.toList());
        System.out.println("Accending Order:"+num1);
        // TODO: SORT DESCENDING
        System.out.print("Sorted Descending Order: ");
//        decendingorder;
        List<Integer>number=Arrays.asList(21,2,23,4,25,26,17,8);

        List<Integer>num2=number.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(num2);
        // TODO: LIMIT
        System.out.print("First 3 elements: ");
        list.stream().limit(3).forEach(num21 -> System.out.print(num21 + " "));
        System.out.println();

        // TODO: SKIP
        System.out.print("After skipping first 2 elements: ");
        list.stream().skip(2).forEach(num11 -> System.out.print(num11 + " "));
        System.out.println();

        // TODO: FLATMAP
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 3, 1), Arrays.asList(5, 7, 6));
        // 7.flatMap(): flatten the lists into a single list
        System.out.println("Print Single List::" + lists.stream().flatMap(List::stream).collect(Collectors.toList()));

        // merge list and remove duplicate
        System.out.println("Print Single List and Remove duplicate::" + lists.stream().flatMap(List::stream).distinct().collect(Collectors.toList()));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "app", "application");
// 2. map : Transforms each elements into another form
        // Print String in upper case
        System.out.println("UPPERCASE WORDS::" + words.stream().map(String::toUpperCase).collect(Collectors.toList()));
        // 5. grouping the stream using Stream API
        System.out.println("group the Strings::" + words.stream().collect(Collectors.groupingBy(String::length)));

        // 6. count the word greater than 3
        System.out.println("Count Word Greater Than Three::" + words.stream().filter(x -> x.length() > 3).count());
// 8. sort them in alphabetical order and collect the result
        System.out.println("Alphabetical Order Sort::" + words.stream().sorted().collect(Collectors.toList()));
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
        String str1 = "swiss";
        Optional<Character> firstNonRepeated = str1.chars()
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

    // TODO: Count Occurences of Words
    public static class CountOccurencesOfWords {
        public static void main(String[] args) {
            String str = "Java is fun and java is popular";
            String[] words = str.split(" ");
            Map<String, Long> wordCount = Arrays.stream(words)
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,  // preserve order
                            Collectors.counting()
                    ));
            System.out.println("Word frequencies: " + wordCount);
        }
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
        // Count character occurrences in a string
        String input = "hello world";
        Map<Character, Long> characterCount = input.chars() // Convert the string to an IntStream of characters
                .mapToObj(c -> (char) c) // Convert the IntStream to a Stream<Character>
                .collect(Collectors.groupingBy( // Group by each character
                        Function.identity(), // Use the character as the key
                        Collectors.counting() // Count the occurrences
                ));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "app", "application");
        // Convert a stream of strings to a list of integers representing their lengths
        List<Integer> x2 = words.stream().map(String::length).collect(Collectors.toList());

        // Convert a stream of strings to a list of integers representing their lengths
        List<Integer> x3 = words.stream().map(String::length).collect(Collectors.toList());

    }
// TODO : Duplicate Elements in an Arrays
    public static class DuplicateElements {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9, 1};
            //TODO: using java 8
            Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting())).
                    entrySet().stream().filter(e->e.getValue()>1).forEach(e->System.out.println(e.getKey()));
        }
    }
    //TODO : Duplicate Characters in a String
    public static class DuplicateCharacters {
        public static void main(String[] args) {
            String str = "hello world";
            //TODO: using java 8
            str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(e->e,Collectors.counting())).
                    entrySet().stream().filter(e->e.getValue()>1).forEach(e->System.out.println(e.getKey()));
        }
    }
    //TODO : Duplicate Words in a String
    public static class DuplicateWords {
        public static void main(String[] args) {
            String str = "hello world java hello";
            //TODO: using java 8
            Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(e->e,Collectors.counting())).
                    entrySet().stream().filter(e->e.getValue()>1).forEach(e->System.out.println(e.getKey()));
        }
    }
 // TODO: Intersecting Elements in Two Arrays & Common Elements in Two Arrays
    public static class IntersectingElements {
     public static void main(String[] args) {
         int[] arr1 = {1, 2, 3, 4, 5};
         int[] arr2 = {4, 5, 6, 7, 8};
         Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
         int[] intersection=Arrays.stream(arr2).filter(set1::contains).distinct().toArray();
         System.out.println("Intersection: "+Arrays.toString(intersection));
     }
 }
 //TODO : Union of Two Arrays
    public static class UnionOfTwoArrays {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = {4, 5, 6, 7, 8};
            Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
            int[] union = Arrays.stream(arr2).filter(set1::contains).distinct().toArray();
            System.out.println("Union: " + Arrays.toString(union));
        }
    }
    //TODO : Merge and Duplicate Elements
    public static class MergeAndDuplicateElements {
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = {4, 5, 6, 7, 8};
            Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
            int[] merge = Arrays.stream(arr2).filter(set1::contains).distinct().toArray();
            System.out.println("Merge: " + Arrays.toString(merge));
        }
    }
    // TODO: Second Largest Elements
    public static class SecondLargestElements {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int secondLargest = Arrays.stream(arr).sorted().skip(arr.length - 2).findFirst().orElse(-1);
            System.out.println("Second largest: " + secondLargest);
        }
    }
    // TODO: Find Largest Word
    public static class FindLargestWord {
        public static void main(String[] args) {
            String str = "Java is fun and java is popular";
            String[] words = str.split(" ");
            Optional<String> largestWord = Arrays.stream(words)
                    .max(Comparator.comparingInt(String::length));
            System.out.println("Largest word: " + largestWord.orElse(null));
        }
    }
}
