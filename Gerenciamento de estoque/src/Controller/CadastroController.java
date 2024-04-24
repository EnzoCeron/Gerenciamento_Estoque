package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.CadastroView;

public class CadastroController {

    private CadastroView cv;
    private Usuario usuario;
    private UsuarioDAO ud;

    public CadastroController() {
        this.cv = new CadastroView();
        this.usuario = this.cv.cadastrarUsuario();
        this.ud = new UsuarioDAO();
        this.ud.inserirUsuario(this.usuario);
        

    }
    
}
