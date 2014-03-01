/*
 * PC/UVA IDs: 110304/850
 * PC: ? / UVA: Runtime Error
 * Run Time: ?
 */

package tema03;

import java.util.Scanner;

public class CryptKicker_II {
	private static String lineaCifrada = "xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj";
	private static char[] cifradoUtilizado = { 'x', 'k', 'q', 's', 'u', 'p',
			'm', 'j', 'f', 'g', 'd', 'b', 'e', 'h', 'c', 'a', 'y', 'r', 'v',
			'o', 'i', 'n', 'z', 't', 'l', 'w' };
	private static char[][] texto = new char[100][];

	private static boolean lineaCifradaEncontrada(int numFilas) {
		boolean lineaEncontrada = false;
		int i, j;
		for (i = 0; i < numFilas; i++) {
			// Para evitar IndexOutOfBoundsException al acceder a los caracteres
			// de lineaCifrada tenemos que asegurarnos de que la linea a
			// comprobar tiene el mismo tamaño que lineaCifrada
			if ((texto[i][0] == lineaCifrada.charAt(0))
					&& (lineaCifrada.length() == texto[i].length)) {
				for (j = 0; j < texto[i].length; j++) {
					if (texto[i][j] != lineaCifrada.charAt(j)) {
						break;
					}
				}
				// Si ha llegado al final sin romper el bucle significa que ha
				// encontrado la linea que buscamos
				if (j == texto[i].length) {
					lineaEncontrada = true;
					break;
				}
			}
		}

		return lineaEncontrada;
	}

	private static void descrifrarTexto(int numFilas) {
		char caracter;
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < texto[i].length; j++) {
				caracter = texto[i][j];
				// Solo se procesan los caracteres en minuscula
				if (caracter >= 97 && caracter <= 122) {
					// Desciframos el caracter
					caracter = cifradoUtilizado[caracter - 97];
					// Sustituimos por el nuevo caracter
					texto[i][j] = caracter;
				}
			}
		}
	}

	private static void imprimirTexto(int numFilas) {
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < texto[i].length; j++) {
				System.out.print(texto[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numCasos = Integer.parseInt(entrada.nextLine());

		// Saltamos la primera linea en blanco
		entrada.nextLine();

		while (numCasos-- > 0) {
			String linea;
			int numLineas = 0;
			while ((linea = entrada.nextLine()) != null && !linea.isEmpty()) {
				texto[numLineas++] = linea.toCharArray();
			}

			if (lineaCifradaEncontrada(numLineas)) {
				descrifrarTexto(numLineas);
				imprimirTexto(numLineas);

			} else {
				System.out.println("No solution.");
			}

			// Linea en blanco despues de cada caso de prueba
			if (numCasos > 0) {
				System.out.print("\n");
			}
		}

		entrada.close();
	}

}
