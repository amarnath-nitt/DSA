package main.java8features;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C++", "C#", "Java", "C++", "python");
        System.out.println("Elements: " + listOfStrings);
        List<String> uniqueStrings = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique Elements: "+uniqueStrings);
    }
}
