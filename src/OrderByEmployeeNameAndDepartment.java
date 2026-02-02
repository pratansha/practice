    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;

    public class OrderByEmployeeNameAndDepartment {
        public static void main(String[] args) {
            Employee e1 = new Employee(1, "Test1", "Engineering");
            Employee e2 = new Employee(2, "Test2", "ComputerScience");
            Employee e3 = new Employee(3, "Test3", "Engineering");
            Employee e4 = new Employee(4, "Test1", "ComputerScience");
            Employee e5 = new Employee(5, "Test2", "Chemical");

            List<Employee> employees = new ArrayList<>();
            employees.add(e1);
            employees.add(e2);
            employees.add(e3);
            employees.add(e4);
            employees.add(e5);

            employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getDepartmentName).reversed());
            employees.forEach(x -> System.out.println("name :"+x.getName()+" , department :"+x.getDepartmentName()));
        }
    }

    class Employee {
        private Integer id;
        private String name;
        private String departmentName;

        public Employee(Integer id, String name, String departmentName) {
            this.id = id;
            this.name = name;
            this.departmentName = departmentName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }
    }
