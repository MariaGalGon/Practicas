package org.practica03;

import java.util.Comparator;

/**
 * Clase BTComparator.
 */
public class BTComparator implements Comparator<Contador> {

	public int compare(Contador c1, Contador c2) {
		return -Integer.compare(c1.getAT(), c2.getAT());
	}
	
}
