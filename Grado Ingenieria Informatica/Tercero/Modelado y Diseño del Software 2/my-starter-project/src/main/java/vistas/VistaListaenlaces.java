package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-listaenlaces template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaenlaces")
@JsModule("./src/vista-listaenlaces.js")
public class VistaListaenlaces extends PolymerTemplate<VistaListaenlaces.VistaListaenlacesModel> {

    /**
     * Creates a new VistaListaenlaces.
     */
    public VistaListaenlaces() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaenlaces and vista-listaenlaces
     */
    public interface VistaListaenlacesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
