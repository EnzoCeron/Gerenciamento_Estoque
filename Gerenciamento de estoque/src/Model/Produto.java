package Model;

public class Produto {

    private int id;    
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, String descricao, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto (String nome, String descricao, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto (String nome){
        this.nome = nome;
    }


    public Produto(String nome,String descricao, int quantidade, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
