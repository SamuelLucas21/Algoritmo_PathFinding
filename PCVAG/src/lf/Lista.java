package lf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gpt.Lista;
import gpt.No;

public class Lista {
	private Elemento head;
	private Elemento tail;

	// Insere no inicio da lista
	void addPrimeiro(String st, int nivel, String pai) {
		Elemento novo_no = new Elemento(pai, st, nivel, null, null);

		if (this.head == null) {
			this.tail = novo_no;
			this.head = novo_no;
		} else {
			novo_no.setProximo(this.head);
			this.head.setAnterior(novo_no);
			this.head = novo_no;
		}
	}

	// Insere no último da lista
	void addUltimo(String st, int nivel, String pai) {
		Elemento novo_no = new Elemento(pai, st, nivel, null, null);

		if (this.tail == null) {
			this.tail = novo_no;
			this.head = novo_no;
		} else {
			novo_no.setAnterior(this.tail);
			this.tail.setProximo(novo_no);
			this.tail = novo_no;
		}
	}

	// Deleta o primeiro
	Elemento deleteFirst() {
		this.head = this.head.getProximo();
		if (this.head == null) {
			System.out.println("Não ha nada na lista");
			return null;
		} else {
			Elemento no = this.head;
			this.head = this.tail.getAnterior();

			if (this.tail != null) {
				this.tail.setProximo(null);
			} else {
				this.head = null;
			}
			return no;
		}
	}

	// Deleta o último
	Elemento deleteLast() {
		this.head = this.head.getProximo();
		if (this.head == null) {
			System.out.println("Não ha nada na lista");
			return null;
		} else {
			Elemento no = this.head;
			this.head = this.tail.getAnterior();

			if (this.tail != null) {
				this.tail.setProximo(null);
			} else {
				this.head = null;
			}
			return no;
		}
	}

	// Mostra o primeiro

	// Mostra todos da lista
	void showLista() {
		Elemento aux = head;
		if (head != null) {
			while (aux != null) {
				System.out.println(aux.getEstado());
				aux = aux.getProximo();
			}
		}
	}

	// Verifica se está vazia
	boolean vazio() {

		if (this.head == null) {
			return true;
		} else {
			return false;
		}
	}

	public List<String> amplitude(String inicio, String fim, String[] nos, List<String[]> grafo) {
		Lista l1 = new Lista();
		Lista l2 = new Lista();
		l1.addUltimo(inicio, 0, null);
		l2.addUltimo(inicio, 0, null);

		List<String[]> visitado = new ArrayList<>();
		String[] linha = { inicio, "0" };
		visitado.add(linha);

		while (!l1.vazio()) {
			Elemento atual = l1.deleteLast();

			for (String[] novo : grafo) {
				boolean flag = true;
				for (String[] visit : visitado) {
					if (visit[0].equals(novo[0])) {
						if (Integer.parseInt(visit[1]) <= (atual.nivel + 1)) {
							flag = false;
						} else {
							visit[1] = String.valueOf(atual.nivel + 1);
						}
						break;
					}
				}
				int ind = -1;
				for (int i = 0; i < nos.length; i++) {
					if (nos[i].equals(atual.estado)) {
						ind = i;
						break;
					}
				}
				if (flag) {
					l1.addUltimo(novo[0], atual.nivel + 1, atual);
					l2.addUltimo(novo[0], atual.nivel + 1, atual);

					String[] novaLinha = { novo[0], String.valueOf(atual.nivel + 1) };
					visitado.add(novaLinha);

					if (novo[0].equals(fim)) {
						List<String> caminho = l2.exibeCaminho();
						return caminho;
					}
				}
			}
		}
		return new ArrayList<>();
	}

	List<String> exibeCaminho() {
		// Elemento aux = this.ultimo;
		List<String> Caminho = new ArrayList<>();

		// while (aux.getPai() != null) {
		// Caminho.add(aux.getCidade());
		// aux = aux.getPai();
		// }
		// Caminho.add(aux.getCidade());
		Collections.reverse(Caminho);
		return Caminho;
	}
}
