package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-repartidor template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-repartidor")
@JsModule("./src/vista-repartidor.js")
public class VistaRepartidor extends PolymerTemplate<VistaRepartidor.VistaRepartidorModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaRepartidor.
     */
    public VistaRepartidor() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaRepartidor and vista-repartidor
     */
    public interface VistaRepartidorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
    
    
}
