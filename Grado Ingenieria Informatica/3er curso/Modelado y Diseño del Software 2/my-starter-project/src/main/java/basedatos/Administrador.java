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
@Table(name="Administrador")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioIdUsuario", referencedColumnName="IdUsuario")
public class Administrador extends basedatos.Usuario implements Serializable {
	public Administrador() {
	}
	
	@Column(name="Foto", nullable=true, length=255)	
	private String foto;
	
	public void setFoto(String value) {
		this.foto = value;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
