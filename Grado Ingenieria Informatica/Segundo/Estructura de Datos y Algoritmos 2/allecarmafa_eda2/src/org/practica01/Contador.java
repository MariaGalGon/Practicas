package org.practica01;

import java.util.Locale;

/**
 * Clase Contador.
 */
public class Contador implements Comparable<Contador>{

	/** Flujo del objeto Contador. */
	private double flujo;
	
	/** Media del objeto Contador. */
	private double media;
	
	/** Calle donde se encuentra el contador. */
	private int calle;
	
	/** Avenida donde se encuentra el contador. */
	private int avenida;

	/**
	 * Constructor por defecto de la clase Contador.
	 */
	public Contador() {
		this.flujo = 0.0;
		this.media = 0.0;
		this.calle = 0;
		this.avenida = 0;
	}

	/**
	 * Constructor al que se le pasa por parámetro el flujo, media y dirección del objeto Contador.
	 *
	 * @param flujo the flujo
	 * @param media the media
	 * @param direccion the direccion
	 */
	public Contador(double flujo, double media, String direccion) {
		this.flujo = flujo;
		this.media = media;
		this.calle = Integer.parseInt(direccion.substring(direccion.indexOf('C') + 1));
		this.avenida = Integer.parseInt(direccion.substring(1, direccion.indexOf('C')));
	}
	
	/**
	 * Calcula la variación que se usa en el algoritmo Greedy de flujos.
	 *
	 * @return the double
	 */
	public double variacion() {
		return (flujo-media)/media;
	}

	/**
	 * Devuelve la cantidad de flujo del contador.
	 *
	 * @return flujo
	 */
	public double getFlujo() {
		return flujo;
	}

	/**
	 * Establece el flujo al valor del parámetro.
	 *
	 * @param flujo
	 */
	public void setFlujo(double flujo) {
		this.flujo = flujo;
	}

	/**
	 * Devuelve la media del contador.
	 *
	 * @return media
	 */
	public double getMedia() {
		return media;
	}

	/**
	 * Establece la media al valor del parámetro.
	 *
	 * @param media
	 */
	public void setMedia(double media) {
		this.media = media;
	}

	/**
	 * Devuelve la calle donde se encuentra el contador.
	 *
	 * @return calle
	 */
	public int getCalle() {
		return calle;
	}

	/**
	 * Establece la calle al valor que se le introduce por parámetro.
	 *
	 * @param calle the new calle
	 */
	public void setCalle(int calle) {
		this.calle = calle;
	}

	/**
	 * Devuelve la avenida donde se encuentra el contador.
	 *
	 * @return avenida
	 */
	public int getAvenida() {
		return avenida;
	}

	/**
	 * Establece la avenida al valor que se le introduce por parámetro.
	 *
	 * @param avenida
	 */
	public void setAvenida(int avenida) {
		this.avenida = avenida;
	}

	public String toString() {
		return "(" + String.format(Locale.US, "%.2f",flujo) + "/" + String.format(Locale.US, "%.2f",media) + ")";
	}
	
	/**
	 * Devuelve la dirección donde se encuentra el contador.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return "A"+this.avenida+"C"+this.calle;
	}
	/**
	 * Compara dos contadores a partir de la diferencia de sus flujos y medias.
	 * 
	 */
	@Override
	public int compareTo(Contador o) {
		if(this.flujo-this.media > o.flujo-o.media) return -1;
		if(this.flujo-this.media < o.flujo-o.media) return 1;
		return 0;
	}	
}
