/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Maria(University of Almeria)
 * License Type: Academic
 */
package basedatos;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Anuncio")
public class Anuncio implements Serializable {
	public Anuncio() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_ANUNCIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_ANUNCIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Enlace", nullable=true, length=255)	
	private String enlace;
	
	@Column(name="Altura", nullable=false, length=10)	
	private int altura;
	
	@Column(name="Anchura", nullable=false, length=10)	
	private int anchura;
	
	@Column(name="Imagen", nullable=true, length=255)	
	private String imagen;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEnlace(String value) {
		this.enlace = value;
	}
	
	public String getEnlace() {
		return enlace;
	}
	
	public void setAltura(int value) {
		this.altura = value;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAnchura(int value) {
		this.anchura = value;
	}
	
	public int getAnchura() {
		return anchura;
	}
	
	public void setImagen(String value) {
		this.imagen = value;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
