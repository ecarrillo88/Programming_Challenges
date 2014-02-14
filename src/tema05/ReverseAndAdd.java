/*
 * PC/UVA IDs: 110502/10018
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.455
 */

package tema05;

import java.util.Scanner;

public class ReverseAndAdd {

	private static long invertirNumero(long numero) {
		long num = numero;
		long numInvertido = 0;
		int ultimoDigito;
		while (num != 0) {
			ultimoDigito = (int) (num % 10);
			num = num / 10;
			numInvertido = numInvertido * 10 + ultimoDigito;
		}
		return numInvertido;
	}

	private static String sumar(long numero) {
		int contador = 0;
		long num = numero;
		while (!esPalindromo(num)) {
			num += invertirNumero(num);
			contador++;
		}
		return contador + " " + num;
	}

	private static boolean esPalindromo(long numero) {
		if (numero == invertirNumero(numero)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int casosPrueba = scan.nextInt();
		long numero;
		while (casosPrueba > 0) {
			numero = scan.nextLong(); // Long para que no desborde
			System.out.println(sumar(numero));
			casosPrueba--;
		}

		scan.close();
	}

}
