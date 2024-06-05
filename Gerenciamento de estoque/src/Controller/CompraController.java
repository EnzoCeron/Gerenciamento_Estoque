package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.CompraView;

import java.sql.ResultSet;
public class CompraController {

    private CompraView cv;
    private Produto produto;
    private ProdutoDAO cd;

    public CompraController() {
        this.cv = new CompraView();
        this.cd = new ProdutoDAO();
        Produto produto = this.cv.Compra();
        ResultSet rs = this.cd.Compra(produto);
        this.cv.printCompraResult(rs, produto);
    }
}