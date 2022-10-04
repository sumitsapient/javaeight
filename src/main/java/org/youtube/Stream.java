package org.youtube;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {

        //Create list of Integer
        List<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(23);
        list1.add(2);

        //List.of() creates unmodifiable list
        List<Integer> list2 = List.of(2, 34, 23, 21);

        //Traditional way to filter even numbers
        List<Integer> newList1 = new ArrayList<>();
        for (Integer i : list1) {
            if (i % 2 == 0) {
                newList1.add(i);
            }
        }

        System.out.println("Original List " + list1);
        System.out.println("Original List Even Without Stream " + newList1);
        System.out.println("--------------------------------");

        List<Integer> streamList = list1.stream().filter(m->m%2==0).collect(Collectors.toList());
        System.out.println("Original List Even Witht Stream " + streamList);

    }
}
