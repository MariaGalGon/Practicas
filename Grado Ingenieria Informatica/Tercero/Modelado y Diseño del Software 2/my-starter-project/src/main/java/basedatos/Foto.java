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
@Table(name="Foto")
public class Foto implements Serializable {
	public Foto() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_FOTO_PRODUCTO) {
			this.producto = (basedatos.Producto) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_FOTO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_FOTO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basedatos.Producto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProductoIdProducto", referencedColumnName="IdProducto", nullable=false) }, foreignKey=@ForeignKey(name="FKFoto329541"))	
	private basedatos.Producto producto;
	
	@Column(name="Direccion", nullable=true, length=255)	
	private String direccion;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setProducto(basedatos.Producto value) {
		if (producto != null) {
			producto.fotos.remove(this);
		}
		if (value != null) {
			value.fotos.add(this);
		}
	}
	
	public basedatos.Producto getProducto() {
		return producto;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Producto(basedatos.Producto value) {
		this.producto = value;
	}
	
	private basedatos.Producto getORM_Producto() {
		return producto;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
