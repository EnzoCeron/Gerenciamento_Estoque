package View;

import Model.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VendaView {

    private Scanner sc;

    public VendaView() { sc = new Scanner(System.in); }

    public Produto Venda() {
        try {
            System.out.println("----Realizar a venda de um Produto----");
            System.out.println("Nome ou Id do produto que deseja vender: ");
            String identificador = sc.nextLine();
            System.out.println("Quantidade que deseja vender: ");
            int quantidade = Integer.parseInt(sc.nextLine());

            return new Produto(identificador, quantidade);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printVendaResult(ResultSet rs, Produto produto) {
        try {
            int quantidadeAtual = rs.getInt("quantidade");

            System.out.println("Quantidade antes da venda: " + quantidadeAtual);

            if (quantidadeAtual >= produto.getQuantidade()) {
                int novaQuantidade = quantidadeAtual - produto.getQuantidade();

                System.out.println("Produto vendido!");
                System.out.println("Quantidade Atual: " + novaQuantidade);
                System.out.println("---------------------------- \n");
            } else {
                System.out.println("Quantidade insuficiente para a venda.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}