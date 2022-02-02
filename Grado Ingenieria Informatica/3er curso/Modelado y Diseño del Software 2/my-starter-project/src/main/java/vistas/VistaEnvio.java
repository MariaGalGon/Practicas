package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-envio template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-envio")
@JsModule("./src/vista-envio.js")
public class VistaEnvio extends PolymerTemplate<VistaEnvio.VistaEnvioModel> {

    @Id("id_envio")
	private Label id_envio;
	@Id("estado")
	private Paragraph estado;
	@Id("boton_ver_mas")
	private Button boton_ver_mas;

	/**
     * Creates a new VistaEnvio.
     */
    public VistaEnvio() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEnvio and vista-envio
     */
    public interface VistaEnvioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getId_envio() {
		return id_envio;
	}

	public void setId_envio(Label id_envio) {
		this.id_envio = id_envio;
	}

	public Paragraph getEstado() {
		return estado;
	}

	public void setEstado(Paragraph estado) {
		this.estado = estado;
	}

	public Button getBoton_ver_mas() {
		return boton_ver_mas;
	}

	public void setBoton_ver_mas(Button boton_ver_mas) {
		this.boton_ver_mas = boton_ver_mas;
	}
}
