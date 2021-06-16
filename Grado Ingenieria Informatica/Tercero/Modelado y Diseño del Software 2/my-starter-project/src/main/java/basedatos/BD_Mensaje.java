package basedatos;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basedatos.Mensaje;
import interfaz.Cibernauta_identificado;

public class BD_Mensaje {
	public BDPrincipal _bD_Prinicpal_Mensaje;
	public Vector<Mensaje> _mensaje = new Vector<Mensaje>();

	public void eliminar_mensaje(int aIdUsuario, int aIdMensaje) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			MensajeDAO.delete(MensajeDAO.getMensajeByORMID(aIdMensaje));
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void enviar_mensaje(int aIdDestinatario, String aAsunto, String aTexto, int aIdRemitente) throws PersistentException {
		PersistentTransaction t = MDS2v4GalvezRosenovPersistentManager.instance().getSession().beginTransaction();

		try {
			Mensaje mensaje = MensajeDAO.createMensaje();
			mensaje.setAsunto(aAsunto);
			mensaje.setDestinatario(UsuarioDAO.getUsuarioByORMID(aIdDestinatario));
			mensaje.setFecha(new java.sql.Date(System.currentTimeMillis()));
			mensaje.setTexto(aTexto);
			mensaje.setRemitente(UsuarioDAO.getUsuarioByORMID(aIdRemitente));
			Cibernauta_identificado.usuario.mensaje_enviado.add(mensaje);
			MensajeDAO.save(mensaje);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}