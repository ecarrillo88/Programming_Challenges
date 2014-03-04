package tema03;

import java.util.Scanner;

public class FileFragmentation {
	private static int numArchivos;
	private static int tamanoArchivo;
	private static final int MAX_ARCHIVOS = 144;
	private static final int MAX_TAMANO = 2048; // 256 bytes
	private static String[] fragmentos = new String[MAX_ARCHIVOS * 2];

	private static String uniFragmentos(int numFragmentos) {
		String archivoTemporal = "";
		for (int i = 0; i < numFragmentos; i++) {
			for (int j = 0; j < numFragmentos; j++) {
				if (fragmentos[i].length() + fragmentos[j].length() == tamanoArchivo) {
					archivoTemporal = fragmentos[i].concat(fragmentos[j]);
				}
				if (!todosFragmentosIguales(archivoTemporal, numFragmentos)) {
					break;
				}
			}
		}

		return archivoTemporal;
	}

	private static boolean todosFragmentosIguales(String temp, int numFragmentos) {
		String archivoTemporal2 = "";
		for (int i = 0; i < numFragmentos; i++) {
			for (int j = 0; j < numFragmentos; j++) {
				if (fragmentos[i].length() + fragmentos[j].length() == tamanoArchivo) {
					archivoTemporal2 = fragmentos[i].concat(fragmentos[j]);
				}
				if (!archivoTemporal2.equals(temp)) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numCasos = Integer.parseInt(entrada.nextLine());
		String linea = entrada.nextLine(); // Linea en blanco

		while (numCasos-- > 0) {
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

			System.out.println(uniFragmentos(numFragmentos));

			if (numCasos > 0) {
				System.out.print("\n");
			}
		}

		entrada.close();
	}
}
