package Receptionist;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connn {
    public static java.sql.Connection connectdb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con= DriverManager.getConnection("jdbc:mysql://localhost/paroll","root","");
            System.out.println("Connected...");
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connn con= new Connn();
        connectdb();
    }
}
