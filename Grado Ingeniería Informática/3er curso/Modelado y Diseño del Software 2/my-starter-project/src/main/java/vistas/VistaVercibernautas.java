package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tab;
import vistas.VistaListacibernautas;

/**
 * A Designer generated component for the vista-vercibernautas template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vercibernautas")
@JsModule("./src/vista-vercibernautas.js")
public class VistaVercibernautas extends PolymerTemplate<VistaVercibernautas.VistaVercibernautasModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	/**
     * Creates a new VistaVercibernautas.
     */
    public VistaVercibernautas() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVercibernautas and vista-vercibernautas
     */
    public interface VistaVercibernautasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
}
