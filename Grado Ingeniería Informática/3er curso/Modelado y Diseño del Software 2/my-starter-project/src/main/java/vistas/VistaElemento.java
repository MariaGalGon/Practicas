package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-elemento template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-elemento")
@JsModule("./src/vista-elemento.js")
public class VistaElemento extends PolymerTemplate<VistaElemento.VistaElementoModel> {

    @Id("checkbox_elemento")
	private Checkbox checkbox_elemento;
	@Id("detalles_elemento")
	private Paragraph detalles_elemento;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
     * Creates a new VistaElemento.
     */
    public VistaElemento() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaElemento and vista-elemento
     */
    public interface VistaElementoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Checkbox getCheckbox_elemento() {
		return checkbox_elemento;
	}

	public void setCheckbox_elemento(Checkbox checkbox_elemento) {
		this.checkbox_elemento = checkbox_elemento;
	}

	public Paragraph getDetalles_elemento() {
		return detalles_elemento;
	}

	public void setDetalles_elemento(Paragraph detalles_elemento) {
		this.detalles_elemento = detalles_elemento;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}
}
