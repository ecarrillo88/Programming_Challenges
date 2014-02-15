/*
 * PC/UVA IDs: 110303/10252
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema03;

import java.util.Arrays;
import java.util.Scanner;

public class CommonPermutation {

	private static String buscarCadena(char[] a, char[] b) {
		String cadena = "";
		int i = 0, j = 0;
		int menor = Math.min(a.length, b.length);
		while (true) {
			if (a[i] == b[j]) {
				cadena += a[i];
				i++;
				j++;
			} else{
				i++;
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
			Arrays.sort(a);
			Arrays.sort(b);
			System.out.println(buscarCadena(a, b).trim());
		}

		scan.close();

	}

}
