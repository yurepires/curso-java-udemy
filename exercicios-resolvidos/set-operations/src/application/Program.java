package application;

import entities.Product;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Tv");
        set.add("Tablet");
        set.add("Notebook");
        set.add("Computador");
        set.add("Celular");

        set.removeIf(x -> x.length() >= 8); //remove todo elemento x que x.length seja >= 3.
        set.removeIf(x -> x.charAt(0) == 'T'); //remove todo elemento x que primeiro elemento de x seja 'T'.

        for (String p: set){
            System.out.println(p);
        }

        System.out.println("-----------------------------------------");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10,11));

        // União
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println("União: " + c);

        // Interseção
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println("Interseção: " + d);

        // Diferença
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println("Diferença: " + e);

        System.out.println("-----------------------------------------");

        Set<Product> treeSet = new TreeSet<>();

        treeSet.add(new Product("TV", 900.0));
        treeSet.add(new Product("Notebook", 1200.0));
        treeSet.add(new Product("Tablet", 400.0));

        for (Product p: treeSet){
            System.out.println(p);
        }
    }
}
