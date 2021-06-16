package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.Usuario;

import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import vistas.VistaAdministrador;


public class Administrador extends VistaAdministrador{
	public Pagina_principal__Administrador_ ppa;
	public VerticalLayout layout;
	public Abrir_menu_lateral__Administrador_ menu;
	public Ver_perfil__Administrador_ perfil;
	public Ver_catalogo__Administrador_ catalogo;
	public Ofertas ofertas;
	public Categorias categ;
	public Administrar_cuentas cuentas;
	public Compras compras;
	public Gestionar_anuncios anuncios;
	public Buscar_producto__Adminitrador_ barraBuscar;
	public static basedatos.Administrador usuario;

	public Administrador() {
		inicializar();
	}

	private void inicializar() {
		ppa = new Pagina_principal__Administrador_();
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		layout.removeAll();

		layout.add(ppa);

		menu = new Abrir_menu_lateral__Administrador_();
		perfil = new Ver_perfil__Administrador_();
		catalogo = new Ver_catalogo__Administrador_();
		ofertas = new Ofertas();
		categ = new Categorias();
		cuentas = new Administrar_cuentas();
		compras = new Compras();
		anuncios = new Gestionar_anuncios();
		barraBuscar = new Buscar_producto__Adminitrador_();

		menu();
		inicio();
		perfil();
		botones();
		catalogo();
		editarCateg();
		ofertas();
		editarOferta();
		producto();
		trabajador();
		categorias();
		anuncios();
	}


	private void menu() {		
		//Acceso al menu lateral pagina principal
		ppa.getBoton_menu().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});		

		//Acceso al menu lateral catalogo
		catalogo.barra.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral producto
		catalogo.verProducto.getBoton_menu().addClickListener(new ComponentEventListener() {
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

		//Acceso al menu lateral ofertas
		ofertas.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral editar oferta
		ofertas.editOferta.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral categoria
		categ.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral editar categoria
		categ.editCateg.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral listado compras
		compras.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral administrar cuentas
		cuentas.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral editar trabajador
		cuentas.trabajadores.trabajador.getBoyon_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral gestionar anuncios
		anuncios.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral buscar producto asociado categoria
		categ.editCateg.aniadirProductosAsociados._buscar_productos_asociados.getBoton_menu().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.add(menu);

			}
		});

		//Acceso al menu lateral buscar producto asociado oferta
		ofertas.editOferta.verProductos.aniadirProductosAsociados._buscar_productos_asociados.getBoton_menu().addClickListener(new ComponentEventListener() {
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


		menu.anuncios.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(anuncios);
			}
		});

		menu.catalogo.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(catalogo);
			}
		});

		menu.categorias.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(categ);
			}
		});

		menu.compras.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(compras);
			}
		});

		menu.cuentas.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(cuentas);
			}
		});

		menu.ofertas.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(ofertas);
			}
		});

		menu.perfil.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();		
				layout.add(perfil);
			}
		});
	}

	private void inicio() {
		//Volver a inicializar en pagina principal		
		ppa.getBoton_logo().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);				
				inicializar();			
			}
		});

		//Volver a inicializar desde catalogo
		catalogo.barra.getLogo_admin().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(catalogo);				
				inicializar();	

			}
		});

		//Volver a inicializar desde producto
		catalogo.verProducto.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();				
				inicializar();

			}
		});

		//Volver a inicializar desde perfil
		perfil.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(perfil);				
				inicializar();

			}
		});

		//Volver a inicializar desde ofertas
		ofertas.getBoton_logo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ofertas);				
				inicializar();

			}
		});

		//Volver a inicializar desde editar oferta
		ofertas.editOferta.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ofertas.editOferta);				
				inicializar();

			}
		});

		//Volver a inicializar desde categoria
		categ.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(categ);				
				inicializar();

			}
		});

		//Volver a inicializar desde editar categoria
		categ.editCateg.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(categ.editCateg);				
				inicializar();

			}
		});

		//Volver a inicializar desde listado compras
		compras.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(compras);				
				inicializar();

			}
		});

		//Volver a inicializar desde administrar cuentas
		cuentas.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cuentas);				
				inicializar();

			}
		});

		//Volver a inicializar desde editar trabajador
		cuentas.trabajadores.trabajador.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cuentas.trabajadores.trabajador);
				inicializar();

			}
		});

		//Volver a inicializar desde gestionar anuncios
		anuncios.getLogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(anuncios);				
				inicializar();

			}
		});

		//Volver a inicializar desde buscar productos asociados categoria
		categ.editCateg.aniadirProductosAsociados._buscar_productos_asociados.getLogo_admin().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(categ.editCateg.aniadirProductosAsociados);				
				inicializar();

			}
		});

		//Volver a inicializar desde buscar productos asociados oferta
		ofertas.editOferta.verProductos.aniadirProductosAsociados._buscar_productos_asociados.getLogo_admin().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ofertas.editOferta.verProductos.aniadirProductosAsociados);				
				inicializar();

			}
		});
	}

	private void perfil() {
		// Acceso perfil pagina principal
		ppa.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(perfil);

			}
		});

		// Acceso perfil catalogo
		catalogo.barra.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(catalogo);
				layout.add(perfil);

			}
		});

		// Acceso perfil producto
		catalogo.verProducto.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.removeAll();
				layout.add(perfil);

			}
		});

		// Acceso perfil ofertas
		ofertas.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ofertas);
				layout.add(perfil);

			}
		});

		// Acceso perfil editar oferta
		ofertas.editOferta.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ofertas.editOferta);
				layout.add(perfil);
			}
		});

		// Acceso perfil editar categoria
		categ.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(categ);
				layout.add(perfil);
			}
		});

		// Acceso perfil editar categoria
		categ.editCateg.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(categ.editCateg);
				layout.add(perfil);
			}
		});

		// Acceso perfil listado compras
		compras.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(compras);
				layout.add(perfil);
			}
		});

		// Acceso perfil administrar cuentas
		cuentas.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cuentas);
				layout.add(perfil);
			}
		});

		// Acceso perfil editar trabajador
		cuentas.trabajadores.trabajador.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cuentas.trabajadores.trabajador);
				layout.add(perfil);

			}
		});

		// Acceso perfil gestionar anuncios
		anuncios.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(anuncios);
				layout.add(perfil);
			}
		});

		// Acceso perfil buscar productos asociados categoria
		categ.editCateg.aniadirProductosAsociados._buscar_productos_asociados.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(categ.editCateg.aniadirProductosAsociados);
				layout.add(perfil);
			}
		});


		// Acceso perfil buscar productos asociados oferta
		ofertas.editOferta.verProductos.aniadirProductosAsociados._buscar_productos_asociados.getBoton_perfil().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ofertas.editOferta.verProductos.aniadirProductosAsociados);
				layout.add(perfil);
			}
		});
	}

	private void botones() {
		//Acceso catalogo
		ppa.getBoton_catalogo().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(catalogo);

			}
		});

		//Acceso ofertas
		ppa.getBoton_ofertas().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(ofertas);

			}
		});

		//Acceso categorias
		ppa.getBoton_categorias().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(categ);

			}
		});

		//Acceso listado compras
		ppa.getBoton_compras().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(compras);

			}
		});

		//Acceso administrar cuentas
		ppa.getBoton_cuentas().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(cuentas);
				trabajadores_click();

			}
		});

		//Acceso gestionar anuncios
		ppa.getBoton_anuncios().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(ppa);
				layout.add(anuncios);

			}
		});
	}

	private void catalogo(){
		catalogo.verProducto.getBoton_buscar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				layout.remove(catalogo.verProducto);
				layout.add(catalogo);

			}
		});


		catalogo.lista.getBoton_aniadir_producto().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				layout.remove(catalogo);
				catalogo.verProducto.id = -1;
				layout.add(catalogo.verProducto);

			}
		});		

	}

	private void editarOferta() {
		ofertas.getVaadinButton().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				ofertas.editOferta.clear();
				layout.remove(ofertas);
				layout.add(ofertas.editOferta);
			}
		});

		ofertas.editOferta.getBoton_guardar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(ofertas.editOferta.comprobar_campos()) {
					ofertas.editOferta.guardar_ofertas();
					inicializar();
					layout.removeAll();
					layout.add(ofertas);
				}



			}
		});

		ofertas.editOferta.verProductos.productos.getBoton_aniadir().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(ofertas.editOferta.id == -1) {
					Notification.show("Primero debes guardar la oferta.");
				}else {
					layout.remove(ofertas.editOferta);
					ofertas.editOferta.verProductos.aniadirProductosAsociados.idOferta = ofertas.editOferta.id;
					layout.add(ofertas.editOferta.verProductos.aniadirProductosAsociados);
				}

			}
		});

		ofertas.editOferta.verProductos.aniadirProductosAsociados._lista_resultados.getBoton_aniadir_resultados().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				//layout.removeAll();
				ofertas.editOferta.verProductos.aniadirProductosAsociados.aniadir_productos_asociados_oferta();
				inicializar();
				layout.removeAll();
				layout.add(ofertas);
			}
		});

		ofertas.editOferta.verProductos.productos.getBoton_eliminar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				ofertas.editOferta.verProductos.productos.eliminar_producto_asociado();
				inicializar();

				layout.removeAll();
				layout.add(ofertas);
			}
		});

		ofertas.seleccionarOfertas.getBoton_eliminar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				ofertas.seleccionarOfertas.eliminar_ofertas();
				inicializar();
				layout.removeAll();
				layout.add(ofertas);
			}
		});
	}

	private void editarCateg() {
		categ.getBoton_aniadir_categoria().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				layout.remove(categ);
				categ.editCateg.id = -1;

				layout.add(categ.editCateg);
			}
		});



		categ.editCateg.getBoton_guardar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				categ.editCateg.guardar_categoria();
				inicializar();

				layout.removeAll();
				layout.add(categ);
			}
		});

		categ.editCateg.productosAsociados.getBoton_aniadir().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				
				if(categ.editCateg.id == -1) {
					Notification.show("Recarga la página...");
				}else {
					layout.remove(categ.editCateg);
					categ.editCateg.aniadirProductosAsociados.idCategoria = categ.editCateg.id;
					layout.add(categ.editCateg.aniadirProductosAsociados);
				}
				
			}
		});

		categ.editCateg.productosAsociados.getBoton_eliminar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				categ.editCateg.eliminar_productos_asociados_categoria();
				inicializar();

				layout.removeAll();
				layout.add(categ);
			}
		});



		categ.editCateg.aniadirProductosAsociados._lista_resultados.getBoton_aniadir_resultados().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				//layout.removeAll();
				categ.editCateg.aniadirProductosAsociados.aniadir_productos_asociados_categoria();
				inicializar();
				layout.removeAll();
				layout.add(categ);
			}
		});

		categ.seleccionarCategorias.getBoton_eliminar() .addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				categ.seleccionarCategorias.eliminar_categorias();
				inicializar();
				layout.removeAll();
				layout.add(categ);
			}
		});


	}


	public void ofertas() {
		Oferta o = new Oferta();		


		for(int i = 0; i < ofertas.ofertasInterfaz.length; i++) {
			o = ofertas.ofertasInterfaz[i];
			basedatos.Oferta oBD = ofertas.ofertasBD[i];

			o.getBoton_editar().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					layout.remove(ofertas);
					ofertas.editOferta.ofertaBD = oBD;
					ofertas.editOferta.cargar_oferta();
					layout.add(ofertas.editOferta);
				}
			});			
		}
	}

	public void categorias() {
		Categoria c = new Categoria();		


		for(int i = 0; i < categ.categoriaInterfaz.length; i++) {
			c = categ.categoriaInterfaz[i];
			int id = categ.ids[i];

			c.getBoton_editar_productos().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					if(id != -1) {
						layout.remove(categ);
						categ.editCateg.id = id;
						categ.editCateg.cargar_categoria();

						layout.add(categ.editCateg);
					}
			
				}
			});			
		}
	}


	public void producto() {
		Producto_resultado p = new Producto_resultado();


		for(int i = 0; i < catalogo.productosInterfaz.length; i++) {
			p =  catalogo.productosInterfaz[i];
			int id =  catalogo.ids[i];


			p.getVaadinVerticalLayout().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					layout.remove(catalogo);
					catalogo.verProducto.id = id;
					catalogo.verProducto.cargar_producto();
					layout.add(catalogo.verProducto);
				}
			});


		}

		//Buscar
		catalogo.barra.getBoton_buscar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				catalogo.barra.buscar_producto();
				Notification.show("Buscando...");
				catalogo.mostrar_busqueda();
				producto();

			}
		});	

		catalogo.verProducto.getBoton_eliminar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				catalogo.verProducto.eliminar_producto_catalogo();
				inicializar();
				layout.removeAll();
				layout.add(catalogo);
			}
		});

		catalogo.verProducto.categorias.getBoton_aniadir_categoria_producto().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(catalogo.verProducto);
				catalogo.verProducto.aniadirCategoria.cargar_categorias();
				layout.add(catalogo.verProducto.aniadirCategoria);

			}
		});	

		catalogo.verProducto.aniadirCategoria._categorias_posibles.getBoton_aniadir_categoria_posible().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				catalogo.verProducto.aniadirCategoria.actualizarSeleccionados();
				catalogo.verProducto.cat_aniadida();
				layout.remove(catalogo.verProducto.aniadirCategoria);
				layout.add(catalogo.verProducto);

			}
		});	

		catalogo.verProducto.aniadirCategoria._categorias_posibles.getBoton_cancelar().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				layout.remove(catalogo.verProducto.aniadirCategoria);
				layout.add(catalogo.verProducto);

			}
		});	

		catalogo.verProducto.categorias.getBoton_eliminar_categoria_producto().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				catalogo.verProducto.cat_eliminada();
			}
		});	

		catalogo.verProducto.getBoton_guardar().addClickListener(new ComponentEventListener() {

			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(catalogo.verProducto.comprobar_campos()) {
					catalogo.verProducto.guardar();
					catalogo.verProducto.cargar_producto();
					inicializar();
					layout.removeAll();
					layout.add(catalogo);
				}	
			}

		});


	}

	private void trabajador() {
		cuentas.trabajadores.lista.getVaadinButton().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {

				layout.remove(cuentas);
				cuentas.trabajadores.trabajador.trabajador_nuevo();
				layout.add(cuentas.trabajadores.trabajador);

			}
		});

		cuentas.trabajadores.trabajador.getBoton_guardar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(cuentas.trabajadores.trabajador.comprobar_campos()) {
					cuentas.trabajadores.trabajador.guardar_trabajador();
					inicializar();
					layout.removeAll();
					layout.add(cuentas);
					trabajadores_click();
				}


			}
		});



	}

	private void trabajadores_click() {
		Trabajador t;
		for(int i = 0; i <cuentas.trabajadores.trabajadoresInterfaz.length ; i++) {
			t =  cuentas.trabajadores.trabajadoresInterfaz[i];
			Usuario usuarioBD =  cuentas.trabajadores.bdTrabajadores[i];


			t.getVaadinButton().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					layout.remove(cuentas);
					cuentas.trabajadores.trabajador.bdUsuario = usuarioBD;
					cuentas.trabajadores.trabajador.cargar_trabajador();
					layout.add(cuentas.trabajadores.trabajador);
				}
			});


		}
	}

	private void anuncios() {

		anuncios.editar.getBoton_guardar_anuncio().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(anuncios.comprobar_campos()) {
					anuncios.guardar_anuncio();
					inicializar();
					layout.removeAll();
					layout.add(anuncios);

				}


			}
		});

		anuncios.lista.getBoton_aniadir_anuncio().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {

				inicializar();
				layout.removeAll();
				layout.add(anuncios);
			}
		});	

		for(int i = 0; i< anuncios.bdAnuncios.length; i++) {
			int idLocal = anuncios.bdAnuncios[i].getID();
			anuncios.editar.getBoton_eliminar_anuncio().addClickListener(new ComponentEventListener() {
				@Override
				public void onComponentEvent(ComponentEvent event) {
					if(anuncios.comprobar_campos()) {
						anuncios.id = idLocal;
						anuncios.eliminar_anuncio();
						inicializar();
						layout.removeAll();
						layout.add(anuncios);

					}


				}
			});
		}


	}


}