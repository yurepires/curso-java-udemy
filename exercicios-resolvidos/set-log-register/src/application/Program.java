package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path = "C:\\estudos\\curso-java-udemy\\exercicios-resolvidos\\set-log-register\\src\\input\\in";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Set<LogEntry> setLogEntries = new HashSet<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(" ");
                String usuario = fields[0];
                Instant moment = Instant.parse(fields[1]);
                setLogEntries.add(new LogEntry(usuario, moment));
                line = br.readLine();
            }
            System.out.println("Total users: " + setLogEntries.size());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
