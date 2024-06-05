package DAO;

import java.sql.Connection;
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
        this.conexao = Conexao.getInstancia();
    }

    //Funcao de Cadastro de Produto
    public void inserirProduto(Produto produto) {
        try {
            this.query = "INSERT INTO produto (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";
            this.ps = this.conexao.getCon().prepareStatement(query);
            this.ps.setString(1, produto.getNome());
            this.ps.setString(2, produto.getDescricao());
            this.ps.setInt(3, produto.getQuantidade());
            this.ps.setDouble(4, produto.getPreco());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Funcao de Listar Produtos
    public ResultSet listarProdutos() {
        try {
            this.query = "SELECT * FROM produto";
            this.ps = this.conexao.getCon().prepareStatement(query);
            return this.ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Método editarProduto

    public void editarProduto(Produto produto) {
        try {
            this.query = "UPDATE produto SET descricao = ?, preco = ?, WHERE nome = ?";
            this.ps = this.conexao.getCon().prepareStatement(query);  // Padronizado para getCon()
            this.ps.setString(1, produto.getNome());
            this.ps.setString(2, produto.getDescricao());
            this.ps.setDouble(3, produto.getPreco());


            //executa atualizacao
            this.ps.executeUpdate();


            // fecha o preparedstatement
            this.ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Excluir produto

    public void excluirProduto(Produto nome) {

        try {
            // Verifica se o produto existe antes de tentar excluí-lo
            if (verificaProdutoExiste(nome)) {
                // Prepara a query SQL para deletar um produto pelo nome
                this.query = "DELETE FROM produto WHERE nome = ?";
                this.ps = this.conexao.getCon().prepareStatement(query);  // Utiliza a classe 'conexao' que gerencia a conexão com o banco de dados

                // Define o nome do produto no PreparedStatement
                this.ps.setString(1, String.valueOf(nome));

                // Executa a atualização
                int affectedRows = this.ps.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Produto excluído com sucesso!");
                } else {
                    System.out.println("Nenhum produto encontrado com o nome: " + nome);
                }

                // Fecha o PreparedStatement
                this.ps.close();
            } else {
                System.out.println("Produto com o nome " + nome + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //davi
    public boolean verificaProdutoExiste(Produto nome) {
        String sql = "SELECT COUNT(*) FROM produto WHERE nome = ?";

        try (Connection conn = this.conexao.getCon(); //
             PreparedStatement ps = ((Connection) conn).prepareStatement(sql)) {

            ps.setString(1, String.valueOf(nome)); // Define o nome do produto no PreparedStatement

            ResultSet rs = ps.executeQuery(); // Executa a consulta
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se o count for maior que 0
            }
            return false; // Retorna false se não houver registros
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a existência do produto: " + e.getMessage());
            return false; // Retorna false em caso de exceção
        }
    }


}














