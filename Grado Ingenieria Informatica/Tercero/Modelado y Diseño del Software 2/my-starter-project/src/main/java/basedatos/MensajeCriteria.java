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

public class MensajeCriteria extends AbstractORMCriteria {
	public final IntegerExpression idMensaje;
	public final IntegerExpression originalId;
	public final AssociationExpression original;
	public final IntegerExpression destinatarioId;
	public final AssociationExpression destinatario;
	public final IntegerExpression remitenteId;
	public final AssociationExpression remitente;
	public final StringExpression asunto;
	public final StringExpression texto;
	public final DateExpression fecha;
	public final IntegerExpression respuestaId;
	public final AssociationExpression respuesta;
	
	public MensajeCriteria(Criteria criteria) {
		super(criteria);
		idMensaje = new IntegerExpression("idMensaje", this);
		originalId = new IntegerExpression("original.idMensaje", this);
		original = new AssociationExpression("original", this);
		destinatarioId = new IntegerExpression("destinatario.idUsuario", this);
		destinatario = new AssociationExpression("destinatario", this);
		remitenteId = new IntegerExpression("remitente.idUsuario", this);
		remitente = new AssociationExpression("remitente", this);
		asunto = new StringExpression("asunto", this);
		texto = new StringExpression("texto", this);
		fecha = new DateExpression("fecha", this);
		respuestaId = new IntegerExpression("respuesta.idMensaje", this);
		respuesta = new AssociationExpression("respuesta", this);
	}
	
	public MensajeCriteria(PersistentSession session) {
		this(session.createCriteria(Mensaje.class));
	}
	
	public MensajeCriteria() throws PersistentException {
		this(MDS2v4GalvezRosenovPersistentManager.instance().getSession());
	}
	
	public MensajeCriteria createOriginalCriteria() {
		return new MensajeCriteria(createCriteria("original"));
	}
	
	public UsuarioCriteria createDestinatarioCriteria() {
		return new UsuarioCriteria(createCriteria("destinatario"));
	}
	
	public UsuarioCriteria createRemitenteCriteria() {
		return new UsuarioCriteria(createCriteria("remitente"));
	}
	
	public MensajeCriteria createRespuestaCriteria() {
		return new MensajeCriteria(createCriteria("respuesta"));
	}
	
	public Mensaje uniqueMensaje() {
		return (Mensaje) super.uniqueResult();
	}
	
	public Mensaje[] listMensaje() {
		java.util.List list = super.list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}

