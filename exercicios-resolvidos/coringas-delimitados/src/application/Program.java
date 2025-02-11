package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);
    }

//    List<? extends Number>  - Lista de qualquer tipo que extends Number. (apenas get) (covariância)
//    List<? super Number>    - Lista de qualquer tipo que pode ser um super tipo de Number. (apenas put) (contra-variância)
    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for (Number number: source){
            destiny.add(number);
        }
    }

    public static void printList(List<?> list){
        for (Object obj: list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
