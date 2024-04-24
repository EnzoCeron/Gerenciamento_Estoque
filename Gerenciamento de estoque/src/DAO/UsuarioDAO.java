package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuario;

public class UsuarioDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDAO() {
        this.conexao = Conexao.getInstacia();
    }

    //Funcao de verificacao de email dentro do banco
    private boolean verificarEmailExistente(String email) {
        this.query = "SELECT EXISTS(SELECT * FROM usuario WHERE email = ?)";
        try {
            this.ps = conexao.getCon().prepareStatement(query);
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1); 
                }
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    //Funcao de Cadastro de Usuario
    public void inserirUsuario(Usuario usuario){
        try{
            if (verificarEmailExistente(usuario.getEmail())) {
                System.out.println("\n");
                System.out.println("Email ja esta cadastrado no banco de dados \n");
            }
            else{
                this.query = "INSERT INTO usuario (email, nome, senha) VALUES (?, ?, ?)";
                this.ps = this.conexao.getCon().prepareStatement(query);
                this.ps.setString(1, usuario.getEmail());
                this.ps.setString(2, usuario.getNome());
                this.ps.setString(3, usuario.getSenha());
                this.ps.executeUpdate();
                System.out.println("\n");
                System.out.println("Usuario cadastrado com sucesso!");
                this.ps.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Funcao de Login de Usuario
    public boolean LoginUsuario(Usuario usuario) {
        try {
            this.query = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
            this.ps = this.conexao.getCon().prepareStatement(query);
            this.ps.setString(1, usuario.getEmail());
            this.ps.setString(2, usuario.getSenha()); 
            this.rs = this.ps.executeQuery();
            return rs.next(); // Retorna True se encontrar um usuario correspondente
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Funcao de Listar Usuarios
    public ResultSet listarUsuarios(){
        try{
            this.query = "SELECT * FROM usuario";
            this.ps = this.conexao.getCon().prepareStatement(query);
            return this.ps.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}