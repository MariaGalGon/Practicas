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
@Table(name="Encargado_compras")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="UsuarioIdUsuario", referencedColumnName="IdUsuario")
public class Encargado_compras extends basedatos.Usuario implements Serializable {
	public Encargado_compras() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ENCARGADO_COMPRAS_PEDIDOS) {
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
	
	@Column(name="Foto", nullable=true, length=255)	
	private String foto;
	
	@OneToMany(mappedBy="encargado_compras", targetEntity=basedatos.Pedido.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pedidos = new java.util.HashSet();
	
	public void setFoto(String value) {
		this.foto = value;
	}
	
	public String getFoto() {
		return foto;
	}
	
	private void setORM_Pedidos(java.util.Set value) {
		this.ORM_pedidos = value;
	}
	
	private java.util.Set getORM_Pedidos() {
		return ORM_pedidos;
	}
	
	@Transient	
	public final basedatos.PedidoSetCollection pedidos = new basedatos.PedidoSetCollection(this, _ormAdapter, ORMConstants.KEY_ENCARGADO_COMPRAS_PEDIDOS, ORMConstants.KEY_PEDIDO_ENCARGADO_COMPRAS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
