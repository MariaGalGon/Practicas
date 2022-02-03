package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tab;
import vistas.VistaListatrabajadores;

/**
 * A Designer generated component for the vista-vertrabajadores template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vertrabajadores")
@JsModule("./src/vista-vertrabajadores.js")
public class VistaVertrabajadores extends PolymerTemplate<VistaVertrabajadores.VistaVertrabajadoresModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	/**
     * Creates a new VistaVertrabajadores.
     */
    public VistaVertrabajadores() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVertrabajadores and vista-vertrabajadores
     */
    public interface VistaVertrabajadoresModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

}
