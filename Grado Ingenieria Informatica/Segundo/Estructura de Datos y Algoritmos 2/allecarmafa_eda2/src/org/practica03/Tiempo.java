package org.practica03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Clase Tiempo.
 */
public class Tiempo {
	
	/** Mochila de la Practica 3. */
	private static MochilaP3 mochilaP3;
	
	/** Mochila de la Practica 4. */
	private static MochilaP4 mochilaP4;

	/**
	 * Tiempos problema WTT de la Practica 3.
	 *
	 * @param peso
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposWTTP3(int peso) throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			mochilaP3.problemaWTT(peso);
			mochilaP3.solucionWTT();
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;
	}
	
	/**
	 * Tiempos problema MI de la Practica 3.
	 *
	 * @param peso
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposMIP3(int peso) throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			mochilaP3.problemaMI(peso);
			mochilaP3.solucionMI();
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;		
	}
	
	/**
	 * Tiempos problema WTT de la Practica 4.
	 *
	 * @param peso
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposWTTP4(int peso) throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			mochilaP4.problemaWTT(peso);
			long tiempoFin = System.nanoTime();
			long tiempoTotal = tiempoFin - tiempoInicio;
			tiempos[i] = tiempoTotal;
		}
		double media = media(tiempos);
		
		return media;
	}
	
	/**
	 * Tiempos problema MI de la Practica 4.
	 *
	 * @param peso
	 * @return media de tiempos
	 * @throws IOException
	 */
	public static double tiemposMIP4(int peso) throws IOException {		
		long[] tiempos = new long[10];
		
		for(int i = 0; i < 10; i++) {
			long tiempoInicio = System.nanoTime();
			mochilaP4.problemaMI(peso);
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
	 * @param errores
	 * @param nombre archivo
	 * @param pesoWTT
	 * @param pesoMI
	 * @throws IOException
	 */
	public static void mostrar(String nombre, int pesoWTT, int pesoMI) throws IOException {
		String mostrar = "Tamano\tP3WTT\tP4WTT\tP3MI\tP4MI\n" + "-------------------------------------------------------------------\n";
		for(int i = 10; i <= 40; i += 10) {
			mostrar += i + "\t";
			GenerarArchivo g = new GenerarArchivo(i, 100, 100);
			g.generar(nombre);
			String camino = System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
					+ File.separator + "practica03" + File.separator + "datos" + File.separator + nombre + ".txt";
			mochilaP3 = new MochilaP3(camino, 60);
			mochilaP4 = new MochilaP4(camino, 60);
			mostrar += String.format(Locale.US, "%.2f", tiemposWTTP3(pesoWTT)) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposWTTP4(pesoWTT)) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposMIP3(pesoMI)) + "\t";
			mostrar += String.format(Locale.US, "%.2f", tiemposMIP4(pesoMI)) + "\n";
			
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
		mochilaP3 = new MochilaP3();
		mochilaP4 = new MochilaP4();
		
		//Caso mejor
		mostrar("TiempoMejor", 3000, 20000);
		
		//Caso peor
		mostrar("TiempoPeor", 5000, 30000);
		
	}
}
