package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-imagen template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-imagen")
@JsModule("./src/vista-imagen.js")
public class VistaImagen extends PolymerTemplate<VistaImagen.VistaImagenModel> {

	@Id("foto")
	private Image foto;

	/**
     * Creates a new VistaImagen.
     */
    public VistaImagen() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaImagen and vista-imagen
     */
    public interface VistaImagenModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Image getFoto() {
		return foto;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}
}
