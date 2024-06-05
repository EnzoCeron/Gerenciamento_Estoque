package View;

import Model.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PesquisarProdView {

    private Scanner sc;

    public PesquisarProdView() { sc = new Scanner(System.in); }

    public Produto PesquisarProd(){
        try{
            System.out.println("----Pesquisar produto por nome ou id----");
            System.out.println("Nome ou Id do produto: ");
            String prod = sc.nextLine();

            return new Produto(prod);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void printProdutoResultSet(ResultSet rs) {
        try {
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
    }
}
