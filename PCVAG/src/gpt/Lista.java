package gpt;

import java.util.ArrayList;
import java.util.List;

class No {
    No pai;
    String estado;
    int nivel;
    No anterior;
    No proximo;

    public No(No pai, String estado, int nivel, No anterior, No proximo) {
        this.pai = pai;
        this.estado = estado;
        this.nivel = nivel;
        this.anterior = anterior;
        this.proximo = proximo;
    }
}

class Lista {
    No head;
    No tail;

    // INSERE NO INÍCIO DA LISTA
    public void inserePrimeiro(String st, int ni, No p) {
        No novo_no = new No(p, st, ni, null, null);
        if (head == null) {
            tail = novo_no;
            head = novo_no;
        } else {
            novo_no.proximo = head;
            head.anterior = novo_no;
            head = novo_no;
        }
    }

    // INSERE NO FIM DA LISTA
    public void insereUltimo(String st, int ni, No p) {
        No novo_no = new No(p, st, ni, null, null);
        if (head == null) {
            head = novo_no;
            tail = novo_no;
        } else {
            tail.proximo = novo_no;
            novo_no.anterior = tail;
            tail = novo_no;
        }
    }

    // REMOVE NO INÍCIO DA LISTA
    public No deletaPrimeiro() {
        if (head == null) {
            return null;
        } else {
            No no = head;
            head = head.proximo;
            if (head != null) {
                head.anterior = null;
            } else {
                tail = null;
            }
            return no;
        }
    }

    // REMOVE NO FIM DA LISTA
    public No deletaUltimo() {
        if (tail == null) {
            return null;
        } else {
            No no = tail;
            tail = tail.anterior;
            if (tail != null) {
                tail.proximo = null;
            } else {
                head = null;
            }
            return no;
        }
    }

    // RETORNA O PRIMEIRO DA LISTA
    public No primeiro() {
        return head;
    }

    // RETORNA O ÚLTIMO DA LISTA
    public No ultimo() {
        return tail;
    }

    // VERIFICA SE LISTA ESTÁ VAZIA
    public boolean vazio() {
        return head == null;
    }

    // EXIBE O CONTEÚDO DA LISTA
    public List<String[]> exibeLista() {
        No aux = head;
        List<String[]> str1 = new ArrayList<>();
        while (aux != null) {
            String[] temp = {aux.estado, String.valueOf(aux.nivel)};
            str1.add(temp);
            aux = aux.proximo;
        }
        return str1;
    }

    // EXIBE O CAMINHO ENCONTRADO
    public List<String> exibeCaminho() {
        No atual = tail;
        List<String> caminho = new ArrayList<>();
        while (atual.pai != null) {
            caminho.add(atual.estado);
            atual = atual.pai;
        }
        caminho.add(atual.estado);
        return caminho;
    }

    // EXIBE O CAMINHO ENCONTRADO (BIDIRECIONAL)
    public List<String> exibeCaminho1(String valor) {
        No atual = head;
        while (!atual.estado.equals(valor)) {
            atual = atual.proximo;
        }

        List<String> caminho = new ArrayList<>();
        atual = atual.pai;
        while (atual.pai != null) {
            caminho.add(atual.estado);
            atual = atual.pai;
        }
        caminho.add(atual.estado);
        return caminho;
    }
}

class Busca {
    
}
