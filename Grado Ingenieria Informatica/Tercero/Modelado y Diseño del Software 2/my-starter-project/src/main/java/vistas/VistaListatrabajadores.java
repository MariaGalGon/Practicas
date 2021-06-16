package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaTrabajador;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-listatrabajadores template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listatrabajadores")
@JsModule("./src/vista-listatrabajadores.js")
public class VistaListatrabajadores extends PolymerTemplate<VistaListatrabajadores.VistaListatrabajadoresModel> {

    @Id("lista_trabajadores")
	private Element lista_trabajadores;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("vaadinButton")
	private Button vaadinButton;

	/**
     * Creates a new VistaListatrabajadores.
     */
    public VistaListatrabajadores() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListatrabajadores and vista-listatrabajadores
     */
    public interface VistaListatrabajadoresModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getLista_trabajadores() {
		return lista_trabajadores;
	}

	public void setLista_trabajadores(Element lista_trabajadores) {
		this.lista_trabajadores = lista_trabajadores;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Button getVaadinButton() {
		return vaadinButton;
	}

	public void setVaadinButton(Button vaadinButton) {
		this.vaadinButton = vaadinButton;
	}
}
