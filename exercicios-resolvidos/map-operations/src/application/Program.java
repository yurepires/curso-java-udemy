package application;

import entities.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria"); //inserção de elementos
        cookies.put("email", "Maria@email.com");
        cookies.put("phone", "99711122");

        cookies.remove("email");
        cookies.put("phone", "999991133"); // sobrescreve o outro phone

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));

        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Size: " + cookies.size());

        System.out.println("ALL COOKIES:");
        for (String key: cookies.keySet()){  // pegando os elementos pela key
            System.out.println(key + ": " + cookies.get(key));
        }

        System.out.println("------------------------------------");

        Map<Product, Double> stock = new HashMap<>();

        Product p1 = new Product("Tv", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        stock.put(p1, 10000.0);
        stock.put(p2, 20000.0);
        stock.put(p3, 15000.0);

        Product ps = new Product("Tv", 900.0);

        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
    }
}
