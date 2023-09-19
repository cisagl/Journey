package Hafta2.MaasHesaplama;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Patika Dev", 2000, 35, 2020);
        employee.tax();
        employee.calculateBonus();
        employee.raiseSalary();
        System.out.println(employee.toString());

    }
}