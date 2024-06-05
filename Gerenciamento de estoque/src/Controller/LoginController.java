package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.LoginView;

public class LoginController {

    private final LoginView lv;
    private final Usuario usuario;
    private final UsuarioDAO ud;
    private  MenuController mc;

    public LoginController() {
        this.lv = new LoginView();
        this.usuario = this.lv.login();
        this.ud = new UsuarioDAO();
        this.ud.LoginUsuario(this.usuario);
        boolean logado = this.ud.LoginUsuario(this.usuario);

        if(logado){
            this.mc = new MenuController();

        }else{
            System.out.println("Usuário inválido!");
            new LoginController();
        }
    }
}
    

