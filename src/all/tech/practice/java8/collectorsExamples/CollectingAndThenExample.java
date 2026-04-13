package all.tech.practice.java8.collectorsExamples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static all.tech.practice.java8.collectorsExamples.DepartmentEmployeeQuesJava8.employeeList;

/*
collectingAndThen allows you to apply a finishing transformation after a collector runs,
commonly used to enforce immutability or post‑process collected results.
When should YOU use collectingAndThen?
    Use it when you need:
    ✅ Immutability
    ✅ Post‑processing after collection
    ✅ Optional unwrapping
    ✅ Formatting / transformation of collected result
    ✅ Clean one‑pass pipeline (no extra stream)

When NOT to use it
    ❌ If simple toList() is enough
    ❌ If transformation can be done with map() before collecting
    ❌ If result mutation is required later
*/

public class CollectingAndThenExample {
    public static void main(String[] args) {
        List<DepartmentEmployeeQuesJava8.Employee> unmodifiable =
                employeeList.stream().collect(Collectors.collectingAndThen(
                        Collectors.toList(), // downstream
                        Collections::unmodifiableList // finisher -> immutable list
                ));
        System.out.println(unmodifiable);

        // Example:1 Returned Immutable List
        List<String> names =
                Stream.of("A", "B", "C").collect(Collectors.collectingAndThen(
                        Collectors.toList(), // downstream
                        Collections::unmodifiableList // finisher
                ));
        System.out.println(names);

        // Example:2 Returned Immutable Set.
        Set<String> set = Stream.of("A", "A", "B", "C", "D")
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(),
                        Collections::unmodifiableSet
                ));
        System.out.println(set);


        // Example:3 If Interviewer asked you to provide a Immutable list in group by.
        //✔ Groups by department
        //✔ Extracts names
        //✔ Makes each department list immutable
        Map<String, List<String>> map =
                employeeList.stream().collect(
                        Collectors.groupingBy(DepartmentEmployeeQuesJava8.Employee::getDepartmentName,
                                Collectors.collectingAndThen(
                                        Collectors.mapping(DepartmentEmployeeQuesJava8.Employee::getName, Collectors.toList()), // downstream
                                        Collections::unmodifiableList // finisher -> immutable list
                                )
                        )
                );
        System.out.println(map);

        // Example:4 maxBy returns Optional<Employee> if Optional comes null then default value will come.
        // This pattern is shown in advanced collector examples.
        DepartmentEmployeeQuesJava8.Employee highestPaidEmployee =
                employeeList.stream().collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(DepartmentEmployeeQuesJava8.Employee::getSalary)),
                        opt -> opt.orElse(new DepartmentEmployeeQuesJava8.Employee(0, "test", 10000, "my-test-department", false))
                ));
        System.out.println(highestPaidEmployee.getName());

        // Example:5
        Map<String, Long> deptCountWithoutCollectingAndThen = employeeList.stream()
                .collect(Collectors.groupingBy(
                        DepartmentEmployeeQuesJava8.Employee::getDepartmentName,
                        Collectors.counting()
                ));
        System.out.println(deptCountWithoutCollectingAndThen);
        //OR
        Map<String, String> deptCountWithCollectingAndThen = employeeList.stream()
                .collect(Collectors.groupingBy(
                        DepartmentEmployeeQuesJava8.Employee::getDepartmentName,
                        Collectors.collectingAndThen(Collectors.counting(), // downstream using terminal method.
                                x -> "<total:" + x + ">"// finisher used to convert result in String format.
                        )
                ));
        System.out.println(deptCountWithCollectingAndThen);

        //employeeList.parallelStream()


    }
}