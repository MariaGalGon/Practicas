package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.H3;

/**
 * A Designer generated component for the vista-vercaracteristicascibernautas template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vercaracteristicascibernautas")
@JsModule("./src/vista-vercaracteristicascibernautas.js")
public class VistaVercaracteristicascibernautas extends PolymerTemplate<VistaVercaracteristicascibernautas.VistaVercaracteristicascibernautasModel> {

    
	@Id("h3")
	private H3 h3;
	@Id("p")
	private Paragraph p;

	/**
     * Creates a new VistaVercaracteristicascibernautas.
     */
    public VistaVercaracteristicascibernautas() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVercaracteristicascibernautas and vista-vercaracteristicascibernautas
     */
    public interface VistaVercaracteristicascibernautasModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public H3 getH3() {
		return h3;
	}

	public void setH3(H3 h3) {
		this.h3 = h3;
	}

	public Paragraph getP() {
		return p;
	}

	public void setP(Paragraph p) {
		this.p = p;
	}

	
}
