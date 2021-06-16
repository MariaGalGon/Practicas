package org.practica01;

import java.util.ArrayList;

/**
 * Clase Parcela.
 */
public class Parcela {
	
	/** Estructura donde se guardan los contadores de los consumidores de la parcela */
	private ArrayList<Contador> contadores;
	
	/** Contador donde se guarda la suma de los flujos y medias de los consumidores de la parcela. */
	private Contador contadorGeneral;
	
	/** Porcentaje de pérdida del contadorGeneral. */
	private int perdida;
	
	/**
	 * Constructor por defecto de Parcela.
	 */
	public Parcela () {
		this.contadores = new ArrayList<Contador>();
		this.contadorGeneral = new Contador();
		perdida = 0;
	}
	
	/**
	 * Constructor al que se le pasa por parámetro el contadorGeneral, 
	 * un ArrayList de contadores y el porcentaje de pérdida.
	 *
	 * @param contador
	 * @param contadores
	 */
	public Parcela(Contador contador, ArrayList<Contador> contadores, int perdida) {
		this.contadorGeneral = contador;
		this.contadores = contadores;
		this.perdida = perdida;
	}
	
	/**
	 * Devuelve el porcentaje de pérdida.
	 * 
	 * @return perdida
	 */
	public int getPerdida() {
		return perdida;
	}
	
	/**
	 * Establece el porcentaje de pérdida al valor introducido por parámetro
	 * 
	 * @param perdida
	 */
	public void setPerdida(int perdida) {
		this.perdida = perdida;
	}

	/**
	 * Devuelve el ArrayList de contadores.
	 *
	 * @return contadores
	 */
	public ArrayList<Contador> getContadores() {
		return contadores;
	}

	/**
	 * Establece contadores al valor introducido por parámetro.
	 *
	 * @param contadores
	 */
	public void setContadores(ArrayList<Contador> contadores) {
		this.contadores = contadores;
	}

	/**
	 * Devuelve el contador general.
	 *
	 * @return contador general
	 */
	public Contador getContadorGeneral() {
		return contadorGeneral;
	}

	/**
	 * Establece el contador general al valor introducido por parámetro.
	 *
	 * @param contadorGeneral
	 */
	public void setContadorGeneral(Contador contadorGeneral) {
		this.contadorGeneral = contadorGeneral;
	}
	
	/**
	 * Realiza la suma de los flujos de todos los contadores de los consumidores de la parcela.
	 *
	 * @return suma
	 */
	public double sumaFlujos() {
		double sumaFlujo = 0;
		for(Contador c : contadores) {
			sumaFlujo += c.getFlujo();
		}
		return sumaFlujo;
	}
	
	/**
	 * Realiza la suma de las medias de todos los contadores de los consumidores de la parcela.
	 *
	 * @return suma
	 */
	public double sumaMedias() {
		double sumaMedias = 0;
		for(Contador c : contadores) {
			sumaMedias += c.getMedia();
		}
		return sumaMedias;
	}
	
	/**
	 * Devuelve el flujo del contador general de la parcela.
	 *
	 * @return flujo contador general
	 */
	public double getFlujoContadorGeneral() {
		return contadorGeneral.getFlujo();
	}
	
	/**
	 * Devuelve la media del contador general de la parcela.
	 *
	 * @return media contador general
	 */
	public double getMediaContadorGeneral() {
		return contadorGeneral.getMedia();
	}

	@Override
	public String toString() {
		return contadorGeneral.getNombre() + " -> ContadorGeneral: " + contadorGeneral.toString() + ", contadores: " + contadores.toString();
	}
	
}
