/*
 * PC/UVA IDs: 110306/10132
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.178
 */

package tema03;

import java.util.Scanner;

public class FileFragmentation {
	private static int numArchivos;
	private static int tamanoArchivo;
	private static final int MAX_ARCHIVOS = 144;
	private static String[] fragmentos = new String[MAX_ARCHIVOS * 2];

	private static String unirFragmentos(int numFragmentos) {
		String archivoTemporal, archivoReconstruido = null;
		boolean fin = false;
		for (int i = 0; i < numFragmentos && !fin; i++) {
			for (int j = i + 1; j < numFragmentos && !fin; j++) {
				if (fragmentos[i].length() + fragmentos[j].length() == tamanoArchivo) {
					// Unimos los fragmentos y comprobamos con el resto
					archivoTemporal = fragmentos[i].concat(fragmentos[j]);
					if (comprobarRestoFragmentos(archivoTemporal, numFragmentos)) {
						archivoReconstruido = archivoTemporal;
						fin = true;
						break;
					}
					// Unimos los fragmentos a la inversa y volvemos a comprobar
					archivoTemporal = fragmentos[j].concat(fragmentos[i]);
					if (comprobarRestoFragmentos(archivoTemporal, numFragmentos)) {
						archivoReconstruido = archivoTemporal;
						fin = true;
					}
				}
			}
		}

		return archivoReconstruido;
	}

	private static boolean comprobarRestoFragmentos(String temp, int numFragmentos) {
		int iguales = 0;
		String archivoTemporal2 = "";
		for (int i = 0; i < numFragmentos; i++) {
			for (int j = i + 1; j < numFragmentos; j++) {
				if (fragmentos[i].length() + fragmentos[j].length() == tamanoArchivo) {
					archivoTemporal2 = fragmentos[i].concat(fragmentos[j]);
					if (archivoTemporal2.equals(temp)) {
						iguales++;
					}
					archivoTemporal2 = fragmentos[j].concat(fragmentos[i]);
					if (archivoTemporal2.equals(temp)) {
						iguales++;
					}
				}
			}
		}

		if (iguales >= numArchivos) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numCasos = Integer.parseInt(entrada.nextLine());
		String linea = entrada.nextLine(); // Linea en blanco

		while (numCasos-- > 0) {
			numArchivos = 0;
			tamanoArchivo = 0;
			int numFragmentos = 0;
			while (entrada.hasNextLine()) {
				linea = entrada.nextLine();
				if (linea.isEmpty()) {
					break;
				}
				fragmentos[numFragmentos++] = linea;
				tamanoArchivo += linea.length();
			}

			numArchivos = numFragmentos / 2;
			tamanoArchivo = tamanoArchivo / numArchivos;

			System.out.println(unirFragmentos(numFragmentos));

			if (numCasos > 0) {
				System.out.print("\n");
			}
		}

		entrada.close();
	}
}
