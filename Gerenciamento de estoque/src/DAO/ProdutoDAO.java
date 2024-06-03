package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Produto;

public class
ProdutoDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProdutoDAO() {
        this.conexao = Conexao.getInstacia();
    } 

    //Funcao de Cadastro de Produto
    public void inserirProduto(Produto produto){
        try{
            this.query = "INSERT INTO produto (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";
            this.ps = this.conexao.getCon().prepareStatement(query);
            this.ps.setString(1, produto.getNome());
            this.ps.setString(2, produto.getDescricao());
            this.ps.setInt(3, produto.getQuantidade());
            this.ps.setDouble(4, produto.getPreco());
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

    //Funcao de Listar Produtos
    public ResultSet listarProdutos(){
        try{
            this.query = "SELECT * FROM produto";
            this.ps = this.conexao.getCon().prepareStatement(query);
            return this.ps.executeQuery();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
