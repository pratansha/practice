package all.tech.practice.java8.match;

import java.util.Arrays;

import static all.tech.practice.java8.collectorsExamples.DepartmentEmployeeQuesJava8.employeeList;

public class AllMatchExample {
    public static void main(String[] args) {
        // Example:1 AllMatch Java8. (If all pass then only result will product, If single fail then no result (entire will fail)).
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        System.out.println();
        Arrays.stream(arr3).filter(x -> Arrays.stream(arr3).allMatch(y -> y > 1)).forEach(x -> System.out.print(x + " "));

        // Example:2 AllMatch Java8.
        Boolean allHighPaid = employeeList.stream().allMatch(e -> e.getSalary() > 5000);
        System.out.println(allHighPaid);

        // OR Using findAny() method. (This is reverse way we check but not that readable) , So prefer to use allMatch() method.
        Boolean allHighPaidUsingFindAny = employeeList.stream()
                .filter(e -> e.getSalary() <= 5000)
                .findAny()
                .isPresent(); // ❌ verbose & less readable
        System.out.println(allHighPaidUsingFindAny);
    }
}