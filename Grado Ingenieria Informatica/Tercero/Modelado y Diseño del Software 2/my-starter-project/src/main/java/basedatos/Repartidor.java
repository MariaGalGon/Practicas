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
@Table(name="Repartidor")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioIdUsuario", referencedColumnName="IdUsuario")
public class Repartidor extends basedatos.Usuario implements Serializable {
	public Repartidor() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_REPARTIDOR_PEDIDOS) {
			return ORM_pedidos;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@OneToMany(mappedBy="repartidor", targetEntity=basedatos.Pedido.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pedidos = new java.util.HashSet();
	
	private void setORM_Pedidos(java.util.Set value) {
		this.ORM_pedidos = value;
	}
	
	private java.util.Set getORM_Pedidos() {
		return ORM_pedidos;
	}
	
	@Transient	
	public final basedatos.PedidoSetCollection pedidos = new basedatos.PedidoSetCollection(this, _ormAdapter, ORMConstants.KEY_REPARTIDOR_PEDIDOS, ORMConstants.KEY_PEDIDO_REPARTIDOR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
