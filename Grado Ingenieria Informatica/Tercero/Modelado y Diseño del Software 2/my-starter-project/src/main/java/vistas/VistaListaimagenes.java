package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaImagen;

/**
 * A Designer generated component for the vista-listaimagenes template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaimagenes")
@JsModule("./src/vista-listaimagenes.js")
public class VistaListaimagenes extends PolymerTemplate<VistaListaimagenes.VistaListaimagenesModel> {

    @Id("cuadro_imagenes")
	private HorizontalLayout cuadro_imagenes;

	/**
     * Creates a new VistaListaimagenes.
     */
    public VistaListaimagenes() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaimagenes and vista-listaimagenes
     */
    public interface VistaListaimagenesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCuadro_imagenes() {
		return cuadro_imagenes;
	}

	public void setCuadro_imagenes(HorizontalLayout cuadro_imagenes) {
		this.cuadro_imagenes = cuadro_imagenes;
	}

}
