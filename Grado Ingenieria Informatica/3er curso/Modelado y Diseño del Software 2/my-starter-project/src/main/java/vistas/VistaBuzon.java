package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaListamensajes;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-buzon template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-buzon")
@JsModule("./src/vista-buzon.js")
public class VistaBuzon extends PolymerTemplate<VistaBuzon.VistaBuzonModel> {

    @Id("nombre_buzon")
	private H3 nombre_buzon;
	@Id("lista")
	private Element lista;
	/**
     * Creates a new VistaBuzon.
     */
    public VistaBuzon() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaBuzon and vista-buzon
     */
    public interface VistaBuzonModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public H3 getNombre_buzon() {
		return nombre_buzon;
	}

	public void setNombre_buzon(H3 nombre_buzon) {
		this.nombre_buzon = nombre_buzon;
	}

	public Element getLista() {
		return lista;
	}

	public void setLista(Element lista) {
		this.lista = lista;
	}

}
