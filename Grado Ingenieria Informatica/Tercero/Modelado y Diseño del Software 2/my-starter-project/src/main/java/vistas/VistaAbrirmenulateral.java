package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import vistas.VistaListaenlaces;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-abrirmenulateral template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-abrirmenulateral")
@JsModule("./src/vista-abrirmenulateral.js")
public class VistaAbrirmenulateral extends PolymerTemplate<VistaAbrirmenulateral.VistaAbrirmenulateralModel> {

    @Id("boton_salir")
	private Button boton_salir;
	@Id("listaVertical")
	private Element listaVertical;

	/**
     * Creates a new VistaAbrirmenulateral.
     */
    public VistaAbrirmenulateral() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAbrirmenulateral and vista-abrirmenulateral
     */
    public interface VistaAbrirmenulateralModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	

	public Button getBoton_salir() {
		return boton_salir;
	}

	public void setBoton_salir(Button boton_salir) {
		this.boton_salir = boton_salir;
	}

	public Element getListaVertical() {
		return listaVertical;
	}

	public void setListaVertical(Element listaVertical) {
		this.listaVertical = listaVertical;
	}
}
