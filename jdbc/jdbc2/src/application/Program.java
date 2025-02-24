package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection(); //Connection

            st = conn.createStatement(); //Statement

            rs = st.executeQuery("SELECT * FROM department"); // ResultSet

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs); // Criados métodos estáticos na classe DB para evitar repetidos try/catch
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}