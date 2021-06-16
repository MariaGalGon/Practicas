package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_identificado;
import basedatos.iComun;

public class Cibernauta_identificado extends Comun {
	public Pagina_principal__Cibernauta_ ppc;
	public VerticalLayout layout;
	public Carrito__Cibernauta_identificado_ cci;
	public Abrir_menu_lateral__Cibernauta_ menu;
	public Buscar_producto__Cibernauta_ buscar;
	public Ver_perfil__Cibernauta_ perfil;
	public Ver_producto__Cibernauta_identificado_ producto;
	public Comprar__Cibernauta_identificado_ compra;
	public static basedatos.Cibernauta usuario;
	public static ArrayList<Producto_aniadido> carro = new ArrayList<Producto_aniadido>();


	public Cibernauta_identificado() {
		inicializar();
	}

	public void inicializar() {
		// Vista pagina principal
		ppc = new Pagina_principal__Cibernauta_();
		layout = this.getVerticalLayout().as(VerticalLayout.class);
		ppc.getContador().setText(Integer.toString(carro.size()));
		layout.add(ppc);

		menu = new Abrir_menu_lateral__Cibernauta_();
		buscar = new Buscar_producto__Cibernauta_();
		cci = new Carrito__Cibernauta_identificado_();
		perfil = new Ver_perfil__Cibernauta_();
		producto = new Ver_producto__Cibernauta_identificado_();
		compra = new Comprar__Cibernauta_identificado_();

		menu(); // Abrir menu lateral
		inicio(); // Reiniciar página
		buscador(); // Busqueda
		carrito(); // Abrir carrito
		perfil(); // Ver perfil
		producto(); //Abrir un producto
		aniadirCarrito(); //Aniadir producto al carrito

	}

	public void menu() {
		//Acceso al menu lateral pagina principal
		ppc.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				//layout.remove(ppc);				
				layout.add(menu);

			}
		});

		//Acceso al menu lateral buscador
		buscar.getBoton_menu1().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				layout.add(menu);

			}
		});

		//Acceso al menu lateral carrito
		cci.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {				
				layout.add(menu);

			}
		});

		//Acceso al menu lateral carrito
		perfil.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {			
				layout.add(menu);

			}
		});

		//Acceso al menu lateral producto
		producto.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {			
				layout.add(menu);

			}
		});

		//Acceso al menu lateral compra
		compra.getBoton_menu().addClickListener(new ComponentEventListener(){
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

			}
		});

		menu.perfil.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				perfil.getContador().setText(Integer.toString(carro.size()));
				layout.add(perfil);
			}
		});

	}

	private void inicio() {
		//Volver a inicializar en pagina principal		
		ppc.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppc);				
				inicializar();			
			}
		});

		//Volver a inicializar en buscador		
		buscar.getLogo_user().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(buscar);				
				inicializar();			
			}
		});

		//Volver a inicializar carrito
		cci.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cci);				
				inicializar();			
			}
		});

		//Volver a inicializar en perfil	
		perfil.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(perfil);				
				inicializar();			
			}
		});

		//Volver a inicializar producto
		producto.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);				
				inicializar();			
			}
		});

		//Volver a inicializar compra
		compra.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(compra);				
				inicializar();			
			}
		});
	}

	private void buscador() {
		buscar.getCabecera_admin_buscar_producto().setVisible(false);

		//Buscador desde pagina principal
		ppc.getBoton_buscar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				layout.remove(ppc);	
				ppc.buscar_producto();
				buscar.bdProductos = ppc.bdProductos;
				buscar.mostrar();
				buscar.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(buscar); 
				clickBuscar();

			}
		});

		//Buscador desde buscar
		buscar.getBoton_buscar1().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				buscar.buscar_producto();
				Notification.show("Buscando...");
				buscar.getBarra_busqueda().clear();
				clickBuscar();

			}
		});

		//Buscador desde carrito
		cci.getBoton_buscar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cci);
				cci.buscar_producto();
				buscar.bdProductos = cci.bdProductos;
				buscar.mostrar();
				buscar.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(buscar); 
				clickBuscar();

			}
		});

		//Buscador desde perfil
		perfil.getBoton_buscar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(perfil);
				perfil.buscar_producto();
				buscar.bdProductos = perfil.bdProductos;
				buscar.mostrar();
				buscar.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(buscar); 
				clickBuscar();

			}
		});

		//Buscador desde producto
		producto.getBoton_buscar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);
				producto.buscar_producto();
				buscar.bdProductos = producto.bdProductos;
				buscar.mostrar();
				buscar.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(buscar); 
				clickBuscar();

			}
		});

		//Buscador desde producto
		compra.getBoton_buscar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(compra);
				compra.buscar_producto();
				buscar.bdProductos = compra.bdProductos;
				buscar.mostrar();
				buscar.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(buscar); 
				clickBuscar();

			}
		});
	}

	private void carrito() {
		// Acceso al carrito
		ppc.getBoton_carrito().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppc);
				cci.carrito = carro;
				cci.cargar_productos();
				cci.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(cci);
				botonesCarrito();

			}
		});

		//Acceso al carrito desde el buscador
		buscar.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(buscar);
				cci.carrito = carro;
				cci.cargar_productos();
				cci.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(cci);
				botonesCarrito();
			}
		});		

		//Acceso al carrito desde el producto
		producto.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);
				cci.carrito = carro;
				cci.cargar_productos();
				cci.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(cci);
				botonesCarrito();
			}
		});	

		//Acceso al carrito desde el perfil
		perfil.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(perfil);
				cci.carrito = carro;
				cci.cargar_productos();
				cci.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(cci);
				botonesCarrito();
			}
		});	

		//Acceso al carrito desde la compra
		compra.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(compra);
				cci.carrito = carro;
				cci.cargar_productos();
				cci.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(cci);
				botonesCarrito();
			}
		});	

		//Acceso a compra
		cci.getBoton_comprar_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cci);
				compra.inicializar();
				compra.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(compra);
				comprar();				
			}
		});	



	}

	private void comprar() {
		compra.getBoton_comprar_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(compra.getEnvio_cvv().isEmpty()) {
					Notification.show("Introduzca un CVV");
				} else {
					compra.realizar_compra();
					layout.remove(compra);
					carro.clear();
					inicializar();
					Notification.show("Compra realizada");
				}				
			}
		});
	}

	private void perfil() {
		// Acceso perfil
		ppc.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppc);
				perfil.getContador().setText(Integer.toString(carro.size()));
				layout.add(perfil);

			}
		});

		//Acceso perfil desde buscador
		buscar.getBoton_perfil1().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(buscar);
				perfil.getContador().setText(Integer.toString(carro.size()));
				layout.add(perfil);

			}
		});	

		//Acceso perfil desde carrito
		cci.getBoton_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cci);
				perfil.getContador().setText(Integer.toString(carro.size()));
				layout.add(perfil);				
			}
		});

		//Acceso perfil desde compra
		compra.getBoton_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(compra);
				perfil.getContador().setText(Integer.toString(carro.size()));
				layout.add(perfil);				
			}
		});

		//Acceso perfil desde producto
		producto.getBoton_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);
				perfil.getContador().setText(Integer.toString(carro.size()));
				layout.add(perfil);				
			}
		});
	}

	public void producto() {
		Producto p = new Producto();


		for(int i = 0; i < ppc.productosInterfaz.size(); i++) {
			p = ppc.productosInterfaz.get(i);
			int id = ppc.ids.get(i);

			p.getVaadinVerticalLayout().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					layout.remove(ppc);
					producto.id = id;
					producto.cargar_datos();
					producto.getContador_carrito().setText(Integer.toString(carro.size()));
					layout.add(producto);
				}
			});			
		}

		Producto_Oferta pOferta = new Producto_Oferta();

		for(int i = 0; i < ppc.ofertasInterfaz.size(); i++) {
			pOferta = ppc.ofertasInterfaz.get(i);
			int id = ppc.idsOfertas.get(i);

			pOferta.getVaadinVerticalLayout().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					layout.remove(ppc);
					producto.id = id;
					producto.cargar_datos();
					producto.getContador_carrito().setText(Integer.toString(carro.size()));
					layout.add(producto);
				}
			});			

		}

		ppc.destacado.getCombobox_lista_productos().addValueChangeListener(event -> {
			ppc.seleccion_categoria(event.getValue());
			producto();
		});
	}

	public void clickBuscar() {
		Producto p = new Producto();		

		for(int i = 0; i < buscar.productosInterfaz.length; i++) {
			p = buscar.productosInterfaz[i];
			int id = buscar.ids[i];

			p.getVaadinVerticalLayout().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					layout.remove(buscar);
					producto.id = id;
					producto.cargar_datos();
					producto.getContador_carrito().setText(Integer.toString(carro.size()));
					layout.add(producto);
				}
			});			
		}
	}

	public void aniadirCarrito() {
		producto.getBoton_aniadir_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				Producto_aniadido p = new Producto_aniadido();
				p.producto = producto.p;
				p.cantidad = 1;
				carro.add(p);
				producto.getContador_carrito().setText(Integer.toString(carro.size()));
				Notification.show("Producto aniadido");
			}
		});
	}

	public void botonesCarrito() {
		cci.carrito = carro;
		for(int i = 0; i < carro.size(); i++) {
			int indice = i;
			Producto_aniadido p = carro.get(i);
			p.getBoton_eliminar_producto_aniadido().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					if(!carro.isEmpty()) {
						carro.remove(p);
						inicializar();
						layout.removeAll();
						cci.carrito = carro;
						cci.cargar_productos();
						botonesCarrito();
						cci.getLabel_contador().setText(Integer.toString(carro.size()));
						layout.add(cci);
					}
				}
			});

			/*p.getCantidad_producto_aniadido().addValueChangeListener(event -> {
				System.out.println("\n\n" + event.getValue() + "\n\n");
				if(event.getValue() != null) {
					carro.get(indice).cantidad = Integer.parseInt(event.getValue());
					layout.remove(cci);
					cci.carrito = carro;
					cci.cargar_productos();
					botonesCarrito();
					layout.add(cci);
				}				
			});*/
		}
	}
}