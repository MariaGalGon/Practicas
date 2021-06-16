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

public class RepartidorCriteria extends AbstractORMCriteria {
	public final IntegerExpression idUsuario;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression correo;
	public final StringExpression contrasena;
	public final CollectionExpression mensaje_recibido;
	public final CollectionExpression mensaje_enviado;
	public final CollectionExpression pedidos;
	
	public RepartidorCriteria(Criteria criteria) {
		super(criteria);
		idUsuario = new IntegerExpression("idUsuario", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		correo = new StringExpression("correo", this);
		contrasena = new StringExpression("contrasena", this);
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this);
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this);
		pedidos = new CollectionExpression("ORM_pedidos", this);
	}
	
	public RepartidorCriteria(PersistentSession session) {
		this(session.createCriteria(Repartidor.class));
	}
	
	public RepartidorCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public PedidoCriteria createPedidosCriteria() {
		return new PedidoCriteria(createCriteria("ORM_pedidos"));
	}
	
	public MensajeCriteria createMensaje_recibidoCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensaje_recibido"));
	}
	
	public MensajeCriteria createMensaje_enviadoCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensaje_enviado"));
	}
	
	public Repartidor uniqueRepartidor() {
		return (Repartidor) super.uniqueResult();
	}
	
	public Repartidor[] listRepartidor() {
		java.util.List list = super.list();
		return (Repartidor[]) list.toArray(new Repartidor[list.size()]);
	}
}

