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

public class FotoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression productoId;
	public final AssociationExpression producto;
	public final StringExpression direccion;
	
	public FotoDetachedCriteria() {
		super(basedatos.Foto.class, basedatos.FotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		productoId = new IntegerExpression("producto.idProducto", this.getDetachedCriteria());
		producto = new AssociationExpression("producto", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
	}
	
	public FotoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.FotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		productoId = new IntegerExpression("producto.idProducto", this.getDetachedCriteria());
		producto = new AssociationExpression("producto", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createProductoCriteria() {
		return new ProductoDetachedCriteria(createCriteria("producto"));
	}
	
	public Foto uniqueFoto(PersistentSession session) {
		return (Foto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Foto[] listFoto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Foto[]) list.toArray(new Foto[list.size()]);
	}
}

