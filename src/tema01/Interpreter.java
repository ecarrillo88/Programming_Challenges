/*
 * PC/UVA IDs: 110106/10033
 * PC: Wrong Answer / UVA: Wrong Answer
 * Run Time: ?
 */

package tema01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Interpreter {
	private static int[] registros = new int[10];
	private static int[] RAM = new int[1000];
	private static int posRAM = 0;

	private static String ReadLine() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void cargarRAM(Scanner scan) {
		posRAM = 0;
		int nInstrucciones = 0;
		String instruccion;
		while (scan.hasNextLine()) {
			instruccion = scan.nextLine();
			if (!instruccion.equals("")) {
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
			posRAM = registros[d];
		}
	}

	private static int iniciarEjecucion() {
		int instruccion, digito1, digito2, digito3, ejecutadas = 0;
		while (posRAM < RAM.length) {
			instruccion = RAM[posRAM++];
			digito1 = instruccion / 100;
			digito2 = (instruccion / 10) % 10;
			digito3 = instruccion % 10;
			switch (digito1) {
			case 1:
				if (instruccion == 100) {
					return ++ejecutadas;
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
			}
			ejecutadas++;
		}
		return ejecutadas;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		int numCasos = scan.nextInt();
		// Linea en blanco
		scan.nextLine();
		scan.nextLine();

		while (numCasos > 0) {
			cargarRAM(scan);
			System.out.println(iniciarEjecucion());
			if (--numCasos > 0) {
				System.out.print("\n");
			}
		}
		scan.close();
	}
}
