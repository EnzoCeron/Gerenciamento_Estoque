package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.CompraView;

import java.sql.ResultSet;
public class CompraController {

    private final CompraView cv;
    private final Produto produto;
    private final ProdutoDAO cd;

    public CompraController() {
        this.cv = new CompraView();
        this.cd = new ProdutoDAO();
        this.produto = this.cv.Compra();
        ResultSet rs = this.cd.Compra(produto);
        this.cv.printCompraResult(rs, produto);
    }
}