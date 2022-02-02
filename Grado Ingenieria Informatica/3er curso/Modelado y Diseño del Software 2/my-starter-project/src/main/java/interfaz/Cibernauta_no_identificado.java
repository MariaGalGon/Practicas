package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.Item;

public class Cibernauta_no_identificado extends Comun {

	public Pagina_principal__Cibernauta_ ppc;
	public VerticalLayout layout;
	public Carrito__Cibernauta_no_identificado_ ccni;
	public Abrir_menu_lateral__Cibernauta_ menu;
	public Buscar_producto__Cibernauta_ buscar;
	public Iniciar_sesion login;
	public Ver_producto__Cibernauta_no_registrado_ producto;
	public Confirmar confirmarBaja;
	public static ArrayList<Producto_aniadido> carro = new ArrayList<Producto_aniadido>();



	public Cibernauta_no_identificado() {

		inicializar(false);		
	}

	public Cibernauta_no_identificado(boolean baja) {

		inicializar(baja);		
	}

	public void inicializar(boolean baja) {
		//Vista pagina principal		
		layout = this.getVerticalLayout().as(VerticalLayout.class);	

		ppc = new Pagina_principal__Cibernauta_();
		menu = new Abrir_menu_lateral__Cibernauta_();
		buscar = new Buscar_producto__Cibernauta_();
		ccni = new Carrito__Cibernauta_no_identificado_();
		login = new Iniciar_sesion();
		producto = new Ver_producto__Cibernauta_no_registrado_();
		confirmarBaja = new Confirmar();

		ppc.getContador().setText(Integer.toString(carro.size()));
		layout.add(ppc);

		if(baja) {
			layout.add(confirmarBaja);
		}

		menu(); //Abrir menu lateral
		inicio(); //Reiniciar página
		buscador(); //Busqueda
		login(); //Iniciar sesion
		carrito(); //Abrir carrito
		producto(); //Abrir un producto
		aniadirCarrito(); //Aniadir producto al carrito
	}

	private void menu() {		
		//Acceso al menu lateral pagina principal
		ppc.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {				
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
		ccni.getBoton_menu().addClickListener(new ComponentEventListener(){
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

		//Salir del menu lateral
		menu.getBoton_salir().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(menu);	

			}
		});

	}

	private void inicio() {
		//Volver a inicializar en pagina principal		
		ppc.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppc);				
				inicializar(false);			
			}
		});

		//Volver a inicializar en buscador		
		buscar.getLogo_user().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(buscar);				
				inicializar(false);			
			}
		});

		//Volver a inicializar carrito	
		ccni.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ccni);				
				inicializar(false);			
			}
		});

		//Volver a inicializar producto
		producto.getLogo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);				
				inicializar(false);			
			}
		});

		//Volver a inicio desde ventana de baja
		confirmarBaja.getBoton_productos().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(confirmarBaja);				
			}
		});


		menu.perfil.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(login);
			}
		});
	}

	private void buscador() {

		buscar.getCabecera_admin_buscar_producto().setVisible(false);

		//Buscador desde pagina principal
		ppc.getBoton_buscar().addClickListener(new ComponentEventListener(){
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
		ccni.getBoton_buscar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ccni);
				ccni.buscar_producto();
				buscar.bdProductos = ccni.bdProductos;
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
	}

	private void carrito() {
		//Acceso al carrito desde pagina principal
		ppc.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppc);
				ccni.carrito = carro;
				ccni.cargar_productos();
				ccni.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(ccni);
				botonesCarrito();
			}
		});

		//Acceso al carrito desde el buscador
		buscar.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(buscar);
				ccni.carrito = carro;
				ccni.cargar_productos();
				ccni.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(ccni);
				botonesCarrito();
			}
		});		

		//Acceso al carrito desde el producto
		producto.getBoton_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);
				ccni.carrito = carro;
				ccni.cargar_productos();
				ccni.getLabel_contador().setText(Integer.toString(carro.size()));
				layout.add(ccni);
				botonesCarrito();
			}
		});	
	}

	private void login() {
		//Acceso login desde pagina principal
		ppc.getBoton_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppc);				
				layout.add(login);

			}
		});	

		//Acceso login desde buscador
		buscar.getBoton_perfil1().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(buscar);				
				layout.add(login);

			}
		});	

		//Acceso login desde carrito
		ccni.getBoton_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ccni);				
				layout.add(login);				
			}
		});

		//Acceso login desde producto
		producto.getBoton_perfil().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);				
				layout.add(login);				
			}
		});

		//Acceso login desde comentarios
		producto.comentarios.getBoton_escribir_comentario().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(producto);				
				layout.add(login);				
			}
		});

		ccni.getBoton_comprar_carrito().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ccni);				
				layout.add(login);

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
		ccni.carrito = carro;
		for(int i = 0; i < carro.size(); i++) {
			int indice = i;
			Producto_aniadido p = carro.get(i);
			p.getBoton_eliminar_producto_aniadido().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {
					if(!carro.isEmpty()) {
						carro.remove(p);
						inicializar(false);
						layout.removeAll();
						ccni.carrito = carro;
						ccni.cargar_productos();
						botonesCarrito();
						layout.add(ccni);
					}
				}
			});

			/*p.getCantidad_producto_aniadido().addValueChangeListener(event -> {
				System.out.println("\n\n" + event.getValue() + "\n\n");
				if(event.getValue() != null) {
					carro.get(indice).cantidad = Integer.parseInt(event.getValue());
					layout.remove(ccni);
					ccni.carrito = carro;
					ccni.cargar_productos();
					botonesCarrito();
					layout.add(ccni);
				}				
			});*/
		}
	}

}