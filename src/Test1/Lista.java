package Test1;

import java.util.Random;

public class Lista {
    private Elemento primeiro;
    private Elemento ultimo;
    private Elemento atual;

    void add(String novaCidade, int novoNivel){
        Elemento element = new Elemento(novaCidade,novoNivel,null,null);
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
        int size = 0;
            if(primeiro!=null){
                while (aux!=null) {
                    aux=aux.getProx();
                    size++;
                }
            }
        return size;
    }

    Elemento removeFirst(){
        Elemento aux = primeiro;
        primeiro = primeiro.getProx();
        primeiro.setAnterior(null);
        return aux;
    }
    Elemento removeLast(){
        Elemento aux = ultimo;
        ultimo = ultimo.getAnterior();
        ultimo.setProx(null);
        return aux;
    }
    Elemento remover(String ElementoProcurado){
        Elemento aux = primeiro;
        Elemento retornar = aux;
        if(this.primeiro!=null){
            while(aux!=null){
                if(ElementoProcurado == aux.getCidade()){
                    if(ElementoProcurado == primeiro.getCidade()) {
                        return removeFirst();
                    }else if(ElementoProcurado == ultimo.getCidade()) {
                        return removeLast();
                        
                    }else{
                        retornar = aux;
                        aux.getAnterior().setProx(aux.getProx());
                        aux.getProx().setAnterior(aux.getAnterior());
                        return retornar;
                        }
                    }
                    aux=aux.getProx();
                }

            }
            return null;
        }
    
    void addRandom(String novaCidade){
        Elemento element = new Elemento(novaCidade, 0, null, null);
        Elemento aux = primeiro, auxprox;
        Random num = new Random();
		int num_random = num.nextInt(getSize());
            if(this.primeiro!=null){
                for(int i =1;i<num_random;i++){
                    aux=aux.getProx();
                }
                auxprox=aux.getProx();
                aux.setProx(element);
                aux.getProx().setAnterior(aux);
                aux=aux.getProx();
                aux.setProx(auxprox);
            }
    }


}




