package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import vistas.VistaMensaje;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the vista-listamensajes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listamensajes")
@JsModule("./src/vista-listamensajes.js")
public class VistaListamensajes extends PolymerTemplate<VistaListamensajes.VistaListamensajesModel> {



	/**
     * Creates a new VistaListamensajes.
     */
    public VistaListamensajes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListamensajes and vista-listamensajes
     */
    public interface VistaListamensajesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	
}
