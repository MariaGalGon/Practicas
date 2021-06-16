package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


import vistas.VistaEncargadocompras;

public class Encargado_compras extends VistaEncargadocompras{	
	public Pagina_principal__Encargado_ ppe;
	public VerticalLayout layout;
	public Abrir_menu_lateral__Encargado_ menu;
	public Ver_perfil__Encargado_ perfil;
	public Pedidos pedidos;
	public Pedido pedi;
	public static basedatos.Encargado_compras usuario;

	
	public Encargado_compras(){
		inicializar();
	}

	public void inicializar() {
		ppe = new Pagina_principal__Encargado_();
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		layout.add(ppe);
		
		menu = new Abrir_menu_lateral__Encargado_();
		perfil = new Ver_perfil__Encargado_();
		pedidos = new Pedidos();
		pedi = new Pedido();

		menu(); 
		botones();
		inicio();
	}
	
	private void menu() {		
		//Acceso al menu lateral pagina principal
		ppe.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 				
				layout.add(menu);
				
			}
		});		
		
		
		//Acceso al menu lateral pagina principal
				pedidos.getBoton_menu().addClickListener(new ComponentEventListener(){
					@Override
					public void onComponentEvent(ComponentEvent event) {
						 				
						layout.add(menu);
						
					}
				});	
		
		//Acceso al menu lateral perfil
		perfil.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});
		
		//Acceso al menu lateral pedido
		pedi.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});
		
		//Salir del menu lateral
		menu.getBoton_salir().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(menu);				
				//layout.add(ppc);
				
			}
		});
		
		menu.perfil.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(perfil);
			}
		});
		
		menu.pedidos.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(pedidos);
			}
		});
		
	}
	
	private void botones() {
		
		ppe.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppe);
				layout.add(perfil);

			}
		});
		
		ppe.getBoton_ver_pedidos().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppe);
				layout.add(pedidos);
				verPedido();
			}
		});
	}
	
	private void inicio() {
		ppe.getBoton_logo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(ppe);				
				inicializar();			
			}
		});
		
		perfil.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(perfil);				
				inicializar();			
			}
		});
		
		pedidos.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(pedidos);				
				inicializar();		
			}
		});
		
		pedi.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				layout.remove(pedi);				
				inicializar();			
			}
		});
	}
	
	public void verPedido() {
		for(int i = 0; i < pedidos.pedidosVista.size(); i++) {
			Producto_pedido pInt = pedidos.pedidosVista.get(i);
			pInt.getBoton_ver_mas().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					pedi.p = pInt.p;
					pedi.cargar_pedido();
					layout.remove(pedidos);				
					layout.add(pedi);	
				}
			});
		}
	}
	
}