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

public class CategoriaCriteria extends AbstractORMCriteria {
	public final IntegerExpression idCategoria;
	public final StringExpression nombe;
	public final CollectionExpression producto_asociado;
	
	public CategoriaCriteria(Criteria criteria) {
		super(criteria);
		idCategoria = new IntegerExpression("idCategoria", this);
		nombe = new StringExpression("nombe", this);
		producto_asociado = new CollectionExpression("ORM_producto_asociado", this);
	}
	
	public CategoriaCriteria(PersistentSession session) {
		this(session.createCriteria(Categoria.class));
	}
	
	public CategoriaCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createProducto_asociadoCriteria() {
		return new ProductoCriteria(createCriteria("ORM_producto_asociado"));
	}
	
	public Categoria uniqueCategoria() {
		return (Categoria) super.uniqueResult();
	}
	
	public Categoria[] listCategoria() {
		java.util.List list = super.list();
		return (Categoria[]) list.toArray(new Categoria[list.size()]);
	}
}

