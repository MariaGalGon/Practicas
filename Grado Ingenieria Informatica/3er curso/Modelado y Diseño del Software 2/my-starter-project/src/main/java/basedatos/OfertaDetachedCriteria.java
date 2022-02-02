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

public class OfertaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idOferta;
	public final StringExpression nombre;
	public final StringExpression detalles;
	public final DateExpression fechaCaducidad;
	public final DoubleExpression descuento;
	public final CollectionExpression producto_asociado;
	
	public OfertaDetachedCriteria() {
		super(basedatos.Oferta.class, basedatos.OfertaCriteria.class);
		idOferta = new IntegerExpression("idOferta", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		detalles = new StringExpression("detalles", this.getDetachedCriteria());
		fechaCaducidad = new DateExpression("fechaCaducidad", this.getDetachedCriteria());
		descuento = new DoubleExpression("descuento", this.getDetachedCriteria());
		producto_asociado = new CollectionExpression("ORM_producto_asociado", this.getDetachedCriteria());
	}
	
	public OfertaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.OfertaCriteria.class);
		idOferta = new IntegerExpression("idOferta", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		detalles = new StringExpression("detalles", this.getDetachedCriteria());
		fechaCaducidad = new DateExpression("fechaCaducidad", this.getDetachedCriteria());
		descuento = new DoubleExpression("descuento", this.getDetachedCriteria());
		producto_asociado = new CollectionExpression("ORM_producto_asociado", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createProducto_asociadoCriteria() {
		return new ProductoDetachedCriteria(createCriteria("ORM_producto_asociado"));
	}
	
	public Oferta uniqueOferta(PersistentSession session) {
		return (Oferta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Oferta[] listOferta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Oferta[]) list.toArray(new Oferta[list.size()]);
	}
}

