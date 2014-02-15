/*
 * PC/UVA IDs: 110106/10033
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema01;

import java.util.Scanner;

public class Interpreter {
	private static int[] registros = new int[10];
	private static int[] RAM = new int[1000];
	private static int posRAM = 0;

	private static void cargarRAM(Scanner scan) {
		posRAM = 0;
		int nInstrucciones = 0;
		String instruccion;
		while ((instruccion = scan.nextLine()) != null
				&& !instruccion.equals("")) {
			RAM[nInstrucciones++] = Integer.parseInt(instruccion.trim());
		}

	}

	private static void inicializarRegistroConValor(int d, int n) {
		registros[d] = n;
	}

	private static void sumarValor(int d, int n) {
		registros[d] = (registros[d] + n) % 1000;
	}

	private static void multiplicarPorValor(int d, int n) {
		registros[d] = (registros[d] * n) % 1000;
	}

	private static void inicializarRegistroConRegistro(int d, int s) {
		registros[d] = registros[s];
	}

	private static void sumarRegistro(int d, int s) {
		registros[d] = (registros[d] + registros[s]) % 1000;
	}

	private static void multiplicarPorRegistro(int d, int s) {
		registros[d] = (registros[d] * registros[s]) % 1000;
	}

	private static void inicializarRegistroConRAM(int d, int a) {
		registros[d] = RAM[registros[a]];
	}

	private static void inicializarRAMConRegistro(int s, int a) {
		RAM[registros[a]] = registros[s];
	}

	private static void goTo(int d, int s) {
		if (registros[s] != 0) {
			posRAM = registros[d];
		}
	}

	private static void imprimirRegistros() {
		for (int i = 0; i < registros.length; i++)
			System.out.print(registros[i] + "|");
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = scan.nextInt();
		// Necesario para saltarnos la linea en blanco inicial
		scan.nextLine();
		scan.nextLine();

		while (numCasos > 0) {
			cargarRAM(scan);

			int ejecutadas = 0;
			while (RAM[posRAM++] != 100) {
				int inst = RAM[posRAM - 1];
				int digito1 = inst / 100;
				int digito2 = (inst / 10) % 10;
				int digito3 = inst % 10;
				switch (digito1) {
				case 2:
					inicializarRegistroConValor(digito2, digito3);
					break;
				case 3:
					sumarValor(digito2, digito3);
					break;
				case 4:
					multiplicarPorValor(digito2, digito3);
					break;
				case 5:
					inicializarRegistroConRegistro(digito2, digito3);
					break;
				case 6:
					sumarRegistro(digito2, digito3);
					break;
				case 7:
					multiplicarPorRegistro(digito2, digito3);
					break;
				case 8:
					inicializarRegistroConRAM(digito2, digito3);
					break;
				case 9:
					inicializarRAMConRegistro(digito2, digito3);
					break;
				case 0:
					goTo(digito2, digito3);
				}
				ejecutadas++;
			}

			System.out.println(++ejecutadas + "\n");
			numCasos--;
		}

		scan.close();
	}
}
