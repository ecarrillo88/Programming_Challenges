/*
 * PC/UVA IDs: 110303/10252
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.355
 */

package tema03;


import java.util.Arrays;
import java.util.Scanner;

public class CommonPermutation {

	private static String buscarCoincidencias(char[] a, char[] b) {
		String cadena = "";
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = k; j < b.length; j++) {
				if (a[i] == b[j]) {
					cadena += a[i];
					k = j + 1;
					break;
				}
			}
		}
		return cadena;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char[] a, b;
		while (scan.hasNext()) {
			a = scan.nextLine().toCharArray();
			b = scan.nextLine().toCharArray();
			// Ordenamos los arrays para facilitar la busqueda
			Arrays.sort(a);
			Arrays.sort(b);
			System.out.println(buscarCoincidencias(a, b));
		}

		scan.close();
	}

}
