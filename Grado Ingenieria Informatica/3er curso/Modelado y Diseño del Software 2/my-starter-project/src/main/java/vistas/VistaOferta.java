package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-oferta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-oferta")
@JsModule("./src/vista-oferta.js")
public class VistaOferta extends PolymerTemplate<VistaOferta.VistaOfertaModel> {

    @Id("nombre_oferta")
	private Label nombre_oferta;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("detalles_oferta")
	private Paragraph detalles_oferta;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("boton_editar")
	private Button boton_editar;

	/**
     * Creates a new VistaOferta.
     */
    public VistaOferta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaOferta and vista-oferta
     */
    public interface VistaOfertaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Label getNombre_oferta() {
		return nombre_oferta;
	}

	public void setNombre_oferta(Label nombre_oferta) {
		this.nombre_oferta = nombre_oferta;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Paragraph getDetalles_oferta() {
		return detalles_oferta;
	}

	public void setDetalles_oferta(Paragraph detalles_oferta) {
		this.detalles_oferta = detalles_oferta;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public Button getBoton_editar() {
		return boton_editar;
	}

	public void setBoton_editar(Button boton_editar) {
		this.boton_editar = boton_editar;
	}
}
