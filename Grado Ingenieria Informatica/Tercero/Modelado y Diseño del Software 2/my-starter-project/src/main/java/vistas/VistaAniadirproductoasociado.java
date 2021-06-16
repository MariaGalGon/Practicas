package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-aniadirproductoasociado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-aniadirproductoasociado")
@JsModule("./src/vista-aniadirproductoasociado.js")
public class VistaAniadirproductoasociado extends PolymerTemplate<VistaAniadirproductoasociado.VistaAniadirproductoasociadoModel> {

    @Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaAniadirproductoasociado.
     */
    public VistaAniadirproductoasociado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAniadirproductoasociado and vista-aniadirproductoasociado
     */
    public interface VistaAniadirproductoasociadoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	
}
