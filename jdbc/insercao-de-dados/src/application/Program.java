package application;

import db.DB;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
              "INSERT INTO seller " +
                  "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                  "VALUES " +
                  "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            // Os ? são substituídos
            st.setString(1, "John Green"); // 1 de primeiro interrogação
            st.setString(2, "john@email.com");
            st.setDate(3, Date.valueOf(LocalDate.parse("13/08/1993", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            st.setDouble(4, 4500.0);
            st.setInt(5, 2);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
               ResultSet rs = st.getGeneratedKeys();
               while (rs.next()) {
                   int id = rs.getInt(1); // ResultSet cria uma tabela auxiliar contendo uma coluna com os IDs e o 1 é pra selecionar essa coluna
                   System.out.println("Done! Id = " + id);
               }
            } else {
               System.out.println("No rows affected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}