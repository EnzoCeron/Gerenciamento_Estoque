package View;

import Model.Produto;

import java.util.Scanner;

public class VendaView {

    private Scanner sc;

    public VendaView() { sc = new Scanner(System.in); }

    public Produto Venda(){
        try{
            System.out.println("----Realizar a venda de um Produto----");
            System.out.println("Nome ou Id do produto que deseja vender: ");
            String identificador = sc.nextLine();
            System.out.println("Quantidade que deseja vender: ");
            int quantidade = Integer.parseInt(sc.nextLine());

            return new Produto(identificador,quantidade);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}