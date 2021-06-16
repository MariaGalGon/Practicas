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

public class CibernautaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idUsuario;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression correo;
	public final StringExpression contrasena;
	public final CollectionExpression mensaje_recibido;
	public final CollectionExpression mensaje_enviado;
	public final StringExpression usuario;
	public final StringExpression direccion;
	public final IntegerExpression tarjeta;
	public final IntegerExpression cvv;
	public final StringExpression foto;
	public final BooleanExpression estado;
	public final CollectionExpression comentarios;
	public final CollectionExpression comprado;
	
	public CibernautaDetachedCriteria() {
		super(basedatos.Cibernauta.class, basedatos.CibernautaCriteria.class);
		idUsuario = new IntegerExpression("idUsuario", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this.getDetachedCriteria());
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this.getDetachedCriteria());
		usuario = new StringExpression("usuario", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		tarjeta = new IntegerExpression("tarjeta", this.getDetachedCriteria());
		cvv = new IntegerExpression("cvv", this.getDetachedCriteria());
		foto = new StringExpression("foto", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
		comprado = new CollectionExpression("ORM_comprado", this.getDetachedCriteria());
	}
	
	public CibernautaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.CibernautaCriteria.class);
		idUsuario = new IntegerExpression("idUsuario", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this.getDetachedCriteria());
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this.getDetachedCriteria());
		usuario = new StringExpression("usuario", this.getDetachedCriteria());
		direccion = new StringExpression("direccion", this.getDetachedCriteria());
		tarjeta = new IntegerExpression("tarjeta", this.getDetachedCriteria());
		cvv = new IntegerExpression("cvv", this.getDetachedCriteria());
		foto = new StringExpression("foto", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_comentarios", this.getDetachedCriteria());
		comprado = new CollectionExpression("ORM_comprado", this.getDetachedCriteria());
	}
	
	public ComentarioDetachedCriteria createComentariosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comentarios"));
	}
	
	public PedidoDetachedCriteria createCompradoCriteria() {
		return new PedidoDetachedCriteria(createCriteria("ORM_comprado"));
	}
	
	public MensajeDetachedCriteria createMensaje_recibidoCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensaje_recibido"));
	}
	
	public MensajeDetachedCriteria createMensaje_enviadoCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensaje_enviado"));
	}
	
	public Cibernauta uniqueCibernauta(PersistentSession session) {
		return (Cibernauta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cibernauta[] listCibernauta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cibernauta[]) list.toArray(new Cibernauta[list.size()]);
	}
}

