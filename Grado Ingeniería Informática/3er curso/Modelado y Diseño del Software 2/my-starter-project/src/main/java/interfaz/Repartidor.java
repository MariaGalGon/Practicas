package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import vistas.VistaRepartidor;

//import basededatos.iRepartidor;

public class Repartidor extends VistaRepartidor {

	public Ver_envios envios;
	public VerticalLayout layout;
	public Ver_mas_envio envio;
	public Ver_perfil__Repartidor_ perfil;
	public static basedatos.Repartidor usuario;
	
	public Repartidor() {
		inicializar();
	}

	public void inicializar() {
		envios = new Ver_envios();
		envio = new Ver_mas_envio();
		perfil = new Ver_perfil__Repartidor_();
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		
		tabsEnvios();
		tabsPerfil();
		verEnvio();
		layout.add(envios);		
	}
	
	private void tabsEnvios() {
		//Recargar pagina envios
		envios.getTab_envios().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(envios);				
				inicializar();
				
			}
		});
		
		//Acceder pagina envios desde envio
		envio.getTab_envios().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.removeAll();
				inicializar();
				verEnvio();
			}
		});
		
		//Acceder pagina envios desde perfil
		perfil.getTab_envios().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(perfil);				
				layout.add(envios);
				verEnvio();
			}
		});
	}
	
	private void tabsPerfil() {
		//Acceder perfil desde envios
		envios.getTabs_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(envios);				
				layout.add(perfil);
				
			}
		});
		
		//Acceder perfil desde envio
		envio.getTab_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(envio);				
				layout.add(perfil);
				
			}
		});
		
		//Acceder pagina envios desde perfil
		perfil.getTab_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
							
				perfil.inicializar();
				
			}
		});
	}

	public void verEnvio() {
		for(int i = 0; i < envios.lista.enviosVista.size(); i++) {
			Envio eInt = envios.lista.enviosVista.get(i);
			eInt.getBoton_ver_mas().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					envio.p = eInt.p;
					envio.cargar_pedido();
					layout.remove(envios);				
					layout.add(envio);	
				}
			});
		}
	}
	
}