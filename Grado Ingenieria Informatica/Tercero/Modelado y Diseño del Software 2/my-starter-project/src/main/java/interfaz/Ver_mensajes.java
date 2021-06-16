package interfaz;

import java.util.ArrayList;
import java.util.Vector;
//import interfaz.Lista_Buzones;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import basedatos.iCibernauta_identificado;
import vistas.VistaVermensajes;

public class Ver_mensajes extends VistaVermensajes {


	Lista_Buzones buzones = new Lista_Buzones();
	Nuevo_mensaje nuevoMensaje = new Nuevo_mensaje();
	Mensaje_abierto abierto = new Mensaje_abierto();
	boolean cib;
	public iAdministrador administrador = new BDPrincipal();
	private iCibernauta_identificado cibernauta = new BDPrincipal();
	int id;
	ArrayList<Mensaje> mensajesInterfaz;
	ArrayList<basedatos.Mensaje> mensajesBD;
	
	public Ver_mensajes(boolean cib) {
		this.cib = cib;
		inicializar();
		click();
	}
	public void inicializar() {
		this.nuevoMensaje.getAsunto().clear();
		this.nuevoMensaje.getDestinatario().clear();
		this.nuevoMensaje.getMensaje().clear();
		nuevoMensaje.getDestinatario().setEnabled(true);

		getVaadinHorizontalLayout().removeAll();
		this.getVaadinHorizontalLayout().add(buzones);
		this.getVaadinHorizontalLayout().add(nuevoMensaje);
		cargar_mensajes();
	}
	
	public boolean comprobar_campos() {
		if(nuevoMensaje.getDestinatario().getValue().equals("") || nuevoMensaje.getAsunto().getValue().equals("") || nuevoMensaje.getMensaje().getValue().equals("")) {
			Notification.show("Rellene todos los campos.");
			return false;
		}
		return true;
	}

	public void enviar_mensaje() {
		if(cib) {
			cibernauta.enviar_mensaje(nuevoMensaje.getDestinatario().getValue(),  nuevoMensaje.getAsunto().getValue(), nuevoMensaje.getMensaje().getValue(), id);
			inicializar();
		}else {
			administrador.enviar_mensaje(nuevoMensaje.getDestinatario().getValue(),  nuevoMensaje.getAsunto().getValue(), nuevoMensaje.getMensaje().getValue(), id);
			inicializar();
		}
	}
	
	public void click() {

		nuevoMensaje.getBoton_enviar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(comprobar_campos()) {
					enviar_mensaje();
				}else {
					Notification.show("Rellene todos los campos.");
				}

			}
		});
		
		abierto.getBoton_eliminar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				abierto.cib = cib;
				abierto.eliminar_mensaje();
				inicializar();
			}
		});
		
		abierto.getBoton_responder().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				inicializar();
				nuevoMensaje.getDestinatario().setValue(abierto.bdMensaje.getRemitente().getCorreo());
				nuevoMensaje.getDestinatario().setEnabled(false);
			}
		});
	}
	
	public void cargar_mensajes() {
		basedatos.Mensaje[] recibidos = null;
		basedatos.Mensaje[] enviados = null;
		if(cib) {
			recibidos =  Cibernauta_identificado.usuario.mensaje_recibido.toArray();
			enviados =  Cibernauta_identificado.usuario.mensaje_enviado.toArray() ;
		}else {
			recibidos =  Administrador.usuario.mensaje_recibido.toArray();
			 enviados =  Administrador.usuario.mensaje_enviado.toArray() ;
		}
		

		mensajesInterfaz = new ArrayList<Mensaje>();
		mensajesBD = new ArrayList<basedatos.Mensaje>();
		
		buzones.entrada.getLista().as(VerticalLayout.class).removeAll();
		for(int i = 0; i< recibidos.length; i++) {
			Mensaje m = new Mensaje();
			m.getAsunto().setText(recibidos[i].getAsunto());
			m.getFecha().setText(recibidos[i].getFecha().toString());
			mensajesInterfaz.add(m);
			mensajesBD.add(recibidos[i]);
			
			basedatos.Mensaje bdM = recibidos[i];
			m.getVertical().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					abierto.cib = cib;
					abierto.bdMensaje = bdM;
					abierto.cargar_mensaje();
					abierto.getBoton_responder().setVisible(true);
					getVaadinHorizontalLayout().removeAll();
					getVaadinHorizontalLayout().add(abierto);
				}
			});		
			buzones.entrada.getLista().as(VerticalLayout.class).add(m);
		}
		
		buzones.enviados.getLista().as(VerticalLayout.class).removeAll();
		for(int i = 0; i< enviados.length; i++) {
			Mensaje m = new Mensaje();
			m.getAsunto().setText(enviados[i].getAsunto());
			m.getFecha().setText(enviados[i].getFecha().toString());
			mensajesInterfaz.add(m);
			mensajesBD.add(enviados[i]);
			
			basedatos.Mensaje bdM = enviados[i];
			m.getVertical().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					abierto.cib = cib;
					abierto.bdMensaje = bdM;
					abierto.cargar_mensaje();
					abierto.getBoton_responder().setVisible(false);
					getVaadinHorizontalLayout().removeAll();
					getVaadinHorizontalLayout().add(abierto);
				}
			});		
			
			buzones.enviados.getLista().as(VerticalLayout.class).add(m);
		}
	}
}