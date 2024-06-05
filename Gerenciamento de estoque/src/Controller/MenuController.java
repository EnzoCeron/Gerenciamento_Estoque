package Controller;

import View.MenuView;

public class MenuController {

    private CadastroController cc;
    private ListarUserController luc;
    private CadastroProdController cpc;
    private ListarProdController lpc;
    private MenuView mv;
    private ExclusaoUsuarioController euc;
    private PesquisarProdController ppc;
    private VendaController vc;
    private int opcao;

    public MenuController() {
       
        this.mv = new MenuView();

        while (this.opcao != 99) {
            this.opcao = this.mv.menu();

            if(this.opcao == 1){
                //cadastro de usuario
                this.cc = new CadastroController();
            }else if(this.opcao == 2){
                //listar usuarios
                this.luc = new ListarUserController();        
            }else if(this.opcao == 3){
                //excluir usuario
                this.euc = new ExclusaoUsuarioController();
            }else if(this.opcao == 4){
                //cadastrar produto
                this.cpc = new CadastroProdController();
            }else if(this.opcao == 5){
                //listar produtos
                this.lpc = new ListarProdController();
            }else if(this.opcao == 6){
                //pesquisar produtos
                this.ppc = new PesquisarProdController();

            }else if(this.opcao == 7){
                //excluir produto

            }else if(this.opcao == 8){
                //atualizar produto

            }else if(this.opcao == 9){
                //realizar venda
                this.vc = new VendaController();

            }else if(this.opcao == 10){
                //realizar compra

            }else if(this.opcao == 11){
                //relatorio de compras e vendas

            }else {
                this.mv.opcaoInvalida();
            }
                
        }

    }
}