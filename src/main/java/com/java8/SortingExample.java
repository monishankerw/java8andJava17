package com.java8;

import java.util.*;
import java.util.stream.Collectors;

public class SortingExample {

    public static void main(String[] args) {

        // Sorting a list of Person objects
        List<Person> people = Arrays.asList(
                new Person(30, "Alice"),
                new Person(25, "Bob"),
                new Person(35, "Charlie")
        );

        // Sort by age using Stream
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(person -> person.age))
                .collect(Collectors.toList());

        System.out.println("Sorted People by Age:");
        sortedPeople.forEach(System.out::println);

        // Collecting a map from a list of people
        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(person -> person.name, person -> person.age));

        System.out.println("\nName to Age Map:");
        System.out.println(nameToAgeMap);

        // Employee list
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Mani", 122222));
        list.add(new Employee(102, "Shanker", 111111));
        list.add(new Employee(103, "Test", 22222));

        // Sorting by ID (natural ordering using Comparable)
        Collections.sort(list);
        System.out.println("\nSorted by ID:");
        list.forEach(System.out::println);

        // Sorting by Name using Comparator
        Collections.sort(list, Comparator.comparing(Employee::getName));
        System.out.println("\nSorted by Name:");
        list.forEach(System.out::println);

        // Sorting by Salary using Comparator
        Collections.sort(list, Comparator.comparingInt(Employee::getSalary));
        System.out.println("\nSorted by Salary:");
        list.forEach(System.out::println);
    }

    // Person class
    public static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    // Employee class with Comparable implementation
    public static class Employee implements Comparable<Employee> {
        private int id;
        private String name;
        private int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public int compareTo(Employee o) {
            return this.id - o.id; // Natural order by ID
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }
}