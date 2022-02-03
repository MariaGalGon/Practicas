package org.practica03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase GenerarArchivo.
 */
public class GenerarArchivo {

	/** Numero de edificios con error. */
	private int edificios;
	
	/** Calles de la ciudad. */
	private int calles;
	
	/** Avenidas de la ciudad. */
	private int avenidas;
	
	/** Direcciones usadas. */
	private ArrayList<String> usados;
	
	/**
	 * Constructor de la clase GenerarArchivo.
	 *
	 * @param numElementos
	 * @param avenidas
	 * @param calles
	 */
	public GenerarArchivo(int numElementos, int avenidas, int calles) {
		edificios = numElementos;
		this.calles = calles;
		this.avenidas = avenidas;
		usados = new ArrayList<String>();
	}
	
	/**
	 * Metodo para generar el archivo.
	 *
	 * @param nombre
	 * @throws FileNotFoundException
	 */
	public void generar(String nombre) throws FileNotFoundException {
		File f = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
				+ File.separator + "practica03" + File.separator + "datos" + File.separator + nombre + ".txt");
		PrintWriter pw = new PrintWriter(f);
		
		pw.println("@Tamano: " + avenidas + " x " + calles);
		pw.println("@Numero edificios: " + edificios + "\n");
		pw.println("@Direccion;BC;IP;OP");
		
		avenidas = avenidas - 1;
		calles = calles - 1;
		
		int av = 0;
		int cal = 0;
		int min = 0;
		boolean error = false;
		boolean par = false;
		String direccion = "";
		for(int i = 0; i < edificios; i++) {
			do {
				if(avenidas % 2 == 0) {
					min = 2;
					par = true;
				} else {
					min = 1;
					par = false;
				}
				av = (int) (Math.random() * (avenidas - min) + min);
				cal = (int) (Math.random() * (calles - 3) + 3);
				direccion = "A" + av + "C" + cal;
				
				if(par && (av % 2 == 0)) {
					error = false;					
				} else if((!par) && (av % 2 != 0)) {
					error = false;
				} else {
					error = true;
					continue;
				}
				
				
				if(usados.contains(direccion)) {
					error = true;
					continue;
				} else {
					usados.add(direccion);
					error = false;
					continue;
				}				
			} while(error);
			
			int bc = (int) (Math.random() * 99 + 1);
			int ip = 8 + (int) (Math.random() * 40);
			int op = 4000 + (int) (Math.random() * 46000);
			
			pw.println(direccion + ";" + bc + ";" + ip + ";" + op);
		}
		pw.close();
	}
}
