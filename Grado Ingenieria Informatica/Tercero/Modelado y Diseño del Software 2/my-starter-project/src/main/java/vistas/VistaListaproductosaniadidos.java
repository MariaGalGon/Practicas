package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaProductoaniadido;

/**
 * A Designer generated component for the vista-listaproductosaniadidos template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaproductosaniadidos")
@JsModule("./src/vista-listaproductosaniadidos.js")
public class VistaListaproductosaniadidos extends PolymerTemplate<VistaListaproductosaniadidos.VistaListaproductosaniadidosModel> {

    @Id("lista_productos_aniadidos")
	private HorizontalLayout lista_productos_aniadidos;
	

	/**
     * Creates a new VistaListaproductosaniadidos.
     */
    public VistaListaproductosaniadidos() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaproductosaniadidos and vista-listaproductosaniadidos
     */
    public interface VistaListaproductosaniadidosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_productos_aniadidos() {
		return lista_productos_aniadidos;
	}

	public void setLista_productos_aniadidos(HorizontalLayout lista_productos_aniadidos) {
		this.lista_productos_aniadidos = lista_productos_aniadidos;
	}

	
}
