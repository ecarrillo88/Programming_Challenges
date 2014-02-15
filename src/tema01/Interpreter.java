/*
 * PC/UVA IDs: 110106/10033
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.198
 */

package tema01;

import java.util.Scanner;

public class Interpreter {
	private static int[] registros;
	private static int[] RAM;
	private static int pc;

	private static void cargarRAM(Scanner scan) {
		int nInstrucciones = 0;
		String instruccion;
		while (scan.hasNextLine()) {
			instruccion = scan.nextLine();
			if (instruccion.trim().length() != 0) {
				RAM[nInstrucciones++] = Integer.parseInt(instruccion);
			} else {
				break;
			}
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
			pc = registros[d];
		}
	}

	private static int iniciarEjecucion() {
		int instruccion, digito1, digito2, digito3, contadorInstrucciones = 0;
		while (pc < RAM.length) {
			instruccion = RAM[pc++];
			digito1 = instruccion / 100;
			digito2 = (instruccion / 10) % 10;
			digito3 = instruccion % 10;
			switch (digito1) {
			case 1:
				if (instruccion == 100) {
					return ++contadorInstrucciones;
				}
				break;
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
				break;
			}
			// Todas las instrucciones anteriores a la 100 (detener) cuentan como
			// instrucciones, incluidas instrucciones no validas como 000 y 1XX
			contadorInstrucciones++;
		}
		return contadorInstrucciones;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = Integer.parseInt(scan.nextLine());
		scan.nextLine(); // Linea en blanco

		while (numCasos > 0) {
			registros = new int[10];
			RAM = new int[1000];
			pc = 0;
			cargarRAM(scan);
			System.out.println(iniciarEjecucion());
			if (--numCasos > 0) {
				System.out.print("\n");
			}
		}
		scan.close();
	}
}
