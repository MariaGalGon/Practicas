package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tab;
import vistas.VistaListaproductosasociados;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-verproductosasociados template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verproductosasociados")
@JsModule("./src/vista-verproductosasociados.js")
public class VistaVerproductosasociados extends PolymerTemplate<VistaVerproductosasociados.VistaVerproductosasociadosModel> {

	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaVerproductosasociados.
     */
    public VistaVerproductosasociados() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerproductosasociados and vista-verproductosasociados
     */
    public interface VistaVerproductosasociadosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	
}
