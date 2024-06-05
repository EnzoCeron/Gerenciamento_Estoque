package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Produto;

public class ProdutoDAO {

    private final Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProdutoDAO() {
        this.conexao = Conexao.getInstancia();
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

        return null;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ResultSet pesquisarProd(Produto produto) {
        ResultSet rs = null;
        try {
            String identificador = produto.getIdentificador();
            if (isNumeric(identificador)) {
                int id = Integer.parseInt(identificador);
                this.query = "SELECT * FROM produto WHERE id_produto = ?";
                this.ps = this.conexao.getCon().prepareStatement(query);
                this.ps.setInt(1, id);
            } else {
                this.query = "SELECT * FROM produto WHERE nome = ?";
                this.ps = this.conexao.getCon().prepareStatement(query);
                this.ps.setString(1, identificador);
            }
            rs = this.ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet Venda(Produto produto) {
        ResultSet rs = null;
        try {
            String identificador = produto.getIdentificador();
            int quantidadeVendida = produto.getQuantidade();

            if (isNumeric(identificador)) {
                int id = Integer.parseInt(identificador);
                query = "SELECT quantidade FROM produto WHERE id_produto = ?";
                ps = conexao.getCon().prepareStatement(query);
                ps.setInt(1, id);
            } else {
                query = "SELECT quantidade FROM produto WHERE nome = ?";
                ps = conexao.getCon().prepareStatement(query);
                ps.setString(1, identificador);
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                int quantidadeAtual = rs.getInt("quantidade");

                if (quantidadeAtual >= quantidadeVendida) {
                    int novaQuantidade = quantidadeAtual - quantidadeVendida;

                    if (isNumeric(identificador)) {
                        int id = Integer.parseInt(identificador);
                        query = "UPDATE produto SET quantidade = ? WHERE id_produto = ?";
                        ps = conexao.getCon().prepareStatement(query);
                        ps.setInt(1, novaQuantidade);
                        ps.setInt(2, id);
                    } else {
                        query = "UPDATE produto SET quantidade = ? WHERE nome = ?";
                        ps = conexao.getCon().prepareStatement(query);
                        ps.setInt(1, novaQuantidade);
                        ps.setString(2, identificador);
                    }

                    ps.executeUpdate();
                }
            } else {
                System.out.println("Produto não existe!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet Compra(Produto produto) {
        ResultSet rs = null;
        try {
            String identificador = produto.getIdentificador();
            int quantidadeComprada = produto.getQuantidade();
            int quantidadeAtual = 0;

            PreparedStatement ps;
            String query;

            if (isNumeric(identificador)) {
                int id = Integer.parseInt(identificador);
                query = "SELECT quantidade FROM produto WHERE id_produto = ?";
                ps = conexao.getCon().prepareStatement(query);
                ps.setInt(1, id);
            } else {
                query = "SELECT quantidade FROM produto WHERE nome = ?";
                ps = conexao.getCon().prepareStatement(query);
                ps.setString(1, identificador);
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                quantidadeAtual = rs.getInt("quantidade");

                int novaQuantidade = quantidadeAtual + quantidadeComprada;

                if (isNumeric(identificador)) {
                    int id = Integer.parseInt(identificador);
                    query = "UPDATE produto SET quantidade = ? WHERE id_produto = ?";
                    ps = conexao.getCon().prepareStatement(query);
                    ps.setInt(1, novaQuantidade);
                    ps.setInt(2, id);
                } else {
                    query = "UPDATE produto SET quantidade = ? WHERE nome = ?";
                    ps = conexao.getCon().prepareStatement(query);
                    ps.setInt(1, novaQuantidade);
                    ps.setString(2, identificador);
                }

                ps.executeUpdate();
            }  else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Método editarProduto

    public void editarProduto(Produto produto) {
        try {
            this.query = "UPDATE produto SET descricao = ?, preco = ?  WHERE nome = ?";
            this.ps = this.conexao.getCon().prepareStatement(query);  // Padronizado para getCon()
            this.ps.setString(1, produto.getDescricao());
            this.ps.setDouble(2, produto.getPreco());
            this.ps.setString(3, produto.getNome());

            //executa atualizacao
            this.ps.executeUpdate();


            // fecha o preparedstatement
            this.ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}











