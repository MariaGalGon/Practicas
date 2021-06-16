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
@Table(name="Producto")
public class Producto implements Serializable {
	public Producto() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PRODUCTO_FOTOS) {
			return ORM_fotos;
		}
		else if (key == ORMConstants.KEY_PRODUCTO_CANTIDAD) {
			return ORM_cantidad;
		}
		else if (key == ORMConstants.KEY_PRODUCTO_COMENTARIOS) {
			return ORM_comentarios;
		}
		else if (key == ORMConstants.KEY_PRODUCTO_PERTENECE_A_CATEGORIA) {
			return ORM_pertenece_a_categoria;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PRODUCTO_OFERTA_APLICADA) {
			this.oferta_aplicada = (basedatos.Oferta) owner;
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
	
	@Column(name="IdProducto", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDATOS_PRODUCTO_IDPRODUCTO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDATOS_PRODUCTO_IDPRODUCTO_GENERATOR", strategy="native")	
	private int idProducto;
	
	@ManyToOne(targetEntity=basedatos.Oferta.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="OfertaIdOferta", referencedColumnName="IdOferta") }, foreignKey=@ForeignKey(name="FKProducto151090"))	
	private basedatos.Oferta oferta_aplicada;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="Informacion", nullable=true, length=255)	
	private String informacion;
	
	@Column(name="Imagen", nullable=true, length=255)	
	private String imagen;
	
	@Column(name="Precio", nullable=false)	
	private double precio;
	
	@Column(name="ValoracionMedia", nullable=false, length=10)	
	private int valoracionMedia;
	
	@OneToMany(mappedBy="producto", targetEntity=basedatos.Foto.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_fotos = new java.util.HashSet();
	
	@OneToMany(mappedBy="productos_pedido", targetEntity=basedatos.Item.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_cantidad = new java.util.HashSet();
	
	@OneToMany(mappedBy="producto", targetEntity=basedatos.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comentarios = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_producto_asociado", targetEntity=basedatos.Categoria.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pertenece_a_categoria = new java.util.HashSet();
	
	private void setIdProducto(int value) {
		this.idProducto = value;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public int getORMID() {
		return getIdProducto();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setInformacion(String value) {
		this.informacion = value;
	}
	
	public String getInformacion() {
		return informacion;
	}
	
	public void setImagen(String value) {
		this.imagen = value;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setPrecio(double value) {
		this.precio = value;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setValoracionMedia(int value) {
		this.valoracionMedia = value;
	}
	
	public int getValoracionMedia() {
		return valoracionMedia;
	}
	
	public void setOferta_aplicada(basedatos.Oferta value) {
		if (oferta_aplicada != null) {
			oferta_aplicada.producto_asociado.remove(this);
		}
		if (value != null) {
			value.producto_asociado.add(this);
		}
	}
	
	public basedatos.Oferta getOferta_aplicada() {
		return oferta_aplicada;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Oferta_aplicada(basedatos.Oferta value) {
		this.oferta_aplicada = value;
	}
	
	private basedatos.Oferta getORM_Oferta_aplicada() {
		return oferta_aplicada;
	}
	
	private void setORM_Fotos(java.util.Set value) {
		this.ORM_fotos = value;
	}
	
	private java.util.Set getORM_Fotos() {
		return ORM_fotos;
	}
	
	@Transient	
	public final basedatos.FotoSetCollection fotos = new basedatos.FotoSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCTO_FOTOS, ORMConstants.KEY_FOTO_PRODUCTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Cantidad(java.util.Set value) {
		this.ORM_cantidad = value;
	}
	
	private java.util.Set getORM_Cantidad() {
		return ORM_cantidad;
	}
	
	@Transient	
	public final basedatos.ItemSetCollection cantidad = new basedatos.ItemSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCTO_CANTIDAD, ORMConstants.KEY_ITEM_PRODUCTOS_PEDIDO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Comentarios(java.util.Set value) {
		this.ORM_comentarios = value;
	}
	
	private java.util.Set getORM_Comentarios() {
		return ORM_comentarios;
	}
	
	@Transient	
	public final basedatos.ComentarioSetCollection comentarios = new basedatos.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCTO_COMENTARIOS, ORMConstants.KEY_COMENTARIO_PRODUCTO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Pertenece_a_categoria(java.util.Set value) {
		this.ORM_pertenece_a_categoria = value;
	}
	
	private java.util.Set getORM_Pertenece_a_categoria() {
		return ORM_pertenece_a_categoria;
	}
	
	@Transient	
	public final basedatos.CategoriaSetCollection pertenece_a_categoria = new basedatos.CategoriaSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCTO_PERTENECE_A_CATEGORIA, ORMConstants.KEY_CATEGORIA_PRODUCTO_ASOCIADO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdProducto());
	}
	
}
