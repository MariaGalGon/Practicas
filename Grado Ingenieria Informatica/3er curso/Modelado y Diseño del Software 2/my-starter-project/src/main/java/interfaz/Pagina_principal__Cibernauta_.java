package interfaz;

import vistas.VistaPaginaprincipalcibernauta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;

import basedatos.BDPrincipal;
import basedatos.iComun;




public class Pagina_principal__Cibernauta_ extends VistaPaginaprincipalcibernauta {

	
	public Productos_destacados destacado = new Productos_destacados();
	public Ofertas__Cibernauta_ ofertas = new Ofertas__Cibernauta_();
	public iComun comun = new BDPrincipal();
	public VerticalLayout verticalLayout;
	ArrayList<Producto> productosInterfaz;
	ArrayList<Producto_Oferta> ofertasInterfaz;
	ArrayList<Integer> ids;
	ArrayList<Integer> idsOfertas;
	basedatos.Producto[] bdProductos;
	
	
	
	
	public Pagina_principal__Cibernauta_() {
		inicializar();		
	}
	
	
	public void inicializar() {
		//Poner logo y tamaño
		
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		this.getAnuncio_pagina_principal().setSrc("/img/banner.png");
		this.getAnuncio_pagina_principal().setHeight("40.5em");
		
		verticalLayout = this.getListas_pagina_principal().as(VerticalLayout.class);
		verticalLayout.add(ofertas);
		verticalLayout.add(destacado);
		
		cargar_productos_destacados();
		cargar_anuncio();
		cargar_categorias_combobox();
	}
	
	public void cargar_productos_destacados() {
		ofertasInterfaz = new ArrayList<Producto_Oferta>();
		idsOfertas = new ArrayList<Integer>();
		basedatos.Producto[] productos = comun.cargar_productos_destacados();
		int limite = 6;
		
		if(productos.length < limite)
			limite = productos.length;
		
		productosInterfaz = new ArrayList<Producto>();
		ids = new ArrayList<Integer>();

		destacado.getCuadro_lista_boton().removeAll();
		ofertas.getLista_ofertas().removeAll();

		
		for(int i = 0; i < limite; i++) {
			Producto p = new Producto();
			Producto_Oferta pOferta = new Producto_Oferta();
			//basedatos.Foto img = productos[i].getImagen();
			//p.setImagen_producto_resultado(productos[i].getImagen());			
			//p.getImagen_producto_resultado().setSrc(null);
			
			p.getNombre_producto().setText(productos[i].getNombre());
			
			
			DecimalFormat formato = new DecimalFormat("#.00");
			
			
			p.getFecha_oferta_producto().setVisible(false);
			p.getLabel_oferta_producto().setVisible(false);
			p.setId(Integer.toString(productos[i].getIdProducto()));
			
			if(productos[i].getImagen() != null) {
				p.getImagen_producto().setSrc(productos[i].getImagen());
			}
			p.getImagen_producto().setHeight("8em");
			
			if(productos[i].getOferta_aplicada() == null) {
				p.getPrecio_producto().setText(Double.toString(productos[i].getPrecio()) + " €");		
			}else {
				p.getTachado().setText(Double.toString(productos[i].getPrecio()) + " €");
				p.getPrecio_producto().setText(formato.format(productos[i].getPrecio()- productos[i].getPrecio()*productos[i].getOferta_aplicada().getDescuento()) + " €");	
				
				pOferta.getNombre_producto().setText(productos[i].getNombre());
				pOferta.getTachado().setText(Double.toString(productos[i].getPrecio()) + " €");
				pOferta.getPrecio_producto().setText(formato.format(productos[i].getPrecio()- productos[i].getPrecio()*productos[i].getOferta_aplicada().getDescuento()) + " €");	
				pOferta.getFecha_oferta_producto().setVisible(false);
				pOferta.getLabel_oferta_producto().setVisible(false);
				pOferta.setId(Integer.toString(productos[i].getIdProducto()));
				if(productos[i].getImagen() != null) {
					pOferta.getImagen_producto().setSrc(productos[i].getImagen());
				}
				pOferta.getImagen_producto().setHeight("8em");
				pOferta.getFecha_oferta_producto().setText(productos[i].getOferta_aplicada().getFechaCaducidad().toString());
				pOferta.getFecha_oferta_producto().setVisible(true);
				pOferta.getLabel_oferta_producto().setVisible(true);
				ofertasInterfaz.add(pOferta);
				idsOfertas.add( productos[i].getIdProducto());
				ofertas.getLista_ofertas().add(pOferta);
			}
			
			
			productosInterfaz.add(p);
			ids.add(productos[i].getIdProducto());
			
			destacado.getCuadro_lista_boton().add(p);
		}
	}
	

	
	public void buscar_producto() {
		bdProductos = comun.buscar_producto(this.getBarra_busqueda().getValue());
	}
	
	public void cargar_anuncio() {
		basedatos.Anuncio[] anuncios = comun.cargar_anuncios();
		if(anuncios.length == 0) {
			return;
		}
		int aleatorio = (int) (Math.random() * anuncios.length);
		
		this.getAnuncio_pagina_principal().setSrc(anuncios[aleatorio].getImagen());
		this.getAnuncio_pagina_principal().setHeight("40.5em");
	}
	
	public void cargar_categorias_combobox() {
		basedatos.Categoria[] categorias = comun.cargar_categorias_combobox();
		
		List<String> combobox = new ArrayList<String>();
		combobox.add("Todos");
		for(int i = 0; i< categorias.length; i++) {
			combobox.add(categorias[i].getNombe());

		}
		destacado.getCombobox_lista_productos().setItems(combobox);
		destacado.getCombobox_lista_productos().setValue("Todos");
		
		

	}
	
	public void seleccion_categoria(String elegida) {
		if(elegida.equals("Todos")) {
			cargar_productos_destacados();
			return;
		}
		
		basedatos.Producto[] productos = comun.cargar_productos_destacados();
		int limite = 6;
		
		if(productos.length < limite)
			limite = productos.length;
		destacado.getCuadro_lista_boton().removeAll();

		productosInterfaz = new ArrayList<Producto>();
		ids = new ArrayList<Integer>();
		int numMostrar = 0;
		for(int i = 0; i < productos.length; i++) {
			
			if(numMostrar > limite) {
				break;
			}
			basedatos.Categoria[] categorias = productos[i].pertenece_a_categoria.toArray();
			boolean valido = false;
			for(int j = 0; j < categorias.length; j++) {
				if(categorias[j].getNombe().equals(elegida)) {
					valido = true;
				}
			}
			
			if(!valido) {
				continue;
			}
			numMostrar++;
			
			Producto p = new Producto();
			p.getNombre_producto().setText(productos[i].getNombre());
			p.getFecha_oferta_producto().setVisible(false);
			p.getLabel_oferta_producto().setVisible(false);
			p.setId(Integer.toString(productos[i].getIdProducto()));
			
			p.getImagen_producto().setSrc(productos[i].getImagen());
			p.getImagen_producto().setHeight("8em");
			
			if(productos[i].getOferta_aplicada() == null) {
				p.getPrecio_producto().setText(Double.toString(productos[i].getPrecio()) + " €");		
			}else {
				p.getTachado().setText(Double.toString(productos[i].getPrecio()) + " €");
				p.getPrecio_producto().setText(Double.toString(productos[i].getPrecio()*productos[i].getOferta_aplicada().getDescuento()) + " €");	
			}
			
			
			productosInterfaz.add(p);
			ids.add(productos[i].getIdProducto());
			
			destacado.getCuadro_lista_boton().add(p);
		}
	}
	
}