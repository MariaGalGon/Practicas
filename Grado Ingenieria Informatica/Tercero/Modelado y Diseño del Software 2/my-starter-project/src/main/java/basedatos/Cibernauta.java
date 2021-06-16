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
@Table(name="Cibernauta")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioIdUsuario", referencedColumnName="IdUsuario")
public class Cibernauta extends basedatos.Usuario implements Serializable {
	public Cibernauta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CIBERNAUTA_COMENTARIOS) {
			return ORM_comentarios;
		}
		else if (key == ORMConstants.KEY_CIBERNAUTA_COMPRADO) {
			return ORM_comprado;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Usuario", nullable=true, length=255)	
	private String usuario;
	
	@Column(name="Direccion", nullable=true, length=255)	
	private String direccion;
	
	@Column(name="Tarjeta", nullable=false, length=10)	
	private int tarjeta;
	
	@Column(name="Cvv", nullable=false, length=10)	
	private int cvv;
	
	@Column(name="Foto", nullable=true, length=255)	
	private String foto;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	@OneToMany(mappedBy="cibernauta", targetEntity=basedatos.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comentarios = new java.util.HashSet();
	
	@OneToMany(mappedBy="comprado_por", targetEntity=basedatos.Pedido.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comprado = new java.util.HashSet();
	
	public void setUsuario(String value) {
		this.usuario = value;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setTarjeta(int value) {
		this.tarjeta = value;
	}
	
	public int getTarjeta() {
		return tarjeta;
	}
	
	public void setCvv(int value) {
		this.cvv = value;
	}
	
	public int getCvv() {
		return cvv;
	}
	
	public void setFoto(String value) {
		this.foto = value;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	private void setORM_Comentarios(java.util.Set value) {
		this.ORM_comentarios = value;
	}
	
	private java.util.Set getORM_Comentarios() {
		return ORM_comentarios;
	}
	
	@Transient	
	public final basedatos.ComentarioSetCollection comentarios = new basedatos.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_CIBERNAUTA_COMENTARIOS, ORMConstants.KEY_COMENTARIO_CIBERNAUTA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Comprado(java.util.Set value) {
		this.ORM_comprado = value;
	}
	
	private java.util.Set getORM_Comprado() {
		return ORM_comprado;
	}
	
	@Transient	
	public final basedatos.PedidoSetCollection comprado = new basedatos.PedidoSetCollection(this, _ormAdapter, ORMConstants.KEY_CIBERNAUTA_COMPRADO, ORMConstants.KEY_PEDIDO_COMPRADO_POR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
