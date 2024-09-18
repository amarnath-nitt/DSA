package main.java8features;

import java.util.*;
import java.util.stream.Collectors;

public class SeparateOddAndEven {
    public static void main(String[] args) {
        List<Integer> listOfInteger = Arrays.asList(1,2,3,5,6,7,8,10,9);
        Map<Boolean, List<Integer>> numbers = listOfInteger.stream().collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        for(Map.Entry<Boolean, List<Integer>> entry : numbers.entrySet()){
            if(entry.getKey()){
                System.out.print("Even numbers: ");
            }
            else{
                System.out.print("Odd numbers: ");
            }
            for(int x : entry.getValue()){
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
