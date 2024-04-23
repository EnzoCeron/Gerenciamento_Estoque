package Controller;

import DAO.LoginDAO;
import Model.Usuario;
import View.LoginView;

public class LoginController {

    private LoginView lv;
    private Usuario usuario;
    private LoginDAO Ld;
    private MenuController mc;

    
        public LoginController() {
        this.lv = new LoginView();
        this.usuario = this.lv.login();
        this.Ld = new LoginDAO();
        this.Ld.LoginUsuario(this.usuario);
        boolean logado = this.Ld.LoginUsuario(this.usuario);

        if(logado){
            System.out.println("Logado com sucesso!");
            this.mc = new MenuController();

        }else{  
            System.out.println("Usuario ou senha invalidos");
            new LoginController();
        }
        }
    }
    

