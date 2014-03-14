/*
 * PC/UVA IDs: 110403/10037
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.982
 */

package tema04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bridge {
	// Cada posicion del array es una persona y su contenido es su velocidad
	// Al inicio suponemos que todas estan a la izquierda del puente
	private static int[] personasIzquierda;
	private static int[] personasDerecha;
	private static int numIzquierda;
	private static int numDerecha;
	// Se utiliza para guardar el log de personas que van y vienen por el puente
	private static ArrayList<String> log;
	private static int costeTotal;

	// COUNTING SORT O(n+k)
	private static void countingSort(int a[]) {
		int min = a[0], max = a[0];
		for (int i = 1; i < a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}

		if (max - min <= 10000000) { // To use 40MB of RAM at most
			int counter[] = new int[max - min + 1];
			for (int i = 0; i < a.length; i++)
				counter[a[i] - min]++;

			int k = 0;
			for (int i = 0; i < counter.length; i++) {
				while (counter[i] > 0) {
					a[k++] = i + min;
					counter[i]--;
				}
			}

		} else {
			Arrays.sort(a); // O(n log(n))
		}
	}

	private static void cruzar() {
		int ultimo = ultimoIzquierda();
		int a, b;
		if (!todosDerecha()) {
			if (numIzquierda >= 2) {
				a = personasIzquierda[1] + 3 * personasIzquierda[2] + personasIzquierda[ultimo];
				b = 2 * personasIzquierda[1] + personasIzquierda[2] + personasIzquierda[ultimo - 1] + personasIzquierda[ultimo];

				if (numIzquierda == 3) {
					cruzar(1, ultimo);
					volverMasRapido();
					cruzar(1, 2);
				} else {
					if (a <= b) {
						cruzar(1, 2);
						volverMasRapido();
						cruzar(ultimo - 1, ultimo);
						volverMasRapido();
					} else {
						cruzar(1, ultimo);
						volverMasRapido();
						cruzar(1, ultimo - 1);
						volverMasRapido();
					}
					if (numIzquierda == 2) {
						cruzar(1, 2);
					}
				}
			} else {
				cruzarSolo(1);
			}
		}
	}

	private static void cruzarSolo(int a) {
		if (!todosDerecha()) {
			int velocidad1 = 0;
			velocidad1 = personasIzquierda[a];
			personasDerecha[a] = velocidad1;
			numDerecha++;
			personasIzquierda[a] = 0;
			numIzquierda--;
			costeTotal += velocidad1;
			log.add(velocidad1 + "");
		}
	}

	private static void cruzar(int a, int b) {
		if (!todosDerecha()) {
			int velocidad1, velocidad2;
			velocidad1 = personasIzquierda[a];
			velocidad2 = personasIzquierda[b];
			personasDerecha[a] = velocidad1;
			numDerecha++;
			personasIzquierda[a] = 0;
			numIzquierda--;
			personasDerecha[b] = velocidad2;
			numDerecha++;
			personasIzquierda[b] = 0;
			numIzquierda--;
			costeTotal += velocidad2;
			log.add(velocidad1 + " " + velocidad2);
		}
	}

	private static void volverMasRapido() {
		// Siempre vuelve una de las dos personas mas rapidas.
		// En el caso de que las dos personas mas rapidas esten a la derecha
		// entonces volvera la persona mas rapida (numero 1)
		if (!todosDerecha()) {
			int velocidad, persona;
			if (personasDerecha[1] != 0) {
				persona = 1;
			} else {
				persona = 2;
			}
			velocidad = personasDerecha[persona];
			personasIzquierda[persona] = velocidad;
			numIzquierda++;
			personasDerecha[persona] = 0;
			numDerecha--;
			costeTotal += velocidad;
			log.add(velocidad + "");
		}
	}

	private static int ultimoIzquierda() {
		for (int i = personasIzquierda.length - 1; i >= 0; i--) {
			if (personasIzquierda[i] != 0) {
				return i;
			}
		}
		return -1;
	}

	private static boolean todosDerecha() {
		return (personasDerecha.length - 1) == numDerecha;
	}

	private static void imprimirLog() {
		for (int i = 0; i < log.size(); i++) {
			System.out.println(log.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = scan.nextInt();

		while (numCasos > 0) {
			int numPersonas = scan.nextInt();
			personasIzquierda = new int[numPersonas + 1];
			personasDerecha = new int[numPersonas + 1];
			for (int i = 1; i <= numPersonas; i++) {
				personasIzquierda[i] = scan.nextInt();
			}

			// Ordenamos las personas de menor a mayor velocidad
			countingSort(personasIzquierda);

			numDerecha = 0;
			numIzquierda = personasIzquierda.length - 1;
			costeTotal = 0;
			log = new ArrayList<String>();

			while (!todosDerecha()) {
				cruzar();
			}

			System.out.println(costeTotal);
			imprimirLog();

			if (--numCasos > 0){
				System.out.print("\n");
			}
		}
	}

}
