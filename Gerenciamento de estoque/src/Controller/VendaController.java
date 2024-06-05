package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.VendaView;

import java.sql.ResultSet;

public class VendaController {

    private VendaView vv;
    private Produto produto;
    private ProdutoDAO pd;

    public VendaController() {
        this.vv = new VendaView();
        this.pd = new ProdutoDAO();
        Produto produto = this.vv.Venda();
        ResultSet rs = this.pd.Venda(produto);
        this.vv.printVendaResult(rs, produto);
    }
}
