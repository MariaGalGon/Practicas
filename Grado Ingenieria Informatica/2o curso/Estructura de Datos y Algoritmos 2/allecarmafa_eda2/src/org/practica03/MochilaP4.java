package org.practica03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Clase MochilaP4.
 */
public class MochilaP4 {

	/** Elementos. */
	private ArrayList<Contador> elementos;
	
	/** Valor base de atencion (BA). */
	private int ba;
	
	/** Solucion. */
	private ArrayList<Contador> solucion;
	
	/** Numero de elementos. */
	private int numElementos;
	
	/** Peso de la mochila. */
	private int peso;
	
	/** Nivel donde nos encontramos en el arbol. */
	private int nivel;
	
	/** Estado de los nodos del arbol. */
	private int[] s;
	
	/** Valor Optimo Actual (voa). */
	private double voa;
	
	/** Solucion Optima Actual (soa). */
	private int[] soa;
	
	/** pact. */
	private int pact;
	
	/** bact. */
	private int bact;
	
	/**
	 * Constructor por defecto de la clase MochilaP4.
	 */
	public MochilaP4() {
		elementos = new ArrayList<Contador>();
		solucion = new ArrayList<Contador>();
		this.ba = 0;
	}
	
	/**
	 * Constructor donde se le pasa por parametro la ruta del archivo a leer y el BA de la clase MochilaP4.
	 *
	 * @param ruta
	 * @param ba
	 */
	public MochilaP4(String ruta, int ba) {
		elementos = new ArrayList<Contador>();
		solucion = new ArrayList<Contador>();
		this.ba = ba;
		leerArchivo(ruta);
		numElementos = elementos.size();
	}
	
	/**
	 * Leer archivo.
	 *
	 * @param file
	 */
	private void leerArchivo(String file) {
		elementos.clear();
		Scanner fileScanner = null;
		String lectura = null;
		String[] linea = null;
		
		try {
			fileScanner = new Scanner(new File(file));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
		}
		while (fileScanner.hasNextLine()) {
			lectura = fileScanner.nextLine().trim();
			if (lectura.isEmpty() || lectura.startsWith("@")) continue;
			linea = lectura.split(";");
			addObjetos(linea);
		}		
	}
	
	/**
	 * Anade objetos al ArrayList elementos.
	 *
	 * @param linea
	 */
	private void addObjetos(String...linea) {
		double bc = Double.parseDouble(linea[1]);
		int porcentaje = Integer.parseInt(linea[2]);
		int op = Integer.parseInt(linea[3]);
		Contador aux = new Contador(bc, linea[0], porcentaje, op);
		aux.setAT(ba);
		
		elementos.add(aux);
	}

	/**
	 * Devuelve elementos.
	 *
	 * @return elementos
	 */
	public ArrayList<Contador> getElementos() {
		return elementos;
	}

	/**
	 * Devuelve solucion.
	 *
	 * @return solucion
	 */
	public ArrayList<Contador> getSolucion() {
		return solucion;
	}

	/**
	 * Algoritmo para el problema WTT.
	 *
	 * @param peso
	 */
	public void problemaWTT(int peso) {
		Collections.sort(elementos, new BTComparator());
		this.peso = peso;
		nivel = 0;
		s = new int[numElementos];
		Arrays.fill(s, -1);
		voa = Double.MIN_VALUE;
		pact = 0;
		bact = 0;
		
		//Realizar algoritmo
		do {
			generarWTT();
			
			if(solucionWTT() && bact > voa) {
				voa = bact;
				soa = new int[numElementos];
				System.arraycopy(s, 0, soa, 0, numElementos);
			}
			
			if(criterio() && pact <= this.peso) {
				nivel++;
			} else {
				while((nivel > -1) && !masHermanos()) {
					retrocederWTT();
				}
			}
			
		} while(nivel > -1);
		
		//Obtener elementos de la solucion
		if(soa != null) {
			solucion.clear();
			for(int i = 0; i < soa.length; i++) {
				if(soa[i] == 1) {
					solucion.add(elementos.get(i));
				}
			}
		}
		
	}
	
	/**
	 * Generar WTT.
	 */
	private void generarWTT() {
		s[nivel]++;
		if(s[nivel] == 1) {
			pact += elementos.get(nivel).getAT();
			bact += elementos.get(nivel).getOp();
		} 
	}
	
	/**
	 * Solucion WTT.
	 *
	 * @return true si se cumplen las condiciones
	 */
	private boolean solucionWTT() {
		return (nivel == numElementos - 1) && (pact <= peso);
	}
	
	/**
	 * Retroceder WTT.
	 */
	private void retrocederWTT() {
		pact -= elementos.get(nivel).getAT();
		bact -= elementos.get(nivel).getOp();
		s[nivel] = -1;
		nivel--;
	}
	
	/**
	 * Algoritmo para el problema MI.
	 *
	 * @param peso
	 */
	public void problemaMI(int peso) {
		Collections.sort(elementos, new BTComparator());
		this.peso = peso;
		nivel = 0;
		s = new int[numElementos];
		Arrays.fill(s, -1);
		voa = Double.POSITIVE_INFINITY;
		pact = 0;
		bact = 0;
		
		//Realizar algoritmo
		do {
			generarMI();
			
			if(solucionMI() && bact < voa) {
				voa = bact;
				soa = new int[numElementos];
				System.arraycopy(s, 0, soa, 0, numElementos);
			}
			
			if(criterio() && bact <= voa) {
				nivel++;
			} else {
				while((nivel > -1) && !masHermanos()) {
					retrocederMI();
				}
			}
			
		} while(nivel > -1);
		
		//Obtener elementos de la solucion
		if(soa != null) {
			solucion.clear();
			for(int i = 0; i < soa.length; i++) {
				if(soa[i] == 1) {
					solucion.add(elementos.get(i));
				}
			}
		}
	}
	
	/**
	 * Generar MI.
	 */
	private void generarMI() {
		s[nivel]++;
		if(s[nivel] == 1) {
			pact += elementos.get(nivel).getOp();
			bact += elementos.get(nivel).getAT();
		}
	}
	
	/**
	 * Solucion MI.
	 *
	 * @return true si se cumplen las condiciones
	 */
	private boolean solucionMI() {
		return (nivel == numElementos - 1) && (pact >= peso);
	}
	
	/**
	 * Retroceder MI.
	 */
	private void retrocederMI() {
		pact -= elementos.get(nivel).getOp();
		bact -= elementos.get(nivel).getAT();
		s[nivel] = -1;
		nivel--;
	}
	
	/**
	 * Criterio.
	 *
	 * @return true si se cumplen las condiciones
	 */
	private boolean criterio() {
		return nivel < numElementos - 1;
	}
	
	/**
	 * Mas hermanos.
	 *
	 * @return true si se cumplen las condiciones
	 */
	private boolean masHermanos() {
		return s[nivel] < 1;
	}
	
	/**
	 * Tiene datos.
	 *
	 * @return true, if successful
	 */
	public boolean tieneDatos() {
		return elementos.size() >= 1 ? true : false;
	}
	
	/**
	 * ToString WTT.
	 *
	 * @return StringBuilder
	 */
	public StringBuilder toStringWTT() {
		StringBuilder mensaje = new StringBuilder();
		
		if(!solucion.isEmpty()) {
			mensaje.append("El resultado del algoritmo es: ");
			for(Contador x : solucion) {
				mensaje.append(x.toStringWTT()).append(", ");
			}
			mensaje.delete(mensaje.length() - 2, mensaje.length() - 1);
		} else {
			mensaje.append("El algoritmo no tiene solucion.");
		}
		
		return mensaje;
	}
	
	/**
	 * ToString MI.
	 *
	 * @return StringBuilder
	 */
	public StringBuilder toStringMI() {
		StringBuilder mensaje = new StringBuilder();
		
		if(!solucion.isEmpty()) {
			mensaje.append("El resultado del algoritmo es: ");
			for(Contador x : solucion) {
				mensaje.append(x.toStringMI()).append(", ");
			}
			mensaje.delete(mensaje.length() - 2, mensaje.length() - 1);
		} else {
			mensaje.append("El algoritmo no tiene solucion.");
		}
		
		return mensaje;
	}	
}