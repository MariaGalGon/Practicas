package org.practica01;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Clase GeneradorPruebas1.
 */
public class GeneradorPruebas1 {

	/** Numero avenidas. */
	private int numAvenidas;
	
	/** Numero calles. */
	private int numCalles;
	
	/** Incluye los fallos de presión que se desean insertar en la ciudad. */
	private ArrayList<String> fallosPresion;
	
	/** Incluye los fallos de flujo que se desean insertar en la ciudad. */
	private ArrayList<String> fallosFlujo;
	
	/** Indica la presión máxima de la ciudad, es decir, la presión del depósito. */
	private final double PRESION_MAX = 150;

	/**
	 * Establece las variables globales de la clase a los valores de los parámetros del constructor.
	 *
	 * @param avenidas
	 * @param calles
	 * @param fallosPresion
	 * @param fallosFlujo
	 */
	public GeneradorPruebas1(int avenidas, int calles, ArrayList<String> fallosPresion, ArrayList<String> fallosFlujo) {
		numAvenidas = avenidas;
		numCalles = calles;
		this.fallosPresion = fallosPresion;
		this.fallosFlujo = fallosFlujo;
	}
	
	/**
	 * Genera el archivo usando los métodos generarPresion y generarFlujo.
	 *
	 * @param archivo
	 * @throws IOException
	 */
	public void generar(String archivo) throws IOException {
		File f = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "org"
				+ File.separator + "practica01" + File.separator + "datos" + File.separator + archivo + ".txt");
		PrintWriter pw = new PrintWriter(f);
		int calles = numCalles - 1;
		int avenidas = numAvenidas - 1;
		
		pw.println("@Tipo1");
		pw.println("@Tamano: " + numAvenidas + " x " + numCalles);
		pw.println();
		
		StringBuilder presion = generarPresion(avenidas, calles);
		pw.println(presion);
		
		StringBuilder flujo = generarFlujo(avenidas, calles);
		pw.println(flujo);
		
		pw.close();
	}
	
	/**
	 * Genera la parte del archivo de presiones.
	 *
	 * @param avenidas
	 * @param calles
	 * @return StringBuilder
	 */
	private StringBuilder generarPresion(int avenidas, int calles) {
		StringBuilder s = new StringBuilder();
		int y = 0;
		int x = 0;
		int errorCalle = 0;
		int errorAvenida = 0;
		double porcentaje = 0;
		double presionDistribucion = 0;
		double presionTroncal = 0;
		double antesTroncal = 0;
		boolean errorAqui = false;
		boolean errorTroncal = false;
		boolean errorPasadoT = false;
		boolean errorPasadoD = false;
		boolean errorPresion = false;
		if (!(fallosPresion.isEmpty() || fallosPresion == null)) errorPresion = true;
		
		s.append("#Presiones\n\n");
		
		for(int i = avenidas; i > 0; i -= 2) {
			y = 0;
			errorPasadoD = false;			
			
			for (int j = calles; j >= 3; j--) {
				errorTroncal = false;
				errorAqui = false;
				
				//Funcion para asignar presiones troncal
				if(errorPasadoT) presionTroncal = -0.2 + antesTroncal;
				else presionTroncal = -0.2 * x + PRESION_MAX;
				
				//Funcion para asignar presiones linea de distribucion
				if(errorPasadoD) presionDistribucion = -0.2 + presionDistribucion;
				else presionDistribucion = -0.2 * y + presionTroncal;
				
				if(errorPresion) {
					for(String elemento : fallosPresion) {
						String[] partes = elemento.split(" ");
						errorAvenida = Integer.parseInt(partes[0].substring(1, partes[0].indexOf('C')));
						errorCalle = Integer.parseInt(partes[0].substring(partes[0].indexOf('C') + 1));
						porcentaje = Double.parseDouble(partes[1]);
						if(i == errorAvenida && j == errorCalle) {
							if(errorCalle == calles) {
								errorTroncal = true;
								errorPasadoT = true;
							} else {
								errorPasadoD = true;
							}
							errorAqui = true;							
							break;
						}
					}
				}
				
				if(errorAqui) {
					if(errorTroncal) {
						presionTroncal = presionTroncal * (1 - (porcentaje / 100));
						presionDistribucion = -0.2 * y + presionTroncal;
					} else {
						presionDistribucion = presionDistribucion * (1 - (porcentaje / 100));					
					}
				}
					
				if (j == calles) {
					if(presionTroncal < 0) presionTroncal = 0;
					if(errorAqui) s.append("A").append(i).append("C").append(j).append(" ").append(String.format(Locale.US, "%.4f", presionTroncal)).append(", ");
					else s.append("A").append(i).append("C").append(j).append(" ").append(String.format(Locale.US, "%.1f", presionTroncal)).append(", ");
					
					antesTroncal = presionTroncal;
					presionDistribucion -= 0.2;
					x++;
				}
				y++;
				if(presionDistribucion < 0) presionDistribucion = 0;
				if(errorAqui) s.append("A").append(i).append("C").append(j).append(" ").append(String.format(Locale.US, "%.4f", presionDistribucion)).append(", ");
				else s.append("A").append(i).append("C").append(j).append(" ").append(String.format(Locale.US, "%.1f", presionDistribucion)).append(", ");
				
							
			}
			s.delete(s.length() - 2, s.length() - 1);
			s.append("\n");
		}
		
		return s;
	}
	
	/**
	 * Genera la parte del archivo de flujos.
	 *
	 * @param avenidas
	 * @param calles
	 * @return StringBuilder
	 */
	private StringBuilder generarFlujo(int avenidas, int calles) {
		StringBuilder s = new StringBuilder();
		int errorCalle = 0;
		int errorAvenida = 0;
		double porcentaje = 0;
		boolean errorAqui = false;
		boolean errorFlujo = false;
		if (!(fallosFlujo.isEmpty() || fallosFlujo == null)) errorFlujo = true;
		
		s.append("#Flujos\n\n");
		
		for (int i = avenidas; i > 0; i -= 2) {
			for (int j = calles; j >= 3; j--) {
				errorAqui = false;
				StringBuilder sFlujos = new StringBuilder();
				StringBuilder sMedia = new StringBuilder();
				double media = 0;
				double flujo = 0;
				int cont = 0;
				
				s.append("A").append(i).append("C").append(j).append(" ").append("P-");
				
				if(errorFlujo) {
					for (String elemento : fallosFlujo) {
						String[] partes = elemento.split(" ");
						errorAvenida = Integer.parseInt(partes[0].substring(1, partes[0].indexOf('C')));
						errorCalle = Integer.parseInt(partes[0].substring(partes[0].indexOf('C') + 1));
						porcentaje = Double.parseDouble(partes[1]);
						if(i == errorAvenida && j == errorCalle) {
							errorAqui = true;
							break;
						}
					}
				}
				for(int k = 0; k < 4; k++) {
					if (errorAqui) {
						if (j == calles && i == avenidas) {	//3 consumidores
							if (cont == 0) {
								media = (Math.random() * 60 + 10);
								flujo = media * (porcentaje / 100);
								cont++;
							} else {
								media = (Math.random() * 60 + 10);
								flujo = media * (Math.random() * 2 + 0.1);
								cont = 0;
							}
							if (k == 3) break;
						} else if (j == calles || j == 1) { //4 consumidores
							if (cont == 0) {
								media = (Math.random() * 60 + 10);
								flujo = media * (porcentaje / 100);
								cont++;
							} else {
								media = (Math.random() * 60 + 10);
								flujo = media * (Math.random() * 2 + 0.1);
								cont = 0;
							}
						} else { //2 consumidores
							if (cont == 0) {
								media = (Math.random() * 60 + 10);
								flujo = media * (porcentaje / 100);
								cont++;
							} else {
								media = (Math.random() * 60 + 10);
								flujo = media * (Math.random() * 2 + 0.1);
								cont = 0;
							}
							if (k == 2) break;
						}
					} else {
						if (j == calles && i == avenidas) {
							media = (Math.random() * 60 + 10); 
							flujo = media * (Math.random() * 2 + 0.1); 
							if (k == 3) break;
						} else if (j == calles || j == 1) {
							media = (Math.random() * 60 + 10);
							flujo = media * (Math.random() * 2 + 0.1);
						} else {
							media = (Math.random() * 60 + 10);
							flujo = media * (Math.random() * 2 + 0.1);
							if (k == 2) break;
						}
						
					}
					if(flujo < 0) flujo = 0;
					sFlujos.append(String.format(Locale.US, "%.1f", flujo)).append(";");
					if(media < 0) media = 0;
					sMedia.append(String.format(Locale.US, "%.1f", media)).append(";");
				}
				s.append(sFlujos.delete(sFlujos.length() - 1, sFlujos.length())).append(" ").append("M-").append(sMedia.delete(sMedia.length() - 1, sMedia.length())).append(", ");
			}			
			s.delete(s.length() - 2, s.length() - 1);
			s.append("\n");
		}
		
		return s;
	}
	
}