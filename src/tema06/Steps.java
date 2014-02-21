/*
 * PC/UVA IDs: 110608/846
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.472
 */

package tema06;

import java.util.ArrayList;
import java.util.Scanner;

public class Steps {
	private static final int MAX_VALOR = 2147483647; // 2^31
	private static ArrayList<Long> array = new ArrayList<Long>();
	
	/*
	 * steps   max_reachable_number    increase
	 * 0       0  (0)              
	 * 1       1  (1)                  +1
	 * 2       2  (11)                 +1
	 * 3       4  (121)                +2
	 * 4       6  (1221)               +2
	 * 5       9  (12321)              +3
	 * 6       12 (123321)             +3
	 * 7       16 (1234321)            +4
	 * 8       20 (12344321)           +4
	 * 
	 * De acuerdo al ejemplo anterior, el array va a contener los valores max_reachable_number
	 * que son los ultimos valores hasta que el numero de pasos se incrementa en una unidad.
	 * Por ejemplo, para los valores 13, 14, 15 y 16 el numero de pasos sera 7. De esta forma
	 * el array que vamos a mantener en memoria es mucho mas pequeño que almacenar uno de 2^31
	 * que es el maximo valor que podemos recibir como entrada.
	 */
	private static void precargaArray() {
		array.add((long) 0);
		int incremento = 1;
		for (int i = 1; array.get(i - 1) < MAX_VALOR; i += 2) {
			array.add(array.get(i - 1) + incremento);
			array.add(array.get(i) + incremento);
			incremento++;
		}
	}

	/* 
	 * Se encarga de buscar el valor de n en el array y retorna la posicion que
	 * ocupa en el array si lo ha encontrado o la posicion del array del
	 * siguiente valor mas alto.
	 * 
	 * La posicion del array se corresponde con el numero de pasos, y para agilizar
	 * la busqueda se utiliza una busqueda dicotomica
	 */
	private static int numeroDePasos(long n, int inicio, int fin) {
		int pivote = (fin + inicio) / 2;
		if (fin - inicio == 1) {
			return fin;
		}

		if (array.get(pivote) > n) {
			return numeroDePasos(n, inicio, pivote);
		} else if (array.get(pivote) < n) {
			return numeroDePasos(n, pivote, fin);
		} else {
			return pivote;
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		precargaArray();

		int x, y, diferencia, numPasos;
		int numCasos = entrada.nextInt();
		while (numCasos > 0) {
			x = entrada.nextInt();
			y = entrada.nextInt();
			diferencia = y - x;
			if (diferencia <= 0) {
				System.out.println(0);
			} else {
				numPasos = numeroDePasos(diferencia, 0, array.size());
				System.out.println(numPasos);
			}
			numCasos--;
		}
		entrada.close();
	}

}
