package org.practica03;

import java.util.Comparator;

/**
 * Clase BeneficioComparator.
 */
public class BeneficioComparator implements Comparator<Contador> {

	public int compare(Contador c1, Contador c2) {
		return Integer.compare(c1.getOp(), c2.getOp());
	}
	
}
