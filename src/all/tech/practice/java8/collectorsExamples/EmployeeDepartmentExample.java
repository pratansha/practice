package all.tech.practice.java8.collectorsExamples;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDepartmentExample {
    private static class Employee {
        private final String name;
        private final String department;
        private final int yearOfJoining;
        private final double salary;

        public Employee(String name, String department, int yearOfJoining, double salary) {
            this.name = name;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getYearOfJoining() {
            return yearOfJoining;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (" + department + ", " + yearOfJoining + ", " + salary + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 2010, 50000),
                new Employee("Bob", "IT", 2012, 70000),
                new Employee("Charlie", "IT", 2009, 80000),
                new Employee("David", "Finance", 2015, 60000),
                new Employee("Eve", "HR", 2008, 55000)
        );

        // 1. What is the average salary of each department ?
        Map<String, Double> map = employees.stream().collect(Collectors.groupingBy(emp -> emp.department, Collectors.averagingDouble(emp -> emp.salary)));
        System.out.println(map);

        // 2. Who has the most working experience in the organization ?
        Optional<Employee> employeeOptional = employees.stream().min(Comparator.comparing(x -> x.yearOfJoining));
        System.out.println(employeeOptional.get());

        // 3. Who has the recently joined organization ,If 2 matches then get who has high salary .
        // Optional<Employee> employeeOptional = employees.stream().sorted(Comparator.comparing(x -> x.yearOfJoining)).findFirst();
        //  System.out.println(employeeOptional.get());

        // 3. List down the names of all employees in each department?
        // 4. Get all employee record in comma separator format
    }
}