package View;

import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CompraView {

    private Scanner sc;

    public CompraView() {
        sc = new Scanner(System.in);
    }

    public Produto Compra() {
        try {
            System.out.println("----Realizar a compra de um Produto----");
            System.out.println("Nome ou Id do produto que deseja comprar: ");
            String identificador = sc.nextLine();
            System.out.println("Quantidade que deseja comprar: ");
            int quantidade = Integer.parseInt(sc.nextLine());

            return new Produto(identificador, quantidade);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printCompraResult(ResultSet rs, Produto produto) {
        try {
            int quantidadeAtual = rs.getInt("quantidade");

            System.out.println("Quantidade antes da compra: " + quantidadeAtual);

            int novaQuantidade = quantidadeAtual + produto.getQuantidade();

            System.out.println("Produto comprado!");
            System.out.println("Quantidade Atual: " + novaQuantidade);
            System.out.println("---------------------------- \n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}