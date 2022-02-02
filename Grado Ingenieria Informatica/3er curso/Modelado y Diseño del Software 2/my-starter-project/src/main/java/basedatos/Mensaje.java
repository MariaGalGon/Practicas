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
@Table(name="Mensaje")
public class Mensaje implements Serializable {
	public Mensaje() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_MENSAJE_ORIGINAL) {
			this.original = (basedatos.Mensaje) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_REMITENTE) {
			this.remitente = (basedatos.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_DESTINATARIO) {
			this.destinatario = (basedatos.Usuario) owner;
		}
		
		else if (key == ORMConstants.KEY_MENSAJE_RESPUESTA) {
			this.respuesta = (basedatos.Mensaje) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="IdMensaje", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_MENSAJE_IDMENSAJE_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_MENSAJE_IDMENSAJE_GENERATOR", strategy="native")	
	private int idMensaje;
	
	@OneToOne(targetEntity=basedatos.Mensaje.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="MensajeIdMensaje", referencedColumnName="IdMensaje") }, foreignKey=@ForeignKey(name="FKMensaje909498"))	
	private basedatos.Mensaje original;
	
	@ManyToOne(targetEntity=basedatos.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioIdUsuario2", referencedColumnName="IdUsuario", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje37420"))	
	private basedatos.Usuario destinatario;
	
	@ManyToOne(targetEntity=basedatos.Usuario.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="UsuarioIdUsuario", referencedColumnName="IdUsuario", nullable=false) }, foreignKey=@ForeignKey(name="FKMensaje217044"))	
	private basedatos.Usuario remitente;
	
	@Column(name="Asunto", nullable=true, length=255)	
	private String asunto;
	
	@Column(name="Texto", nullable=true, length=255)	
	private String texto;
	
	@Column(name="Fecha", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fecha;
	
	@OneToOne(mappedBy="original", targetEntity=basedatos.Mensaje.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private basedatos.Mensaje respuesta;
	
	private void setIdMensaje(int value) {
		this.idMensaje = value;
	}
	
	public int getIdMensaje() {
		return idMensaje;
	}
	
	public int getORMID() {
		return getIdMensaje();
	}
	
	public void setAsunto(String value) {
		this.asunto = value;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public void setTexto(String value) {
		this.texto = value;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setFecha(java.util.Date value) {
		this.fecha = value;
	}
	
	public java.util.Date getFecha() {
		return fecha;
	}
	
	public void setOriginal(basedatos.Mensaje value) {
		if (this.original != value) {
			basedatos.Mensaje loriginal = this.original;
			this.original = value;
			if (value != null) {
				original.setRespuesta(this);
			}
			if (loriginal != null && loriginal.getRespuesta() == this) {
				loriginal.setRespuesta(null);
			}
		}
	}
	
	public basedatos.Mensaje getOriginal() {
		return original;
	}
	
	public void setRemitente(basedatos.Usuario value) {
		if (remitente != null) {
			remitente.mensaje_enviado.remove(this);
		}
		if (value != null) {
			value.mensaje_enviado.add(this);
		}
	}
	
	public basedatos.Usuario getRemitente() {
		return remitente;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Remitente(basedatos.Usuario value) {
		this.remitente = value;
	}
	
	private basedatos.Usuario getORM_Remitente() {
		return remitente;
	}
	
	public void setDestinatario(basedatos.Usuario value) {
		if (destinatario != null) {
			destinatario.mensaje_recibido.remove(this);
		}
		if (value != null) {
			value.mensaje_recibido.add(this);
		}
	}
	
	public basedatos.Usuario getDestinatario() {
		return destinatario;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Destinatario(basedatos.Usuario value) {
		this.destinatario = value;
	}
	
	private basedatos.Usuario getORM_Destinatario() {
		return destinatario;
	}
	
	public void setRespuesta(basedatos.Mensaje value) {
		if (this.respuesta != value) {
			basedatos.Mensaje lrespuesta = this.respuesta;
			this.respuesta = value;
			if (value != null) {
				respuesta.setOriginal(this);
			}
			if (lrespuesta != null && lrespuesta.getOriginal() == this) {
				lrespuesta.setOriginal(null);
			}
		}
	}
	
	public basedatos.Mensaje getRespuesta() {
		return respuesta;
	}
	
	public String toString() {
		return String.valueOf(getIdMensaje());
	}
	
}
