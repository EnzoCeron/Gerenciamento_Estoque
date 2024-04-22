package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String host;
    private String user;
    private String password;
    private Connection con;
    private static Conexao conexao;
   

    private Conexao() {
        this.host = "jdbc:mysql://localhost:3306/programa_estoque?useSSL=false";
        this.user = "root";
        this.password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.host, this.user, this.password);

        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Conexao getInstacia() {
        if (conexao == null) {
            conexao = new Conexao();
        }

        return conexao;
    }
  
    public Connection getCon() {
        return this.con;
    }
}

