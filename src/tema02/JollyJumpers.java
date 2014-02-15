/*
 * PC/UVA IDs: 110201/10038
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.702
 */

package tema02;

import java.util.Arrays;
import java.util.Scanner;

public class JollyJumpers {

	private static boolean comprobarDiferenciaAbsoluta(int[] numeros) {
		int diferencia;
		int[] diferencias = new int[numeros.length];
		for (int i = 1; i < numeros.length; i++) {
			diferencia = Math.abs(numeros[i - 1] - numeros[i]);
			diferencias[i] = diferencia;
		}
		
		// Ordenamos el array porque las diferencias no tienen por que estar
		// ordenadas y debe cumplirse que van desde 1 hasta n-1
		Arrays.sort(diferencias);
		for (int i = 1; i < diferencias.length; i++) {
			if (diferencias[i] != i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			int num = scan.nextInt();
			int[] numeros = new int[num];
			for (int i = 0; i < num; i++) {
				numeros[i] = scan.nextInt();
			}

			boolean jolly = comprobarDiferenciaAbsoluta(numeros);
			if (jolly) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
		}
		scan.close();
	}

}
