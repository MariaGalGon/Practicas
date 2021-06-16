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

public class RepartidorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idUsuario;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression correo;
	public final StringExpression contrasena;
	public final CollectionExpression mensaje_recibido;
	public final CollectionExpression mensaje_enviado;
	public final CollectionExpression pedidos;
	
	public RepartidorDetachedCriteria() {
		super(basedatos.Repartidor.class, basedatos.RepartidorCriteria.class);
		idUsuario = new IntegerExpression("idUsuario", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this.getDetachedCriteria());
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this.getDetachedCriteria());
		pedidos = new CollectionExpression("ORM_pedidos", this.getDetachedCriteria());
	}
	
	public RepartidorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.RepartidorCriteria.class);
		idUsuario = new IntegerExpression("idUsuario", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this.getDetachedCriteria());
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this.getDetachedCriteria());
		pedidos = new CollectionExpression("ORM_pedidos", this.getDetachedCriteria());
	}
	
	public PedidoDetachedCriteria createPedidosCriteria() {
		return new PedidoDetachedCriteria(createCriteria("ORM_pedidos"));
	}
	
	public MensajeDetachedCriteria createMensaje_recibidoCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensaje_recibido"));
	}
	
	public MensajeDetachedCriteria createMensaje_enviadoCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensaje_enviado"));
	}
	
	public Repartidor uniqueRepartidor(PersistentSession session) {
		return (Repartidor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Repartidor[] listRepartidor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Repartidor[]) list.toArray(new Repartidor[list.size()]);
	}
}

