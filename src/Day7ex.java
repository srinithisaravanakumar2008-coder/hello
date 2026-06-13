public class day8 {
    interface Employee {
        void solveProblem();
        void work();
    }
    static class BankEmployee implements Employee {
        String name;
        String id;
        int salary;
        BankEmployee(String name, String id, int salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }
        @Override
        public void solveProblem() {
            System.out.println(name + " is solving problems");
        }
        @Override
        public void work() {
            System.out.println(name + " is working in the bank");
        }
    }
    static class CheckingEmployee implements Employee {
        String name;
        String id;
        int salary;
        CheckingEmployee(String name, String id, int salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }
        @Override
        public void solveProblem() {
            System.out.println(name + " is checking customer accounts");
        }
        @Override
        public void work(){
            System.out.println(name + " is performing checking operations");
        }
    }
    public static void main(String[] args) {
        Employee emp1 = new BankEmployee("srinithi", "B101", 50000);
        Employee emp2 = new CheckingEmployee("sanjana", "C102", 30000);
        System.out.println();
        emp1.work();
        System.out.println();
        emp2.solveProblem();
        System.out.println();
    }
}