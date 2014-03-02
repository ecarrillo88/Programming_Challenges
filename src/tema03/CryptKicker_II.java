/*
 * PC/UVA IDs: 110304/850
 * PC: ? / UVA: Accepted
 * Run Time: 0.455
 */

package tema03;

import java.util.Scanner;

public class CryptKicker_II {
	private static String textoPlano = "the quick brown fox jumps over the lazy dog";
	private static char[] cifradoUtilizado;
	private static char[][] texto = new char[100][80];

	private static boolean lineaCifradaEncontrada(int numFilas) {
		cifradoUtilizado = new char[26];
		for (int i = 0; i < numFilas; i++) {
			if (textoPlano.length() == texto[i].length) {
				// Obtenemos un posible cifrado
				for (int j = 0; j < texto[i].length; j++) {
					if (texto[i][j] != ' ') {
						cifradoUtilizado[texto[i][j] - 97] = textoPlano.charAt(j);
					}
				}

				// Desciframos la linea a partir de la cual hemos obtenido el cifrado
				String linea = "";
				for (int j = 0; j < texto[i].length; j++) {
					if (texto[i][j] != ' ') {
						linea += cifradoUtilizado[texto[i][j] - 97];
					} else {
						linea += ' ';
					}
				}

				// El cifrado obtenido solo es valido si la linea descifrada es
				// igual a la linea en texto plano que tomamos como referencia
				if (linea.equals(textoPlano)) {
					return true;
				}
			}
		}

		return false;
	}

	private static void descrifrarTexto(int numFilas) {
		char caracter;
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < texto[i].length; j++) {
				caracter = texto[i][j];
				// Solo se procesan los caracteres en minuscula
				if (caracter >= 97 && caracter <= 122) {
					// Desciframos el caracter y sustituimos
					texto[i][j] = cifradoUtilizado[caracter - 97];
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
			while (entrada.hasNextLine()) {
				linea = entrada.nextLine();
				if (linea.isEmpty()) {
					break;
				}

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
