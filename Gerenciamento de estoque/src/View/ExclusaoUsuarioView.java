package View;

import java.util.Scanner;

import Model.Usuario;
public class ExclusaoUsuarioView {

    private Scanner sc;

    public ExclusaoUsuarioView() { sc = new Scanner(System.in); }

    public Usuario ExclusaoUsuario() {
        try {
            System.out.println("----Exclusão de Usuario----");
            System.out.println("Email: ");
            String email = sc.nextLine();


            return new Usuario(email);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
