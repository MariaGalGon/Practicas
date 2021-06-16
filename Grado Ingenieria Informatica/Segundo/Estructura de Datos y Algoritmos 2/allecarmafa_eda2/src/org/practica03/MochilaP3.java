package org.practica03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Clase MochilaP3.
 */
public class MochilaP3 {

	/** Elementos. */
	private ArrayList<Contador> elementos;
	
	/** Valor base de atencion (BA). */
	private int ba;
	
	/** MCD. */
	private int mcd;
	
	/** Tabla. */
	private int[][] tabla;
	
	/** Solucion. */
	private ArrayList<Contador> solucion;
	
	/**
	 * Constructor por defecto de la clase MochilaP3.
	 */
	public MochilaP3() {
		elementos = new ArrayList<Contador>();
		solucion = new ArrayList<Contador>();
		ba = 0;
	}
	
	/**
	 * Constructor donde se le pasa por parametro la ruta del archivo a leer y el BA de la clase MochilaP3.
	 *
	 * @param ruta
	 * @param ba
	 */
	public MochilaP3(String ruta, int ba) {
		elementos = new ArrayList<Contador>();
		solucion = new ArrayList<Contador>();
		this.ba = ba;
		leerArchivo(ruta);
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
		Collections.sort(elementos, null);
		int[] pesosSimp = new int[elementos.size()];
		int[] beneficio = new int[elementos.size()];
		
		for(int i = 0; i < elementos.size(); i++) {
			pesosSimp[i] = elementos.get(i).getAT();
			beneficio[i] = elementos.get(i).getOp();
		}
		
		//Simplificar pesos
		mcd = mcd(peso, pesosSimp);
		int pesoMochila = peso / mcd;
		
		for(int i = 0; i < pesosSimp.length; i++) {
			pesosSimp[i] = pesosSimp[i] / mcd;
		}
		
		//Rellenar tabla
		tabla = new int[elementos.size()  + 1][pesoMochila + 1];
		for(int i = 1; i < tabla.length; i++) {
			for(int j = 1; j < tabla[0].length; j++) {
				if(j < pesosSimp[i-1]) {
					tabla[i][j] = tabla[i-1][j];
				} else {
					tabla[i][j] = Math.max(tabla[i-1][j], beneficio[i-1] + tabla[i-1][j-pesosSimp[i-1]]);
				}
			}
		}
	}
	
	/**
	 * Algoritmo para obtener la solucion WTT.
	 */
	public void solucionWTT() {
		solucion = new ArrayList<Contador>();
		int j = tabla[0].length - 1;
		for(int i = tabla.length - 1; i > 0; i--) {
			if(tabla[i][j] != tabla[i-1][j]) {
				solucion.add(elementos.get(i-1));
				j -= elementos.get(i-1).getAT() / mcd;
			}
		}
	}
	
	/**
	 * Algoritmo para el problema MI.
	 *
	 * @param peso
	 */
	public void problemaMI(int peso) {
		Collections.sort(elementos, new BeneficioComparator());
		int[] pesosSimp = new int[elementos.size()];
		int[] beneficio = new int[elementos.size()];
		
		for(int i = 0; i < elementos.size(); i++) {
			pesosSimp[i] = elementos.get(i).getOp();
			beneficio[i] = elementos.get(i).getAT();
		}
		
		//Simplificar pesos
		
		int pesoMochila = (sumaPesos(pesosSimp) - peso);	//Calculo nuevo peso de la mochila
		mcd = mcd(pesoMochila, pesosSimp);
		
		pesoMochila = pesoMochila / mcd;
		for(int i = 0; i < pesosSimp.length; i++) {
			pesosSimp[i] = pesosSimp[i] / mcd;
		}
		
		//Rellenar tabla
		tabla = new int[elementos.size()  + 1][pesoMochila + 1];
		for(int i = 1; i < tabla.length; i++) {
			for(int j = 1; j < tabla[0].length; j++) {
				if(j < pesosSimp[i-1]) {
					tabla[i][j] = tabla[i-1][j];
				} else {
					tabla[i][j] = Math.max(tabla[i-1][j], beneficio[i-1] + tabla[i-1][j-pesosSimp[i-1]]);
				}
			}
		}
	}
	
	/**
	 * Algoritmo para obtener la solucion MI.
	 */
	public void solucionMI() {
		solucion = new ArrayList<Contador>();
		int j = tabla[0].length - 1;
		for(int i = tabla.length - 1; i > 0; i--) {
			if(tabla[i][j] != tabla[i-1][j]) {
				j -= elementos.get(i-1).getOp() / mcd;
			} else {
				solucion.add(elementos.get(i-1));
			}
		}
	}
	
	/**
	 * Suma pesos del array introducido.
	 *
	 * @param pesos
	 * @return peso total
	 */
	private int sumaPesos(int[] pesos) {
		int suma = 0;
		for(int i = 0; i < pesos.length; i++) {
			suma += pesos[i];
		}
		return suma;
	}
	
	/**
	 * MCD.
	 *
	 * @param peso
	 * @param x
	 * @return mcd
	 */
	private int mcd(int peso, int[] x) {
		int mcd = peso;
		
		for(int i = 0; i < x.length; i++) {
			mcd = mcdIndividual(mcd, x[i]);
		}
		
		return mcd;
	}
	
	/**
	 * MCD para dos elementos.
	 *
	 * @param a
	 * @param b
	 * @return mcd
	 */
	private int mcdIndividual(int a, int b) {
		int resto = 0;
		
		do {            
            resto = a % b;
            a = b;
            if (resto != 0) b = resto;            
        } while (resto != 0);
		
        return b;
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