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

public class PedidoCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPedido;
	public final IntegerExpression encargado_comprasId;
	public final AssociationExpression encargado_compras;
	public final IntegerExpression repartidorId;
	public final AssociationExpression repartidor;
	public final IntegerExpression comprado_porId;
	public final AssociationExpression comprado_por;
	public final DoubleExpression precioTotal;
	public final IntegerExpression totalProductos;
	public final DateExpression fechaEnvio;
	public final DateExpression fechaRecepcion;
	public final CollectionExpression cantidad;
	
	public PedidoCriteria(Criteria criteria) {
		super(criteria);
		idPedido = new IntegerExpression("idPedido", this);
		encargado_comprasId = new IntegerExpression("encargado_compras.", this);
		encargado_compras = new AssociationExpression("encargado_compras", this);
		repartidorId = new IntegerExpression("repartidor.", this);
		repartidor = new AssociationExpression("repartidor", this);
		comprado_porId = new IntegerExpression("comprado_por.", this);
		comprado_por = new AssociationExpression("comprado_por", this);
		precioTotal = new DoubleExpression("precioTotal", this);
		totalProductos = new IntegerExpression("totalProductos", this);
		fechaEnvio = new DateExpression("fechaEnvio", this);
		fechaRecepcion = new DateExpression("fechaRecepcion", this);
		cantidad = new CollectionExpression("ORM_cantidad", this);
	}
	
	public PedidoCriteria(PersistentSession session) {
		this(session.createCriteria(Pedido.class));
	}
	
	public PedidoCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public Encargado_comprasCriteria createEncargado_comprasCriteria() {
		return new Encargado_comprasCriteria(createCriteria("encargado_compras"));
	}
	
	public RepartidorCriteria createRepartidorCriteria() {
		return new RepartidorCriteria(createCriteria("repartidor"));
	}
	
	public CibernautaCriteria createComprado_porCriteria() {
		return new CibernautaCriteria(createCriteria("comprado_por"));
	}
	
	public ItemCriteria createCantidadCriteria() {
		return new ItemCriteria(createCriteria("ORM_cantidad"));
	}
	
	public Pedido uniquePedido() {
		return (Pedido) super.uniqueResult();
	}
	
	public Pedido[] listPedido() {
		java.util.List list = super.list();
		return (Pedido[]) list.toArray(new Pedido[list.size()]);
	}
}

