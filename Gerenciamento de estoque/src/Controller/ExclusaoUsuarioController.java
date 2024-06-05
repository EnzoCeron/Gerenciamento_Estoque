package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import View.ExclusaoUsuarioView;
public class ExclusaoUsuarioController {

    private final ExclusaoUsuarioView euv;
    private final Usuario usuario;
    private final UsuarioDAO ud;

    public ExclusaoUsuarioController() {
        this.euv = new ExclusaoUsuarioView();
        this.usuario = this.euv.ExclusaoUsuario();
        this.ud = new UsuarioDAO();
        this.ud.excluirUsuario(this.usuario);
    }
}
