package View;

import java.sql.ResultSet;

public class ListarProdutoView {
    
    public void listarProdutos(ResultSet lista){
        System.out.println("-----Lista de Produtos----- \n");
        try{
            while(lista.next()){
                System.out.println("Id: " + lista.getString("id_produto"));
                System.out.println("Nome: " + lista.getString("nome"));
                System.out.println("Descricao: " + lista.getString("descricao"));
                System.out.println("Preço: R$ " + lista.getString("preco"));
                System.out.println("Quantidade Disponivel: " + lista.getString("quantidade"));
                System.out.println("---------------------------- \n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
