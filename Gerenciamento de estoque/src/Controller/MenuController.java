package Controller;

import View.MenuView;

public class MenuController {


    private CadastroController cc;
    private MenuView mv;
    private int opcao;

    public MenuController() {
       
        this.mv = new MenuView();

        while (this.opcao != 3) {
            this.opcao = this.mv.menu();

            if(this.opcao == 1){
                this.cc = new CadastroController();
            }else if(this.opcao == 2){
                
            }else{ 
                this.mv.opcaoInvalida();
            }
        }

    }
}