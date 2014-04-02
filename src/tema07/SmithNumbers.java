/*
 * PC/UVA IDs: 110706/10042
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.489
 */

package tema07;

import java.util.Scanner;
import java.util.ArrayList;

class SmithNumbers {

	private static boolean esPrimo(int n) {
		int cont = 0;
		int raiz = (int) Math.sqrt(n);
		for (int i = 1; i <= raiz; i++) {
			if (n % i == 0) {
				cont++;
			}
		}
		return cont == 1;
	}

	private static int sumaDigitos(int n) {
		int numero = n, suma = 0;
		while (numero != 0) {
			suma += numero % 10;
			numero /= 10;
		}
		return suma;
	}

	private static int sumaDigitos(ArrayList<Integer> n) {
		int numero, suma = 0;
		for (int i = 0; i < n.size(); i++) {
			numero = n.get(i);
			suma += sumaDigitos(numero);
		}
		return suma;
	}

	private static ArrayList<Integer> factorizar(int n) {
		ArrayList<Integer> listaFactores = new ArrayList<Integer>();
		int num = n;
		// Mientras podamos dividir por 2 el dos es un factor
		while (num % 2 == 0) {
			listaFactores.add((int) 2);
			num = num / 2;
		}

		// Ahora probaremos con los impares, empezando por el 3
		int cuenta = 3;
		int raiz = (int) Math.sqrt(num);

		while (cuenta <= raiz && num > 1) {
			if (num % cuenta == 0) {
				listaFactores.add(cuenta);
				num = num / cuenta;
			} else {
				cuenta += 2;
			}
		}

		if (num > 1) {
			listaFactores.add(num);
		}

		return listaFactores;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numCasos = entrada.nextInt();

		while (numCasos-- > 0) {
			int numero = entrada.nextInt();
			int suma1, suma2, resultado = 0;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			for (int i = numero + 1; i < Integer.MAX_VALUE; i++) {
				if (!esPrimo(i)) {
					suma1 = sumaDigitos(i);
					lista = factorizar(i);
					suma2 = sumaDigitos(lista);
					if (suma1 == suma2) {
						resultado = i;
						break;
					}
				}
			}

			System.out.println(resultado);
		}
	}
}
