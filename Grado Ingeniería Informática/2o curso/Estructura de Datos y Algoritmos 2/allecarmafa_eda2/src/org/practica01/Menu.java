package org.practica01;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Menu.
 */
public class Menu {

	/** ciudad. */
	private static Ciudad ciudad;

	/** terminado, mientras sea true muestra el Menu y realiza las operaciones del Menu. */
	private static boolean terminado;

	/**
	 * Main.
	 *
	 * @param args
	 * @throws IOExceptio.
	 */
	public static void main(String[] args) throws IOException {
		inicializar();
		do {
			menu();
			int opcion = elegirOpcion("Seleccione opcion", 1, 6);
			ejecutarOpcion(opcion);
		} while (terminado);
		System.out.println();
	}

	/**
	 * Ejecuta una de las 6 opciones principales que se le dan a escoger al usuario. 
	 *
	 * @param opcion
	 * @throws IOException.
	 */
	private static void ejecutarOpcion(int opcion) throws IOException {
		switch (opcion) {
		case 1:
			cargarArchivo();
			break;
		case 2:
			introducirDatos();
			break;
		case 3:
			mostrarCiudad();
			break;
		case 4:
			ejecutarAlgoritmos();
			break;
		case 5:
			mostrarCreditos();
			break;
		case 6:
			terminado = false;
			System.out.println("Proceso terminado");
			break;
		default:
			break;
		}
	}

	/**
	 *  Este método genera una ciudad.
	 *
	 * @param avenidas
	 * @param calles
	 * @param fallosPresion
	 * @param fallosFlujo
	 * @param nombreArchivo
	 * @param perdidas
	 * @param fallosPerdidas
	 * @throws IOException.
	 */
	private static void generarCiudad(int avenidas, int calles, ArrayList<String> fallosPresion,
			ArrayList<String> fallosFlujo, String nombreArchivo, int perdidas, ArrayList<String> fallosPerdidas)
			throws IOException {
		if (perdidas == 1) {
			GeneradorPruebas1 gp = new GeneradorPruebas1(avenidas, calles, fallosPresion, fallosFlujo);
			gp.generar(nombreArchivo);
		} else if (perdidas == 0) {
			GeneradorPruebas2 gp = new GeneradorPruebas2(avenidas, calles, fallosPresion, fallosFlujo, fallosPerdidas);
			gp.generar(nombreArchivo);
		}

	}

	/**
	 *  Este método recoge los datos necesarios para generar una ciudad con el método anterior.
	 *
	 * @throws IOException.
	 */
	private static void introducirDatos() throws IOException {
		System.out.println();
		System.out.println("Introduzca el numero de avenidas de la ciudad");
		Scanner sc = new Scanner(System.in);
		int avenidas = 0;
		String s1 = "";
		boolean correcto = false;
		while (!correcto) {
			try {
				s1 = sc.nextLine();
				if (s1.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}
				avenidas = Integer.parseInt(s1);
				if (avenidas <= 0) {
					System.out.println("Introduzca un numero mayor que 0");
					continue;
				}

				correcto = true;
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
//				sc.next();
			}
		}
		System.out.println("Introduzca el numero de calles de la ciudad");
		int calles = 0;
		correcto = false;
		int cont = 0;
		while (!correcto) {
			try {
				s1 = sc.nextLine();
				if (s1.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}
				// ERROR
				calles = Integer.parseInt(s1);
				if (calles <= 0) {
					System.out.println("Introduzca un numero mayor que 0");
					continue;
				}
				correcto = true;
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
//				sc.next();
			}
		}
		String[] arrayPresion = null;
		correcto = false;
		Scanner sc1 = new Scanner(System.in);
		ArrayList<String> fallosPresion = new ArrayList<>();
		String s2 = "";
		int y = 0;
		int z = 0;
		int opcion = 0;
		boolean correcto2 = false;
		while (!correcto) {
			System.out.println("\n¿Quiere Introducir fallos de PRESION? \n1.-Si, 2.-No");
			try {
				s2 = sc.nextLine();
				if (s2.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}
				if (s2.charAt(0) != '1' && s2.charAt(0) != '2' || s2.length() > 1) {
					System.out.println("Error. Solo puede introducir la opcion 1 o 2");
					continue;
				}
				correcto = true;
				opcion = Integer.parseInt(s2);
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
//				sc.next();
			}
		}
		switch (opcion) {
		case 1:
			do {
				correcto2 = true;
				System.out.println(
						"Introduzca la direccion de los fallos de PRESION y su porcentaje. Por ejemplo: A5C5 50,A3C2 10");
				String s = sc1.nextLine().toUpperCase();
				if (s.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					correcto2 = false;
					continue;
				}
				// A11C7
				cont = contarCaracteres(s, 'A');
				arrayPresion = s.trim().split(", ");
				for (int i = 0; i < arrayPresion.length; i++) {
					if (Integer.parseInt(arrayPresion[i].substring(1, arrayPresion[i].indexOf('C'))) >= avenidas
							|| Integer.parseInt(arrayPresion[i].substring(arrayPresion[i].indexOf('C') + 1,
									arrayPresion[i].indexOf(' '))) >= calles) {
						System.out.println("Valor erroneo. No existe el manometro " + arrayPresion[i]);
						correcto2 = false;
						continue;
					}
					if ((avenidas % 2 == 0
							&& Integer.parseInt(arrayPresion[i].substring(1, arrayPresion[i].indexOf('C'))) % 2 == 0)) {
						System.out.println("Valor erroneo. No existe el manometro " + arrayPresion[i]);
						correcto2 = false;
						continue;
					}
					if (avenidas % 2 != 0
							&& Integer.parseInt(arrayPresion[i].substring(1, arrayPresion[i].indexOf('C'))) % 2 != 0) {
						System.out.println("Valor erroneo. No existe el manometro " + arrayPresion[i]);
						correcto2 = false;
						continue;
					}

				}
				if (correcto2 == false) {
					continue;
				}
				correcto = false;
				if (cont == arrayPresion.length)
					correcto = true;
				if (!correcto)
					System.out.print("Error. Separe los errores con comas\n");
				if (arrayPresion != null) {
					for (int i = 0; i < arrayPresion.length; i++) {
						fallosPresion.add(arrayPresion[i].trim());
					}
				}
			} while (!correcto || !correcto2);
			break;
		case 2:

			break;

		default:
			break;
		}
		String[] arrayFlujo = null;
		correcto = false;
		ArrayList<String> fallosFlujo = new ArrayList<>();

		while (!correcto) {
			System.out.println("\n¿Quiere Introducir fallos de FLUJO? \n1.-Si, 2.-No");
			try {
				s2 = sc.nextLine();
				if (s2.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}

				if (s2.charAt(0) != '1' && s2.charAt(0) != '2' || s2.length() > 1) {
					System.out.println("Error. Solo puede introducir la opcion 1 o 2");
					continue;
				}

				correcto = true;
				opcion = Integer.parseInt(s2);
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
//				sc.next();
			}
		}
		switch (opcion) {
		case 1:
			do {
				correcto2 = true;
				System.out.println(
						"Introduzca la direccion de los fallos de FLUJO y su porcentaje. Por ejemplo: A5C5 700,A3C2 800");
				String s = sc1.nextLine().toUpperCase();
				if (s.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					correcto2 = false;
					continue;
				}
				cont = contarCaracteres(s, 'A');
				arrayFlujo = s.trim().split(", ");
				for (int i = 0; i < arrayFlujo.length; i++) {
					if (Integer.parseInt(arrayFlujo[i].substring(1, arrayFlujo[i].indexOf('C'))) >= avenidas
							|| Integer.parseInt(arrayFlujo[i].substring(arrayFlujo[i].indexOf('C') + 1,
									arrayFlujo[i].indexOf(' '))) >= calles) {
						System.out.println("Valor erroneo. No existe el contador " + arrayFlujo[i]);
						correcto2 = false;
						continue;
					}
					if ((avenidas % 2 == 0
							&& Integer.parseInt(arrayFlujo[i].substring(1, arrayFlujo[i].indexOf('C'))) % 2 == 0)) {
						System.out.println("Valor erroneo. No existe el manometro " + arrayFlujo[i]);
						correcto2 = false;
						continue;
					}
					if (avenidas % 2 != 0
							&& Integer.parseInt(arrayFlujo[i].substring(1, arrayFlujo[i].indexOf('C'))) % 2 != 0) {
						System.out.println("Valor erroneo. No existe el manometro " + arrayFlujo[i]);
						correcto2 = false;
						continue;
					}

				}

				if (correcto2 == false) {
					continue;
				}
				if (cont == arrayFlujo.length)
					correcto = true;
				if (!correcto)
					System.out.print("Error. Separe los errores con comas");
				if (arrayFlujo != null) {
					for (int i = 0; i < arrayFlujo.length; i++) {
						fallosFlujo.add(arrayFlujo[i].trim());
					}
				}
			} while (!correcto || !correcto2);
			break;
		case 2:

			break;
		default:
			break;
		}
		int perdidas = 0;
		String[] arrayPerdidas = null;
		ArrayList<String> fallosPerdidas = new ArrayList<>();
		correcto = false;
		while (!correcto) {
			System.out.println("\n¿Quiere introducir perdidas en alguna parcela? \n1.-Si, 2.-No");
			try {
				s2 = sc.nextLine();
				if (s2.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}

				if (s2.charAt(0) != '1' && s2.charAt(0) != '2' || s2.length() > 1) {
					System.out.println("Error. Solo puede introducir la opcion 1 o 2");
					continue;
				}

				correcto = true;
				opcion = Integer.parseInt(s2);
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
//				sc.next();
			}
		}
		switch (opcion) {
		case 1:
			do {
				correcto2 = true;
				System.out.println(
						"Introduzca la direccion del contador al que le quiere agregar su perdida y su porcentaje de perdida. Por ejemplo: A5C5 700,A3C2 800");
				String s = sc1.nextLine().toUpperCase();
				if (s.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					correcto2 = false;
					continue;
				}
				cont = contarCaracteres(s, 'A');
				arrayPerdidas = s.trim().split(", ");
				for (int i = 0; i < arrayPerdidas.length; i++) {
					if (Integer.parseInt(arrayPerdidas[i].substring(1, arrayPerdidas[i].indexOf('C'))) >= avenidas
							|| Integer.parseInt(arrayPerdidas[i].substring(arrayPerdidas[i].indexOf('C') + 1,
									arrayPerdidas[i].indexOf(' '))) >= calles) {
						System.out.println("Valor erroneo. No existe el contador " + arrayPerdidas[i]);
						correcto2 = false;
						continue;
					}
					if ((avenidas % 2 == 0
							&& Integer.parseInt(arrayPerdidas[i].substring(1, arrayPerdidas[i].indexOf('C')))
									% 2 == 0)) {
						System.out.println("Valor erroneo. No existe el contador " + arrayPerdidas[i]);
						correcto2 = false;
						continue;
					}
					if (avenidas % 2 != 0
							&& Integer.parseInt(arrayPerdidas[i].substring(1, arrayPerdidas[i].indexOf('C')))
									% 2 != 0) {
						System.out.println("Valor erroneo. No existe el contador " + arrayPerdidas[i]);
						correcto2 = false;
						continue;
					}

				}

				if (correcto2 == false) {
					continue;
				}
				if (cont == arrayPerdidas.length)
					correcto = true;
				if (!correcto)
					System.out.print("Error. Separe los errores con comas");
				if (arrayPerdidas != null) {
					for (int i = 0; i < arrayPerdidas.length; i++) {
						fallosPerdidas.add(arrayPerdidas[i].trim());
					}
				}
			} while (!correcto || !correcto2);
			break;
		case 2:
			perdidas = 1;
			break;
		default:
			break;
		}
		correcto = false;
		String nombreArchivo = "";
		do {
			System.out.println("Introduzca el nombre del archivo que va a crear");
			nombreArchivo = sc1.nextLine();
			if (nombreArchivo.charAt(0) == ' ' || nombreArchivo.equals(".")) {
				System.out.println("Valor erroneo. Introduzca un nombre valido\n");
				continue;
			}
			correcto = true;
		} while (!correcto);
		generarCiudad(avenidas, calles, fallosPresion, fallosFlujo, nombreArchivo, perdidas, fallosPerdidas);
	}

	/**
	 * Cuenta el número de veces que aparece un caracter en una cadena.
	 *
	 * @param cadena
	 * @param caracter
	 * @return numero caracteres
	 */
	private static int contarCaracteres(String cadena, char caracter) {
		int posicion, contador = 0;
		// se busca la primera vez que aparece
		posicion = cadena.indexOf(caracter);
		while (posicion != -1) { // mientras se encuentre el caracter
			contador++; // se cuenta
			// se sigue buscando a partir de la posicion siguiente a la encontrada
			posicion = cadena.indexOf(caracter, posicion + 1);
		}
		return contador;
	}

	/**
	 * Muestra la ciudad cargada.
	 */
	private static void mostrarCiudad() {
		if (!comprobarVacio()) {
			System.out.println(ciudad.toString());
		}

	}

	/**
	 * Muestra los componentes del grupo.
	 */
	private static void mostrarCreditos() {
		System.out.println("Grupo formado por:");
		System.out.println("Maria Galvez Gonzalez");
		System.out.println("Alejandra Domene Rodriguez");
		System.out.println("Favio Alain Moreno Ayala");
		System.out.println("Carlos Alvarez Caballero");
		System.out.println();

	}

	/**
	 * Imprime el menú con las diferentes opciones en la consola.
	 */
	private static void menu() {
		System.out.println("------------------MENU-------------------");
		System.out.println("-----------------------------------------");
		System.out.println("|	1.- Cargar ciudad		|");
		System.out.println("|	2.- Generar ciudad		|");
		System.out.println("|	3.- Mostrar ciudad		|");
		System.out.println("|	4.- Ejecutar algoritmos		|");
		System.out.println("|	5.- Creditos			|");
		System.out.println("|	6.- Exit			|");
		System.out.println("-----------------------------------------");

	}

	/**
	 * Permite indicar la opción que deseamos ejecutar.
	 *
	 * @param string
	 * @param i
	 * @param j
	 * @return opcion
	 */
	private static int elegirOpcion(String string, int i, int j) {
		System.out.println();
		System.out.println(string);
		Scanner sc = new Scanner(System.in);
		int elegido = 0;
		String s = "";
		try {
			s = sc.nextLine();
			elegido = Integer.parseInt(s);
			if (s.charAt(0) == ' ' || elegido < i || elegido > j)
				System.out.println("Error, por favor introduce un numero entre: " + i + " y " + j);
		} catch (Exception e) {
			System.out.println("Error en la lectura del numero");
		}

		return elegido;
	}

	/**
	 * Inicializa la ciudad.
	 */
	private static void inicializar() {
		ciudad = new Ciudad();
		terminado = true;
	}

	/**
	 * Carga el archivo en la ciudad.
	 *
	 * @throws IOException.
	 */
	private static void cargarArchivo() throws IOException {
		String archivo = escogerArchivo();
		ciudad = new Ciudad();
		ciudad.cargarArchivo(archivo);

	}

	/**
	 * Muestra todos los archivos en la carpeta de org.practica01.datos
	 *
	 * @return nada
	 */
	private static String escogerArchivo() {
		File dir = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
				+ File.separator + "practica01" + File.separator + "datos" + File.separator);
		File[] archivos = dir.listFiles();
		for (int i = 0; i < archivos.length; i++) {
			System.out.println((i + 1) + ".-" + archivos[i].getName());
		}
		int opcion = 0;
		do {
			opcion = elegirOpcion("Escoja: ", 1, archivos.length);
			try {
				return archivos[opcion - 1].getAbsolutePath();
			} catch (Exception e) {

			}
		} while (opcion == 0 || opcion >= archivos.length);
		return "";
	}

	/**
	 *  Ejecuta todos los algoritmos.
	 */
	private static void ejecutarAlgoritmos() {
		if(comprobarVacio() == true) return;
		System.out.println("Divide y venceras de presiones: \n");
		ciudad.DividePresiones();
		ciudad.mostrarErroresPresiones();
		System.out.println();
		System.out.println("Divide y venceras de flujos: \n");
		ciudad.DivideFlujos();
		ciudad.mostrarErroresFlujos();
		System.out.println("\nGreedy de presiones: \n");
		ciudad.GreedyPresiones();
		ciudad.mostrarErroresPresiones();
		System.out.println("\nGreedy de flujos: \n");
		ciudad.GreedyFlujos();
		ciudad.mostrarErroresFlujos();
		System.out.println("\nFuerza Bruta (Apartado 2 Practica 2)");
		ciudad.FBFlujosTuberias();
		ciudad.mostrarErroresFlujos();
	}

	/**
	 * Comprueba si hay datos cargados en la ciudad.
	 *
	 * @return true si no hay datos
	 */
	private static boolean comprobarVacio() {
		if (!ciudad.tieneDatos()) {
			System.out.println("No hay datos. Debe cargar un archivo");
			return true;
		}
		return false;
	}
}