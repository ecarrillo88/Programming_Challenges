/*
 * PC/UVA IDs: 110701/10110
 * PC: Accepted / UVA: Accepted
 * Run Time: 1.702
 */

package tema07;

import java.util.Scanner;

public class LightMoreLight {
	private static long bombilla_nesima;

	/*
	 * Si por cada divisor de bombilla_nesima desde 1 hasta n vamos encendiendo
	 * o apagando la bombilla obtendremos un Time Limit Exceeded debido a la
	 * cantidad tan alta de operaciones que hay que hacer para numeros muy
	 * grandes (hasta 2^31 - 1).
	 * 
	 * SOLUCION: Comprobar si la bombilla_nesima es un cuadrado perfecto, es
	 * decir, comprobar si el cuadrado de la raiz cuadrada de bombilla_nesima es
	 * igual a bombilla_nesima.
	 */
	private static void bombillaEncendida() {
		long raiz = (long) Math.sqrt(bombilla_nesima);
		long cuadradoDeRaiz = raiz * raiz;

		if (cuadradoDeRaiz == bombilla_nesima)
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		while ((bombilla_nesima = entrada.nextLong()) != 0) {
			bombillaEncendida();
		}

		entrada.close();
	}

}
