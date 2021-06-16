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
@Table(name="Oferta")
public class Oferta implements Serializable {
	public Oferta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_OFERTA_PRODUCTO_ASOCIADO) {
			return ORM_producto_asociado;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="IdOferta", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_OFERTA_IDOFERTA_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_OFERTA_IDOFERTA_GENERATOR", strategy="native")	
	private int idOferta;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Detalles", nullable=true, length=255)	
	private String detalles;
	
	@Column(name="FechaCaducidad", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaCaducidad;
	
	@Column(name="Descuento", nullable=false)	
	private double descuento;
	
	@OneToMany(mappedBy="oferta_aplicada", targetEntity=basedatos.Producto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_producto_asociado = new java.util.HashSet();
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setIdOferta(int value) {
		this.idOferta = value;
	}
	
	public int getIdOferta() {
		return idOferta;
	}
	
	public int getORMID() {
		return getIdOferta();
	}
	
	public void setDetalles(String value) {
		this.detalles = value;
	}
	
	public String getDetalles() {
		return detalles;
	}
	
	public void setFechaCaducidad(java.util.Date value) {
		this.fechaCaducidad = value;
	}
	
	public java.util.Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	public void setDescuento(double value) {
		this.descuento = value;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	private void setORM_Producto_asociado(java.util.Set value) {
		this.ORM_producto_asociado = value;
	}
	
	private java.util.Set getORM_Producto_asociado() {
		return ORM_producto_asociado;
	}
	
	@Transient	
	public final basedatos.ProductoSetCollection producto_asociado = new basedatos.ProductoSetCollection(this, _ormAdapter, ORMConstants.KEY_OFERTA_PRODUCTO_ASOCIADO, ORMConstants.KEY_PRODUCTO_OFERTA_APLICADA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdOferta());
	}
	
}
