package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextArea;

/**
 * A Designer generated component for the vista-vercaracteristicasadministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vercaracteristicasadministrador")
@JsModule("./src/vista-vercaracteristicasadministrador.js")
public class VistaVercaracteristicasadministrador extends PolymerTemplate<VistaVercaracteristicasadministrador.VistaVercaracteristicasadministradorModel> {

    

	@Id("caracteristicas")
	private TextArea caracteristicas;

	/**
     * Creates a new VistaVercaracteristicasadministrador.
     */
    public VistaVercaracteristicasadministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVercaracteristicasadministrador and vista-vercaracteristicasadministrador
     */
    public interface VistaVercaracteristicasadministradorModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public TextArea getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(TextArea caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	
}
