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

public class PedidoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public PedidoDetachedCriteria() {
		super(basedatos.Pedido.class, basedatos.PedidoCriteria.class);
		idPedido = new IntegerExpression("idPedido", this.getDetachedCriteria());
		encargado_comprasId = new IntegerExpression("encargado_compras.", this.getDetachedCriteria());
		encargado_compras = new AssociationExpression("encargado_compras", this.getDetachedCriteria());
		repartidorId = new IntegerExpression("repartidor.", this.getDetachedCriteria());
		repartidor = new AssociationExpression("repartidor", this.getDetachedCriteria());
		comprado_porId = new IntegerExpression("comprado_por.", this.getDetachedCriteria());
		comprado_por = new AssociationExpression("comprado_por", this.getDetachedCriteria());
		precioTotal = new DoubleExpression("precioTotal", this.getDetachedCriteria());
		totalProductos = new IntegerExpression("totalProductos", this.getDetachedCriteria());
		fechaEnvio = new DateExpression("fechaEnvio", this.getDetachedCriteria());
		fechaRecepcion = new DateExpression("fechaRecepcion", this.getDetachedCriteria());
		cantidad = new CollectionExpression("ORM_cantidad", this.getDetachedCriteria());
	}
	
	public PedidoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.PedidoCriteria.class);
		idPedido = new IntegerExpression("idPedido", this.getDetachedCriteria());
		encargado_comprasId = new IntegerExpression("encargado_compras.", this.getDetachedCriteria());
		encargado_compras = new AssociationExpression("encargado_compras", this.getDetachedCriteria());
		repartidorId = new IntegerExpression("repartidor.", this.getDetachedCriteria());
		repartidor = new AssociationExpression("repartidor", this.getDetachedCriteria());
		comprado_porId = new IntegerExpression("comprado_por.", this.getDetachedCriteria());
		comprado_por = new AssociationExpression("comprado_por", this.getDetachedCriteria());
		precioTotal = new DoubleExpression("precioTotal", this.getDetachedCriteria());
		totalProductos = new IntegerExpression("totalProductos", this.getDetachedCriteria());
		fechaEnvio = new DateExpression("fechaEnvio", this.getDetachedCriteria());
		fechaRecepcion = new DateExpression("fechaRecepcion", this.getDetachedCriteria());
		cantidad = new CollectionExpression("ORM_cantidad", this.getDetachedCriteria());
	}
	
	public Encargado_comprasDetachedCriteria createEncargado_comprasCriteria() {
		return new Encargado_comprasDetachedCriteria(createCriteria("encargado_compras"));
	}
	
	public RepartidorDetachedCriteria createRepartidorCriteria() {
		return new RepartidorDetachedCriteria(createCriteria("repartidor"));
	}
	
	public CibernautaDetachedCriteria createComprado_porCriteria() {
		return new CibernautaDetachedCriteria(createCriteria("comprado_por"));
	}
	
	public ItemDetachedCriteria createCantidadCriteria() {
		return new ItemDetachedCriteria(createCriteria("ORM_cantidad"));
	}
	
	public Pedido uniquePedido(PersistentSession session) {
		return (Pedido) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pedido[] listPedido(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pedido[]) list.toArray(new Pedido[list.size()]);
	}
}

