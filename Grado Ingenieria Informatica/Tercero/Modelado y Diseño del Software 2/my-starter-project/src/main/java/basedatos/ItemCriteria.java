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

public class ItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression productos_pedidoId;
	public final AssociationExpression productos_pedido;
	public final IntegerExpression pedidoId;
	public final AssociationExpression pedido;
	public final IntegerExpression cantidadProducto;
	
	public ItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		productos_pedidoId = new IntegerExpression("productos_pedido.idProducto", this);
		productos_pedido = new AssociationExpression("productos_pedido", this);
		pedidoId = new IntegerExpression("pedido.idPedido", this);
		pedido = new AssociationExpression("pedido", this);
		cantidadProducto = new IntegerExpression("cantidadProducto", this);
	}
	
	public ItemCriteria(PersistentSession session) {
		this(session.createCriteria(Item.class));
	}
	
	public ItemCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public ProductoCriteria createProductos_pedidoCriteria() {
		return new ProductoCriteria(createCriteria("productos_pedido"));
	}
	
	public PedidoCriteria createPedidoCriteria() {
		return new PedidoCriteria(createCriteria("pedido"));
	}
	
	public Item uniqueItem() {
		return (Item) super.uniqueResult();
	}
	
	public Item[] listItem() {
		java.util.List list = super.list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

