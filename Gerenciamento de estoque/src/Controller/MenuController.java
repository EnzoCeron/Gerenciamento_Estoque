package Controller;

import View.MenuView;


public class MenuController {


    private CadastroController cc;
    private ListarUserController luc;
    private MenuView mv;
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

            }else if(this.opcao == 4){
                //cadastrar produto

            }else if(this.opcao == 5){
                //listar produtos

            }else if(this.opcao == 6){
                //pesquisar produto por nome

            }else if(this.opcao == 7){
                //pesquisar produto por codigo

            }else if(this.opcao == 8){
                //excluir produto


            }else if(this.opcao == 9){
                //atualizar produto

            }else if(this.opcao == 10){
                //realizar venda

            }else if(this.opcao == 11){
                //realizar compra

            }else if(this.opcao == 12){
                //relatorio de compras e vendas

            }else {
                this.mv.opcaoInvalida();
            }
                
        }

    }
}