package ag;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		ZonaDeTeste ag = new ZonaDeTeste();

		// Tamanho da Matriz
		int n = 5;
		// Limite de valores
		int max = 9;
		// Matriz Inicial
		int[][] mInicial = ag.GerarMatriz(n, max);
		// Mostrando a matriz
		System.out.println("---Matriz Inicial---");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + mInicial[i][j]);
			}
			System.out.print("\n");
		}
		// Tamanho da minha população
		int tp = 4;
		int[][] popini = ag.populacaoInicial(n, tp);
		// Exibindo minha população inicial
		System.out.println("---População Inicial---");
		for (int i = 0; i < tp; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + popini[i][j]);
			}
			System.out.print("\n");
		}

		for (int ig = 0; ig < 50; ig++) {
			// Calcula o Fit da minha população
			double[] fit = ag.Aptidao(n, tp, popini, mInicial);
			List<Double> lfit = new ArrayList<>();
			for (int i = 0; i < tp; i++) {
				lfit.add(fit[i]);
			}
			// Organizando minha matriz pelo fitness
			ag.ordenarMatrizPorFitness(popini, lfit);

			System.out.println("---População Inicial Organizada por fitness---");
			for (int i = 0; i < tp; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" " + popini[i][j]);
				}
				System.out.print("\n");
			}
			List<Integer> avals = new ArrayList<>();
			
			for (int i = 0; i < tp; i++) {
				for (int j = 0; j < n; j++) {
					avals.add(popini[i][j]);
				}
				System.out.println("Avalia -> "+ag.AvaliaAG(n, avals, mInicial));
				avals.clear();
			}
			
			System.out.println(lfit);

			// Fazendo o cruzamento
			List<String> cross = ag.Crossover(n, popini, fit, tp, 0.8, mInicial);
			System.out.println("---Gerando Descendentes---");
			System.out.println(cross);

			// Fazendo a mutação dos descendentes
			List<String> mut = ag.mutacao(n, cross, tp, 0.1);
			System.out.println("---Fazendo Mutação---");
			System.out.println(mut);

			// Convertendo descendentes mutados para uma matriz
			int[][] desc = ag.converterListaParaMatriz(mut);

			// Fazendo a aptidao dos meus descendentes
			double[] fitD = ag.Aptidao(n, mut.size(), desc, mInicial);
			lfit.clear();

			for (int i = 0; i < fitD.length; i++) {
				lfit.add(fitD[i]);
			}

			// Organizando Descendentes por Fitness
			ag.ordenarMatrizPorFitness(desc, lfit);

			System.out.println("---Descendentes Organizados por fitness---");
			for (int i = 0; i < mut.size(); i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" " + desc[i][j]);
				}
				System.out.print("\n");
			}

			int[][] novaPop = ag.novaPop(popini, desc, tp, 0.1);

			for (int i = 0; i < tp; i++) {
				for (int j = 0; j < n; j++) {
					popini[i][j] = novaPop[i][j];
				}
			}

			lfit.clear();

			System.out.println("---Nova População---");
			for (int i = 0; i < tp; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" " + popini[i][j]);
				}
				System.out.print("\n");
			}
			avals.clear();
			for (int i = 0; i < tp; i++) {
				for (int j = 0; j < n; j++) {
					avals.add(popini[i][j]);
				}
				System.out.println("Avalia -> "+ag.AvaliaAG(n, avals, mInicial));
				avals.clear();
			}
		}
	}

}
