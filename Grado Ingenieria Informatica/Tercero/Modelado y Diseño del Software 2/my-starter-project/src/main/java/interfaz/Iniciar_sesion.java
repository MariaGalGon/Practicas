package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.Usuario;
import basedatos.iCibernauta_no_identificado;
import vistas.VistaIniciarsesion;

public class Iniciar_sesion extends VistaIniciarsesion{

	public static String tipo;
	
	public VerticalLayout layout;
	private iCibernauta_no_identificado cibernauta = new BDPrincipal();
	
	public Iniciar_sesion() {
		inicializar();
	}
	
	public void inicializar() {
		layout = this.getWeb().as(VerticalLayout.class);
		
		tipo = "";
		
		iniciarSesion();
		recuperar();
		crearCuenta();
	}
	
	private void iniciarSesion() {
		//Iniciar sesion
		this.getBoton_iniciar_sesion().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				
				iniciar_sesion();				
			}
		});
	}
	
	private void iniciar_sesion() {
		cibernauta.iniciar_sesion(getCorreo().getValue(), getContrasenia().getValue());
		
		if(tipo.equals("Cibernauta")) {
			Cibernauta_identificado ci = new Cibernauta_identificado();
			Cibernauta_identificado.carro.addAll(Cibernauta_no_identificado.carro);
			Cibernauta_no_identificado.carro.clear();
			ci.ppc.getContador().setText(Integer.toString(ci.carro.size()));
			layout.removeAll();
			layout.add(ci);
		} else if(tipo.equals("Administrador")) {
			Administrador admin = new Administrador();
			layout.removeAll();
			layout.add(admin);
		} else if(tipo.equals("Encargado")) {
			Encargado_compras enc = new Encargado_compras();
			layout.removeAll();
			layout.add(enc);
		} else if(tipo.equals("Repartidor")) {
			Repartidor rep = new Repartidor();
			layout.removeAll();
			layout.add(rep);
		} else {
			Notification.show("Usuario incorrecto");
		}	
		
	}
	
	private void recuperar() {
		Recuperar_contrasenia recuperar = new Recuperar_contrasenia();
		getEnlace_recuperar_contrasenia().addEventListener("click", e -> {	
			layout.add(recuperar);			
		});
		
		recuperar.getBoton_recuperar().addClickListener(new ComponentEventListener(){					 
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(!recuperar.getCorreo().getValue().isEmpty()) {
					recuperar.recuperar_contrasenia();
					
					if(recuperar.encontrada) {
						layout.remove(recuperar);
					}
					
				} else {
					Notification.show("Introduzca un correo");
				}
			}
		});
	}
	
	private void crearCuenta() {
		//Crear cuenta
		Crear_cuenta cuenta = new Crear_cuenta();
		getBoton_crear_cuenta().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				
				layout.add(cuenta);
				
			}
		});
		
		cuenta.getBoton_crear_cuenta().addClickListener(new ComponentEventListener(){					 
			@Override
			public void onComponentEvent(ComponentEvent event) {
				cuenta.registrarse();
				if(cuenta.correcto && cuenta.comprobar_campos()) {
					layout.remove(cuenta);
				}else {
					Notification.show("Rellene todos los campos.");
				}
			}	
		});
	}
	
}