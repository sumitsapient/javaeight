package org.youtube;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMethod {

    public static void main(String[] args) {

        //filter
        List<String> city = List.of("Allahabad","Bangalore","Bhopal");
        List<String> cityStartsWithB = city.stream().filter(m->m.startsWith("B")).collect(Collectors.toList());
        System.out.println("City Starting With Name B "+ cityStartsWithB);

        //map
        List<Integer> num = List.of(2,5,3,6);
        List<Integer> numSquare = num.stream().map(m->m*m).collect(Collectors.toList());
        System.out.println("Numbers doubled "+ numSquare);

        //min,max,average,count,sum,summaryStatistics
        int[] numbers = {4,34,0,6};
        int minimum  = IntStream.of(numbers).min().getAsInt();
        System.out.println("Min number is "+ minimum);
        IntStream.of(numbers).min().ifPresent(System.out::println);
        int max = IntStream.of(numbers).max().getAsInt();
        long count = IntStream.of(numbers).count();
        int sum = IntStream.of(numbers).sum();
        double average = IntStream.of(numbers).average().getAsDouble();
        IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
        statistics.getMin();
        statistics.getMax();
        statistics.getSum();
        statistics.getCount();
        statistics.getAverage();

        //Find 3 distinct smallest numbers
        int[] num1 = {4,1,13,90,0,1};
        int[] distinct = IntStream.of(num1).distinct().sorted().limit(3).toArray();
        System.out.println("Distinct elements");
        IntStream.of(num1).distinct().sorted().limit(3).forEach(System.out::println);

        //Sum of first three distinct smallest numbers
        int[] num2 = {3,5,6,4,0,1,5};
        int sum1 = IntStream.of(num2).distinct().sorted().limit(3).sum();
        System.out.println("Sum of three smallest numbers "+sum1);

        //Create IntStream
        int[] num3 = {3,5,76,1,0};
        int[] numberOf = IntStream.of(num3).toArray(); //of()
        int[] numberRange = IntStream.range(1,101).toArray(); // range
        int[] numberRangeClosed = IntStream.rangeClosed(1,100).toArray(); //rangeClosed

        //Process IntStream
        IntStream.of(num3).distinct();       //distinct
        IntStream.of(num3).sorted();         //sorted
        IntStream.of(num3).limit(3); //get first 3
        IntStream.of(num3).skip(3);      //skip first 3
        IntStream.of(num3).filter(m->m%2==0); //even only
        IntStream.of(num3).map(m->m*m);       // double numbers
        IntStream.of(num3).boxed();           //convert each num to Integer

        //IntStream Consume
        IntStream.of(num3).min();    //min
        IntStream.of(num3).max();    //max
        IntStream.of(num3).count();  //count
        IntStream.of(num3).sum();    //sum
        IntStream.of(num3).average(); //average

        IntStream.of(num3).forEach(System.out::println); //print all numbers
        IntStream.of(num3).toArray();                    //collect into array
        IntStream.of(num3).boxed().collect(Collectors.toList()); //collect into list

        IntStream.of(num3).anyMatch(m->m%2==1); //is any odd
        IntStream.of(num3).allMatch(m->m%2==1); // are all odd

    }
}
