import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return ("Employee[name =" + name + ", id" + id + " , salary " + calculateSalary() + "]");
    }
}

class fullTimeEmployee extends Employee {
    private double monthlySalary;

    public fullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public partTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class payRollSystem {
    private List<Employee> employeeList;

    public payRollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getID() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        payRollSystem payrollsystem = new payRollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("Vikash", 101, 23330);
        partTimeEmployee emp2 = new partTimeEmployee("Amit Raj", 201, 51, 100);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("__________________________________");
        System.out.println("Initial Employee detail");
        payrollsystem.displayEmployee();
        System.out.println("________________________________");
        System.out.println("Removing Employee");
        payrollsystem.removeEmployee(101);
        System.out.println("______________________________");
        System.out.println("Remaining Employees Detail");
        payrollsystem.displayEmployee();
    }
}
