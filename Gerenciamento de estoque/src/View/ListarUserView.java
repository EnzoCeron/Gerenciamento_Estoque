package View;

import java.sql.ResultSet;

public class ListarUserView {

    public void listarUsuarios(ResultSet lista) {
        System.out.println("----Lista de Usuarios----\n");
        try {
            while (lista.next()) {
                System.out.println("Nome: " + lista.getString("nome"));
                System.out.println("Email: " + lista.getString("email"));
                //System.out.println("Senha: " + lista.getString("senha"));
                System.out.println("---------------------------- \n");
            }
        } 
        catch (Exception e) {
            System.out.println("Erro ao listar usuarios");
        }
    }
    













    
}