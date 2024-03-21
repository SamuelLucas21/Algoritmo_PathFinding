package Test1;

public class Elemento {
    private String cidade;    
    private Elemento prox, anteiro,pai,filho;
    private int nivel;

    public Elemento(String novaCidade, int novoNivel, Elemento novoPai, Elemento novoFilho){
        this.cidade=novaCidade;
        this.prox=null;
        this.anteiro=null;
        this.nivel=novoNivel;
        this.pai=novoPai;
        this.filho=novoFilho;
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
    public Elemento getPai(){
        return this.pai;
    }
    public void setPai(Elemento novoPai){
        this.pai=novoPai;
    }
    public Elemento getFilho(){
        return this.filho;
    }
    public void setFilho(Elemento novoFilho){
        this.filho=novoFilho;
    }
    public int getNivel(){
        return this.nivel;
    }
    public void setNivel(int novoNivel){
        this.nivel=novoNivel;
    }

    
}
