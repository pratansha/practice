package all.tech.practice.java8.collectorsExamples;

import java.util.*;
import java.util.stream.Collectors;

public class DepartmentEmployeeQuesJava8 {
    public static List<Employee> employeeList = new ArrayList<>();

    static {
        Employee e1 = new Employee(1, "Employee-1", 4000.0, "IT", false);
        Employee e2 = new Employee(2, "Employee-2", 5000.0, "Mechanical", false);
        Employee e3 = new Employee(3, "Employee-3", 6000.0, "Mechanical", true);
        Employee e4 = new Employee(4, "Employee-4", 4000.0, "IT", true);
        Employee e5 = new Employee(5, "Employee-5", 5000.0, "Mechanical", false);
        Employee e6 = new Employee(6, "Employee-6", 6000.0, "Mechanical", false);
        Employee e7 = new Employee(7, "Employee-7", 7000.0, "CS", false);
        Employee e8 = new Employee(8, "Employee-8", 8000.0, "Electromics", false);
        Employee e9 = new Employee(9, "Employee-9", 9000.0, "CS", false);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);
        employeeList.add(e8);
        employeeList.add(e9);
    }

    public static class Employee {
        private int id;
        private boolean isManager;
        private String name;
        private double salary;
        private String departmentName;


        public Employee(int id, String name, double salary, String departmentName, boolean isManager) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.departmentName = departmentName;
            this.isManager = isManager;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public boolean isManager() {
            return isManager;
        }

        public void setManager(boolean manager) {
            isManager = manager;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", isManager=" + isManager +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", departmentName='" + departmentName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Example:1 Group By with Mapping Name.
        Map<String, List<String>> map = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.mapping(Employee::getName, Collectors.toList())));
        // groupingBy takes 2 param Function(classifier) which takes input & Downstream(Collector).
        System.out.println(map);

        // Example:2 Group By with min salary employee.
        Map<String, Optional<Employee>> map2 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary).thenComparing(x -> x.id))));
        // groupingBy takes 2 param Function(classifier) which takes input & Downstream(Collector).
        System.out.println(map2);

        // Example:3 Group By with min salary amount.
        Map<String, Double> map3 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 4000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                                        opt -> opt.map(Employee::getSalary).orElse(0d)
                                )
                        )
                );
        System.out.println(map3);

        // Example:4 Group By with max salary amount.
        Map<String, Double> map4 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                        opt -> opt.map(Employee::getSalary).orElse(0d)
                                )
                        )
                );
        System.out.println(map4);

        // Example:5 Group By with Average salary amount
        Map<String, Double> map5 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                                Collectors.mapping(Employee::getSalary, Collectors.averagingDouble(x -> x)
                                )
                        )
                );
        System.out.println(map5);

        // Example:6 Group By with max salary amount(Another way)
        Map<String, Optional<Double>> map6 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                                Collectors.mapping(Employee::getSalary, Collectors.maxBy(Comparator.comparingDouble(x -> x))
                                )
                        )
                );
        System.out.println(map6);

        // Example:7 Group By with count of all employees in that department
        Map<String, Long> map7 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting())
                );
        System.out.println(map7);

        // Example:8 Group By where 1 department will have number of employees in the descending order of their name.
        Map<String, List<String>> map8 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 4000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                                Collectors.collectingAndThen(
                                        Collectors.mapping(Employee::getName, Collectors.toList()),
                                        list -> list.stream().sorted(Comparator.reverseOrder())
                                                .collect(Collectors.toList())
                                )
                        )
                );
        System.out.println(map8);
        //OR
        Map<String, List<Employee>> map9 = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 4000)
                .collect(Collectors.groupingBy(Employee::getDepartmentName,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream().sorted(Comparator.comparing(Employee::getName).reversed().thenComparing(Employee::getSalary))
                                                .collect(Collectors.toList())
                                )
                        )
                );
        System.out.println(map9);

        // Partitioning Example.
        Map<Boolean, List<String>> mapPartitionBy = employeeList.stream().filter(x -> x.getName() != null && x.getSalary() > 5000)
                .collect(Collectors.partitioningBy(Employee::isManager, Collectors.mapping(Employee::getName, Collectors.toList())));
        // partitioningBy takes 2 param Predicate(predicate) which takes input & return true/false & Downstream(Collector) for mapping.
        System.out.println(mapPartitionBy);
    }
}