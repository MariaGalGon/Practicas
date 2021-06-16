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

public class OfertaCriteria extends AbstractORMCriteria {
	public final IntegerExpression idOferta;
	public final StringExpression nombre;
	public final StringExpression detalles;
	public final DateExpression fechaCaducidad;
	public final DoubleExpression descuento;
	public final CollectionExpression producto_asociado;
	
	public OfertaCriteria(Criteria criteria) {
		super(criteria);
		idOferta = new IntegerExpression("idOferta", this);
		nombre = new StringExpression("nombre", this);
		detalles = new StringExpression("detalles", this);
		fechaCaducidad = new DateExpression("fechaCaducidad", this);
		descuento = new DoubleExpression("descuento", this);
		producto_asociado = new CollectionExpression("ORM_producto_asociado", this);
	}
	
	public OfertaCriteria(PersistentSession session) {
		this(session.createCriteria(Oferta.class));
	}
	
	public OfertaCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createProducto_asociadoCriteria() {
		return new ProductoCriteria(createCriteria("ORM_producto_asociado"));
	}
	
	public Oferta uniqueOferta() {
		return (Oferta) super.uniqueResult();
	}
	
	public Oferta[] listOferta() {
		java.util.List list = super.list();
		return (Oferta[]) list.toArray(new Oferta[list.size()]);
	}
}

