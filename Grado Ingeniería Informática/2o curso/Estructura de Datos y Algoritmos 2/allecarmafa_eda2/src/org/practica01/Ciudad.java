package org.practica01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase Ciudad.
 */
public class Ciudad {
	
	/** Estructura donde se guardan todos los objetos de tipo Lineas. */
	private ArrayList<Linea> ciudad;
	
	/** Array que contiene todos los errores de presiones. */
	private ArrayList<String> erroresPresiones;
	
	/** Array que contiene todos los errores de flujos. */
	private ArrayList<String> erroresFlujos;

	/**
	 * Constructor por defecto de Ciudad.
	 */
	public Ciudad() {
		ciudad = new ArrayList<Linea>();
		erroresPresiones = new ArrayList<String>();
		erroresFlujos = new ArrayList<String>();
	}
	
	/**
	 * Método cargar archivo que diferencia entre el tipo 1 o 2, 
	 * dependiendo de si los contadores tienen pérdidas o no.
	 *
	 * @param file
	 * @throws IOException
	 */
	public void cargarArchivo(String file) throws IOException {
		ciudad.clear();
		Scanner fileScanner = null;
		String lectura = null;
		Linea troncal = new Linea();
		
		ciudad.add(0, troncal);
		
		try {
			fileScanner = new Scanner(new File(file));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
		}
		lectura = fileScanner.nextLine().trim();
		if(lectura.equals("@Tipo1")) cargarArchivo1(file);
		else if(lectura.equals("@Tipo2")) cargarArchivo2(file);
		
	}
	
	/**
	 * Cargar archivo de contadores sin pérdidas.
	 *
	 * @param file
	 * @throws IOException
	 */
	private void cargarArchivo1(String file) throws IOException {
		Scanner fileScanner = null;
		String[] linea = null;
		String lectura = null;
		String seccion = ""; //Si igual P presiones y si F flujos
		int numLinea = 1;
		
		try {
			fileScanner = new Scanner(new File(file));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
		}
		while (fileScanner.hasNextLine()) {
			lectura = fileScanner.nextLine().trim();
			if (lectura.isEmpty() || lectura.startsWith("@")) continue;
			linea = lectura.split(", ");
			if(lectura.startsWith("#Presiones")) {
				seccion = "P";
				continue;
			}
			if(lectura.startsWith("#Flujo")) {
				seccion = "F";
				continue;
			}
			if(seccion.equals("P")) addPresiones(linea);
			if(seccion.equals("F")) addFlujos1(numLinea++, linea);
		}
		for(int i = 1; i < ciudad.size(); i++) {
			ciudad.get(i).setContadoresGenerales1();			
		}
		ciudad.get(0).setContadoresGenerales1();
	}
	
	/**
	 * Cargar archivo de contadores con pérdidas.
	 *
	 * @param file
	 * @throws IOException
	 */
	 
	
	private void cargarArchivo2(String file) throws IOException {
		Scanner fileScanner = null;
		String[] linea = null;
		String lectura = null;
		String seccion = ""; //Si igual P presiones y si F flujos
		int numLinea = 1;

		try {
			fileScanner = new Scanner(new File(file));
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
		}
		while (fileScanner.hasNextLine()) {
			lectura = fileScanner.nextLine().trim();
			if (lectura.isEmpty() || lectura.startsWith("@")) continue;
			linea = lectura.split(", ");
			if(lectura.startsWith("#Presiones")) {
				seccion = "P";
				continue;
			}
			if(lectura.startsWith("#Flujo")) {
				seccion = "F";
				continue;
			}
			if(seccion.equals("P")) addPresiones(linea);
			if(seccion.equals("F")) addFlujos2(numLinea++, linea);
		}
		for(int i = 1; i < ciudad.size(); i++) {
			ciudad.get(i).setContadoresGenerales2();			
		}
		ciudad.get(0).setContadoresGenerales2();
	}
	
	/**
	 * Añade los contadores sin pérdidas a las parcelas.
	 *
	 * @param linea
	 * @param flujos
	 */
	private void addFlujos1(int linea, String...flujos) {
		ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
		Parcela aux = null;
		
		for(String elemento : flujos) {
			aux = new Parcela();
			String[] flujo = elemento.split(" ");
			String[] contador = flujo[1].split(";");
			contador[0] = contador[0].substring(2);
			String[] media = flujo[2].split(";");
			media[0] = media[0].substring(2);
			
			for(int i = 0; i < contador.length; i++) {
				aux.getContadores().add(new Contador(Double.parseDouble(contador[i]), Double.parseDouble(media[i]), flujo[0]));
			}
			
			Contador general = new Contador(aux.sumaFlujos(), aux.sumaMedias(), flujo[0]);
			aux.setContadorGeneral(general);
			parcelas.add(aux);
			
			if(elemento.equals(flujos[0])) {
				ciudad.get(0).getParcelas().add(aux);
			}
		}
		Linea lin = ciudad.get(linea);
		lin.setParcelas(parcelas);
	}

	/**
	 * Añade los contadores con pérdidas a las parcelas.
	 *
	 * @param linea
	 * @param flujos
	 */
	private void addFlujos2(int linea, String...flujos) {
		ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
		Parcela aux = null;
		
		for(String elemento : flujos) {
			aux = new Parcela();
			String[] flujo = elemento.split(" ");
			String[] contador = flujo[1].split(";");
			contador[0] = contador[0].substring(2);
			String[] media = flujo[2].split(";");
			media[0] = media[0].substring(2);
			int perdida = Integer.parseInt(flujo[3].substring(0, flujo[3].indexOf('%')));
			
			for(int i = 0; i < contador.length; i++) {
				aux.getContadores().add(new Contador(Double.parseDouble(contador[i]), Double.parseDouble(media[i]), flujo[0]));
			}
			
			Contador general = new Contador(aux.sumaFlujos(), aux.sumaMedias(), flujo[0]);
			aux.setContadorGeneral(general);
			aux.setPerdida(perdida);
			parcelas.add(aux);
			
			if(elemento.equals(flujos[0])) {
				ciudad.get(0).getParcelas().add(aux);
			}
		}
		Linea lin = ciudad.get(linea);
		lin.setParcelas(parcelas);
	}

	/**
	 * Incorpora los datos de los manometros.
	 *
	 * @param presiones
	 */
	public void addPresiones(String... presiones) {
		ArrayList<Manometro> listaMan = new ArrayList<Manometro>();
		for (String elemento : presiones) {
			Manometro man = null;
			String[] presion = elemento.split(" ");
			if(elemento.equals(presiones[0])) {	
				man = new Manometro(Double.parseDouble(presion[1]), presion[0], true);
			}else {
				man = new Manometro(Double.parseDouble(presion[1]), presion[0], false);
			}
			listaMan.add(man);
			if(man.isEsTroncal()) {
				ciudad.get(0).getManometros().add(man);
			}
		}
		Linea aux = new Linea(listaMan);
		ciudad.add(aux);
	}

	/**
	 * Devuelve la ciudad.
	 *
	 * @return ciudad
	 */
	public ArrayList<Linea> getCiudad() {
		return ciudad;
	}
	
	/**
	 * Devuelve el array de errores de presiones.
	 *
	 * @return errores presiones
	 */
	public ArrayList<String> getErroresPresiones() {
		return erroresPresiones;
	}
	
	/**
	 * Muestra el contenido de erroresPresiones.
	 */
	public void mostrarErroresPresiones() {
		if(erroresPresiones.size() == 0) {
			System.out.println("No se encontraron errores");
			return;
		}
		for (String s : erroresPresiones) {
			System.out.println(s);
		}
		erroresPresiones.clear();
		System.out.println();
	}

	/**
	 * Muestra el contenido de erroresFlujos.
	 */
	public void mostrarErroresFlujos() {
		if(erroresFlujos.size() == 0) {
			System.out.println("No se encontraron errores");
			return;
		}
		for (String s : erroresFlujos) {
			System.out.println(s);
		}
		erroresFlujos.clear();
		System.out.println();
	}
	
	/**
	 * Método público que realiza el algoritmo Divide y Vencerás de presiones.
	 */
	public void DividePresiones() {
		for (int i = 0; i < ciudad.size(); i++) {
			DividePresiones(ciudad.get(i).getManometros(), 0, ciudad.get(i).sizeManometros() - 1);
		}
		
	}

	/**
	 * Método privado que realiza el algoritmo Divide y Vencerás de presiones.
	 *
	 * @param a 
	 * @param inicio
	 * @param fin
	 */
	private void DividePresiones(ArrayList<Manometro> a, int inicio, int fin) {
		if (a.get(inicio).getPresion() * 0.9 <= a.get(fin).getPresion()) return;
		if (inicio + 1 == fin) {
			erroresPresiones.add("Error entre " + a.get(inicio).toStringExtend()+" y " + a.get(fin).toStringExtend());
		} else {
			int mitad = (inicio + fin) / 2;
			DividePresiones(a, inicio, mitad);
			DividePresiones(a, mitad, fin);
		}
	}
	
	/**
	 * Método público que realiza el algoritmo Divide y Vencerás de flujos.
	 */
	public void DivideFlujos() {		
		for (int i = 0; i < ciudad.size(); i++) {
			ciudad.get(i).getParcelas().add(new Parcela());	//FANTASMA
			DivideFlujos(ciudad.get(i).getParcelas(), 0, ciudad.get(i).sizeParcelas() - 1);
			ciudad.get(i).getParcelas().remove(ciudad.get(i).getParcelas().size()-1);	//ELIMINO FANTASMA
		}
	}
	
	/**
	 * Método privado que realiza el algoritmo Divide y Vencerás de flujos.
	 *
	 * @param a
	 * @param inicio
	 * @param fin
	 */
	private void DivideFlujos(ArrayList<Parcela> a, int inicio, int fin) {
		double varianza = calculoVarianza(a, inicio, fin);
		if(inicio+1 == fin) {
			for (Contador c : a.get(inicio).getContadores()) {
				if((c.getFlujo()-c.getMedia())/c.getMedia() > 7) {
					erroresFlujos.add("Error entre " + a.get(inicio).getContadorGeneral().getNombre()+a.get(inicio).getContadorGeneral().toString() 
							+" y " + a.get(fin).getContadorGeneral().getNombre()+a.get(fin).getContadorGeneral().toString());
				}
			}
		}else {
			int mitad = (inicio+fin)/2;
			if(varianza < calculoVarianza(a, inicio, mitad)) DivideFlujos(a, inicio, mitad);
			if(varianza < calculoVarianza(a, mitad, fin)) DivideFlujos(a, mitad, fin);
		}
	}
	
	
	
	/**
	 * Método que realiza el algoritmo Greedy de presiones.
	 */
	public void GreedyPresiones() {
		String s = "";
		ArrayList<String> aux = new ArrayList<>();
		double variacion = 0;
		for (int i = 0; i < ciudad.size(); i++) {
			for (int j = 0; j < ciudad.get(i).getManometros().size()-1; j++) {
				if(j == ciudad.get(i).getManometros().size()-2) break;
				variacion = (ciudad.get(i).getManometros().get(j).getPresion()
						-ciudad.get(i).getManometros().get(j+1).getPresion())
						/ciudad.get(i).getManometros().get(j).getPresion();
				s = variacion+": "+ciudad.get(i).getManometros().get(j).getNombre()
						+" ("+ciudad.get(i).getManometros().get(j).getPresion()+") - "
						+ciudad.get(i).getManometros().get(j+1).getNombre()
						+" ("+ciudad.get(i).getManometros().get(j+1).getPresion()+")";
				aux.add(s);
			}
		}
		// 14: (T)A14C3
		Collections.sort(aux);
		for (int i = aux.size()-1; i > 0; i--) {
			variacion = Double.parseDouble(aux.get(i).substring(0,aux.get(i).indexOf(':')));
			if(variacion > 0.1) {
				erroresPresiones.add("Error entre "+aux.get(i).substring(aux.get(i).indexOf(':')+2));
			}else {
				break;
			}
		}
	}
	
	/**
	 * Método que realiza el algoritmo Greedy de flujos.
	 */
	public void GreedyFlujos() {
		ArrayList<Contador> aux = null;
		int n = 0;
		for (int i = 1; i < ciudad.size(); i++) {
			for (int j = 0; j < ciudad.get(i).getParcelas().size() - 1; j++) {
				aux = new ArrayList<>();
				for (int k = 0; k < ciudad.get(i).getParcelas().get(j).getContadores().size() - 1; k++) {
					aux.add(ciudad.get(i).getParcelas().get(j).getContadores().get(k));
				}
				Collections.sort(aux);
				for (int k = 0; k < aux.size()-1; k++) {
					if(aux.get(k).variacion() >= 7){
						erroresFlujos.add("Fallo en "+aux.get(k).getNombre()+" "+aux.get(j).toString());
				}else break;
				}
			}
		}

		
		
	}
	
	/**
	 * Algoritmo detección fallos flujos tuberias
	 */	
	public void FBFlujosTuberias() {
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for(int i = 0; i < ciudad.size(); i++) {
			if(i == 0) aux = ciudad.get(i).comprobarContadoresGeneralesT();
			else aux = ciudad.get(i).comprobarContadoresGeneralesD();
			if(!aux.isEmpty()) {
				for(int j = 0; j < aux.size(); j++) {
					if(variacion(ciudad.get(i).getParcelas(), aux.get(j)) > 5) {
						erroresFlujos.add("Error entre " + ciudad.get(i).getParcelas().get(j).getContadorGeneral().getNombre()
								+" " + ciudad.get(i).getParcelas().get(j).getContadorGeneral().toString()
								+" y " + ciudad.get(i).getParcelas().get(j+1).getContadorGeneral().getNombre()
								+" "+ciudad.get(i).getParcelas().get(j+1).getContadorGeneral().toString());
					}
				}
			}
		}
	}

	/**
	 * Calculo variacion para FBFlujosTuberias
	 * @param a
	 * @param indice
	 * @return variacion
	 */
	public double variacion(ArrayList<Parcela> a, int indice) {
		Contador c1 = a.get(indice).getContadorGeneral();
		if((indice + 1) == a.size()) {
			return c1.getFlujo() / c1.getMedia();
		} else {
			Contador c2 = a.get(indice + 1).getContadorGeneral();
			return (c1.getFlujo() - c2.getFlujo()) / (c1.getMedia() - c2.getMedia()); 
		}
	}
	
	/**
	 * Tiene datos.
	 *
	 * @return true si ciudad tiene datos
	 */
	public boolean tieneDatos() {
		return ciudad.size() >= 1 ? true : false;
	}
	
	/**
	 * Método que se utiliza en el algoritmo de DivideFlujos. 
	 * Calcula la varianza entre dos elementos.
	 *
	 * @param a
	 * @param inicio
	 * @param fin
	 * @return varianza
	 */
	public double calculoVarianza(ArrayList<Parcela> a, int inicio, int fin) {
		return ((a.get(inicio).getFlujoContadorGeneral() - a.get(fin).getFlujoContadorGeneral()) / (a.get(inicio).getMediaContadorGeneral() - a.get(fin).getMediaContadorGeneral())) / (fin - inicio);
	}

@Override
	public String toString() {
		String s = "Troncal: \n\n" + ciudad.get(0).toStringManometros() + "\n" + ciudad.get(0).toStringFlujos() + "\n\nDistribucion: \n\n";
				
		for (int i = 1; i < ciudad.size(); i++) {
			s+= "Presiones: " + this.ciudad.get(i).toStringManometros()+"\n";
			s+= "Flujo/Media: " + this.ciudad.get(i).toStringFlujos()+"\n\n";
		}
		
		return s;
	}
}