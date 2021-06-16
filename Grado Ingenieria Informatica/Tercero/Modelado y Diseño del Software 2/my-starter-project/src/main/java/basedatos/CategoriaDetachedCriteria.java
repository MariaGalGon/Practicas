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

public class CategoriaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idCategoria;
	public final StringExpression nombe;
	public final CollectionExpression producto_asociado;
	
	public CategoriaDetachedCriteria() {
		super(basedatos.Categoria.class, basedatos.CategoriaCriteria.class);
		idCategoria = new IntegerExpression("idCategoria", this.getDetachedCriteria());
		nombe = new StringExpression("nombe", this.getDetachedCriteria());
		producto_asociado = new CollectionExpression("ORM_producto_asociado", this.getDetachedCriteria());
	}
	
	public CategoriaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.CategoriaCriteria.class);
		idCategoria = new IntegerExpression("idCategoria", this.getDetachedCriteria());
		nombe = new StringExpression("nombe", this.getDetachedCriteria());
		producto_asociado = new CollectionExpression("ORM_producto_asociado", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createProducto_asociadoCriteria() {
		return new ProductoDetachedCriteria(createCriteria("ORM_producto_asociado"));
	}
	
	public Categoria uniqueCategoria(PersistentSession session) {
		return (Categoria) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Categoria[] listCategoria(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Categoria[]) list.toArray(new Categoria[list.size()]);
	}
}

