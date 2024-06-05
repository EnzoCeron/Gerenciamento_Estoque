package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.PesquisarProdView;

import java.sql.ResultSet;

public class PesquisarProdController {

        private PesquisarProdView pnv;
        private Produto produto;
        private ProdutoDAO pd;

        public PesquisarProdController() {
            this.pnv = new PesquisarProdView();
            this.produto = this.pnv.PesquisarProd();
            this.pd = new ProdutoDAO();
            ResultSet rs = this.pd.pesquisarProd(produto);
            this.pnv.printProdutoResultSet(rs);
        }
    }
