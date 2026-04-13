package all.tech.practice.java;

import java.util.*;

public class ComparatorExample {
    private static class Employee implements Comparator<Employee> {
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
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.yearOfJoining, o2.yearOfJoining);
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
        System.out.println(employees);
        employees.sort(Comparator.comparingInt(o -> o.yearOfJoining));
        System.out.println(employees);
    }
}