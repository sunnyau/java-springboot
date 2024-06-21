package app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    
    public static void main(String[] args) {
        // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // List<Integer> reversedList1 = list.stream()
        //         .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
        //             Collections.reverse(lst);
        //             return lst;
        //         }));

        // System.out.println(reversedList1);

        // List<Integer> newList = new ArrayList<>(list);
        // Collections.reverse(newList);

        // System.out.println(list);

        // System.out.println(newList);

        List<String> list = Arrays.asList("one","two","three","four","five");

        List<String> length4List = list.stream().filter( s -> s.length() == 4).collect(Collectors.toList());

        System.out.println(length4List);
    }
}
