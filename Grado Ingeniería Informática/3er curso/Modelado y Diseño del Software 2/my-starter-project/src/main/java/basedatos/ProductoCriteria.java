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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProductoCriteria extends AbstractORMCriteria {
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
	
	public ProductoCriteria(Criteria criteria) {
		super(criteria);
		idProducto = new IntegerExpression("idProducto", this);
		oferta_aplicadaId = new IntegerExpression("oferta_aplicada.idOferta", this);
		oferta_aplicada = new AssociationExpression("oferta_aplicada", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		informacion = new StringExpression("informacion", this);
		imagen = new StringExpression("imagen", this);
		precio = new DoubleExpression("precio", this);
		valoracionMedia = new IntegerExpression("valoracionMedia", this);
		fotos = new CollectionExpression("ORM_fotos", this);
		cantidad = new CollectionExpression("ORM_cantidad", this);
		comentarios = new CollectionExpression("ORM_comentarios", this);
		pertenece_a_categoria = new CollectionExpression("ORM_pertenece_a_categoria", this);
	}
	
	public ProductoCriteria(PersistentSession session) {
		this(session.createCriteria(Producto.class));
	}
	
	public ProductoCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public OfertaCriteria createOferta_aplicadaCriteria() {
		return new OfertaCriteria(createCriteria("oferta_aplicada"));
	}
	
	public FotoCriteria createFotosCriteria() {
		return new FotoCriteria(createCriteria("ORM_fotos"));
	}
	
	public ItemCriteria createCantidadCriteria() {
		return new ItemCriteria(createCriteria("ORM_cantidad"));
	}
	
	public ComentarioCriteria createComentariosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comentarios"));
	}
	
	public CategoriaCriteria createPertenece_a_categoriaCriteria() {
		return new CategoriaCriteria(createCriteria("ORM_pertenece_a_categoria"));
	}
	
	public Producto uniqueProducto() {
		return (Producto) super.uniqueResult();
	}
	
	public Producto[] listProducto() {
		java.util.List list = super.list();
		return (Producto[]) list.toArray(new Producto[list.size()]);
	}
}

