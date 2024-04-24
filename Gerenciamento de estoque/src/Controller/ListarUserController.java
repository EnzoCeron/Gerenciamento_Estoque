package Controller;

import DAO.UsuarioDAO;
import View.ListarUserView;

public class ListarUserController {
    
    private ListarUserView luv;
    private UsuarioDAO ud;

    public ListarUserController() {
        this.luv = new ListarUserView();
        this.ud = new UsuarioDAO();
        this.luv.listarUsuarios(this.ud.listarUsuarios());
    }
}
