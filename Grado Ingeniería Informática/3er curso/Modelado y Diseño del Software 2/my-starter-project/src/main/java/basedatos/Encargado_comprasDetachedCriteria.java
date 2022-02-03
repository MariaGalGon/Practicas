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

public class Encargado_comprasDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idUsuario;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression correo;
	public final StringExpression contrasena;
	public final CollectionExpression mensaje_recibido;
	public final CollectionExpression mensaje_enviado;
	public final StringExpression foto;
	public final CollectionExpression pedidos;
	
	public Encargado_comprasDetachedCriteria() {
		super(basedatos.Encargado_compras.class, basedatos.Encargado_comprasCriteria.class);
		idUsuario = new IntegerExpression("idUsuario", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this.getDetachedCriteria());
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this.getDetachedCriteria());
		foto = new StringExpression("foto", this.getDetachedCriteria());
		pedidos = new CollectionExpression("ORM_pedidos", this.getDetachedCriteria());
	}
	
	public Encargado_comprasDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.Encargado_comprasCriteria.class);
		idUsuario = new IntegerExpression("idUsuario", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this.getDetachedCriteria());
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this.getDetachedCriteria());
		foto = new StringExpression("foto", this.getDetachedCriteria());
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
	
	public Encargado_compras uniqueEncargado_compras(PersistentSession session) {
		return (Encargado_compras) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Encargado_compras[] listEncargado_compras(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Encargado_compras[]) list.toArray(new Encargado_compras[list.size()]);
	}
}

