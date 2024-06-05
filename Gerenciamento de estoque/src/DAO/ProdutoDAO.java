package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Produto;

public class ProdutoDAO {

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

            if (rs.next()) {
                System.out.println("Id: " + rs.getInt("id_produto"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Descricao: " + rs.getString("descricao"));
                System.out.println("Preço: R$ " + rs.getDouble("preco"));
                System.out.println("Quantidade Disponivel: " + rs.getInt("quantidade"));
                System.out.println("---------------------------- \n");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void Venda(Produto produto) {
        ResultSet rs = null;
        try {
            String identificador = produto.getIdentificador();
            int quantidadeVendida = produto.getQuantidade();
            int quantidadeAtual = 0;

            if (isNumeric(identificador)) {
                int id = Integer.parseInt(identificador);
                this.query = "SELECT quantidade FROM produto WHERE id_produto = ?";
                this.ps = this.conexao.getCon().prepareStatement(query);
                this.ps.setInt(1, id);
            } else {
                this.query = "SELECT quantidade FROM produto WHERE nome = ?";
                this.ps = this.conexao.getCon().prepareStatement(query);
                this.ps.setString(1, identificador);
            }

            rs = this.ps.executeQuery();

            if (rs.next()) {
                quantidadeAtual = rs.getInt("quantidade");

                if (quantidadeAtual >= quantidadeVendida) {
                    int novaQuantidade = quantidadeAtual - quantidadeVendida;

                    if (isNumeric(identificador)) {
                        int id = Integer.parseInt(identificador);
                        this.query = "UPDATE produto SET quantidade = ? WHERE id_produto = ?";
                        this.ps = this.conexao.getCon().prepareStatement(query);
                        this.ps.setInt(1, novaQuantidade);
                        this.ps.setInt(2, id);
                    } else {
                        this.query = "UPDATE produto SET quantidade = ? WHERE nome = ?";
                        this.ps = this.conexao.getCon().prepareStatement(query);
                        this.ps.setInt(1, novaQuantidade);
                        this.ps.setString(2, identificador);
                    }

                    this.ps.executeUpdate();

                    System.out.println("Produto vendido!");
                    System.out.println("Nome/Id: " + identificador);
                    System.out.println("Quantidade Vendida: " + quantidadeVendida);
                    System.out.println("Quantidade Atual: " + novaQuantidade);
                    System.out.println("---------------------------- \n");
                } else {
                    System.out.println("Quantidade insuficiente para a venda.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
