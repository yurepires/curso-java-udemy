package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        Map<String, Integer> eleicao = new HashMap<>();
        String path = "C:\\estudos\\curso-java-udemy\\exercicios-resolvidos\\map-exercicio-fixacao\\src\\in\\votos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                String candidato = fields[0];
                int votos = Integer.parseInt(fields[1]);
                if (eleicao.computeIfPresent(candidato, (key, value) -> value + votos) == null){
                    eleicao.put(candidato, votos);
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String key : eleicao.keySet()){
            System.out.println(key + ": " + eleicao.get(key));
        }
    }
}
