package View;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import Model.Usuario;

public class CadastroView {

    private Scanner sc;

    public CadastroView() {
        sc = new Scanner(System.in);
    }

    public Usuario cadastrarUsuario() {
        try{
            System.out.println("----Cadastro de Usuario----");
            System.out.println("Email: ");;
            String email = sc.nextLine();
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Senha: ");
            //Logica para implementacao do Hash na senha
            String senha = sc.nextLine();
            //Gera o Hash MD5 da senha
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte [] hashMD5 = md5.digest(senha.getBytes());
            //Converte o Hash para uma string Base64
            String hashMD5Base64 = Base64.getEncoder().encodeToString(hashMD5);
        
            return new Usuario(email, nome, hashMD5Base64);
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
}
