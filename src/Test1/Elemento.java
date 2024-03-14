package Test1;

public class Elemento {
    private String cidade;    
    private Elemento prox;
    private Elemento anteiro;

    public Elemento(String novaCidade){
        this.cidade=novaCidade;
        this.prox=null;
        this.anteiro=null;
    }
    public String getCidade(){
        return this.cidade;
    }
    public void setCidade(String novaCidade){
        this.cidade=novaCidade;
    }
    public Elemento getProx(){
        return this.prox;
    }
    public void setProx(Elemento novoProx){
        this.prox=novoProx;
    }
    public Elemento getAnterior(){
        return this.anteiro;
    }
    public void setAnterior(Elemento novoAnteiro){
        this.anteiro=novoAnteiro;   
    }
}
