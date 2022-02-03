package org.practica01;

/**
 * Clase Manometro.
 */
public class Manometro {
	
	/** presión del objeto Manometro. */
	private double presion;
	
	/** calle donde se encuentra el objeto Manometro. */
	private int calle;
	
	/** avenida donde se encuentra el objeto Manometro. */
	private int avenida;
	
	/** es true si el elemento está en la troncal. */
	private boolean esTroncal;

	/**
	 * Constructor por defecto de Manometro.
	 */
	public Manometro() {
		this.presion = 0;
		this.calle = 0;
		this.avenida = 0;
		this.esTroncal = false;
	}

	/**
	 * Constructor que pasa por parámetro la presión, 
	 * dirección y si el elemento está en la troncal.
	 *
	 * @param presion
	 * @param direccion
	 * @param esTroncal
	 */
	public Manometro(double presion, String direccion, boolean esTroncal) {
		this.presion = presion;
		this.esTroncal = esTroncal;
		this.calle = Integer.parseInt(direccion.substring(direccion.indexOf('C') + 1));
		this.avenida = Integer.parseInt(direccion.substring(1, direccion.indexOf('C')));
	}

	/**
	 * Devuelve la presión del manómetro.
	 *
	 * @return presion
	 */
	public double getPresion() {
		return presion;
	}

	/**
	 * Comprueba si el manometro es de la troncal.
	 *
	 * @return true si esta en la troncal
	 */
	public boolean isEsTroncal() {
		return esTroncal;
	}
	
	/**
	 * Devuelve la dirección del manómetro.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return (esTroncal ? "(T)" : "(D)") + "A"+this.avenida+"C"+this.calle;
	}

	/**
	 * Devuelve la dirección del manómetro y su presión.
	 *
	 * @return string
	 */
	public String toStringExtend() {
		return this.getNombre()+this.toString();
	}

	@Override
	public String toString() {
		return " (" + presion + ")";
	}

	
}
