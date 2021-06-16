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
@Table(name="Item")
public class Item implements Serializable {
	public Item() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ITEM_PEDIDO) {
			this.pedido = (basedatos.Pedido) owner;
		}
		
		else if (key == ORMConstants.KEY_ITEM_PRODUCTOS_PEDIDO) {
			this.productos_pedido = (basedatos.Producto) owner;
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
	@GeneratedValue(generator="BASEDATOS_ITEM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_ITEM_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=basedatos.Producto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProductoIdProducto", referencedColumnName="IdProducto", nullable=false) }, foreignKey=@ForeignKey(name="FKItem423252"))	
	private basedatos.Producto productos_pedido;
	
	@ManyToOne(targetEntity=basedatos.Pedido.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="PedidoIdPedido", referencedColumnName="IdPedido", nullable=false) }, foreignKey=@ForeignKey(name="FKItem600544"))	
	private basedatos.Pedido pedido;
	
	@Column(name="CantidadProducto", nullable=false, length=10)	
	private int cantidadProducto;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCantidadProducto(int value) {
		this.cantidadProducto = value;
	}
	
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	
	public void setPedido(basedatos.Pedido value) {
		if (pedido != null) {
			pedido.cantidad.remove(this);
		}
		if (value != null) {
			value.cantidad.add(this);
		}
	}
	
	public basedatos.Pedido getPedido() {
		return pedido;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pedido(basedatos.Pedido value) {
		this.pedido = value;
	}
	
	private basedatos.Pedido getORM_Pedido() {
		return pedido;
	}
	
	public void setProductos_pedido(basedatos.Producto value) {
		if (productos_pedido != null) {
			productos_pedido.cantidad.remove(this);
		}
		if (value != null) {
			value.cantidad.add(this);
		}
	}
	
	public basedatos.Producto getProductos_pedido() {
		return productos_pedido;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Productos_pedido(basedatos.Producto value) {
		this.productos_pedido = value;
	}
	
	private basedatos.Producto getORM_Productos_pedido() {
		return productos_pedido;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
