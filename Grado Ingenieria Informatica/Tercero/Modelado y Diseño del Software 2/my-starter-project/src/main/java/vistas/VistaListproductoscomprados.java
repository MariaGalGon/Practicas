package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-listproductoscomprados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listproductoscomprados")
@JsModule("./src/vista-listproductoscomprados.js")
public class VistaListproductoscomprados extends PolymerTemplate<VistaListproductoscomprados.VistaListproductoscompradosModel> {

    @Id("lista_productos_compra")
	private HorizontalLayout lista_productos_compra;

	/**
     * Creates a new VistaListproductoscomprados.
     */
    public VistaListproductoscomprados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListproductoscomprados and vista-listproductoscomprados
     */
    public interface VistaListproductoscompradosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_productos_compra() {
		return lista_productos_compra;
	}

	public void setLista_productos_compra(HorizontalLayout lista_productos_compra) {
		this.lista_productos_compra = lista_productos_compra;
	}
}
