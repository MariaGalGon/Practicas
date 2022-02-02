package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.checkbox.Checkbox;

/**
 * A Designer generated component for the vista-productoasociado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-productoasociado")
@JsModule("./src/vista-productoasociado.js")
public class VistaProductoasociado extends PolymerTemplate<VistaProductoasociado.VistaProductoasociadoModel> {

    @Id("descripcion_producto")
	private Paragraph descripcion_producto;
	@Id("checkbox")
	private Checkbox checkbox;

	/**
     * Creates a new VistaProductoasociado.
     */
    public VistaProductoasociado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaProductoasociado and vista-productoasociado
     */
    public interface VistaProductoasociadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Paragraph getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(Paragraph descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public Checkbox getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Checkbox checkbox) {
		this.checkbox = checkbox;
	}
}
