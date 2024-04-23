package View;
import java.util.Scanner;

import Model.Usuario;

public class LoginView {
    private Scanner sc;

    public LoginView() {
        sc = new Scanner(System.in);
    }

    public Usuario login(){
        System.out.println("----Login----");
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();

        return new Usuario(email, nome, senha);
    }


}
