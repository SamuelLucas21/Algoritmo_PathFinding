package ag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class ZonaDeTeste extends JFrame {

	private static final long serialVersionUID = 1L;

	public static int avalia = 0, vm;

	public static List<Integer> melhor;

	public static List<Integer> ciV = new ArrayList<>();

	static Random random = new Random();

	public int[][] GerarMatriz(int j, int v) {

		int m[][] = new int[j][j];

		for (int i = 0; i < j; i++) {

			for (int r = 0; r < j; r++) {

				if (i == r) {
					m[i][r] = 0;
				} else {
					m[i][r] = (random.nextInt(v) + 1);
				}

			}
		}
		return m;
	}

	// ----------------------------------VMP-----------------------------------------------------------

	// ----------------------------------CONVERSOR
	// MATRIZ-----------------------------------------------------------
	public String ConverteMatriz(int[][] matriz) {

		StringBuilder sb = new StringBuilder();
		for (int[] linha : matriz) {
			for (int valor : linha) {
				sb.append(valor).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// ----------------------------------AVALIA-----------------------------------------------------------
	public static int Avalia(int n, List<Integer> s, int[][] m1) {
		int valor = 0;

		for (int i = 0; i < n - 1; i++) {
			valor += m1[s.get(i)][s.get(i + 1)];
		}

		valor += m1[s.get(n - 1)][s.get(0)];

		return valor;
	}

	// ----------------------------------SUBIDA DE
	// ENCOSTA-----------------------------------------------------------
	public static List<Integer> sucessores(List<Integer> atual, int va, int n, int[][] m1) {
		List<Integer> melhor = new ArrayList<>(atual);
		int vm = va;
		Random rd = new Random();
		int ind = rd.nextInt(n);
		for (int i = 0; i < n; i++) {
			List<Integer> suc = new ArrayList<>(atual);
			int aux = suc.get(i);
			suc.set(i, suc.get(ind));
			suc.set(ind, aux);
			int vs = Avalia(n, suc, m1);
			if (vs < vm) {
				melhor = new ArrayList<>(suc);
				vm = vs;
			}
		}
		return melhor;
	}

	public static List<Integer> SubidaDeEncosta(List<Integer> si, int vi, int n, int[][] m1) {

		List<Integer> atual = new ArrayList<>(si);
		int va = vi;

		while (true) {
			List<Integer> novo = sucessores(atual, va, n, m1);
			System.out.println("Sucessores Subida de Encosta = " + novo);
			int vn = Avalia(n, novo, m1);

			if (vn >= va) {
				return atual;
			}

			atual = new ArrayList<>(novo);
			va = vn;
		}
	}
	// ----------------------------------SUBIDA DE ENCOSTA
	// ALTERADA-----------------------------------------------------------

	public static List<Integer> Sucessores2(List<Integer> atual, int va, int n, int[][] m1) {
		List<Integer> suc = new ArrayList<>(atual);
		int ind1 = new Random().nextInt(n);
		int ind2 = new Random().nextInt(n);

		while (ind1 == ind2) {
			ind2 = new Random().nextInt(n);
		}

		int aux = suc.get(ind1);
		suc.set(ind1, suc.get(ind2));
		suc.set(ind2, aux);

		return suc;
	}

	public static List<Integer> SubidaDeEncosta1(List<Integer> si, int vi, int n, int[][] m1, int tmax) {
		List<Integer> atual = new ArrayList<>(si);
		int va = vi;
		int t = 1;
		List<Integer> cidades = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			cidades.add(i);
		}

		Collections.shuffle(cidades);

		while (true) {
			List<Integer> novo = Sucessores2(atual, va, n, m1);
			int vn = Avalia(n, novo, m1);

			if (vn >= va) {
				System.out.println("Sucessores Subida de Encosta Alterada = " + novo);
				if (t > tmax) {
					return atual;
				} else {
					t = t + 1;
				}
			} else {
				atual = new ArrayList<>(novo);
				va = vn;
				t = 1;
				cidades.clear();
				System.out.println("Sucessores Subida de Encosta Alterada = " + novo);

				for (int i = 0; i < n; i++) {
					cidades.add(i);
				}

				Collections.shuffle(cidades);
			}
		}
	}

	public static List<Integer> SolucaoInicial(int n) {

		List<Integer> s = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			s.add(i);
		}

		Collections.shuffle(s);

		return s;
	}

	// ----------------------------------TÊMPERA
	// SIMULADA-----------------------------------------------------------
	public static List<Integer> sucessoresTemp(List<Integer> atual, int va, int n, int[][] m1) {
		List<Integer> suc = new ArrayList<>(atual);
		int ind1 = new Random().nextInt(n);
		int ind2 = new Random().nextInt(n);

		while (ind1 == ind2) {
			ind2 = new Random().nextInt(n);
		}

		int aux = suc.get(ind1);
		suc.set(ind1, suc.get(ind2));
		suc.set(ind2, aux);

		return suc;
	}

	public static List<Integer> temperaS(List<Integer> si, int vi, int n, int[][] m1, double tIni, double tFim,
			double fr) {
		List<Integer> atual = new ArrayList<>(si);
		List<Integer> aux = new ArrayList<>(si);
		int va = vi;
		int vaux = vi;
		double t = tIni;
		while (t > tFim) {
			List<Integer> novo = sucessoresTemp(atual, va, n, m1);
			int de = Avalia(n, novo, m1) - va;

			if (de >= 0) {
				double ale = new Random().nextDouble();
				double prob = Math.exp(-de / t);

				if (ale <= prob) {

					atual = new ArrayList<>(novo);
					va = Avalia(n, novo, m1);
					System.out.println("ALE = " + ale + " AUX = " + prob);

				}
			} else {
				atual = new ArrayList<>(novo);
				va = Avalia(n, novo, m1);

			}

			if (va < vaux) {
				aux = new ArrayList<>(atual);
				vaux = va;
			}

			t = t * fr;
		}

		return aux;
	}

	public static double gera_temp(List<Integer> si, int n, int[][] m1) {

		int avaliacaoInicial = Avalia(n, si, m1);
		double temperaturaInicial = 10 * avaliacaoInicial;

		return temperaturaInicial;
	}

	// ----------------------------------ALGORTIMO
	// GENÉTICO-----------------------------------------------------------

	public static int[] npzerosV(int n) {
		int[] ind = new int[n];

		for (int i = 0; i < n; i++) {
			ind[i] = 0;
		}
		return ind;
	}

	public static float[] npzerosVfloat(int n) {
		float[] ind = new float[n];

		for (int i = 0; i < n; i++) {
			ind[i] = 0;
		}
		return ind;
	}

	public static int[][] npzerosM(int n, int tp) {
		int[][] ind = new int[tp][n];

		for (int i = 0; i < tp; i++) {
			for (int j = 0; j < n; j++) {
				ind[i][j] = 0;
			}
		}
		return ind;
	}

	public static int[] Cromossomo(int n) {

		int ind[] = npzerosV(n);

		List<Integer> indi = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			ind[i] = i;
		}

		for (int valor : ind) {
			indi.add(valor);
		}

		Collections.shuffle(indi);

		for (int i = 0; i < ind.length; i++) {
			ind[i] = indi.get(i);
		}

		return ind;
	}

	public int[][] populacaoInicial(int n, int tp) {

		int[][] pop = npzerosM(n, tp);

		for (int i = 0; i < tp; i++) {
			pop[i] = Cromossomo(n);
		}

		return pop;
	}

	public static int AvaliaAG(int n, List<Integer> s, int[][] m1) {
		int valor = 0;

		for (int i = 0; i < n - 1; i++) {
			valor += m1[s.get(i)][s.get(i + 1)];
		}

		valor += m1[s.get(n - 1)][s.get(0)];

		return valor;
	}

	public static List<Integer> Custo_caminho(int[][] popIni, int n, int tp, int[][] mat) {

		List<Integer> avalias = new ArrayList<>();
		List<Integer> si = new ArrayList<>();

		for (int i = 0; i < tp; i++) {
			for (int valor : popIni[i]) {
				si.add(valor);

			}
			int aval = AvaliaAG(n, si, mat);

			avalias.add(aval);
			si.clear();
			aval = 0;
		}

		return avalias;

	}

	public double[] Aptidao(int n, int tp, int[][] pop, int[][] mat) {

		List<Integer> avals = Custo_caminho(pop, n, tp, mat);
		double[] t = new double[tp];
		for (int i = 0; i < avals.size(); i++) {
			t[i] = avals.get(i);
		}

		double[] f = new double[tp];

		for (int i = 0; i < tp; i++) {
			f[i] = 1.0 / t[i];
		}

		double soma = 0.0;

		for (int i = 0; i < tp; i++) {
			soma += f[i];
		}

		for (int i = 0; i < tp; i++) {
			f[i] /= soma;
		}

		return f;
	}

	public static int Roleta(double[] f) {
		int max = 1, min = 0;
		float ale = (float) (Math.random() * (max - min + 1) + min);
		int ind = 0;
		double soma = f[ind];

		while (soma < ale && ind < f.length - 1) {
			ind++;
			soma += f[ind];
		}

		return ind;
	}

	public static int Torneio(double[] f, int tp) {

		int i1 = random.nextInt(0, tp);
		int i2 = random.nextInt(0, tp);

		if (f[i1] > f[i2]) {
			return i1;
		} else {
			return i2;
		}
	}

	public void ordenarMatrizPorFitness(int[][] matriz, List<Double> fitnessList) {
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < fitnessList.size(); i++) {
			indices.add(i);
		}

		// Ordenar os índices com base nos valores de fitness
		Collections.sort(indices, Comparator.comparingDouble(fitnessList::get).reversed());

		// Reorganizar a matriz com base nos índices ordenados
		int[][] matrizOrdenada = new int[matriz.length][matriz[0].length];
		List<Double> fitnessOrdenado = new ArrayList<>();

		for (int i = 0; i < matriz.length; i++) {
			matrizOrdenada[i] = matriz[indices.get(i)].clone();
			fitnessOrdenado.add(fitnessList.get(indices.get(i)));
		}

		// Atualizar a matriz e a lista original
		System.arraycopy(matrizOrdenada, 0, matriz, 0, matriz.length);
		fitnessList.clear();
		fitnessList.addAll(fitnessOrdenado);
	}

	public static void ordenarMatrizPorAvaliacao(List<Integer> avaliacaoList) {

		System.out.println("Array Recebido -> " + avaliacaoList);
		int[] avals = new int[avaliacaoList.size()];

		for (int i = 0; i < avaliacaoList.size(); i++) {
			avals[i] = avaliacaoList.get(i);
		}
		Arrays.sort(avals);
		avaliacaoList.clear();
		for (int valor : avals) {
			avaliacaoList.add(valor);
		}
		System.out.println("Array Organizado -> " + avaliacaoList);
	}

	public List<String> Crossover(int n, int[][] pop, double[] fit, int tp, double tc, int[][] matriz) {

		int QuantidadeCross = (int) Math.ceil(tc * tp);

		List<Integer> p1 = new ArrayList<>();
		List<Integer> p2 = new ArrayList<>();
		List<Integer> d1 = new ArrayList<>();
		List<Integer> d2 = new ArrayList<>();
		List<String> totalDescendentes = new ArrayList<>();

		for (int c = 0; c < QuantidadeCross; c++) {
			int corte = random.nextInt(0, n);

			int pai1 = Torneio(fit, tp);
			int pai2;
			do {
				pai2 = Torneio(fit, tp);
			} while (pai2 == pai1);

			for (int valor : pop[pai1]) {
				p1.add(valor);
			}

			for (int valor : pop[pai2]) {
				p2.add(valor);
			}

			for (int i = 0; i < corte; i++) {
				d1.add(p1.get(i));
			}

			for (int i = 0; i < p2.size(); i++) {
				if (d1.contains(p2.get(i))) {
				} else {
					d1.add(p2.get(i));
				}
			}

			for (int i = 0; i < corte; i++) {
				d2.add(p2.get(i));
			}

			for (int i = 0; i < p1.size(); i++) {
				if (d2.contains(p1.get(i))) {
				} else {
					d2.add(p1.get(i));
				}
			}

			p1.clear();
			p2.clear();

			totalDescendentes.add(d1.toString());
			totalDescendentes.add(d2.toString());

			d1.clear();
			d2.clear();

		}
		System.out.println("---Quantidade descentes -> " + totalDescendentes.size() + "---");

		return totalDescendentes;
	}

	public static void AjusteRestricao(int n, int[][] desc, int qd, float corte) {

		for (int i = 0; i < desc.length; i++) {
			List<Integer> alfabeto = new ArrayList<>();
			for (int j = 0; j < n - 1; j++) {
				alfabeto.add(i);
			}

			for (int j = 0; j < corte; j++) {
				alfabeto.remove(desc[i][j]);
				Collections.shuffle(alfabeto);
			}
		}

	}

	public List<String> mutacao(int n, List<String> desc, int tp, double tm) {

		List<String> descM = new ArrayList<>();
		descM.addAll(desc);
		List<String> xxt = new ArrayList<>();

		int qm = (int) Math.ceil(tm * tp);

		int q_desc = desc.size();

		for (int i = 0; i < qm; i++) {

			int DescS = random.nextInt(0, q_desc);

			String DescMutado = desc.get(DescS);
			DescMutado = DescMutado.substring(1, DescMutado.length() - 1);
			String[] e = DescMutado.split("\\s*,\\s*");
			int tam = e.length;
			int[] v = new int[tam];

			for (int z = 0; z < 3; z++) {
				int ind1 = random.nextInt(0, n);
				int ind2 = random.nextInt(0, n);

				for (int c = 0; c < tam; c++) {
					v[c] = Integer.parseInt(e[c]);
				}
				int i1 = v[ind1];
				int i2 = v[ind2];

				v[ind1] = i2;
				v[ind2] = i1;

				xxt.add(Arrays.toString(v));
				descM.addAll(xxt);

				xxt.clear();
			}
		}

		return descM;
	}

	// Vou fazer uma lista de double contendo o fitness de cada uma das mutações e
	// ver qual o melhor
	// Depois vou pegar os melhores que equivalem ao tamanho da minha população e
	// xesquedele
	// Minha nova população vai ter individuos baseados na meu intervalo de geração
	// Preciso manter meu individuos com o menor fitness e adicionar novos
	// individuos com os menores fitness também

	public int[][] novaPop(int[][] pop, int[][] desc, double tp, double ig) {

		int elite = (int) Math.ceil(tp * ig);

		System.out.println("Intervalo Geração -> " + elite);

		int j = 0;
		for (int i = elite; i < pop.length; i++) {

			pop[i] = Arrays.copyOf(desc[j], desc[j].length);

			j++;
			if (j == desc.length) {
				break;
			}
		}

		return pop;
	}

	public int[][] converterListaParaMatriz(List<String> linhasMatriz) {
		int linhas = linhasMatriz.size();
		int colunas = linhasMatriz.get(0).split("\\s*,\\s*").length;

		int[][] matriz = new int[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			String[] valoresString = linhasMatriz.get(i).replaceAll("\\[|\\]", "").split("\\s*,\\s*");

			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = Integer.parseInt(valoresString[j]);
			}
		}

		return matriz;
	}

	// ----------------------------------SOBRAS DO CÓDIGO
	// O RESTO-----------------------------------------------------------

	

}