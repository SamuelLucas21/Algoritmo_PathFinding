package Test1;

public class Lista {
    private Elemento primeiro;
    private Elemento ultimo;
    private int tamanho;
    private Elemento atual;

    void add(String novaCidade){
        Elemento element = new Elemento(novaCidade);
        if(this.primeiro==null){
            this.primeiro=element;
            this.ultimo=primeiro;
            this.primeiro.setAnterior(null);
        }else{
            this.ultimo.setProx(element);   
            this.ultimo=element;
            this.ultimo.setAnterior(atual);
        }
        atual=element;
    }
    void showProximos(){
        Elemento aux = primeiro;
            if(primeiro!=null){
                while(aux!=null){
                    System.out.println(aux.getCidade());
                    aux=aux.getProx();
                }
            }
    }
    void showAnteriores(){
        Elemento aux = ultimo;
            if(ultimo!=null){
                while(aux!=null){
                    System.out.println(aux.getCidade());
                    aux=aux.getAnterior();
                }
            }
    }
    Elemento getPrimeiro(){
        return this.primeiro;
    }
    Elemento getUltimo(){
        return this.ultimo;
    }
    void setPrimeiro(String novoPrimeiro){
        this.primeiro.setCidade(novoPrimeiro);
    }
    void setUltimo(String novoUltimo){
        this.ultimo.setCidade(novoUltimo);
    }

    int getSize(){
        Elemento aux = primeiro;
            if(primeiro!=null){
                while (aux!=null) {
                    aux=aux.getProx();
                    ++tamanho;
                }
            }
        return this.tamanho;
    }

    void removeFirst(){
        primeiro = primeiro.getProx();
        primeiro.setAnterior(null);
    }
    void removeLast(){
        ultimo = ultimo.getAnterior();
        ultimo.setProx(null);
    }
    void remover(String ElementoProcurado){
        Elemento aux = primeiro;
        if(this.primeiro!=null){
            while(aux!=null){
                if(ElementoProcurado == aux.getCidade()){
                    if(ElementoProcurado == primeiro.getCidade()) {
                        removeFirst();
                        break;
                    }else if(ElementoProcurado == ultimo.getCidade()) {
                        removeLast();
                        break;
                    }else{
                        aux.getAnterior().setProx(aux.getProx());
                        aux.getProx().setAnterior(aux.getAnterior());
                        break;
                        }
                    }
                    aux=aux.getProx();
                }

            }
        }
        
}




