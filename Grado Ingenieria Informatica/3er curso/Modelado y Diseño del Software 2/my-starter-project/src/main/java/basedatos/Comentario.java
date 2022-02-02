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
@Table(name="Comentario")
public class Comentario implements Serializable {
	public Comentario() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMENTARIO_PRODUCTO) {
			this.producto = (basedatos.Producto) owner;
		}
		
		else if (key == ORMConstants.KEY_COMENTARIO_CIBERNAUTA) {
			this.cibernauta = (basedatos.Cibernauta) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="IdComentario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_COMENTARIO_IDCOMENTARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_COMENTARIO_IDCOMENTARIO_GENERATOR", strategy="native")	
	private int idComentario;
	
	@ManyToOne(targetEntity=basedatos.Producto.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ProductoIdProducto", referencedColumnName="IdProducto", nullable=false) }, foreignKey=@ForeignKey(name="FKComentario343166"))	
	private basedatos.Producto producto;
	
	@ManyToOne(targetEntity=basedatos.Cibernauta.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="CibernautaUsuarioIdUsuario", referencedColumnName="UsuarioIdUsuario", nullable=false) }, foreignKey=@ForeignKey(name="FKComentario390339"))	
	private basedatos.Cibernauta cibernauta;
	
	@Column(name="Texto", nullable=true, length=255)	
	private String texto;
	
	@Column(name="Valoracion", nullable=false, length=10)	
	private int valoracion;
	
	private void setIdComentario(int value) {
		this.idComentario = value;
	}
	
	public int getIdComentario() {
		return idComentario;
	}
	
	public int getORMID() {
		return getIdComentario();
	}
	
	public void setTexto(String value) {
		this.texto = value;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setValoracion(int value) {
		this.valoracion = value;
	}
	
	public int getValoracion() {
		return valoracion;
	}
	
	public void setProducto(basedatos.Producto value) {
		if (producto != null) {
			producto.comentarios.remove(this);
		}
		if (value != null) {
			value.comentarios.add(this);
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
	
	public void setCibernauta(basedatos.Cibernauta value) {
		if (cibernauta != null) {
			cibernauta.comentarios.remove(this);
		}
		if (value != null) {
			value.comentarios.add(this);
		}
	}
	
	public basedatos.Cibernauta getCibernauta() {
		return cibernauta;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Cibernauta(basedatos.Cibernauta value) {
		this.cibernauta = value;
	}
	
	private basedatos.Cibernauta getORM_Cibernauta() {
		return cibernauta;
	}
	
	public String toString() {
		return String.valueOf(getIdComentario());
	}
	
}
