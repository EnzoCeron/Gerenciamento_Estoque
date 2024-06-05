package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instancia;
    private Connection con;

    private Conexao() {
        try {
            // Carregamento do driver e inicialização da conexão
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/programa_estoque?useSSL=false", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Conexao getInstancia() { // Há uma pequena correção que eu implementei pra garantir que o método getInstancia()
        if (instancia == null) {                    // seja thread-safe. Isso é importante em ambientes multi-thread, como aplicações web ou servidores. Davi
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection getCon() {
        return con;
    }

}


//    public static Conexao getInstacia() { // anterior
//        if (conexao == null) {
//            conexao = new Conexao();
//        }
//
//        return conexao;
//    }



