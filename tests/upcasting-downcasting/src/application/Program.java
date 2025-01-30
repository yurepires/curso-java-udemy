package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Program {

    public static void main(String[] args) {

        BusinessAccount acc1 = new BusinessAccount(1001, "aaaa", 150.00, 1000);
        Account acc2 = acc1;
        BusinessAccount acc3 = (BusinessAccount) acc2;
        Account acc4 = new SavingAccount(1002, "cccc", 350, 0.01);
        Account acc5 = new Account(1005, "eeeee", 9050);


        // acc3 pega o limite de acc1, pois o acc2 pega a referencia de acc1 e não seus dados propriamente
        // os objetos ficam na memória stack mas as variáveis na heap;
        // acc1 tem o endereço das variáveis na heap e acc2 passa a apontar para as variáveis de acc1 também
        // então quando acc3 = acc1; acc3 também vai apontar para as variáveis de acc1 na heap.
        System.out.println(acc3.getLoanLimit());



        if (acc4 instanceof BusinessAccount){
            System.out.println("Business");
        }

        if (acc4 instanceof SavingAccount){
            SavingAccount acc6 = (SavingAccount) acc4;
            acc6.updateBalance();
            System.out.println(acc6.getBalance());
        }

        System.out.println(acc4.getBalance());

    }

}
