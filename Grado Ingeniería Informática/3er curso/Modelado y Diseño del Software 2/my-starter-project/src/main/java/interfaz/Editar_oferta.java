package interfaz;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import vistas.VistaEditaroferta;

public class Editar_oferta extends VistaEditaroferta{

	
	VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	Informacion info = new Informacion();
	iAdministrador adm = new BDPrincipal();
	Ver_productos_asociados verProductos;
	basedatos.Oferta ofertaBD;

	int id=-1;
	
	public Editar_oferta() {
		inicializar();
	}
	
	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		contenido_tabs.add(info);
		verProductos = new Ver_productos_asociados(id);
		
		//this.getVaadinHorizontalLayout().add(verProductos);
		
		tabs();
	}
	
	private void tabs() {
		VerticalLayout layout_tabs = this.getLayout_tabs().as(VerticalLayout.class);
    	layout_tabs.removeAll();
    	
		Tab tab1 = new Tab("Informacion");
		
		tab1.setSelected(true);

    	Tab tab2 = new Tab("Productos asociados");

    	
    	Tabs tabs = new Tabs(true, tab1, tab2);

    	tabs.addSelectedChangeListener(event -> {
    	String seleccion = event.getSelectedTab().getLabel();
    	
	    	if(seleccion.equals("Informacion")) {
	    		contenido_tabs.add(info);
	    		contenido_tabs.remove(verProductos);
	    	} else if(seleccion.equals("Productos asociados")) {
	    		verProductos.idOferta = id;
	    		verProductos.inicializar(id);
	    		contenido_tabs.remove(info);
	    		contenido_tabs.add(verProductos);
	    	}

    	});
    	
    	
    	layout_tabs.add(tabs);	
	}
	
	public boolean comprobar_campos() {
		if(this.getNombre_oferta1().getValue() == null || info.getFecha().getValue() ==null || info.getText_descripcion().getValue()==null || info.getCondicionesDelDescuento().getValue()==null 
				|| this.getNombre_oferta1().getValue() == "" || info.getText_descripcion().getValue()== "" || info.getCondicionesDelDescuento().getValue()=="") {
			Notification.show("Rellene todos los campos.");
			return false;
		}else  {

			return true;
		}
	}
	
	public void guardar_ofertas() {
	
		
		Date fecha = Date.valueOf(info.getFecha().getValue());
		
		
		adm.guardar_ofertas(fecha, info.getText_descripcion().getValue(), info.getCondicionesDelDescuento().getValue(), this.getNombre_oferta1().getValue(), id);
	}
	
	public void cargar_oferta() {
		
		
		
		
		this.getNombre_oferta1().setValue(ofertaBD.getNombre());
		
		this.info.getCondicionesDelDescuento().setValue(Double.toString(ofertaBD.getDescuento()));
		if(ofertaBD.getDetalles() != null)
			this.info.getText_descripcion().setValue(ofertaBD.getDetalles());
		id = ofertaBD.getIdOferta();
		
		if(ofertaBD.getDetalles() != null)
			this.info.getFecha().setValue(new java.sql.Date( ofertaBD.getFechaCaducidad().getTime() ).toLocalDate());


	}
	
	public void clear() {
		id = -1;
		this.info.getCondicionesDelDescuento().clear();
		this.info.getText_descripcion().clear();
		this.getNombre_oferta1().clear();
		this.info.getFecha().clear();
	}
	
}