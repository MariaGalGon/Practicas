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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProductoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idProducto;
	public final IntegerExpression oferta_aplicadaId;
	public final AssociationExpression oferta_aplicada;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final StringExpression informacion;
	public final StringExpression imagen;
	public final DoubleExpression precio;
	public final IntegerExpression valoracionMedia;
	public final CollectionExpression fotos;
	public final CollectionExpression cantidad;
	public final CollectionExpression comentarios;
	public final CollectionExpression pertenece_a_categoria;
	
	public ProductoDetachedCriteria() {
		super(basedatos.Producto.class, basedatos.ProductoCriteria.class);
		idProducto = new IntegerExpression("idProducto", this.getDetachedCriteria());
		oferta_aplicadaId = new IntegerExpression("oferta_aplicada.idOferta", this.getDetachedCriteria());
		oferta_aplicada = new AssociationExpression("oferta_aplicada", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		informacion = new StringExpression("informacion", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
		precio = new DoubleExpression("precio", this.getDetachedCriteria());
		valoracionMedia = new IntegerExpression("valoracionMedia", this.getDetachedCriteria());
		fotos = new CollectionExpression("ORM_fotos", this.getDetachedCriteria());
		cantidad = new CollectionExpression("ORM_cantidad", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
		pertenece_a_categoria = new CollectionExpression("ORM_pertenece_a_categoria", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.ProductoCriteria.class);
		idProducto = new IntegerExpression("idProducto", this.getDetachedCriteria());
		oferta_aplicadaId = new IntegerExpression("oferta_aplicada.idOferta", this.getDetachedCriteria());
		oferta_aplicada = new AssociationExpression("oferta_aplicada", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		informacion = new StringExpression("informacion", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
		precio = new DoubleExpression("precio", this.getDetachedCriteria());
		valoracionMedia = new IntegerExpression("valoracionMedia", this.getDetachedCriteria());
		fotos = new CollectionExpression("ORM_fotos", this.getDetachedCriteria());
		cantidad = new CollectionExpression("ORM_cantidad", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
		pertenece_a_categoria = new CollectionExpression("ORM_pertenece_a_categoria", this.getDetachedCriteria());
	}
	
	public OfertaDetachedCriteria createOferta_aplicadaCriteria() {
		return new OfertaDetachedCriteria(createCriteria("oferta_aplicada"));
	}
	
	public FotoDetachedCriteria createFotosCriteria() {
		return new FotoDetachedCriteria(createCriteria("ORM_fotos"));
	}
	
	public ItemDetachedCriteria createCantidadCriteria() {
		return new ItemDetachedCriteria(createCriteria("ORM_cantidad"));
	}
	
	public ComentarioDetachedCriteria createComentariosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comentarios"));
	}
	
	public CategoriaDetachedCriteria createPertenece_a_categoriaCriteria() {
		return new CategoriaDetachedCriteria(createCriteria("ORM_pertenece_a_categoria"));
	}
	
	public Producto uniqueProducto(PersistentSession session) {
		return (Producto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Producto[] listProducto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Producto[]) list.toArray(new Producto[list.size()]);
	}
}

