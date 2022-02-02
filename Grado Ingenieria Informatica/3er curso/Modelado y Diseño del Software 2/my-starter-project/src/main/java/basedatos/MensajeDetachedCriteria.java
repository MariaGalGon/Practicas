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

public class MensajeDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public MensajeDetachedCriteria() {
		super(basedatos.Mensaje.class, basedatos.MensajeCriteria.class);
		idMensaje = new IntegerExpression("idMensaje", this.getDetachedCriteria());
		originalId = new IntegerExpression("original.idMensaje", this.getDetachedCriteria());
		original = new AssociationExpression("original", this.getDetachedCriteria());
		destinatarioId = new IntegerExpression("destinatario.idUsuario", this.getDetachedCriteria());
		destinatario = new AssociationExpression("destinatario", this.getDetachedCriteria());
		remitenteId = new IntegerExpression("remitente.idUsuario", this.getDetachedCriteria());
		remitente = new AssociationExpression("remitente", this.getDetachedCriteria());
		asunto = new StringExpression("asunto", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		respuestaId = new IntegerExpression("respuesta.idMensaje", this.getDetachedCriteria());
		respuesta = new AssociationExpression("respuesta", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.MensajeCriteria.class);
		idMensaje = new IntegerExpression("idMensaje", this.getDetachedCriteria());
		originalId = new IntegerExpression("original.idMensaje", this.getDetachedCriteria());
		original = new AssociationExpression("original", this.getDetachedCriteria());
		destinatarioId = new IntegerExpression("destinatario.idUsuario", this.getDetachedCriteria());
		destinatario = new AssociationExpression("destinatario", this.getDetachedCriteria());
		remitenteId = new IntegerExpression("remitente.idUsuario", this.getDetachedCriteria());
		remitente = new AssociationExpression("remitente", this.getDetachedCriteria());
		asunto = new StringExpression("asunto", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		respuestaId = new IntegerExpression("respuesta.idMensaje", this.getDetachedCriteria());
		respuesta = new AssociationExpression("respuesta", this.getDetachedCriteria());
	}
	
	public MensajeDetachedCriteria createOriginalCriteria() {
		return new MensajeDetachedCriteria(createCriteria("original"));
	}
	
	public UsuarioDetachedCriteria createDestinatarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("destinatario"));
	}
	
	public UsuarioDetachedCriteria createRemitenteCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("remitente"));
	}
	
	public MensajeDetachedCriteria createRespuestaCriteria() {
		return new MensajeDetachedCriteria(createCriteria("respuesta"));
	}
	
	public Mensaje uniqueMensaje(PersistentSession session) {
		return (Mensaje) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Mensaje[] listMensaje(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}

