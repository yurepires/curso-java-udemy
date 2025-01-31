package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String strPath = sc.nextLine();

        File file = new File(strPath);
        String strFolder = file.getParent();

        boolean success = new File(strFolder + "\\output").mkdir();

        String targetFileStr = strFolder + "\\output\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            System.out.println("Arquivo de Entrada: ");
            String itemCSV = br.readLine();
            while (itemCSV != null){
                System.out.println(itemCSV);
                String[] fields = itemCSV.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                Integer amount = Integer.parseInt(fields[2]);
                products.add(new Product(name, price, amount));
                itemCSV = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
                for (Product p: products){
                    bw.write(p.getName() + "," + String.format("%.2f", p.totalValue()));
                    bw.newLine();
                }
            } catch (IOException e){
                System.out.println("Erro no arquivo de saída!");
            }

        } catch (IOException e) {
            System.out.println("Erro no arquivo de entrada!");
        }

        System.out.println();

        try (BufferedReader br2 = new BufferedReader(new FileReader(targetFileStr))) {
            System.out.println("Arquio de saída: ");
            String productCSV = br2.readLine();
            while (productCSV != null){
                System.out.println(productCSV);
                productCSV = br2.readLine();
            }
        } catch (IOException e){
            System.out.println("Erro no arquivo!");
        }

    }
}
