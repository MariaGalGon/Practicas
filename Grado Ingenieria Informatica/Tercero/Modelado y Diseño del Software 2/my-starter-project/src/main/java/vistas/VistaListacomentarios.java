package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-listacomentarios template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listacomentarios")
@JsModule("./src/vista-listacomentarios.js")
public class VistaListacomentarios extends PolymerTemplate<VistaListacomentarios.VistaListacomentariosModel> {

    @Id("lista_comentarios")
	private Element lista_comentarios;

	/**
     * Creates a new VistaListacomentarios.
     */
    public VistaListacomentarios() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListacomentarios and vista-listacomentarios
     */
    public interface VistaListacomentariosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getLista_comentarios() {
		return lista_comentarios;
	}

	public void setLista_comentarios(Element lista_comentarios) {
		this.lista_comentarios = lista_comentarios;
	}
}
