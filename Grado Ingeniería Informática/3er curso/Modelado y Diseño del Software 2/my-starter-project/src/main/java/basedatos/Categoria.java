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
@Table(name="Categoria")
public class Categoria implements Serializable {
	public Categoria() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CATEGORIA_PRODUCTO_ASOCIADO) {
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
	
	@Column(name="IdCategoria", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_CATEGORIA_IDCATEGORIA_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_CATEGORIA_IDCATEGORIA_GENERATOR", strategy="native")	
	private int idCategoria;
	
	@Column(name="Nombe", nullable=true, length=255)	
	private String nombe;
	
	@ManyToMany(targetEntity=basedatos.Producto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Producto_Categoria2", joinColumns={ @JoinColumn(name="CategoriaIdCategoria") }, inverseJoinColumns={ @JoinColumn(name="ProductoIdProducto") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_producto_asociado = new java.util.HashSet();
	
	public void setNombe(String value) {
		this.nombe = value;
	}
	
	public String getNombe() {
		return nombe;
	}
	
	private void setIdCategoria(int value) {
		this.idCategoria = value;
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public int getORMID() {
		return getIdCategoria();
	}
	
	private void setORM_Producto_asociado(java.util.Set value) {
		this.ORM_producto_asociado = value;
	}
	
	private java.util.Set getORM_Producto_asociado() {
		return ORM_producto_asociado;
	}
	
	@Transient	
	public final basedatos.ProductoSetCollection producto_asociado = new basedatos.ProductoSetCollection(this, _ormAdapter, ORMConstants.KEY_CATEGORIA_PRODUCTO_ASOCIADO, ORMConstants.KEY_PRODUCTO_PERTENECE_A_CATEGORIA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdCategoria());
	}
	
}
