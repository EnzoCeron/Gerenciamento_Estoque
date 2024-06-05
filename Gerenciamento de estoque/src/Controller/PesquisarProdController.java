package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import View.PesquisarProdView;
    public class PesquisarProdController {

        private PesquisarProdView pnv;
        private Produto produto;
        private ProdutoDAO pd;

        public PesquisarProdController() {
            this.pnv = new PesquisarProdView();
            this.produto = this.pnv.PesquisarProd();
            this.pd = new ProdutoDAO();
            this.pd.pesquisarProd(this.produto);
        }
    }
