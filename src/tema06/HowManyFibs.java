/*
 * PC/UVA IDs: 110601/10183
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema06;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HowManyFibs {
	private static ArrayList<BigInteger> fibonacci;
	private static BigInteger diez100;

	public static void generarFibonacci() {
		fibonacci.add(BigInteger.ZERO);
		fibonacci.add(BigInteger.ONE);

		BigInteger fib = BigInteger.ONE;
		while (fib.compareTo(diez100) <= 0) {
			fibonacci.add(fibonacci.i);
			fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);

		}
	}

	private static void imprimir(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		// 1 Y 100 CEROS
		String MAX_VALOR = "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		diez100 = new BigInteger(MAX_VALOR);

		fibonacci = new ArrayList<BigInteger>();
		generarFibonacci();
		// imprimir(MAX_VALOR);
		System.out.println("FIN");

		/*
		 * ArrayList<BigInteger> lista = new ArrayList<BigInteger>();
		 * 
		 * lista.add(BigInteger.ZERO); lista.add(BigInteger.ONE);
		 * 
		 * BigInteger fib = BigInteger.ONE; while(fib.compareTo(diez100) <= 0){
		 * lista.add(fib); // fib = fib.abs(lista.get(lista.size()-1)); }
		 * 
		 * Scanner entrada = new Scanner(System.in); while(entrada.hasNext()){
		 * 
		 * 
		 * }
		 */
		entrada.close();
	}
}
