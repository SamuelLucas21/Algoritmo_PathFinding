package lf;

import java.util.List;

public class Teste {

	public static void main(String args[]) {

		String arq = "/home/igor/hdsecundario/LabEclipse/PCVAG/src/lf/grafo.txt";

		Busca b = new Busca();

		String node = b.Gerar_No(arq);
		List<String> grafo = b.Gerar_Grafo(arq);

		System.out.println("Nós -> " + node);
		System.out.println("Grafo -> " + grafo);
		Lista list = new Lista();
		
		
	}

}
