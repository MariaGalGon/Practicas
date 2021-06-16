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

public class ItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression productos_pedidoId;
	public final AssociationExpression productos_pedido;
	public final IntegerExpression pedidoId;
	public final AssociationExpression pedido;
	public final IntegerExpression cantidadProducto;
	
	public ItemDetachedCriteria() {
		super(basedatos.Item.class, basedatos.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		productos_pedidoId = new IntegerExpression("productos_pedido.idProducto", this.getDetachedCriteria());
		productos_pedido = new AssociationExpression("productos_pedido", this.getDetachedCriteria());
		pedidoId = new IntegerExpression("pedido.idPedido", this.getDetachedCriteria());
		pedido = new AssociationExpression("pedido", this.getDetachedCriteria());
		cantidadProducto = new IntegerExpression("cantidadProducto", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		productos_pedidoId = new IntegerExpression("productos_pedido.idProducto", this.getDetachedCriteria());
		productos_pedido = new AssociationExpression("productos_pedido", this.getDetachedCriteria());
		pedidoId = new IntegerExpression("pedido.idPedido", this.getDetachedCriteria());
		pedido = new AssociationExpression("pedido", this.getDetachedCriteria());
		cantidadProducto = new IntegerExpression("cantidadProducto", this.getDetachedCriteria());
	}
	
	public ProductoDetachedCriteria createProductos_pedidoCriteria() {
		return new ProductoDetachedCriteria(createCriteria("productos_pedido"));
	}
	
	public PedidoDetachedCriteria createPedidoCriteria() {
		return new PedidoDetachedCriteria(createCriteria("pedido"));
	}
	
	public Item uniqueItem(PersistentSession session) {
		return (Item) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Item[] listItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

