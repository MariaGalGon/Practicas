package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-dardebaja template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-dardebaja")
@JsModule("./src/vista-dardebaja.js")
public class VistaDardebaja extends PolymerTemplate<VistaDardebaja.VistaDardebajaModel> {

    @Id("texto")
	private Paragraph texto;
	@Id("boton_confirmar")
	private Button boton_confirmar;
	@Id("boton_cancelar")
	private Button boton_cancelar;

	/**
     * Creates a new VistaDardebaja.
     */
    public VistaDardebaja() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaDardebaja and vista-dardebaja
     */
    public interface VistaDardebajaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Paragraph getTexto() {
		return texto;
	}

	public void setTexto(Paragraph texto) {
		this.texto = texto;
	}

	public Button getBoton_confirmar() {
		return boton_confirmar;
	}

	public void setBoton_confirmar(Button boton_confirmar) {
		this.boton_confirmar = boton_confirmar;
	}

	public Button getBoton_cancelar() {
		return boton_cancelar;
	}

	public void setBoton_cancelar(Button boton_cancelar) {
		this.boton_cancelar = boton_cancelar;
	}
}
