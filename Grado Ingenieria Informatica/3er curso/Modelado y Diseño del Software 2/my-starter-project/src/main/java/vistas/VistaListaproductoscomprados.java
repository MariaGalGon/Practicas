package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import vistas.VistaProductocompra;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-listaproductoscomprados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaproductoscomprados")
@JsModule("./src/vista-listaproductoscomprados.js")
public class VistaListaproductoscomprados extends PolymerTemplate<VistaListaproductoscomprados.VistaListaproductoscompradosModel> {

	@Id("lista_productos")
	private HorizontalLayout lista_productos;

	/**
     * Creates a new VistaListaproductoscomprados.
     */
    public VistaListaproductoscomprados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaproductoscomprados and vista-listaproductoscomprados
     */
    public interface VistaListaproductoscompradosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_productos() {
		return lista_productos;
	}

	public void setLista_productos(HorizontalLayout lista_productos) {
		this.lista_productos = lista_productos;
	}
}
