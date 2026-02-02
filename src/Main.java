/*
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<Employee> list = Arrays.asList(new Employee(1, "IT", 10000),
            new Employee(1, "IT", 10000),
            new Employee(2, "IT", 20000),
            new Employee(3, "SALES", 30000),
            new Employee(4, "SALES", 40000),
            new Employee(5, "FIN", 50000),
            new Employee(6, "FIN", 60000));

    public static void main(String[] args) {
        list.stream().collect(Collectors.groupingBy(x -> x.departmentName, Collectors.maxBy(Comparator.comparingInt(x->x.)))


        ////////////////////////
        String apple = "AppLe";
        String result = apple.chars()
                .mapToObj(x -> {
                    if (x < 96) {
                        return String.valueOf(Character.toLowerCase((char) x));
                    } else {
                        return String.valueOf(Character.toUpperCase((char) x));
                    }
                }).collect(Collectors.joining());
        System.out.println(result);
    }
}

class Employee {
    Integer id;
    String departmentName;
    Integer salary;

    public Employee(Integer id, String departmentName, Integer salary) {
        this.id = id;
        this.departmentName = departmentName;
        this.salary = salary;
    }
}*/
