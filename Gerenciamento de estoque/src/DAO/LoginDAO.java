package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuario;

public class LoginDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    
        public LoginDAO() {
            this.conexao = Conexao.getInstacia(); // Assuming your Conexao class is correct
        }
    
        public boolean LoginUsuario(Usuario usuario) {
            String query = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
    
            try (PreparedStatement ps = this.conexao.getCon().prepareStatement(query)){
                ps.setString(1, usuario.getEmail());
                ps.setString(2, usuario.getSenha()); 
                
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next(); // Returns true if the user is found
                }
    
            } catch (SQLException e) {
                System.err.println("Error during login: " + e.getMessage());
                return false; 
            } 
        }
    }
    
