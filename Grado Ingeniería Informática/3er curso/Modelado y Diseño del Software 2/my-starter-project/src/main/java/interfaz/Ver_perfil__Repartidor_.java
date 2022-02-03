package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_no_identificado;
import basedatos.iRepartidor;

public class Ver_perfil__Repartidor_ extends Ver_perfil {
	Ver_datos datos;
	VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	public VerticalLayout layout;
	private iRepartidor repartidor = new BDPrincipal();
	private iCibernauta_no_identificado cni = new BDPrincipal();
	
	public Ver_perfil__Repartidor_ () {
		super();
		inicializar();
	}

	public void inicializar() {
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		this.getTitulo_admin().setVisible(false);
		this.getBoton_carrito().setVisible(false);
		this.getContador().setVisible(false);
		this.getBarra_busqueda().setVisible(false);
		this.getBoton_buscar().setVisible(false);
		this.getBoton_perfil().setVisible(false);
		this.getBoton_menu().setVisible(false);

		datos = new Ver_datos();
		datos.getNumero_cuenta().setVisible(false); 
		datos.getCvv().setVisible(false);
		datos.getDireccion_envio().setVisible(false);
		datos.getNombre().setVisible(false); 
		datos.getApellidos().setVisible(false);
		datos.getContrasenia().setVisible(false);

		contenido_tabs.add(datos);

		cargarDatos();
		botones();
	}
	
	private void botones() {
		datos.getBoton_guardar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				guardar_perfil();
			}
		});
		
		datos.getBoton_cerrar_sesion().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {				 				
				Cibernauta_no_identificado cni = new Cibernauta_no_identificado();
				layout.removeAll();
				layout.add(cni);				
			}
		});
	}
	
	private void cargarDatos() {
		basedatos.Repartidor rep = Repartidor.usuario;
		
		datos.getNombre_apellidos().setValue(rep.getNombre() + " " + rep.getApellidos());
		datos.getCorreo().setValue(rep.getCorreo());
		datos.getId_repartidor().setValue(Integer.toString(rep.getIdUsuario()));		
	}
	
	public void guardar_perfil() {
		basedatos.Repartidor rep = Repartidor.usuario;
		
		repartidor.guardar_perfil(rep.getIdUsuario(), datos.getNombre_apellidos().getValue(), datos.getCorreo().getValue());
		
		cni.cargar_repartidor(Repartidor.usuario.getIdUsuario());
		
		Notification.show("Datos guardados");
	}	
	
	
}