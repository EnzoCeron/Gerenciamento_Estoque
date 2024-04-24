package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.LoginView;

public class LoginController {

    private LoginView lv;
    private Usuario usuario;
    private UsuarioDAO ud;
    private MenuController mc;

    public LoginController() {
        this.lv = new LoginView();
        this.usuario = this.lv.login();
        this.ud = new UsuarioDAO();
        this.ud.LoginUsuario(this.usuario);
        boolean logado = this.ud.LoginUsuario(this.usuario);

        if(logado){
            System.out.println("Logado com sucesso!");
            this.mc = new MenuController();

        }else{  
            System.out.println("Usuario ou senha invalidos");
            new LoginController();
        }
    }
}
    

