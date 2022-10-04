package org.youtube;

import org.youtube.pojo.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamObject {

    public static void main(String[] args) {

        Employee e1 = new Employee("Summit","AEM",2000,false);
        Employee e2 = new Employee("Hamid","Hybris",2500,true);
        Employee e3 = new Employee("Sai","Infra",1500,true);
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(e1);
        allEmployees.add(e2);
        allEmployees.add(e3);

        //Names of 2 highest earning employees.
        System.out.println("Two highest earning employees ");
        allEmployees.stream().sorted(Comparator.comparingLong(Employee::getSalary)
                             .reversed()).limit(2)
                             .map(Employee::getName).forEach(System.out::println);

        //Names of 2 active highest earning employees.
        System.out.println("Two active highest earning employees ");
        allEmployees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .filter(employee -> employee.isActive())
                .limit(2).map(Employee::getName).forEach(System.out::println);

        //Collectors - to list
        allEmployees.stream().limit(2).map(Employee::getName).collect(Collectors.toList());

        //Collectors - to set
        allEmployees.stream().limit(2).map(Employee::getName).collect(Collectors.toSet());

        //Collectors - to map
       Map<String , Employee> empMap =  allEmployees.stream().limit(2)
                .collect(Collectors.toMap(e->e.getName(),e->e));

       //Collectors - joining i.e Summit,Hamid,Sai
       String empNames = allEmployees.stream()
                                     .map(Employee::getName)
                                     .collect(Collectors.joining(","));

       //Collectors - groupingBy
       Map<String,List<Employee>> empByDept = allEmployees.stream()
               .collect(Collectors.groupingBy(e->e.getDepartment()));

       //Count employees in each department
       Map<String,Long> deptCounts = allEmployees.stream()
               .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println("AEM employees count "+deptCounts.get("AEM"));

    }
}
