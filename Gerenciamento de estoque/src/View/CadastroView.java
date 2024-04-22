package View;

import java.util.Scanner;

import Model.Usuario;

public class CadastroView {

    private Scanner sc;

    public CadastroView() {
        sc = new Scanner(System.in);
    }

    public Usuario cadastrarUsuario(){
        System.out.println("----Cadastro de Usuario----");
        System.out.println("Email: ");;
        String email = sc.nextLine();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();
        System.out.println("Usuario cadastrado com sucesso!");
        
        return new Usuario(email, nome, senha);

    }






}
