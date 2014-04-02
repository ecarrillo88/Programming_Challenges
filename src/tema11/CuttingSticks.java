/*
 * PC/UVA IDs: 111105/10003
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.962
 */

package tema11;

import java.util.Scanner;

public class CuttingSticks {
	private static int longitud;
	private static int numCortes;
	private static int[] cortes;
	private static int[][] corte;

	private static int corte(int a, int b) {
		int min = Integer.MAX_VALUE;
		int aux;
		for (int cont = a + 1; cont < b; cont++) {
			aux = corte[a][cont] + corte[cont][b];
			if (aux < min) {
				min = aux;
			}
		}
		return min + cortes[b] - cortes[a];
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		while (entrada.hasNext()) {
			longitud = entrada.nextInt();
			if (longitud == 0) {
				break;
			}
			numCortes = entrada.nextInt();
			cortes = new int[numCortes + 2];
			cortes[0] = 0; // corte ficticio
			cortes[cortes.length - 1] = longitud; // corte ficticio
			for (int i = 1; i < cortes.length - 1; i++) {
				cortes[i] = entrada.nextInt();
			}

			corte = new int[cortes.length][cortes.length];
			for (int cont = 2; cont < cortes.length; cont++) {
				int i = 0;
				int j = cont;
				while (i < cortes.length - cont && j < cortes.length) {
					corte[i][j] = corte(i, j);
					i++;
					j++;
				}
			}

			System.out.println("The minimum cutting is " + corte[0][corte.length - 1] + ".");
		}
	}
}
