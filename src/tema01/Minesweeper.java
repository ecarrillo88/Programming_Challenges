/*
 * PC/UVA IDs: 110102/10189
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.582
 */

package tema01;

import java.util.Scanner;

public class Minesweeper {
	private static int[][] tablero = new int[100][100];
	private static int filas = 100;
	private static int columnas = 100;

	private static void setTamanyoTablero(int f, int c) {
		filas = f;
		columnas = c;
	}

	private static void limpiarTablero() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = 0;
			}
		}
	}

	private static void setMina(int f, String linea) {
		for (int c = 0; c < linea.length(); c++) {
			if (linea.charAt(c) == '*') {
				tablero[f][c] = -1;
			}
		}
	}

	private static boolean coordenadasValidas(int f, int c) {
		return f >= 0 && f < filas && c >= 0 && c < columnas;
	}

	private static void setValorAdyacentesMina(int f, int c) {
		for (int i = f; i < (f + 3); i++) {
			for (int j = c; j < (c + 3); j++) {
				if (coordenadasValidas(i, j) && tablero[i][j] != -1) {
					++tablero[i][j];
				}
			}
		}
	}

	private static void imprimirTablero(int field) {
		System.out.print("Field #" + field + ":\n");
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (tablero[i][j] != -1) {
					System.out.print(tablero[i][j]);
				} else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {

		int field = 1;
		Scanner scan = new Scanner(System.in);

		while (true) {
			setTamanyoTablero(scan.nextInt(), scan.nextInt());

			if (filas == 0 && columnas == 0) {
				break;
			}

			limpiarTablero();

			scan.nextLine();
			for (int i = 0; i < filas; i++) {
				String linea = scan.nextLine();
				setMina(i, linea);
			}

			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					if (tablero[i][j] == -1) {
						setValorAdyacentesMina(i - 1, j - 1);
					}
				}
			}

			if (field > 1) {
				System.out.print("\n");
			}
			imprimirTablero(field);

			field++;
		}
		scan.close();
	}
}
