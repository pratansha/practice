package all.tech.practice.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparableExample {
    private static class Employee implements Comparable<Employee> {
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

        @Override
        public int compareTo(Employee o) {
            return Integer.compare(this.yearOfJoining, o.yearOfJoining);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", "HR", 2010, 50000),
                new Employee("Bob", "IT", 2012, 70000),
                new Employee("Charlie", "IT", 2009, 80000),
                new Employee("David", "Finance", 2015, 60000),
                new Employee("Eve", "HR", 2008, 55000)
        );
        Collections.sort(employees1);
        System.out.println(employees1);

        //Using java 8
        List<Employee> employees2 = Arrays.asList(
                new Employee("Alice", "HR", 2010, 50000),
                new Employee("Bob", "IT", 2012, 70000),
                new Employee("Charlie", "IT", 2009, 80000),
                new Employee("David", "Finance", 2015, 60000),
                new Employee("Eve", "HR", 2008, 55000)
        );
        // Sorting based on department name in Asc order.
        System.out.println(employees2.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList()));

        //
    }
}