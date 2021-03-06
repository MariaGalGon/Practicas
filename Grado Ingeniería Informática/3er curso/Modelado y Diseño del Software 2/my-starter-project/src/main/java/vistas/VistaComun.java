package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-comun template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-comun")
@JsModule("./src/vista-comun.js")
public class VistaComun extends PolymerTemplate<VistaComun.VistaComunModel> {

	@Id("VerticalLayout")
	private Element verticalLayout;

	/**
     * Creates a new VistaComun.
     */
    public VistaComun() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaComun and vista-comun
     */
    public interface VistaComunModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVerticalLayout() {
		return verticalLayout;
	}

	public void setVerticalLayout(Element verticalLayout) {
		this.verticalLayout = verticalLayout;
	}
}
