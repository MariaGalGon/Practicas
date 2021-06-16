package interfaz;

import java.util.ArrayList;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaAniadirproductoasociado;

public class Aniadir_producto_asociado extends VistaAniadirproductoasociado{
	public Productos_asociados _productos_asociados;
	public Lista_resultados _lista_resultados;
	public Buscar_productos_asociados _buscar_productos_asociados;
	VerticalLayout layout;
	public iAdministrador adm;
	public int idCategoria;
	public int idOferta;
	Resultado[] resultados;
	int ids[];
	


	public  Aniadir_producto_asociado(boolean categoria) {
		inicializar(categoria);
	}
	
	public void inicializar(boolean categoria) {
		adm = new BDPrincipal();
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		_lista_resultados = new Lista_resultados();
		_buscar_productos_asociados = new Buscar_productos_asociados(); 
		layout.add( _buscar_productos_asociados);
		layout.add( _lista_resultados);
		if(categoria) {
			cargar_productos_aniadir_categoria();
			botonesCategoria();
		}else {
			cargar_productos_aniadir_oferta();
			botonesOferta();
		}
		
	}
	
	private void cargar_productos_aniadir_categoria() {
		basedatos.Producto[] productos = adm.cargar_productos_aniadir_categoria(idCategoria);

		
		resultados = new Resultado[productos.length];
		ids = new int[productos.length];

		
		for(int i = 0; i < productos.length; i++) {
			resultados[i] = new Resultado();
			ids[i] = productos[i].getIdProducto();
			resultados[i].getNombre_resultado().setText(productos[i].getNombre());
			if(productos[i].getImagen() != null) {
				resultados[i].getImagen_resultado().setSrc(productos[i].getImagen()); 
				resultados[i].getImagen_resultado().setHeight("8em");
			}

			_lista_resultados.getLista_elementos_resultado().add(resultados[i]);
		}

	}
	
	private void cargar_productos_aniadir_oferta() {
		basedatos.Producto[] productos = adm.cargar_productos_aniadir_oferta(idOferta);

		
		resultados = new Resultado[productos.length];
		ids = new int[productos.length];

		
		for(int i = 0; i < productos.length; i++) {
			resultados[i] = new Resultado();
			ids[i] = productos[i].getIdProducto();
			resultados[i].getNombre_resultado().setText(productos[i].getNombre());

			if(productos[i].getImagen() != null) {
				resultados[i].getImagen_resultado().setSrc(productos[i].getImagen()); 
				resultados[i].getImagen_resultado().setHeight("8em");
			}
			
			_lista_resultados.getLista_elementos_resultado().add(resultados[i]);
		}

	}
	
	private void botonesCategoria() {
		_buscar_productos_asociados.getBoton_buscar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				buscar_productos_aniadir_categoria();
				
			}
		});
		
		
	}
	
	private void botonesOferta() {
		_buscar_productos_asociados.getBoton_buscar().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				buscar_productos_aniadir_Oferta();
				
			}
		});
		
		
	}
	

	
	private void buscar_productos_aniadir_categoria() {
		basedatos.Producto[] productos = adm.buscar_producto_aniadir_categoria(_buscar_productos_asociados.getBarra_busqueda_producto().getValue());
		_lista_resultados.getLista_elementos_resultado().removeAll();
		ids = new int[productos.length];

		resultados = new Resultado[productos.length];
		for(int i = 0; i < productos.length; i++) {
			resultados[i] = new Resultado();		
			ids[i] = productos[i].getIdProducto();
			
			if(productos[i].getImagen() != null) {
				resultados[i].getImagen_resultado().setSrc(productos[i].getImagen()); 
				resultados[i].getImagen_resultado().setHeight("8em");
			}

			resultados[i].getNombre_resultado().setText(productos[i].getNombre());
			_lista_resultados.getLista_elementos_resultado().add(resultados[i]);
		}

	}
	
	private void buscar_productos_aniadir_Oferta() {
		basedatos.Producto[] productos = adm.buscar_producto_aniadir_oferta(_buscar_productos_asociados.getBarra_busqueda_producto().getValue());
		_lista_resultados.getLista_elementos_resultado().removeAll();
		ids = new int[productos.length];

		resultados = new Resultado[productos.length];
		for(int i = 0; i < productos.length; i++) {
			resultados[i] = new Resultado();		
			ids[i] = productos[i].getIdProducto();
			
			if(productos[i].getImagen() != null) {
				resultados[i].getImagen_resultado().setSrc(productos[i].getImagen()); 
				resultados[i].getImagen_resultado().setHeight("8em");
			}

			resultados[i].getNombre_resultado().setText(productos[i].getNombre());
			_lista_resultados.getLista_elementos_resultado().add(resultados[i]);
		}

	}
	
	public void aniadir_productos_asociados_categoria() {
		ArrayList<Integer> idsSeleccionados = new ArrayList<Integer>();
		for(int i = 0; i< resultados.length; i++) {
			if(resultados[i].getCheckbox_resultado().getValue()) {
				idsSeleccionados.add(ids[i]);
			}
		}
		
		int[] arraySeleccionados = new int[idsSeleccionados.size()];
		
		for(int i = 0; i<arraySeleccionados.length; i++) {
			arraySeleccionados[i] = idsSeleccionados.get(i);
		}
		
		adm.aniadir_productos_asociados_categoria(arraySeleccionados, idCategoria);
	}
	
	public void aniadir_productos_asociados_oferta() {
		ArrayList<Integer> idsSeleccionados = new ArrayList<Integer>();
		for(int i = 0; i< resultados.length; i++) {
			if(resultados[i].getCheckbox_resultado().getValue()) {
				idsSeleccionados.add(ids[i]);
			}
		}
		
		int[] arraySeleccionados = new int[idsSeleccionados.size()];
		
		for(int i = 0; i<arraySeleccionados.length; i++) {
			arraySeleccionados[i] = idsSeleccionados.get(i);
		}
		
		adm.aniadir_productos_asociados_oferta(arraySeleccionados, idOferta);
	}
	
	
}