package Test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lista {
    private Elemento primeiro;
    private Elemento ultimo;
    private Elemento atual1;
    private List<String> setCaminho = new ArrayList<>(); 
    private List<String> setNiveis = new ArrayList<>();
    private int peso=0;

    List<String> getNiveis(){
        return this.setNiveis;
    }
    int getPeso(){
        return this.peso;
    }
    void add(String novaCidade, int novoNivel, Elemento novoPai){

        Elemento element = new Elemento(novaCidade,novoNivel,novoPai,null);
        if(this.primeiro==null){
            this.primeiro=element;
            this.ultimo=primeiro;
            this.primeiro.setAnterior(null);
        }else{
            this.ultimo.setProx(element);   
            this.ultimo=element;
            this.ultimo.setAnterior(atual1);
        }
        atual1=element;
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
    void setPrimeiro(String novoPrimeiro, int novoNivel, Elemento novoPai){
        this.primeiro.setCidade(novoPrimeiro);
        this.primeiro.setPai(novoPai);
        this.primeiro.setNivel(novoNivel);
    }
    void setUltimo(String novoUltimo, int novoNivel, Elemento novoPai){
        this.ultimo.setCidade(novoUltimo);
        this.ultimo.setPai(novoPai);
        this.ultimo.setNivel(novoNivel);
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
    boolean isEmpty(){
        if(this.primeiro==null)return true;
        else return false;
     }

    public List<String> Gerar_Grafo(String arq) {

		List<String> grafo = new ArrayList<>();

		try {
			File arquivo = new File(arq);
			Scanner scanner = new Scanner(arquivo);
			if (scanner.hasNextLine()) {
				scanner.nextLine();
				while (scanner.hasNextLine()) {
					String linha = "[" + scanner.nextLine() + "]";
					grafo.add(linha);

				}
			}
            scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
        
		return grafo;
	}
    public String[] Gerar_No(String arq) {
		String node = null;
		try {
			File arquivo = new File(arq);
			Scanner scanner = new Scanner(arquivo);
			node = scanner.nextLine();
            scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
		String[] nos = node.split(",\\s*");
		return nos;
	}

    void Busca(String inicio, String fim, String[] nos, List<String> grafo) {
    this.setNiveis.clear();
    List<String> niveis = new ArrayList<>();
    niveis.add(inicio + "0");

    int ind = 0;
    boolean parada = false;
    Lista l1 = new Lista();
    Lista l2 = new Lista();
    l1.AddUltimo(inicio, 0, null);
    l2.AddUltimo(inicio, 0, null);
    Map<String, String> pai = new HashMap<>();
    pai.put(inicio, null);
    while (!l1.isEmpty()) {
        Elemento atual = l1.DeletarPrimeiro();

        for (int i = 0; i < nos.length; i++) {
            if (nos[i].equals(atual.getCidade())) {
                ind = i;
            }
        }

        String novo = grafo.get(ind);
        novo = novo.replaceAll("[\\[\\]]", "");
        String[] letras = novo.split(",");

        for (int j = 0; j < letras.length; j++) {
            if (!pai.containsKey(letras[j])) {
                l1.AddUltimo(letras[j], atual.getNivel() + 1, atual);
                l2.AddUltimo(letras[j], atual.getNivel() + 1, atual);
                niveis.add(letras[j] + Integer.toString(atual.getNivel() + 1));
                pai.put(letras[j], atual.getCidade());
            
                if (letras[j].equals(fim)) {
                    parada = true;
                    break;
                }
            }
        }
            if (parada) {
            break;
        }   
    }
        if (parada) {
        String noAtual = fim;
        List<String> caminho = new ArrayList<>();
        while (noAtual != null) {
            caminho.add(noAtual);
            noAtual = pai.get(noAtual);
        }
        Collections.reverse(caminho);
        System.out.println("Caminho encontrado: " + caminho);
        this.setCaminho.clear();
        this.setCaminho.addAll(caminho);
        this.peso=(caminho.size()-1);
        this.setNiveis.addAll(niveis);
    } else {
        System.out.println("Caminho não encontrado.");
    }
}

    void AddUltimo(String estado, int nivel, Elemento pai) {
		Elemento no = new Elemento(estado, nivel, pai, null);

		if (this.primeiro == null) {
			this.primeiro = no;
			this.ultimo = no;
		} else {
			this.ultimo.setProx(no);
			no.setAnterior(this.ultimo);
			this.ultimo = no;
		}
	}
    Elemento DeletarPrimeiro() {
		if (this.primeiro == null) {
			System.out.println("Não há nada na lista!");
			return null;
		} else {
			Elemento no = this.primeiro;
			this.primeiro = this.primeiro.getProx();
			if (this.primeiro != null) {
				this.primeiro.setAnterior(null);
			} else {
				this.primeiro = null;
			}
			return no;
		}
	}
    Elemento DeletarUltimo(){
        if (this.primeiro == null) {
			System.out.println("Não há nada na lista!");
			return null;
		} else {
			Elemento no = this.ultimo;
			this.ultimo = this.ultimo.getAnterior();
			if (this.ultimo != null) {
				this.ultimo.setProx(no);
			} else {
				this.primeiro = null;
			}
			return no;
		}
    }

    void BuscaProfundidade(String inicio, String fim, String[] nos, List<String> grafo) {
        this.setNiveis.clear();
        List<String> niveis = new ArrayList<>();
        niveis.add(inicio + "0");

        int ind = 0;
        boolean parada = false;
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        l1.AddUltimo(inicio, 0, null);
        l2.AddUltimo(inicio, 0, null);
        Map<String, String> pai = new HashMap<>();
        pai.put(inicio, null);
        while (l1.isEmpty()==false) {
            Elemento atual = l1.DeletarUltimo();

            for (int i = 0; i < nos.length; i++) {
                if (nos[i].equals(atual.getCidade())) {
                    ind = i;
                }
            }

            String novo = grafo.get(ind);
            novo = novo.replaceAll("[\\[\\]]", "");
            String[] letras = novo.split(",");

            for (int j = 0; j < letras.length; j++) {
                if (!pai.containsKey(letras[j])) {
                    l1.AddUltimo(letras[j], atual.getNivel() + 1, atual);
                    l2.AddUltimo(letras[j], atual.getNivel() + 1, atual);
                    niveis.add(letras[j] + Integer.toString(atual.getNivel() + 1));
                    pai.put(letras[j], atual.getCidade());

                    if (letras[j].equals(fim)) {
                        parada = true;
                        break;
                    }
                }
            }

                if (parada) {
                break;
            }
        }
            if (parada) {
            String noAtual = fim;
            List<String> caminho = new ArrayList<>();
            while (noAtual != null) {
                caminho.add(noAtual);
                noAtual = pai.get(noAtual);
            }
            Collections.reverse(caminho);
            System.out.println("Caminho encontrado: " + caminho);
            this.setCaminho.clear();
            this.setCaminho.addAll(caminho);
            this.peso=(caminho.size()-1);
            this.setNiveis.addAll(niveis);

            
        } else {
            System.out.println("Caminho não encontrado.");
        }
    }

    public void buscaBidirecional(String inicio, String fim, String[] nos, List<String> grafo) {
        this.setCaminho.clear();
        this.setNiveis.clear();
        List<String> niveis = new ArrayList<>();
        niveis.add(inicio + "0");

        Lista l1 = new Lista();
        Lista l2 = new Lista();
        Lista l3 = new Lista();
        Lista l4 = new Lista();
        l1.AddUltimo(inicio, 0, null);
        l2.AddUltimo(inicio, 0, null);
        l3.AddUltimo(fim, 0, null);
        l4.AddUltimo(fim, 0, null);
    
        List<String[]> visitado1 = new ArrayList<>();
        List<String[]> visitado2 = new ArrayList<>();
        
        Map<String, String> pai1 = new HashMap<>();
        Map<String, String> pai2 = new HashMap<>();
        
        int ni = 0;
    
        pai1.put(inicio, null);
        pai2.put(fim, null);
    
        while (!l1.isEmpty() || !l3.isEmpty()) {
            while (!l1.isEmpty()) {
                if (ni != l1.primeiro.getNivel()) break;
                Elemento atual = l1.DeletarPrimeiro();
                int ind = Arrays.asList(nos).indexOf(atual.getCidade());
                String novo = grafo.get(ind);
                novo = novo.replaceAll("[\\[\\]]", "");
                String[] letras = novo.split(",");
                
                for (String letra : letras) {
                    boolean flag = true;
                    for (String[] visitado : visitado1) {
                        if (visitado[0].equals(letra)) {
                            if (Integer.parseInt(visitado[1]) <= atual.getNivel() + 1) {
                                flag = false;
                            } else {
                                visitado[1] = Integer.toString(atual.getNivel() + 1);
                            }
                            break;
                        }
                    }
                    
                    if (flag) {
                        l1.AddUltimo(letra, atual.getNivel() + 1, atual);
                        l2.AddUltimo(letra, atual.getNivel() + 1, atual);
                        visitado1.add(new String[]{letra, Integer.toString(atual.getNivel() + 1)});
                        niveis.add(letras + Integer.toString(atual.getNivel() + 1));
                        pai1.put(letra, atual.getCidade());
                        flag = false;
                        for (String[] visitado : visitado2) {
                            if (visitado[0].equals(letra)) {
                                flag = true;
                                break;
                            }
                        }
                        
                        if (flag) {
                            List<String> caminho = new ArrayList<>();
                            caminho.addAll(l2.exibirCaminho());
                            caminho.addAll(l4.exibirCaminho1(letra));
                            System.out.println(caminho);
                            this.setCaminho.addAll(caminho);
                            this.peso=(caminho.size()-1);
                        }
                    }
                }
            }
            
            while (!l3.isEmpty()) {
                if (ni != l3.primeiro.getNivel()) break;
                Elemento atual = l3.DeletarPrimeiro();
                int ind = Arrays.asList(nos).indexOf(atual.getCidade());
                String novo = grafo.get(ind);
                novo = novo.replaceAll("[\\[\\]]", "");
                String[] letras = novo.split(",");
                
                for (String letra : letras) {
                    boolean flag = true;
                    for (String[] visitado : visitado2) {
                        if (visitado[0].equals(letra)) {
                            if (Integer.parseInt(visitado[1]) <= atual.getNivel() + 1) {
                                flag = false;
                            } else {
                                visitado[1] = Integer.toString(atual.getNivel() + 1);
                            }
                            break;
                        }
                    }
                    
                    if (flag) {
                        l3.AddUltimo(letra, atual.getNivel() + 1, atual);
                        l4.AddUltimo(letra, atual.getNivel() + 1, atual);
                        visitado2.add(new String[]{letra, Integer.toString(atual.getNivel() + 1)});
                        pai2.put(letra,atual.getCidade());
                        niveis.add(letras + Integer.toString(atual.getNivel() + 1));
                    
                    flag = false;
                    for (String[] visitado : visitado1) {
                        if (visitado[0].equals(letra)) {
                            flag = true;
                            break;
                        }
                    }
                    
                    if (flag) {
                        List<String> caminho = new ArrayList<>();
                        caminho.addAll(l4.exibirCaminho());
                        caminho.addAll(l2.exibirCaminho1(letra));
                        Collections.reverse(caminho);
                        System.out.println(caminho);
                        this.setCaminho.addAll(caminho);
                        this.peso+=(caminho.size()-1);
                        this.setNiveis.addAll(niveis);

                    }
                }
            }
        }
        
        ni++; 
    }
    
}


List<String> exibirCaminho() {
    List<String> caminho = new ArrayList<>();
    Elemento aux = this.ultimo;
    while (aux != null) {
        caminho.add(aux.getCidade());
        aux = aux.getPai();
    }
    Collections.reverse(caminho);
    return caminho;
}
List<String> exibirCaminho1(String destino) {
    List<String> caminho = new ArrayList<>();
    Elemento aux = this.ultimo;
    while (aux != null && !aux.getCidade().equals(destino)) {
        caminho.add(aux.getCidade());
        aux = aux.getPai();
    }
    caminho.add(destino); 
    Collections.reverse(caminho); 
    return caminho;
}

List<String> getCaminho(){
    return this.setCaminho;
}

void BuscaProfundidadeLimitada(String inicio, String fim, String[] nos, List<String> grafo, int limite) {
    int ind = 0;
       boolean parada = false;
       List<String> niveis = new ArrayList<>();
       niveis.add(inicio + "0");
       Lista l1 = new Lista();
       l1.AddUltimo(inicio, 0, null);
       Map<String, String> pai = new HashMap<>();
       pai.put(inicio, null);

       while (!l1.isEmpty()) {
           Elemento atual = l1.DeletarUltimo();
           if (atual.getNivel() <= limite) {
               for (int i = 0; i < nos.length; i++) {
                   if (nos[i].equals(atual.getCidade())) {
                       ind = i;
                       break;
                   }
               }
               String novo = grafo.get(ind);
               novo = novo.replaceAll("[\\[\\]]", "");
               String[] letras = novo.split(",");
               for (int j = 0; j < letras.length; j++) {
                   if (!pai.containsKey(letras[j])) {
                       l1.AddUltimo(letras[j], atual.getNivel() + 1, atual);
                       pai.put(letras[j], atual.getCidade());
                       niveis.add(letras[j] + Integer.toString(atual.getNivel() + 1));
                       if (letras[j].equals(fim)) {
                           parada = true;
                           break;
                       }
                   }
               }
           }
           if (parada) {
               break;
           }
       }
       if (parada) {
           String noAtual = fim;
           List<String> caminho = new ArrayList<>();
           while (noAtual != null) {
               caminho.add(noAtual);
               noAtual = pai.get(noAtual);
           }
           Collections.reverse(caminho);
          // System.out.println("Lista Niveis-> " + niveis);
           System.out.println("Custo: " + (caminho.size() - 1));
           System.out.println("Caminho encontrado: " + caminho);
           this.setCaminho.clear();
           this.setCaminho.addAll(caminho);
           this.peso=(caminho.size()-1);
           this.setNiveis.clear();
           this.setNiveis.addAll(niveis);
       } else {
           System.out.println("Caminho nÃo encontrado dentro do limite de profundidade especificado.");
       }

    }

    void ProfundidadeInterativa(String inicio, String fim, String[] nos, List<String> grafo, int limite) {
	    this.setNiveis.clear();
        List<String> niveis = new ArrayList<>();
        niveis.add(inicio + "0");
            for (int l = 0; l < limite; l++) { 
	        int ind = 0;
	        boolean parada = false;
	        Lista l1 = new Lista();
	        Lista l2 = new Lista();
	        l1.AddUltimo(inicio, 0, null);
	        l2.AddUltimo(inicio, 0, null);
	        Map<String, String> pai = new HashMap<>();
	        pai.put(inicio, null);

	        while (!l1.isEmpty()) { 
	            Elemento atual = l1.DeletarUltimo(); 

	            for (int i = 0; i < nos.length; i++) { 
	                if (nos[i].equals(atual.getCidade())) {
	                    ind = i;
	                    break;
	                }
	            }
	            
	            if (l >= atual.getNivel()) { 
	                String novo = grafo.get(ind);
	                novo = novo.replaceAll("[\\[\\]]", "");
	                String[] letras = novo.split(",");

	                for (int j = 0; j < letras.length; j++) { 
	                    if (!pai.containsKey(letras[j])) {
	                        l1.AddUltimo(letras[j], atual.getNivel() + 1, atual);
	                        l2.AddUltimo(letras[j], atual.getNivel() + 1, atual);
                            niveis.add(letras[j] + Integer.toString(atual.getNivel() + 1));
	                        pai.put(letras[j], atual.getCidade());

	                        if (letras[j].equals(fim)) { 
	                            parada = true;
	                            break;
	                        }
	                    }
	                }

	                if (parada) { 
	                    break;
	                }
	            }
	        }

	        if (parada) { 
	            String noAtual = fim;
	            List<String> caminho = new ArrayList<>();
	            while (noAtual != null) {
	                caminho.add(noAtual);
	                noAtual = pai.get(noAtual);
	            }

	            Collections.reverse(caminho);
	            System.out.println("Caminho encontrado: " + caminho);
                this.setCaminho.clear();
                this.setCaminho.addAll(caminho);
                this.setNiveis.addAll(niveis);
                this.peso=(caminho.size()-1);

	            break; // Interrompe o loop externo, pois o caminho foi encontrado
	        } else {
	            System.out.println("Caminho não encontrado para o nível: " + l);
	        }
	    }
	}

}




