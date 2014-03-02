/*
 * PC/UVA IDs: 110302/10010
 * PC: ? / UVA: Accepted
 * Run Time: 0.375
 */

package tema03;

import java.util.Scanner;

public class WhereIsWaldorf {
	private static char[][] texto;
	private static Palabras[] palabras;

	private static void busqueda() {
		boolean encontrada;
		String palabra;
		for (int k = 0; k < palabras.length; k++) {
			palabra = palabras[k].palabra;
			encontrada = false;
			for (int i = 0; i < texto.length; i++) {
				for (int j = 0; j < texto[i].length; j++) {
					if (texto[i][j] == palabra.charAt(0)) {
						encontrada = comprobarPalabra(palabra, i, j);
						if (encontrada) {
							palabras[k].fila = i + 1;
							palabras[k].columna = j + 1;
							break;
						}
					}
				}
				if (encontrada) {
					break;
				}
			}
		}
	}

	private static boolean comprobarPalabra(String palabra, int a, int b) {
		int tamanoPalabra = palabra.length();
		int i, j, k;

		// Derecha
		i = a;
		j = b;
		if (j + (tamanoPalabra - 1) < texto[i].length) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i][j++] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// Diagonal derecha bajo
		i = a;
		j = b;
		if ((i + (tamanoPalabra - 1) < texto.length)
				&& (j + (tamanoPalabra - 1) < texto[i].length)) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i++][j++] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// Abajo
		i = a;
		j = b;
		if (i + (tamanoPalabra - 1) < texto.length) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i++][j] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// Diagonal izquierda abajo
		i = a;
		j = b;
		if ((i + (tamanoPalabra - 1) < texto.length)
				&& (j - (tamanoPalabra - 1) >= 0)) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i++][j--] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// izquierda
		i = a;
		j = b;
		if (j - (tamanoPalabra - 1) >= 0) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i][j--] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// Diagonal izquierda arriba
		i = a;
		j = b;
		if ((i - (tamanoPalabra - 1) >= 0) && (j - (tamanoPalabra - 1) >= 0)) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i--][j--] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// Arriba
		i = a;
		j = b;
		if (i - (tamanoPalabra - 1) >= 0) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i--][j] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		// Diagonal derecha arriba
		i = a;
		j = b;
		if ((i - (tamanoPalabra - 1) >= 0)
				&& (j + (tamanoPalabra - 1) < texto[i].length)) {
			for (k = 0; k < tamanoPalabra; k++) {
				if (texto[i--][j++] != palabra.charAt(k)) {
					break;
				}
			}

			if (k == tamanoPalabra) {
				return true;
			}
		}

		return false;
	}

	private static void imprimirPosicionPalabras() {
		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i].fila + " " + palabras[i].columna);
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numCasos = entrada.nextInt();

		int m, n, k;
		while (numCasos-- > 0) {
			m = entrada.nextInt();
			n = entrada.nextInt();
			texto = new char[m][n];

			// Leemos el texto de m x n
			entrada.nextLine(); // ¿Linea en blanco que se cuela?
			for (int i = 0; i < m; i++) {
				texto[i] = entrada.nextLine().toLowerCase().toCharArray();
			}

			k = entrada.nextInt();
			palabras = new Palabras[k];

			// Leemos la lista de k palabras
			entrada.nextLine(); // ¿Linea en blanco que se cuela?
			for (int i = 0; i < k; i++) {
				palabras[i] = new Palabras(entrada.nextLine().toLowerCase());
			}

			busqueda();
			imprimirPosicionPalabras();

			// Linea en blanco despues de cada caso de prueba
			if (numCasos > 0) {
				System.out.print("\n");
			}
		}

		entrada.close();

	}
}

class Palabras {
	String palabra;
	int fila;
	int columna;

	Palabras(String palabra) {
		this.palabra = palabra;
		fila = 0;
		columna = 0;
	}
}
