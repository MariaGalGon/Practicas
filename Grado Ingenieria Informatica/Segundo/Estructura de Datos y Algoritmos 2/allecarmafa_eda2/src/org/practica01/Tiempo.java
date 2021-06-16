package org.practica01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Clase Tiempo.
 */
public class Tiempo {
	
	/** ciudad. */
	private static Ciudad ciudad = new Ciudad();

	/**
	 * Tiempos Divide y Venceras presion.
	 *
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposDyVPresion() throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			ciudad.DividePresiones();
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;
	}
	
	/**
	 * Tiempos Divide y Venceras flujo.
	 *
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposDyVFlujo() throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			ciudad.DivideFlujos();
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;		
	}
	
	/**
	 * Tiempos Greedy presion.
	 *
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposGreedyPresion() throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			ciudad.GreedyPresiones();
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;
	}
	
	/**
	 * Tiempos Greedy flujo.
	 *
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposGreedyFlujo() throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			ciudad.GreedyFlujos();
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;
	}
	
	/**
	 * Media.
	 *
	 * @param tiempos
	 * @return media
	 */
	public static double media(long[] tiempos) {
		double suma = 0.0;
		
		for(int i = 0; i < tiempos.length; i++) {
			suma += tiempos[i];
		}
		
		return suma / tiempos.length;
	}
	
	/**
	 * Mostrar tiempos algoritmos.
	 *
	 * @param errorPresion
	 * @param errorFlujo
	 * @param nombre archivo
	 * @throws IOException
	 */
	public static void mostrar(ArrayList<String> errorPresion, ArrayList<String> errorFlujo, String nombre) throws IOException {
		String mostrar = "Tamano\tDyVPresion\tDyVFlujo\tGreedyPresion\tGreedyFlujo\n" + "-------------------------------------------------------------------\n";
		for(int i = 4; i <= 500; i += 50) {
			mostrar += i + "\t";
			GeneradorPruebas1 g = new GeneradorPruebas1(i, i, errorPresion, errorFlujo);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica01" + File.separator + "datos" + File.separator + nombre + ".txt";
			ciudad.cargarArchivo(camino);
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVFlujo()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyFlujo()) + "\n";
			
			if(i < 50) i = 0;
		}
		System.out.println(mostrar + "----------------------------------------------------------------------\n");
	}
	
	/**
	 * Mostrar tiempos algoritmos con error al inicio.
	 *
	 * @param errorPresion
	 * @param errorFlujo
	 * @param nombre archivo
	 * @param tamano de la ciudad donde hay error
	 * @param soloUno
	 * @throws IOException
	 */
	public static void mostrarInicio(ArrayList<String> errorPresion, ArrayList<String> errorFlujo, String nombre, ArrayList<Integer>tamano, boolean soloUno) throws IOException {
		String mostrar = "Tamano\tDyVPresion\tDyVFlujo\tGreedyPresion\tGreedyFlujo\n" + "-------------------------------------------------------------------\n";
		boolean pasadoError = false;
		for(int i = 4; i <= 500; i += 50) {
			mostrar += i + "\t";
			if(pasadoError && soloUno) {
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				pasadoError = false;				
			}			
			for(int j = 0; j <= tamano.size() - 1; j++) {
				if(i == tamano.get(j)) {
					errorPresion.add("A" + (i-2) + "C" + (i-1) + " 50");
					errorFlujo.add("A" + (i-2) + "C" + (i-1) + " 900");
					pasadoError = true;
				}
			}
			
			GeneradorPruebas1 g = new GeneradorPruebas1(i, i, errorPresion, errorFlujo);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica01" + File.separator + "datos" + File.separator + nombre + ".txt";
			ciudad.cargarArchivo(camino);
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVFlujo()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyFlujo()) + "\n";
			
			if(i < 50) i = 0;
		}
		System.out.println(mostrar + "----------------------------------------------------------------------\n");
	}
	
	/**
	 * Mostrar tiempos algoritmos con error al inicio y la mitad.
	 *
	 * @param errorPresion
	 * @param errorFlujo
	 * @param nombre archivo
	 * @param tamano de la ciudad donde hay error
	 * @param soloUno
	 * @throws IOException
	 */
	public static void mostrarInicioMitad(ArrayList<String> errorPresion, ArrayList<String> errorFlujo, String nombre, ArrayList<Integer>tamano, boolean soloUno) throws IOException {
		String mostrar = "Tamano\tDyVPresion\tDyVFlujo\tGreedyPresion\tGreedyFlujo\n" + "-------------------------------------------------------------------\n";
		boolean pasadoError = false;
		for(int i = 4; i <= 500; i += 50) {
			mostrar += i + "\t";
			if(pasadoError && soloUno) {
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				pasadoError = false;				
			}			
			for(int j = 0; j <= tamano.size() - 1; j++) {
				if(i == tamano.get(j)) {
					errorPresion.add("A" + (i-2) + "C" + (i-1) + " 50");
					errorFlujo.add("A" + (i-2) + "C" + (i-1) + " 900");
					errorPresion.add("A" + (i-2) + "C" + (i-20) + " 50");
					errorFlujo.add("A" + (i-2) + "C" + (i-20) + " 900");
					pasadoError = true;
				}
			}
			
			GeneradorPruebas1 g = new GeneradorPruebas1(i, i, errorPresion, errorFlujo);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica01" + File.separator + "datos" + File.separator + nombre + ".txt";
			ciudad.cargarArchivo(camino);
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVFlujo()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyFlujo()) + "\n";
			
			if(i < 50) i = 0;
		}
		System.out.println(mostrar + "----------------------------------------------------------------------\n");
	}
	
	
	
	/**
	 * Mostrar tiempos algoritmos con error al final.
	 *
	 * @param errorPresion
	 * @param errorFlujo
	 * @param nombre archivo
	 * @param tamano de la ciudad donde hay error
	 * @param soloUno
	 * @throws IOException
	 */
	public static void mostrarFin(ArrayList<String> errorPresion, ArrayList<String> errorFlujo, String nombre, ArrayList<Integer> tamano, boolean soloUno) throws IOException {
		String mostrar = "Tamano\tDyVPresion\tDyVFlujo\tGreedyPresion\tGreedyFlujo\n" + "-------------------------------------------------------------------\n";
		boolean pasadoError = false;
		for(int i = 4; i <= 500; i += 50) {
			mostrar += i + "\t";
			if(pasadoError && soloUno) {
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				pasadoError = false;				
			}	
			for(int j = 0; j <= tamano.size() - 1; j++) {
				if(i == tamano.get(j)) {
					errorPresion.add("A" + (i-2) + "C3" + " 50");
					errorFlujo.add("A" + (i-2) + "C3" + " 900");
					pasadoError = true;
				}
			}
			GeneradorPruebas1 g = new GeneradorPruebas1(i, i, errorPresion, errorFlujo);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica01" + File.separator + "datos" + File.separator + nombre + ".txt";
			ciudad.cargarArchivo(camino);
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVFlujo()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyFlujo()) + "\n";
			
			if(i < 50) i = 0;
		}
		System.out.println(mostrar + "----------------------------------------------------------------------\n");
	}
	
	/**
	 * Mostrar tiempos algoritmos con error en la mitad y al final.
	 *
	 * @param errorPresion
	 * @param errorFlujo
	 * @param nombre archivo
	 * @param tamano de la ciudad donde hay error
	 * @param soloUno
	 * @throws IOException
	 */
	public static void mostrarMitadFin(ArrayList<String> errorPresion, ArrayList<String> errorFlujo, String nombre, ArrayList<Integer> tamano, boolean soloUno) throws IOException {
		String mostrar = "Tamano\tDyVPresion\tDyVFlujo\tGreedyPresion\tGreedyFlujo\n" + "-------------------------------------------------------------------\n";
		boolean pasadoError = false;
		for(int i = 4; i <= 500; i += 50) {
			mostrar += i + "\t";
			if(pasadoError && soloUno) {
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				pasadoError = false;				
			}	
			for(int j = 0; j <= tamano.size() - 1; j++) {
				if(i == tamano.get(j)) {
					errorPresion.add("A" + (i/2) + "C3" + " 50");
					errorFlujo.add("A" + (i/2) + "C3" + " 900");
					errorPresion.add("A" + (i/2) + "C" + (i/2) + " 50");
					errorFlujo.add("A" + (i/2) + "C" + (i/2) + " 900");
					pasadoError = true;
				}
			}
			GeneradorPruebas1 g = new GeneradorPruebas1(i, i, errorPresion, errorFlujo);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica01" + File.separator + "datos" + File.separator + nombre + ".txt";
			ciudad.cargarArchivo(camino);
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVFlujo()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyFlujo()) + "\n";
			
			if(i < 50) i = 0;
		}
		System.out.println(mostrar + "----------------------------------------------------------------------\n");
	}
	
	
	/**
	 * Mostrar tiempos algoritmos con error en el inicio y el final.
	 *
	 * @param errorPresion
	 * @param errorFlujo
	 * @param nombre archivo
	 * @param tamano de la ciudad donde hay error
	 * @param soloUno
	 * @throws IOException
	 */
	public static void mostrarInicioFin(ArrayList<String> errorPresion, ArrayList<String> errorFlujo, String nombre, ArrayList<Integer> tamano, boolean soloUno) throws IOException {
		String mostrar = "Tamano\tDyVPresion\tDyVFlujo\tGreedyPresion\tGreedyFlujo\n" + "-------------------------------------------------------------------\n";
		boolean pasadoError = false;
		for(int i = 4; i <= 500; i += 50) {
			mostrar += i + "\t";
			if(pasadoError && soloUno) {
				errorPresion.remove(errorPresion.size()-1);
				errorPresion.remove(errorPresion.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				errorFlujo.remove(errorFlujo.size()-1);
				pasadoError = false;				
			}
			for(int j = 0; j <= tamano.size() - 1; j++) {
				if(i == tamano.get(j)) {
					errorPresion.add("A" + (i-2) + "C" + (i-1) + " 50");
					errorFlujo.add("A" + (i-2) + "C" + (i-1) + " 900");
					errorPresion.add("A" + (i-2) + "C3" + " 50");
					errorFlujo.add("A" + (i-2) + "C3" + " 900");
					pasadoError = true;
				}
			}
			
			GeneradorPruebas1 g = new GeneradorPruebas1(i, i, errorPresion, errorFlujo);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica01" + File.separator + "datos" + File.separator + nombre + ".txt";
			ciudad.cargarArchivo(camino);
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposDyVFlujo()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyPresion()) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposGreedyFlujo()) + "\n";
			
			if(i < 50) i = 0;
		}
		System.out.println(mostrar + "----------------------------------------------------------------------\n");
	}
	
	/**
	 * Main.
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<String> errorPresion = new ArrayList<String>();
		ArrayList<String> errorFlujo = new ArrayList<String>();
		ArrayList<Integer> errores = new ArrayList<Integer>();
		errores.add(4);
		errores.add(50);
		errores.add(100);
		errores.add(150);
		errores.add(200);
		errores.add(250);
		errores.add(300);
		errores.add(350);
		errores.add(400);
		errores.add(450);
		errores.add(500);
		
		//Sin fallos
		mostrar(errorPresion, errorFlujo, "FallosNo");
		
		//1 Fallo troncal principio
		mostrarInicio(errorPresion, errorFlujo, "Fallo1Principio", errores, true);
		errorPresion.clear();
		errorFlujo.clear();
		
		//1 Fallo calle final
		mostrarFin(errorPresion, errorFlujo, "Fallo1Fin", errores, true);
		errorPresion.clear();
		errorFlujo.clear();
		
		//1 Fallo principio y final
		mostrarInicioFin(errorPresion, errorFlujo, "Fallo1PrincipioFin", errores, true);
		errorPresion.clear();
		errorFlujo.clear();
		
		//1 Fallo mitad
		errorPresion.add("A3C5 50");
		errorFlujo.add("A3C5 800");
		mostrar(errorPresion, errorFlujo, "Fallo1Mitad");
		errorPresion.clear();
		errorFlujo.clear();
		
		//2 Fallo troncal principio
		mostrar(errorPresion, errorFlujo, "Fallo2Principio");
		errorPresion.clear();
		errorFlujo.clear();
		
		//2 Fallo calle final 
		errorPresion.add("A5C3 118");
		errorFlujo.add("A1C3 100");
		mostrar(errorPresion, errorFlujo, "Fallo2Final");
		errorPresion.clear();
		errorFlujo.clear();
		
		//2 Fallo calle mitad 
		errorPresion.add("A3C4 129");
		errorFlujo.add("A1C4 109");
		mostrar(errorPresion, errorFlujo, "Fallo2Mitad");
		errorPresion.clear();
		errorFlujo.clear();
		
		//1 Fallo principio y 1 fallo final
		mostrarInicioFin(errorPresion, errorFlujo, "Fallo1Principio", errores, true);
		errorPresion.clear();
		errorFlujo.clear();
		
		//1 Fallo principio y 1 mitad 
		mostrarInicioMitad(errorPresion, errorFlujo, "FalloPrincipioYMitad", errores, true);
		errorPresion.clear();
		errorFlujo.clear();
	}
}
