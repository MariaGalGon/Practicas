package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-anuncio template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-anuncio")
@JsModule("./src/vista-anuncio.js")
public class VistaAnuncio extends PolymerTemplate<VistaAnuncio.VistaAnuncioModel> {

    @Id("nombre_par_anuncio")
	private Label nombre_par_anuncio;
	@Id("boton_editar_anuncio")
	private Button boton_editar_anuncio;
	@Id("par_anuncio")
	private HorizontalLayout par_anuncio;

	/**
     * Creates a new VistaAnuncio.
     */
    public VistaAnuncio() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaAnuncio and vista-anuncio
     */
    public interface VistaAnuncioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getNombre_par_anuncio() {
		return nombre_par_anuncio;
	}

	public void setNombre_par_anuncio(Label nombre_par_anuncio) {
		this.nombre_par_anuncio = nombre_par_anuncio;
	}

	public Button getBoton_editar_anuncio() {
		return boton_editar_anuncio;
	}

	public void setBoton_editar_anuncio(Button boton_editar_anuncio) {
		this.boton_editar_anuncio = boton_editar_anuncio;
	}

	public HorizontalLayout getPar_anuncio() {
		return par_anuncio;
	}

	public void setPar_anuncio(HorizontalLayout par_anuncio) {
		this.par_anuncio = par_anuncio;
	}
}
