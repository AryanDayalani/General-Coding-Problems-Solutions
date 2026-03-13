package STEP;

import java.util.*;

class Calculator {
    public int calculateGross(int salary, int allowance) {
        int gross_salary = salary + allowance;
        return gross_salary;
    }

    public int calculateAnnualBonus(int gross_salary, int bonus) {
        int annual_bonus = (gross_salary * 12 * bonus) / 100;
        return annual_bonus;
    }

    public int calculateAnnual(int gross_salary, int annual_bonus) {
        int annual_salary = (gross_salary * 12) + annual_bonus;
        return annual_salary;
    }

    public int calculateTaxableIncome(int annual_salary) {
        int taxable_income = 0;
        if (annual_salary > 50000) {
            taxable_income = annual_salary - 50000;
        } else {
            taxable_income = 0;
        }
        return taxable_income;
    }

    public int calculateTax(int annual_salary, int taxable_income) {
        int tax = 0;
        if (taxable_income > 0) {
            if (taxable_income > 0 && taxable_income <= 300000) {
                tax = (0 * taxable_income) / 100;
            } else if (taxable_income > 300000 && taxable_income <= 700000) {
                tax = (5 * taxable_income) / 100;
            } else if (taxable_income > 700000 && taxable_income <= 1000000) {
                tax = (10 * taxable_income) / 100;
            } else if (taxable_income > 1000000 && taxable_income <= 1200000) {
                tax = (15 * taxable_income) / 100;
            } else if (taxable_income > 1200000 && taxable_income <= 1500000) {
                tax = (20 * taxable_income) / 100;
            } else if (taxable_income > 1500000) {
                tax = (30 * taxable_income) / 100;
            }
            tax = tax + (4 * tax) / 100;
        }
        return tax;
    }
}

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        if (name.isEmpty() || name.length() > 50) {
            System.out.println(
                    "Invalid input: Name must be non-empty, contain only alphabets and spaces, and be at most 50 characters.");
            scanner.close();
            return;
        }

        System.out.println("Enter employee Id: ");
        String emp_id = scanner.nextLine();

        if (!emp_id.matches("[a-zA-Z0-9]+") || emp_id.length() < 5 || emp_id.length() > 10) {
            System.out.println("Invalid input: Employee ID must be alphanumeric and between 5-10 characters.");
            scanner.close();
            return;
        }

        System.out.println("Enter employee monthly salary: ");
        int salary = scanner.nextInt();

        if (salary <= 0 || salary > 10000000) {
            System.out.println("Invalid input: Basic salary must be positive and at most 10000000.");
            scanner.close();
            return;
        }

        System.out.println("Enter employee monthly special allowance: ");
        int allowance = scanner.nextInt();

        if (allowance < 0 || allowance > 10000000) {
            System.out.println("Invalid input: Special allowance must be non-negative and at most 10000000.");
            scanner.close();
            return;
        }

        System.out.println("Enter employee annual bonus percentage: ");
        int bonus = scanner.nextInt();

        if (bonus < 0 || bonus > 100) {
            System.out.println("Invalid input: Bonus percentage must be between 0 and 100.");
            scanner.close();
            return;
        }

        Calculator cal = new Calculator();
        int gross_salary = cal.calculateGross(salary, allowance);
        int annual_bonus = cal.calculateAnnualBonus(gross_salary, bonus);
        int annual_salary = cal.calculateAnnual(gross_salary, annual_bonus);

        System.out.println("Gross Monthly and Annual Salaries are Rs. " + gross_salary + " , " + annual_salary);

        int taxable_income = cal.calculateTaxableIncome(annual_salary);
        System.out.println("Taxable income is Rs. " + taxable_income);

        int tax = cal.calculateTax(annual_salary, taxable_income);
        System.out.println("Total tax is Rs. " + tax);

        int total_salary = annual_salary - tax;
        System.out.println("The annual salary after tax deduction is Rs: " + total_salary);

        scanner.close();
    }
}
