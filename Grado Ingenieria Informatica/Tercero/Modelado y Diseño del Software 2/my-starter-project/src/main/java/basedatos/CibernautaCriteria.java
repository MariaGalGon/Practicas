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

public class CibernautaCriteria extends AbstractORMCriteria {
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
	
	public CibernautaCriteria(Criteria criteria) {
		super(criteria);
		idUsuario = new IntegerExpression("idUsuario", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		correo = new StringExpression("correo", this);
		contrasena = new StringExpression("contrasena", this);
		mensaje_recibido = new CollectionExpression("ORM_mensaje_recibido", this);
		mensaje_enviado = new CollectionExpression("ORM_mensaje_enviado", this);
		usuario = new StringExpression("usuario", this);
		direccion = new StringExpression("direccion", this);
		tarjeta = new IntegerExpression("tarjeta", this);
		cvv = new IntegerExpression("cvv", this);
		foto = new StringExpression("foto", this);
		estado = new BooleanExpression("estado", this);
		comentarios = new CollectionExpression("ORM_comentarios", this);
		comprado = new CollectionExpression("ORM_comprado", this);
	}
	
	public CibernautaCriteria(PersistentSession session) {
		this(session.createCriteria(Cibernauta.class));
	}
	
	public CibernautaCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public ComentarioCriteria createComentariosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comentarios"));
	}
	
	public PedidoCriteria createCompradoCriteria() {
		return new PedidoCriteria(createCriteria("ORM_comprado"));
	}
	
	public MensajeCriteria createMensaje_recibidoCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensaje_recibido"));
	}
	
	public MensajeCriteria createMensaje_enviadoCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensaje_enviado"));
	}
	
	public Cibernauta uniqueCibernauta() {
		return (Cibernauta) super.uniqueResult();
	}
	
	public Cibernauta[] listCibernauta() {
		java.util.List list = super.list();
		return (Cibernauta[]) list.toArray(new Cibernauta[list.size()]);
	}
}

