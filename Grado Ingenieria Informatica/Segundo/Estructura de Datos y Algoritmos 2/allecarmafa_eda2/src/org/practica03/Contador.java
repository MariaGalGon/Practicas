package org.practica03;

/**
 * Clase Contador.
 */
public class Contador implements Comparable<Contador>{

	/** Flujo del objeto Contador (BC). */
	private double flujo;
	
	/** Calle donde se encuentra el contador. */
	private int calle;
	
	/** Avenida donde se encuentra el contador. */
	private int avenida;
	
	/** Porcentaje de error (IP). */
	private int porcentaje;
	
	/** Precio ofertado para arreglar la fuga (OP). */
	private int op;
	
	/** Tiempo de atencion de la averia (AT). */
	private int at;

	/**
	 * Constructor por defecto de la clase Contador.
	 */
	public Contador() {
		this.flujo = 0.0;
		this.calle = 0;
		this.avenida = 0;
		this.porcentaje = 0;
		this.op = 0;
	}

	/**
	 * Constructor al que se le pasa por parámetro el flujo, la dirección, el porcentaje y el OP del objeto Contador.
	 *
	 * @param flujo
	 * @param direccion
	 * @param porcentaje
	 * @param op
	 */
	public Contador(double flujo, String direccion, int porcentaje, int op) {
		this.flujo = flujo;
		this.calle = Integer.parseInt(direccion.substring(direccion.indexOf('C') + 1));
		this.avenida = Integer.parseInt(direccion.substring(1, direccion.indexOf('C')));
		this.porcentaje = porcentaje;
		this.op = op;
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
	 * @param calle
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

	/**
	 * Devuelve el porcentaje (IP).
	 *
	 * @return porcentaje
	 */
	public int getPorcentaje() {
		return porcentaje;
	}

	/**
	 * Devuelve el precio ofertado (OP).
	 *
	 * @return op
	 */
	public int getOp() {
		return op;
	}
	
	/**
	 * Devuelve el tiempo de atencion (AT).
	 *
	 * @return at
	 */
	public int getAT() {
		return at;
	}

	/**
	 * Establece AT segun la formula indicada.
	 *
	 * @param BA
	 */
	public void setAT(int BA) {
		this.at = (int) (BA + ((5 * flujo) + (12 * (porcentaje - 7))));
	}

	/**
	 * ToString para el problema WTT.
	 *
	 * @return string
	 */
	public String toStringWTT() {
		return this.getNombre() + " (" + getAT() + ")";
	}
	
	/**
	 * ToString para el problema MI.
	 *
	 * @return string
	 */
	public String toStringMI() {
		return this.getNombre() + " (" + getOp() + ")";
	}
	
	/**
	 * Devuelve la direccion donde se encuentra el contador.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return "A"+this.avenida+"C"+this.calle;
	}
	
	/**
	 * Compara dos contadores a partir de los flujos.
	 *
	 * @param o
	 * @return comparacion
	 */
	@Override
	public int compareTo(Contador o) {
		if(this.flujo > o.flujo) return 1;
		if(this.flujo < o.flujo) return -1;
		return 0;
	}	
}
