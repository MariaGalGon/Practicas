package org.practica01;

import java.util.ArrayList;

/**
 * Clase Linea.
 */
public class Linea {
	
	/** Estructura donde se guardan los objetos de tipo Parcela. */
	private ArrayList<Parcela> parcelas;
	
	/** Estructura donde se guardan los objetos de tipo Manometro. */
	private ArrayList<Manometro> manometros;

	/**
	 * Constructor por defecto de Linea.
	 */
	public Linea() {
		this.parcelas = new ArrayList<Parcela>();
		this.manometros = new ArrayList<Manometro>();
	}

	/**
	 * Constructor que pasa por parámetro un ArrayList de manómetros.
	 *
	 * @param manometro
	 */
	public Linea(ArrayList<Manometro> manometro) {
		if(manometro !=null) this.manometros = manometro;
		this.parcelas = new ArrayList<Parcela>();
	}

	/**
	 * Devuelve el ArrayList de manómetros.
	 *
	 * @return manometros
	 */
	public ArrayList<Manometro> getManometros() {
		return manometros;
	}
	
	/**
	 * Devuelve el ArrayList de parcelas.
	 *
	 * @return parcelas
	 */
	public ArrayList<Parcela> getParcelas() {
		return parcelas;
	}

	/**
	 * Cambia parcelas por el ArrayList que se pasa por parámetro.
	 *
	 * @param parcelas
	 */
	public void setParcelas(ArrayList<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	/**
	 * Devuelve el tamaño de manometros.
	 *
	 * @return tamano
	 */
	public int sizeManometros() {
		return this.manometros.size();
	}

	/**
	 * Devuelve el tamaño de parcelas.
	 *
	 * @return tamano
	 */
	public int sizeParcelas() {
		return this.parcelas.size();
	}
	
	/**
	 * Hace que los flujos y medias de un archivo Tipo1 se acumulen 
	 * a lo largo de la línea de distribución o la troncal.
	 */
	public void setContadoresGenerales1() {
		double flujo = 0;
		double media = 0;
		for(int i = parcelas.size() - 2; i >= 0; i--) {
			flujo = parcelas.get(i + 1).getFlujoContadorGeneral() + parcelas.get(i).getFlujoContadorGeneral();
			parcelas.get(i).getContadorGeneral().setFlujo(flujo);
			media = parcelas.get(i + 1).getMediaContadorGeneral() + parcelas.get(i).getMediaContadorGeneral();
			parcelas.get(i).getContadorGeneral().setMedia(media);
		}
	}
	
	/**
	 * Hace que los flujos y medias de un archivo Tipo2 se acumulen 
	 * a lo largo de la línea de distribución o la troncal.
	 */
	public void setContadoresGenerales2() {
		double flujo = 0;
		double media = 0;
		for(int i = parcelas.size() - 2; i >= 0; i--) {
			flujo = (parcelas.get(i).getPerdida() + 100) / 100 * (parcelas.get(i + 1).getFlujoContadorGeneral() + parcelas.get(i).getFlujoContadorGeneral());
			parcelas.get(i).getContadorGeneral().setFlujo(flujo);
			media = parcelas.get(i + 1).getMediaContadorGeneral() + parcelas.get(i).getMediaContadorGeneral();
			parcelas.get(i).getContadorGeneral().setMedia(media);
		}
	}
	
	/**
	 * Comprobar flujo Contadores generales de la linea de distribucion para FBFlujosTuberias.
	 *
	 * @return errores
	 */
	public ArrayList<Integer> comprobarContadoresGeneralesD() {
		ArrayList<Integer> comprobar = new ArrayList<Integer>(); 
		double suma = parcelas.get(1).getFlujoContadorGeneral();
		for(int i = 2; i < sizeParcelas() - 1; i++) {
			suma -= parcelas.get(i-1).sumaFlujos();
			if(parcelas.get(i).getFlujoContadorGeneral() != suma) {
				comprobar.add(i-1);
				i++;
				suma = parcelas.get(i).getFlujoContadorGeneral();
			}
			if(i == sizeParcelas() - 1) {
				suma -= parcelas.get(i).sumaFlujos();
				if(suma != 0) comprobar.add(i);
			}
		}
		return comprobar;
	}
	
	/**
	 * Comprobar flujo Contadores generales de la troncal para FBFlujosTuberias.
	 *
	 * @return errores
	 */
	public ArrayList<Integer> comprobarContadoresGeneralesT() {
		ArrayList<Integer> comprobar = new ArrayList<Integer>(); 
		double suma = parcelas.get(0).getFlujoContadorGeneral();
		for(int i = 1; i < sizeParcelas() - 1; i++) {
			suma -= parcelas.get(i-1).sumaFlujos();
			if(parcelas.get(i).getFlujoContadorGeneral() != suma) {
				comprobar.add(i-1);
				i++;
				suma = parcelas.get(i).getFlujoContadorGeneral();
			}
			if(i == sizeParcelas() - 1) {
				suma -= parcelas.get(i).sumaFlujos();
				if(suma != 0) comprobar.add(i);
			}
		}
		return comprobar;
	}

	/**
	 * Muestra los datos de los manómetros de Linea.
	 *
	 * @return String
	 */
	public String toStringManometros() {
		String s = "";
		for(int i = 0; i < sizeManometros(); i++) {
			s += getManometros().get(i).getNombre() + ": " + getManometros().get(i).getPresion();
			if(i < sizeManometros() - 1) s += ", ";
		}
		return s;
	}
	
	/**
	 * Muestra las datos de las parcelas de Linea.
	 *
	 * @return String
	 */
	public String toStringFlujos() {
		String s = "";
		for(int i = 0; i < sizeParcelas(); i++) {
			s += getParcelas().get(i).toString();
			if(i < sizeParcelas() - 1) s += "; ";
		}
		return s;
	}
	
	public String toString() {
		String mensaje = "";
		for(Manometro x : this.manometros) {
			mensaje += x.getNombre() + " ";
		}
		return mensaje;
	}
}
