package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-enlace template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-enlace")
@JsModule("./src/vista-enlace.js")
public class VistaEnlace extends PolymerTemplate<VistaEnlace.VistaEnlaceModel> {

    @Id("nombre_seccion")
	private Label nombre_seccion;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
     * Creates a new VistaEnlace.
     */
    public VistaEnlace() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEnlace and vista-enlace
     */
    public interface VistaEnlaceModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getNombre_seccion() {
		return nombre_seccion;
	}

	public void setNombre_seccion(Label nombre_seccion) {
		this.nombre_seccion = nombre_seccion;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}
}
