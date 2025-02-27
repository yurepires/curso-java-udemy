package aplicacao;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
//
//        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();


        /*        -------------   Adicionar Pessoa   --------------          */
        // Quando o jpa faz uma operação que não é uma simples leitura de dados, ele precisa de uma transação
//        em.getTransaction().begin();

//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.getTransaction().commit(); // Quando terminar a transação usa o commit para confirmar o que foi feito


        /*    ------------- Buscar Pessoa ------------   */
//        Pessoa p1 = em.find(Pessoa.class, 1);
//
//        System.out.println(p1);

        /*     --------------- Remoção ---------------     */
        // Dessa forma daria erro, pois p2 é uma instância destacada
//        Pessoa p2 = new Pessoa(2, null, null);
//        em.remove(p2);

        // Forma correta
        // p2 é um objeto monitorado. Objetos monitorados são objetos que ou você acabou de inserir,
        // ou buscou do banco de dados e ainda não fechou o EntityManager.
        // Atenção: sempre que for uma operação que não é uma simples consulta, realize a transação.
        em.getTransaction().begin();
        Pessoa p2 = em.find(Pessoa.class, 2);
        em.remove(p2);
        em.getTransaction().commit();

        System.out.println("Pronto");
        em.close();
        emf.close();

//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
    }
}
