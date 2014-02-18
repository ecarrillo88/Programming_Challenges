/*
 * PC/UVA IDs: 110601/10183
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema06;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class HowManyFibs {
	private static BigInteger[] arr;

	// hacer 2 y 3(facil) tema 6
	private static void fibonacci() {
		int num = 1, n2;
		int n1 = num - 1;
		System.out.println(0);
		System.out.println(num);
		for (int cantidad = 1; cantidad < 20; cantidad++) {
			n2 = num + n1;
			System.out.println(n2);
			n1 = num;
			num = n2;
		}
	}

	public static void FibonacciIterativo(int n) {
		arr[0] = BigInteger.ZERO;
		for (int i = 1; i < n; i++) {
			if (i < 2) {
				arr[i] = BigInteger.ONE;

			} else {
				arr[i] = arr[i - 1].add(arr[i - 2]);
			}
		}
	}

	private static void imprimir(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		// 1 Y 100 CEROS
		String num = "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		BigInteger diez100 = new BigInteger(num);
		arr = new BigInteger[2000000];
		FibonacciIterativo(2000000);
		imprimir(2000000);

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

	}
}
