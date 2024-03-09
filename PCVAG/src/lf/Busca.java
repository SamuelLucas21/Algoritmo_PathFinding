package lf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Busca {
	
	Lista l1 = new Lista();
	Lista l2 = new Lista();
	
	public String Gerar_No(String arq) {

		String node = null;
		
		try {
			File arquivo = new File(arq);
			Scanner scanner = new Scanner(arquivo);
			node = scanner.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}

		return node;
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
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}

		return grafo;
	}
	
	public void aplitudde(String ini,String fim) {
		//l1.addUltimo(ini);
		//l2.addUltimo(ini);
		
		List<String> visitados = new ArrayList<>();
		List<String> linha = new ArrayList<>();
		linha.add(ini);
		linha.add("0");
		visitados.addAll(linha);
		
		
	}
}
