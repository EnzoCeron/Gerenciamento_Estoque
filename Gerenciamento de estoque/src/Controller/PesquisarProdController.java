package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.PesquisarProdView;

import java.sql.ResultSet;

public class PesquisarProdController {

        private final PesquisarProdView pnv;
        private final Produto produto;
        private final ProdutoDAO pd;

        public PesquisarProdController() {
            this.pnv = new PesquisarProdView();
            this.produto = this.pnv.PesquisarProd();
            this.pd = new ProdutoDAO();
            ResultSet rs = this.pd.pesquisarProd(produto);
            this.pnv.printProdutoResultSet(rs);
        }
    }
