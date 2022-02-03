package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaProducto;

/**
 * A Designer generated component for the vista-listaresultadosbusqueda template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaresultadosbusqueda")
@JsModule("./src/vista-listaresultadosbusqueda.js")
public class VistaListaresultadosbusqueda extends PolymerTemplate<VistaListaresultadosbusqueda.VistaListaresultadosbusquedaModel> {

    @Id("lista_buscar_productos")
	private HorizontalLayout lista_buscar_productos;
	

	/**
     * Creates a new VistaListaresultadosbusqueda.
     */
    public VistaListaresultadosbusqueda() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaresultadosbusqueda and vista-listaresultadosbusqueda
     */
    public interface VistaListaresultadosbusquedaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_buscar_productos() {
		return lista_buscar_productos;
	}

	public void setLista_buscar_productos(HorizontalLayout lista_buscar_productos) {
		this.lista_buscar_productos = lista_buscar_productos;
	}

}
