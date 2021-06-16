package org.practica03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Menu.
 */
public class Menu {

	/** Mochila Practica 3. */
	private static MochilaP3 mochilaP3;
	
	/** Mochila Practica 4. */
	private static MochilaP4 mochilaP4;

	/** terminado, mientras sea true muestra el Menu y realiza las operaciones del Menu. */
	private static boolean terminado;

	/**
	 * Main.
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		terminado = true;
		mochilaP3 = new MochilaP3();
		mochilaP4 = new MochilaP4();
		do {
			menu();
			int opcion = elegirOpcion("Seleccione opcion", 1, 5);
			ejecutarOpcion(opcion);
		} while (terminado);
		System.out.println();
	}

	/**
	 * Ejecuta una de las 6 opciones principales que se le dan a escoger al usuario. 
	 *
	 * @param opcion
	 * @throws IOException
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
			ejecutarAlgoritmos();
			break;
		case 4:
			mostrarCreditos();
			break;
		case 5:
			terminado = false;
			System.out.println("Proceso terminado");
			break;			
		default:
			break;
		}
	}

	/**
	 *  Este método genera un archivo para ejecutar en los algoritmos.
	 *
	 * @param avenidas
	 * @param calles
	 * @param fallos
	 * @param nombreArchivo
	 * @throws IOException
	 */
	private static void generarListado(int avenidas, int calles,int fallos, String nombreArchivo) throws IOException {
		
		GenerarArchivo ga = new GenerarArchivo(fallos, avenidas, calles);
			ga.generar(nombreArchivo);
		
	}

	/**
	 *  Este método recoge los datos necesarios para generar un archivo con el método anterior.
	 *
	 * @throws IOException Signals
	 */
	private static void introducirDatos() throws IOException {
		System.out.println();
		System.out.println("Introduzca el numero de avenidas.");
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
			}
		}
		System.out.println("Introduzca el numero de calles de la ciudad");
		int calles = 0;
		correcto = false;
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
			}
		}
		int fallos = 0;
		System.out.println("Introduzca el numero de edificios con fallo.");
		correcto = false;
		int formula = (avenidas/2) * (calles - 3);
		while(!correcto) {
			try {
				s1 = sc.nextLine();
				if (s1.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}
				fallos = Integer.parseInt(s1);
				if(formula < fallos) {
					System.out.println("Valor erroneo. No puede haber mas fallos que contadores.");
					continue;
				}
				if(fallos <= 0) {
					System.out.println("Introduzca un numero mayor que 0");
					continue;
				}
				correcto = true;
			}catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
			}
		}
			correcto = false;
			String nombreArchivo = "";
			do {
				System.out.println("Introduzca el nombre del archivo que va a crear");
				nombreArchivo = sc.nextLine();
				if (nombreArchivo.charAt(0) == ' ' || nombreArchivo.equals(".")) {
					System.out.println("Valor erroneo. Introduzca un nombre valido\n");
					continue;
				}
				correcto = true;
			} while (!correcto);
			generarListado(avenidas, calles, fallos, nombreArchivo);
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
		System.out.println("|	1.- Cargar archivo		|");
		System.out.println("|	2.- Generar archivo		|");
		System.out.println("|	3.- Ejecutar algoritmos		|");
		System.out.println("|	4.- Creditos			|");
		System.out.println("|	5.- Exit			|");
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
	 * Carga el archivo.
	 *
	 * @throws IOException
	 */
	private static void cargarArchivo() throws IOException {
		String archivo = escogerArchivo();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Introduzca el valor base del tiempo de atencion de los clientes (min):");
		int ba = s.nextInt();
		mochilaP3 = new MochilaP3(archivo, ba);
		mochilaP4 = new MochilaP4(archivo, ba);
		
	}

	/**
	 * Muestra todos los archivos en la carpeta de org.practica03.datos
	 *
	 * @return nada
	 */
	private static String escogerArchivo() {
		File dir = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
				+ File.separator + "practica03" + File.separator + "datos" + File.separator);
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
	 * Datos problema WTT.
	 *
	 * @return peso para el problema WTT.
	 */
	private static int datosProblemaWTT() {
		System.out.println("Introduzca el tiempo de trabajo maximo (min)");
		Scanner sc = new Scanner(System.in);
		int peso = 0;
		String s1 = "";
		boolean correcto = false;
		while (!correcto) {
			try {
				s1 = sc.nextLine();
				if (s1.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}
				peso = Integer.parseInt(s1);
				if (peso <= 0) {
					System.out.println("Introduzca un numero mayor que 0");
					continue;
				}

				correcto = true;
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
			}
		}
		return peso;
	}

	/**
	 * Datos problema MI.
	 *
	 * @return peso para el problema MI.
	 */
	private static int datosProblemaMI() {
		System.out.println("Introduzca el minimo de ingresos (EUROS)");
		Scanner sc = new Scanner(System.in);
		int peso = 0;
		String s1 = "";
		boolean correcto = false;
		while (!correcto) {
			try {
				s1 = sc.nextLine();
				if (s1.charAt(0) == ' ') {
					System.out.println("Valor erroneo. No introduzca espacios.");
					continue;
				}
				peso = Integer.parseInt(s1);
				if (peso <= 0) {
					System.out.println("Introduzca un numero mayor que 0");
					continue;
				}

				correcto = true;
			} catch (Exception e) {
				System.out.println("Valor erroneo. Introduzca un valor entero");
			}
		}
		return peso;
	}
	
	/**
	 * Ejecutar algoritmos.
	 */
	private static void ejecutarAlgoritmos() {
		System.out.println("Elija el algoritmo a ejecutar:\n1.-Programacion Dinamica(P3)	2.-Backtracking(P4)");
		Scanner sc = new Scanner(System.in);
		int elegido = 0;
		String s = "";
		try {
			s = sc.nextLine();
			elegido = Integer.parseInt(s);
			if (s.charAt(0) == ' ' || elegido < 0 || elegido > 2)
				System.out.println("Error, por favor introduzca la opcion 1 o 2.");
		} catch (Exception e) {
			System.out.println("Error en la lectura del numero");
		}
		
		switch(elegido) {
		case 1:
			ejecutarAlgoritmosP3();
			break;
		case 2:
			ejecutarAlgoritmosP4();
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * Elegir algoritmo.
	 *
	 * @return opcion
	 */
	private static int elegirAlgoritmo() {
		System.out.println("Elija el algoritmo a ejecutar:\n1.-ProblemaWTT	2.-ProblemaMI	3.-ProblemaWTT y ProblemaMI");
		Scanner sc = new Scanner(System.in);
		int elegido = 0;
		String s = "";
		try {
			s = sc.nextLine();
			elegido = Integer.parseInt(s);
			if (s.charAt(0) == ' ' || elegido < 0 || elegido > 3)
				System.out.println("Error, por favor introduzca la opcion 1, 2 o 3.");
		} catch (Exception e) {
			System.out.println("Error en la lectura del numero");
		}
		return elegido;
	}

	/**
	 *  Ejecuta todos los algoritmos de la Practica 3.
	 */
	private static void ejecutarAlgoritmosP3() {
		if(comprobarVacio() == true) return;
		int opcion = elegirAlgoritmo();
		if(opcion == 1) {
			System.out.println("ProblemaWTT:");
			int pesoWTT = datosProblemaWTT();
			mochilaP3.problemaWTT(pesoWTT);
			mochilaP3.solucionWTT();
			System.out.println(mochilaP3.toStringWTT());
		}else if(opcion == 2) {
			System.out.println("ProblemaMI:");
			int pesoMI = datosProblemaMI();
			mochilaP3.problemaMI(pesoMI);
			mochilaP3.solucionMI();
			System.out.println(mochilaP3.toStringMI());
		}else if(opcion == 3) {
			System.out.println("ProblemaWTT:");
			int pesoWTT = datosProblemaWTT();
			mochilaP3.problemaWTT(pesoWTT);
			mochilaP3.solucionWTT();
			System.out.println(mochilaP3.toStringWTT());
			System.out.println("ProblemaMI:");
			int pesoMI = datosProblemaMI();
			mochilaP3.problemaMI(pesoMI);
			mochilaP3.solucionMI();
			System.out.println(mochilaP3.toStringMI());
		}
	}
	
	/**
	 *  Ejecuta todos los algoritmos de la Practica 4.
	 */
	private static void ejecutarAlgoritmosP4() {
		if(comprobarVacio() == true) return;
		int opcion = elegirAlgoritmo();
		if(opcion == 1) {
			System.out.println("ProblemaWTT:");
			int pesoWTT = datosProblemaWTT();
			mochilaP4.problemaWTT(pesoWTT);
			System.out.println(mochilaP4.toStringWTT());
		}else if(opcion == 2) {
			System.out.println("ProblemaMI:");
			int pesoMI = datosProblemaMI();
			mochilaP4.problemaMI(pesoMI);
			System.out.println(mochilaP4.toStringMI());
		}else if(opcion == 3) {
			System.out.println("ProblemaWTT:");
			int pesoWTT = datosProblemaWTT();
			mochilaP4.problemaWTT(pesoWTT);
			System.out.println(mochilaP4.toStringWTT());
			System.out.println("ProblemaMI:");
			int pesoMI = datosProblemaMI();
			mochilaP4.problemaMI(pesoMI);
			System.out.println(mochilaP4.toStringMI());
		}
	}

	/**
	 * Comprueba si hay datos cargados en la mochila.
	 *
	 * @return true si no hay datos
	 */
	private static boolean comprobarVacio() {
		if (!mochilaP3.tieneDatos()) {
			System.out.println("No hay datos. Debe cargar un archivo");
			return true;
		}
		return false;
	}
}