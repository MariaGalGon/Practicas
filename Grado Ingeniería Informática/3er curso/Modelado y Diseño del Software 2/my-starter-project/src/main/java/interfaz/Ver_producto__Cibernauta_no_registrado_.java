package interfaz;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.dom.Element;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import basedatos.iComun;

public class Ver_producto__Cibernauta_no_registrado_ extends Ver_producto__Cibernauta_ {

	
	iComun comun = new BDPrincipal();
	public VerticalLayout layout;
	public VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	Ver_informacion__Cibernauta_ info = new Ver_informacion__Cibernauta_();	
	Ver_caracteristicas__Cibernauta_ caracteristica = new Ver_caracteristicas__Cibernauta_();
	Ver_comentarios__general_ comentarios = new Ver_comentarios__general_();
	public int id;
	basedatos.Producto[] bdProductos;
	basedatos.Producto p;
	Comentarios lista_comentarios;
	int posFoto;


	public Ver_producto__Cibernauta_no_registrado_() {		
		inicializar();
	}
	
	public void inicializar(){
		contenido_tabs.add(info);
		this.getNombre_producto_admin().setVisible(false);
		this.getCuadro_seleccion_imagen().setVisible(false);
		this.getPrecio_admin().setVisible(false);
		this.getBoton_eliminar().setVisible(false);
		this.getBoton_guardar().setVisible(false);
	
		

		lista_comentarios = new Comentarios();
		comentarios.getHueco_lista_comentarios().removeAll();
		comentarios.getHueco_lista_comentarios().add(lista_comentarios);
		
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		
		tabs();
	}
	
	private void tabs() {
		VerticalLayout layout_tabs = this.getLayout_tabs().as(VerticalLayout.class);

    	layout_tabs.removeAll();
		Tab tab1 = new Tab("Informacion");
		tab1.setSelected(true);

    	Tab tab2 = new Tab("Caracteristicas");

    	Tab tab3 = new Tab("Comentarios");

    	Tabs tabs = new Tabs(true, tab1, tab2, tab3);

    	tabs.addSelectedChangeListener(event -> {
    	String seleccion = event.getSelectedTab().getLabel();
    	
    	if(seleccion.equals("Informacion")) {
    		contenido_tabs.add(info);
    		contenido_tabs.remove(caracteristica);
    		contenido_tabs.remove(comentarios);
    	}else if(seleccion.equals("Caracteristicas")) {
    		contenido_tabs.remove(info);
    		contenido_tabs.add(caracteristica);
    		contenido_tabs.remove(comentarios);
    	}else if(seleccion.equals("Comentarios")) {
    		contenido_tabs.remove(info);
    		contenido_tabs.remove(caracteristica);
    		cargar_comentarios();
    		contenido_tabs.add(comentarios);
    	}

    	});
    	
    	
    	layout_tabs.add(tabs);	
	}
	
	public void cargar_datos() {
		p = comun.cargar_datos_producto(id);
		
		this.getNombre_producto_cibernauta().setText(p.getNombre());
		this.getPrecio().setText(p.getPrecio() + " €");
		info.getInfo().setText(p.getInformacion());
		caracteristica.getP().setText(p.getDescripcion());
		valoracion_media();
		this.getFoto_producto().setSrc(p.getImagen());
		posFoto = 0;
		cambiar_imagen();
		//falta img
	}
	
	public void buscar_producto() {
		bdProductos = comun.buscar_producto(this.getBarra_busqueda().getValue());
	}
	
	public void cargar_comentarios() {
		ListBox<Comentario> listbox_comentarios = lista_comentarios.getLista_comentarios().as(ListBox.class);
		listbox_comentarios.removeAll();
		Comentario[] comentariosInterfaz = new Comentario[p.comentarios.size()];
		for(int i = 0; i< comentariosInterfaz.length; i++) {
			comentariosInterfaz[i] = new Comentario();
			comentariosInterfaz[i].getNombre_usuario_comentario().setText(p.comentarios.toArray()[i].getCibernauta().getNombre());
			comentariosInterfaz[i].getContador_valoracion().setText(Integer.toString(p.comentarios.toArray()[i].getValoracion()));
			comentariosInterfaz[i].getTexto_comentario().setText(p.comentarios.toArray()[i].getTexto());
			comentariosInterfaz[i].getIcono_perfil_comentario().setSrc(p.comentarios.toArray()[i].getCibernauta().getFoto());
			comentariosInterfaz[i].getIcono_perfil_comentario().setHeight("4em");
			listbox_comentarios.add(comentariosInterfaz[i]);
		}
		
		
	}
	
	public void valoracion_media() {
		
		int suma = 0;
		for(int i = 0; i< p.comentarios.size(); i++) {
			suma += p.comentarios.toArray()[i].getValoracion();
		}
		
		double media = (double)suma/ p.comentarios.size();
		this.getContador_valoracion().setVisible(false);
		if(media <= 1) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_vacia.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_vacia.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_vacia.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 2) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_vacia.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_vacia.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 3) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_llena.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_vacia.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 4) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_llena.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_llena.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 5) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_llena.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_llena.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_llena.png");
			getEstrella_5().setHeight("2.5em");
		}
	}
	
	public void cambiar_imagen() {
		
		this.getDesp_derch().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(p.fotos.toArray().length != posFoto + 1) {
					posFoto++;
					getFoto_producto().setSrc(p.fotos.toArray()[posFoto].getDireccion());
				}
			}
		});
		
		this.getDesp_izq().addClickListener(new ComponentEventListener(){
			@Override
			public void onComponentEvent(ComponentEvent event) {
				if(-1 != posFoto - 1) {
					posFoto--;
					getFoto_producto().setSrc(p.fotos.toArray()[posFoto].getDireccion());
				}
			}
		});
	}
}