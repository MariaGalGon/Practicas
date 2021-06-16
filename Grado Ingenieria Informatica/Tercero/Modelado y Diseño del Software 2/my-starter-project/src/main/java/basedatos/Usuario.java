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
@Table(name="Usuario")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {
	public Usuario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USUARIO_MENSAJE_RECIBIDO) {
			return ORM_mensaje_recibido;
		}
		else if (key == ORMConstants.KEY_USUARIO_MENSAJE_ENVIADO) {
			return ORM_mensaje_enviado;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="IdUsuario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_USUARIO_IDUSUARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_USUARIO_IDUSUARIO_GENERATOR", strategy="native")	
	private int idUsuario;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Apellidos", nullable=true, length=255)	
	private String apellidos;
	
	@Column(name="Correo", nullable=true, length=255)	
	private String correo;
	
	@Column(name="Contrasena", nullable=true, length=255)	
	private String contrasena;
	
	@OneToMany(mappedBy="destinatario", targetEntity=basedatos.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_mensaje_recibido = new java.util.HashSet();
	
	@OneToMany(mappedBy="remitente", targetEntity=basedatos.Mensaje.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_mensaje_enviado = new java.util.HashSet();
	
	private void setIdUsuario(int value) {
		this.idUsuario = value;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public int getORMID() {
		return getIdUsuario();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellidos(String value) {
		this.apellidos = value;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setCorreo(String value) {
		this.correo = value;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setContrasena(String value) {
		this.contrasena = value;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	private void setORM_Mensaje_recibido(java.util.Set value) {
		this.ORM_mensaje_recibido = value;
	}
	
	private java.util.Set getORM_Mensaje_recibido() {
		return ORM_mensaje_recibido;
	}
	
	@Transient	
	public final basedatos.MensajeSetCollection mensaje_recibido = new basedatos.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_MENSAJE_RECIBIDO, ORMConstants.KEY_MENSAJE_DESTINATARIO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Mensaje_enviado(java.util.Set value) {
		this.ORM_mensaje_enviado = value;
	}
	
	private java.util.Set getORM_Mensaje_enviado() {
		return ORM_mensaje_enviado;
	}
	
	@Transient	
	public final basedatos.MensajeSetCollection mensaje_enviado = new basedatos.MensajeSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_MENSAJE_ENVIADO, ORMConstants.KEY_MENSAJE_REMITENTE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdUsuario());
	}
	
}
