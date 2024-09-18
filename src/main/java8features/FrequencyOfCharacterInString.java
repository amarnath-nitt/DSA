package main.java8features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfCharacterInString {
    public static void main(String[] args) {
        String input = "Java concept of the day";
        char [] chars = input.toCharArray();
        Map<Character, Long> frequency = input.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);
    }
}
