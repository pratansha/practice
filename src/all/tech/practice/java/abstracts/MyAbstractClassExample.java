package all.tech.practice.java.abstracts;

public class MyAbstractClassExample {

    /* Abstract class can contains any types of variable but Interface can contain public static final by default with all abstract methods.*/
    public abstract static class AbstractEmployee {
        protected String name;
        public static int i = 3;

        public AbstractEmployee(String name) {
            this.name = name;
        }

        // abstract method
        public abstract double calculateSalary();

        public static void test(int k) {
            i = i + k;
        }

        public static void printI() {
            System.out.println(i);
        }

        // concrete method
        public void displayName() {
            System.out.println("Employee Name: " + name);
        }

    }


    public static class FullTimeEmployee extends AbstractEmployee {
        public FullTimeEmployee(String name) {
            super(name);
        }

        @Override
        public double calculateSalary() {
            return 80000;
        }
    }


    public static class ContractEmployee extends AbstractEmployee {
        public ContractEmployee(String name) {
            super(name);
        }

        @Override
        public double calculateSalary() {
            return 80000;
        }
    }

    public static void main(String[] args) {
        AbstractEmployee employee = new ContractEmployee("Prashant-as-contract-emp");
        employee.displayName();
        System.out.println(" Employee salary is " + employee.calculateSalary());

        AbstractEmployee employee2 = new FullTimeEmployee("Prashant-as-perm-emp");
        employee2.displayName();
        System.out.println(" Employee salary is " + employee2.calculateSalary());

        AbstractEmployee.printI();
        AbstractEmployee.test(10);
        AbstractEmployee.printI();
    }
}
