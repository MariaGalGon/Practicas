package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaCibernauta;

/**
 * A Designer generated component for the vista-listacibernautas template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listacibernautas")
@JsModule("./src/vista-listacibernautas.js")
public class VistaListacibernautas extends PolymerTemplate<VistaListacibernautas.VistaListacibernautasModel> {

    @Id("lista_cibernautas")
	private Element lista_cibernautas;
    
	/**
     * Creates a new VistaListacibernautas.
     */
    public VistaListacibernautas() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListacibernautas and vista-listacibernautas
     */
    public interface VistaListacibernautasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getLista_cibernautas() {
		return lista_cibernautas;
	}

	public void setLista_cibernautas(Element lista_cibernautas) {
		this.lista_cibernautas = lista_cibernautas;
	}

	
}
