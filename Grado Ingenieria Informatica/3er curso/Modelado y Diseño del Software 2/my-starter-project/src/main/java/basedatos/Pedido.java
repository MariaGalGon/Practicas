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
@Table(name="Pedido")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido implements Serializable {
	public Pedido() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PEDIDO_CANTIDAD) {
			return ORM_cantidad;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PEDIDO_COMPRADO_POR) {
			this.comprado_por = (basedatos.Cibernauta) owner;
		}
		
		else if (key == ORMConstants.KEY_PEDIDO_REPARTIDOR) {
			this.repartidor = (basedatos.Repartidor) owner;
		}
		
		else if (key == ORMConstants.KEY_PEDIDO_ENCARGADO_COMPRAS) {
			this.encargado_compras = (basedatos.Encargado_compras) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="IdPedido", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_PEDIDO_IDPEDIDO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_PEDIDO_IDPEDIDO_GENERATOR", strategy="native")	
	private int idPedido;
	
	@ManyToOne(targetEntity=basedatos.Encargado_compras.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="Encargado_comprasUsuarioIdUsuario", referencedColumnName="UsuarioIdUsuario", nullable=false) }, foreignKey=@ForeignKey(name="FKPedido666344"))	
	private basedatos.Encargado_compras encargado_compras;
	
	@ManyToOne(targetEntity=basedatos.Repartidor.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="RepartidorUsuarioIdUsuario", referencedColumnName="UsuarioIdUsuario", nullable=false) }, foreignKey=@ForeignKey(name="FKPedido224107"))	
	private basedatos.Repartidor repartidor;
	
	@ManyToOne(targetEntity=basedatos.Cibernauta.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CibernautaUsuarioIdUsuario", referencedColumnName="UsuarioIdUsuario", nullable=false) }, foreignKey=@ForeignKey(name="FKPedido97323"))	
	private basedatos.Cibernauta comprado_por;
	
	@Column(name="PrecioTotal", nullable=false)	
	private double precioTotal;
	
	@Column(name="TotalProductos", nullable=false, length=10)	
	private int totalProductos;
	
	@Column(name="FechaEnvio", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaEnvio;
	
	@Column(name="FechaRecepcion", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fechaRecepcion;
	
	@OneToMany(mappedBy="pedido", targetEntity=basedatos.Item.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cantidad = new java.util.HashSet();
	
	private void setIdPedido(int value) {
		this.idPedido = value;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	
	public int getORMID() {
		return getIdPedido();
	}
	
	public void setPrecioTotal(double value) {
		this.precioTotal = value;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setTotalProductos(int value) {
		this.totalProductos = value;
	}
	
	public int getTotalProductos() {
		return totalProductos;
	}
	
	public void setFechaEnvio(java.util.Date value) {
		this.fechaEnvio = value;
	}
	
	public java.util.Date getFechaEnvio() {
		return fechaEnvio;
	}
	
	public void setFechaRecepcion(java.util.Date value) {
		this.fechaRecepcion = value;
	}
	
	public java.util.Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	
	public void setComprado_por(basedatos.Cibernauta value) {
		if (comprado_por != null) {
			comprado_por.comprado.remove(this);
		}
		if (value != null) {
			value.comprado.add(this);
		}
	}
	
	public basedatos.Cibernauta getComprado_por() {
		return comprado_por;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Comprado_por(basedatos.Cibernauta value) {
		this.comprado_por = value;
	}
	
	private basedatos.Cibernauta getORM_Comprado_por() {
		return comprado_por;
	}
	
	public void setRepartidor(basedatos.Repartidor value) {
		if (repartidor != null) {
			repartidor.pedidos.remove(this);
		}
		if (value != null) {
			value.pedidos.add(this);
		}
	}
	
	public basedatos.Repartidor getRepartidor() {
		return repartidor;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Repartidor(basedatos.Repartidor value) {
		this.repartidor = value;
	}
	
	private basedatos.Repartidor getORM_Repartidor() {
		return repartidor;
	}
	
	public void setEncargado_compras(basedatos.Encargado_compras value) {
		if (encargado_compras != null) {
			encargado_compras.pedidos.remove(this);
		}
		if (value != null) {
			value.pedidos.add(this);
		}
	}
	
	public basedatos.Encargado_compras getEncargado_compras() {
		return encargado_compras;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Encargado_compras(basedatos.Encargado_compras value) {
		this.encargado_compras = value;
	}
	
	private basedatos.Encargado_compras getORM_Encargado_compras() {
		return encargado_compras;
	}
	
	private void setORM_Cantidad(java.util.Set value) {
		this.ORM_cantidad = value;
	}
	
	private java.util.Set getORM_Cantidad() {
		return ORM_cantidad;
	}
	
	@Transient	
	public final basedatos.ItemSetCollection cantidad = new basedatos.ItemSetCollection(this, _ormAdapter, ORMConstants.KEY_PEDIDO_CANTIDAD, ORMConstants.KEY_ITEM_PEDIDO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdPedido());
	}
	
}
