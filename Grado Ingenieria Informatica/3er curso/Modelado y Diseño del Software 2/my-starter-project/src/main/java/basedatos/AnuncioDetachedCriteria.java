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

public class AnuncioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final StringExpression enlace;
	public final IntegerExpression altura;
	public final IntegerExpression anchura;
	public final StringExpression imagen;
	
	public AnuncioDetachedCriteria() {
		super(basedatos.Anuncio.class, basedatos.AnuncioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		enlace = new StringExpression("enlace", this.getDetachedCriteria());
		altura = new IntegerExpression("altura", this.getDetachedCriteria());
		anchura = new IntegerExpression("anchura", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
	}
	
	public AnuncioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, basedatos.AnuncioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		enlace = new StringExpression("enlace", this.getDetachedCriteria());
		altura = new IntegerExpression("altura", this.getDetachedCriteria());
		anchura = new IntegerExpression("anchura", this.getDetachedCriteria());
		imagen = new StringExpression("imagen", this.getDetachedCriteria());
	}
	
	public Anuncio uniqueAnuncio(PersistentSession session) {
		return (Anuncio) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Anuncio[] listAnuncio(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Anuncio[]) list.toArray(new Anuncio[list.size()]);
	}
}

