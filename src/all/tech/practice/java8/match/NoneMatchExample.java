package all.tech.practice.java8.match;

import java.util.Arrays;

import static all.tech.practice.java8.collectorsExamples.DepartmentEmployeeQuesJava8.employeeList;

public class NoneMatchExample {
    public static void main(String[] args) {
        // Example:1 NoneMatch Java8.(If all pass then only result will product, If single fail then no result (entire will fail)).
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        Boolean result = Arrays.stream(arr3).noneMatch(y -> y > 10);
        System.out.println(result);

        // Example:2 AllMatch Java8.
        System.out.println();
        Boolean allLowSalary = employeeList.stream().noneMatch(e -> e.getSalary() < 5000);
        System.out.println(allLowSalary);
    }
}