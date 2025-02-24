package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;

        Statement st = null;

        try {
            conn = DB.getConnection();

            // Não confirmar as operações automaticamente
            // Todas as operações vão ficar pendentes de uma confirmação explícita do programador
            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2900 WHERE DepartmentId = 1");

            // testar se o rollback está acontecendo
//            int x = 1;
//            if (x < 2) {
//                throw new SQLException("Fake error");
//            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3350 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Rows 1: " + rows1);

            System.out.println("Rows 2: " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Caused by: " + ex.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}