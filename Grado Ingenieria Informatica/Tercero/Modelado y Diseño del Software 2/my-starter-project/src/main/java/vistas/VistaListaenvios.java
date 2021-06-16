package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;
import vistas.VistaEnvio;

/**
 * A Designer generated component for the vista-listaenvios template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaenvios")
@JsModule("./src/vista-listaenvios.js")
public class VistaListaenvios extends PolymerTemplate<VistaListaenvios.VistaListaenviosModel> {

    @Id("elegir_estado")
	private ComboBox<String> elegir_estado;
	@Id("lista_envios")
	private Element lista_envios;
	

	/**
     * Creates a new VistaListaenvios.
     */
    public VistaListaenvios() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaenvios and vista-listaenvios
     */
    public interface VistaListaenviosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public ComboBox<String> getElegir_estado() {
		return elegir_estado;
	}

	public void setElegir_estado(ComboBox<String> elegir_estado) {
		this.elegir_estado = elegir_estado;
	}

	public Element getLista_envios() {
		return lista_envios;
	}

	public void setLista_envios(Element lista_envios) {
		this.lista_envios = lista_envios;
	}
}
