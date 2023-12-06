package ru.geekbrains.threading;

import ru.geekbrains.threading.FirstTask.RandomNumberList;
import ru.geekbrains.threading.SecondTask.Employee;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //FirstTask
        System.out.println("------------------------------");
        System.out.println("First Task");
        new RandomNumberList();


        //SecondTask
        System.out.println("------------------------------");
        System.out.println("Second Task");
        List<Employee> employees = Arrays.asList(
                new Employee("Sergey", 35, 25000, "IT"),
                new Employee("Sveta", 45, 38000, "Accounting"),
                new Employee("Ann", 32, 9000, "Cleaning"),
                new Employee("Roman", 29, 40000, "Legal"),
                new Employee("Makar", 25, 20000, "IT"),
                new Employee("Petr", 28, 9800, "Logistics"),
                new Employee("Kira", 26, 19000, "Production"),
                new Employee("Olga", 39, 35000, "Accounting"),
                new Employee("Mira", 20, 15000, "Production"),
                new Employee("Elena", 30, 26000, "Marketing"),
                new Employee("Mikola", 32, 9000, "Cleaning"),
                new Employee("Ivan", 22, 20000, "Archive")
        );

        departmentPrint(employees);
        System.out.println("\n" + "Salary increase for employees with less than 10_000 by 20%: ");
        salaryIncrease(employees);
    }

    private static void salaryIncrease(List<Employee> employees) {
        employees.stream()
                .filter(it -> it.getSalary() < 10000)
                .forEach(it -> it.setSalary(it.getSalary()*1.2));

        employees.stream()
                .forEach(System.out::println);
    }

    private static void departmentPrint(List<Employee> employees) {
        System.out.println("Departments titles: ");
        employees.stream()
                .map(it -> it.getDepartment())
                .distinct()
                .forEach(System.out::println);
    }
}