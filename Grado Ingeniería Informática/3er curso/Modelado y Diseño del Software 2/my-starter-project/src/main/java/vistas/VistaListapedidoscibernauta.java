package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-listapedidoscibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listapedidoscibernauta")
@JsModule("./src/vista-listapedidoscibernauta.js")
public class VistaListapedidoscibernauta extends PolymerTemplate<VistaListapedidoscibernauta.VistaListapedidoscibernautaModel> {

    @Id("lista_pedidos")
	private HorizontalLayout lista_pedidos;

	/**
     * Creates a new VistaListapedidoscibernauta.
     */
    public VistaListapedidoscibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListapedidoscibernauta and vista-listapedidoscibernauta
     */
    public interface VistaListapedidoscibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getLista_pedidos() {
		return lista_pedidos;
	}

	public void setLista_pedidos(HorizontalLayout lista_pedidos) {
		this.lista_pedidos = lista_pedidos;
	}
}
