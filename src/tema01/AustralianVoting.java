/*
 * PC/UVA IDs: 110108/10142
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AustralianVoting {
	private static String[] candidatos;
	private static int[][] votos;
	private static final int NUM_VOTOS = 1001;

	// Metodo para testeo
	private static void imprimirArray() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < candidatos.length; j++) {
				System.out.print(votos[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = Integer.parseInt(scan.nextLine());
		scan.nextLine(); // Linea en blanco

		while (numCasos > 0) {
			// Almacenamos los candidatos
			int numCandidatos = Integer.parseInt(scan.nextLine());
			candidatos = new String[numCandidatos + 1];
			for (int i = 1; i < candidatos.length; i++) {
				candidatos[i] = scan.nextLine();
			}

			// Almacenamos los votos
			votos = new int[NUM_VOTOS][candidatos.length];
			String linea;
			int voto = 1;
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (!linea.isEmpty()) {
					StringTokenizer st = new StringTokenizer(linea);
					for (int j = 1; st.hasMoreElements(); j++) {
						votos[voto][j] = Integer.parseInt(st.nextToken());
					}
					voto++;
				} else {
					break;
				}
			}

			// Continuar

			if (--numCasos > 0) {
				System.out.print("\n");
			}
		}
		scan.close();
	}
}
