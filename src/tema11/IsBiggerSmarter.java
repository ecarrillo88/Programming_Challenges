/*
 * PC/UVA IDs: 111101/10131
 * PC: Wrong Answer (Don't judge correctly) / UVA: Accepted
 * Run Time: 0.805
 */

package tema11;

import java.util.ArrayList;
import java.util.Scanner;

public class IsBiggerSmarter {

	public static void selectionSort(ArrayList<Elefante> a) {
		selectionSort(a, 0, a.size());
	}

	public static void selectionSort(ArrayList<Elefante> a, int from, int to) {
		for (int i = from; i < to; i++) {
			int k = i;
			for (int j = i + 1; j < to; j++) {
				if (a.get(k).getPeso() > a.get(j).getPeso())
					k = j;
				else if (a.get(k).getPeso() == a.get(j).getPeso()) {
					if (a.get(k).getCI() < a.get(j).getCI())
						k = j;
				}
			}
			swap(a, i, k);
		}
	}

	private static void swap(ArrayList<Elefante> a, int i, int j) {
		Elefante aux = a.get(i);
		a.set(i, a.get(j));
		a.set(j, aux);
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Elefante> elefantes = new ArrayList<Elefante>();
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ArrayList<Integer> desde = new ArrayList<Integer>();
		int pos = 1;
		int peso = 0;
		int ci = 0;
		Elefante auxiliar = null;
		while (entrada.hasNext()) {
			peso = entrada.nextInt();
			ci = entrada.nextInt();
			auxiliar = new Elefante(peso, ci, pos++);
			elefantes.add(auxiliar);
			ls.add(1);
			desde.add(-1);
		}

		selectionSort(elefantes);

		int posicionMax = 0;
		int longitudMax = 1;
		for (int i = 0; i < elefantes.size() - 1; i++) {
			for (int j = i + 1; j < elefantes.size(); j++) {
				if (elefantes.get(i).getPeso() < elefantes.get(j).getPeso()
						&& elefantes.get(i).getCI() > elefantes.get(j).getCI()) {
					if (ls.get(i) + 1 > ls.get(j)) {
						ls.set(j, ls.get(i) + 1);
						desde.set(j, i);
					}

					if (ls.get(j) > longitudMax) {
						longitudMax = ls.get(j);
						posicionMax = j;
					}
				}
			}
		}

		int aux = posicionMax;
		int indice = ls.get(aux);
		int[] res = new int[indice];
		for (int i = 0; i < res.length; i++) {
			if (aux != -1) {
				res[i] = elefantes.get(aux).getPos();
				aux = desde.get(aux);
			}
		}

		System.out.println(longitudMax);
		for (int j = res.length - 1; j >= 0; j--) {
			System.out.println(res[j]);
		}

	}

}

class Elefante {

	private int peso;
	private int ci;
	private int pos;

	Elefante(int peso, int ci, int pos) {
		this.peso = peso;
		this.ci = ci;
		this.pos = pos;
	}

	public int getPeso() {
		return peso;
	}

	public int getCI() {
		return ci;
	}

	public int getPos() {
		return pos;
	}

}
