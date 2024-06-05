package View;

import Model.Produto;

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
}
