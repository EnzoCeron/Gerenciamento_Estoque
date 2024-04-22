package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Usuario;

public class UsuarioDAO {


    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public UsuarioDAO() {
        this.conexao = Conexao.getInstacia();
    }

    public void inserirUsuario(Usuario usuario){
        try{
            this.query = "INSERT INTO usuario (email, nome, senha) VALUES (?, ?, ?)";
            this.ps = this.conexao.getCon().prepareStatement(query);
            this.ps.setString(1, usuario.getEmail());
            this.ps.setString(2, usuario.getNome());
            this.ps.setString(3, usuario.getSenha());
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
}




}