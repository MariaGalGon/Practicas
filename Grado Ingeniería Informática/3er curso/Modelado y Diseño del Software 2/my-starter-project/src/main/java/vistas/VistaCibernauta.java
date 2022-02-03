package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-cibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cibernauta")
@JsModule("./src/vista-cibernauta.js")
public class VistaCibernauta extends PolymerTemplate<VistaCibernauta.VistaCibernautaModel> {

    @Id("id_cibernauta")
	private Label id_cibernauta;
	@Id("estado_cibernauta")
	private Paragraph estado_cibernauta;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	/**
     * Creates a new VistaCibernauta.
     */
    public VistaCibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaCibernauta and vista-cibernauta
     */
    public interface VistaCibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getId_cibernauta() {
		return id_cibernauta;
	}

	public void setId_cibernauta(Label id_cibernauta) {
		this.id_cibernauta = id_cibernauta;
	}

	public Paragraph getEstado_cibernauta() {
		return estado_cibernauta;
	}

	public void setEstado_cibernauta(Paragraph estado_cibernauta) {
		this.estado_cibernauta = estado_cibernauta;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}
}
