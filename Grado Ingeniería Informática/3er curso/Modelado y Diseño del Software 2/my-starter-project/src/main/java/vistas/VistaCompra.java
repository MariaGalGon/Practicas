package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;

/**
 * A Designer generated component for the vista-compra template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-compra")
@JsModule("./src/vista-compra.js")
public class VistaCompra extends PolymerTemplate<VistaCompra.VistaCompraModel> {

    @Id("nombre_compra")
	private Label nombre_compra;
	@Id("estado_compra")
	private Paragraph estado_compra;

	/**
     * Creates a new VistaCompra.
     */
    public VistaCompra() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCompra and vista-compra
     */
    public interface VistaCompraModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getNombre_compra() {
		return nombre_compra;
	}

	public void setNombre_compra(Label nombre_compra) {
		this.nombre_compra = nombre_compra;
	}

	public Paragraph getEstado_compra() {
		return estado_compra;
	}

	public void setEstado_compra(Paragraph estado_compra) {
		this.estado_compra = estado_compra;
	}
}
