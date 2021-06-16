package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import vistas.VistaVerdatos;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaVerdatosimagen;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-verdatoscibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verdatoscibernauta")
@JsModule("./src/vista-verdatoscibernauta.js")
public class VistaVerdatoscibernauta extends PolymerTemplate<VistaVerdatoscibernauta.VistaVerdatoscibernautaModel> {

    @Id("dar_de_baja")
	private Button dar_de_baja;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("imagen")
	private Element imagen;
	@Id("datos")
	private Element datos;
	/**
     * Creates a new VistaVerdatoscibernauta.
     */
    public VistaVerdatoscibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerdatoscibernauta and vista-verdatoscibernauta
     */
    public interface VistaVerdatoscibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Button getDar_de_baja() {
		return dar_de_baja;
	}

	public void setDar_de_baja(Button dar_de_baja) {
		this.dar_de_baja = dar_de_baja;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Element getImagen() {
		return imagen;
	}

	public void setImagen(Element imagen) {
		this.imagen = imagen;
	}

	public Element getDatos() {
		return datos;
	}

	public void setDatos(Element datos) {
		this.datos = datos;
	}


}
