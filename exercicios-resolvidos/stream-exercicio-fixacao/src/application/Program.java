package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String path = "C:\\estudos\\curso-java-udemy\\exercicios-resolvidos\\stream-exercicio-fixacao\\src\\in\\employees";
        Scanner sc = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> employees = new ArrayList<>();

            System.out.print("Enter salary: ");
            double researchedSalary = sc.nextDouble();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            List<String> emails = employees.stream()
                    .filter(e -> e.getSalary() > researchedSalary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", researchedSalary) + ":");
            emails.forEach(System.out::println);

            double sum = employees.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
