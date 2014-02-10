package tema01;

import java.util.Scanner;

public class Interpreter {
	private static int[] registros = new int[10];
	private static int[] RAM = new int[1000];
	private static int posRAM = 0;
	
	private static void cargarRAM(){
		posRAM = 0;
		
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
		registros[d] = (registros[d] * registros[s]) * 1000;
	}

	private static void inicializarRegistroConRAM(int d, int a) {
		registros[d] = RAM[registros[a]];
	}

	private static void inicializarRAMConRegistro(int s, int a) {
		RAM[registros[a]] = registros[s];
	}

	private static void goTo(int d, int s) {
		if (registros[s] != 0) {
			posRAM = d;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = scan.nextInt();
		String lb = scan.next(); // linea en blanco

		while (numCasos > 0) {

			int nInstrucciones = 0;
			String instruccion;
			do {
				instruccion = scan.nextLine();
				try{
				RAM[nInstrucciones] = Integer.parseInt(instruccion);
				nInstrucciones++;
				}catch(NumberFormatException e){
					;
				}
			} while (!instruccion.equals(""));
			
			System.out.println("total: " + nInstrucciones);

			posRAM = 0;
			int ejecutadas = 0;
			/*while (instruccion != 100) {
				RAM[posRAM++] = instruccion;
				String inst = instruccion + "";
				switch (inst.charAt(0)) {
				case 2:
					inicializarRegistroConValor(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 3:
					sumarValor(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 4:
					multiplicarPorValor(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 5:
					inicializarRegistroConRegistro(inst.charAt(1),
							inst.charAt(2));
					ejecutadas++;
					break;
				case 6:
					sumarRegistro(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 7:
					multiplicarPorRegistro(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 8:
					inicializarRegistroConRAM(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 9:
					inicializarRAMConRegistro(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
					break;
				case 0:
					goTo(inst.charAt(1), inst.charAt(2));
					ejecutadas++;
				}
				instruccion = scan.nextInt();
			}
			*/

			//System.out.println("Total" + ++ejecutadas);
			numCasos--;
		}
		
		scan.close();
	}
}
