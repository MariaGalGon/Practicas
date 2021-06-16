package interfaz;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import basedatos.iCibernauta_identificado;
import vistas.VistaMensajeabierto;

public class Mensaje_abierto extends VistaMensajeabierto {

	private iCibernauta_identificado cibernauta = new BDPrincipal();
	public iAdministrador administrador = new BDPrincipal();

	basedatos.Mensaje bdMensaje;
	boolean cib;

	public Mensaje_abierto() {
		inicializar();
	}
	
	public void inicializar() {
		
	}
	
	public void cargar_remitente() {
		String remitente = null;
		if(cib) {
			remitente = cibernauta.cargar_remitente(bdMensaje.getIdMensaje());
		}else {
			remitente = administrador.cargar_remitente(bdMensaje.getIdMensaje());

		}
		this.getNombre_remitente().setText(remitente);
	}
	
	public void cargar_mensaje() {
		cargar_remitente();
		this.getNombre_remitente().setText(bdMensaje.getRemitente().getCorreo());
		this.getContenido_asunto().setText(bdMensaje.getAsunto());
		this.getFecha_contenido().setText(bdMensaje.getFecha().toString());
		this.getMensaje_contenido().setText(bdMensaje.getTexto());
	}
	
	public void eliminar_mensaje() {
		if(cib) {
			if(Cibernauta_identificado.usuario.mensaje_enviado.contains(bdMensaje)) {
				Cibernauta_identificado.usuario.mensaje_enviado.remove(bdMensaje);
			}else {
				Cibernauta_identificado.usuario.mensaje_recibido.remove(bdMensaje);
			}
			
			cibernauta.eliminar_mensaje(-1, bdMensaje.getIdMensaje());

		}else {
			if(Administrador.usuario.mensaje_enviado.contains(bdMensaje)) {
				Administrador.usuario.mensaje_enviado.remove(bdMensaje);
			}else {
				Administrador.usuario.mensaje_recibido.remove(bdMensaje);
			}
			
			administrador.eliminar_mensaje(-1, bdMensaje.getIdMensaje());

		}
		
	}
}