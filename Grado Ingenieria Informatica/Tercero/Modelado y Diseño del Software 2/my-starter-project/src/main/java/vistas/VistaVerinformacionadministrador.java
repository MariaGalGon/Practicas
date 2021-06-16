package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextArea;

/**
 * A Designer generated component for the vista-verinformacionadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verinformacionadministrador")
@JsModule("./src/vista-verinformacionadministrador.js")
public class VistaVerinformacionadministrador extends PolymerTemplate<VistaVerinformacionadministrador.VistaVerinformacionadministradorModel> {

    @Id("cuadro_informacion_admin")
	private Element vaadinVerticalLayout;
	@Id("info")
	private TextArea info;
	/**
     * Creates a new VistaVerinformacionadministrador.
     */
    public VistaVerinformacionadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerinformacionadministrador and vista-verinformacionadministrador
     */
    public interface VistaVerinformacionadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public TextArea getInfo() {
		return info;
	}

	public void setInfo(TextArea info) {
		this.info = info;
	}


}
