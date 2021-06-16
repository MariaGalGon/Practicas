package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.OrderedList;

/**
 * A Designer generated component for the vista-verinformacioncibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verinformacioncibernauta")
@JsModule("./src/vista-verinformacioncibernauta.js")
public class VistaVerinformacioncibernauta extends PolymerTemplate<VistaVerinformacioncibernauta.VistaVerinformacioncibernautaModel> {

    @Id("info")
	private Paragraph info;
	@Id("vertical")
	private Element vertical;

	/**
     * Creates a new VistaVerinformacioncibernauta.
     */
    public VistaVerinformacioncibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerinformacioncibernauta and vista-verinformacioncibernauta
     */
    public interface VistaVerinformacioncibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }


	public Paragraph getInfo() {
		return info;
	}

	public void setInfo(Paragraph info) {
		this.info = info;
	}

	public Element getVertical() {
		return vertical;
	}

	public void setVertical(Element vertical) {
		this.vertical = vertical;
	}

	
}
