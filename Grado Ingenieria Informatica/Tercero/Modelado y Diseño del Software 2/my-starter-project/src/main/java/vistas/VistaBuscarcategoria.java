package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-buscarcategoria template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-buscarcategoria")
@JsModule("./src/vista-buscarcategoria.js")
public class VistaBuscarcategoria extends PolymerTemplate<VistaBuscarcategoria.VistaBuscarcategoriaModel> {

    @Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("barra_buscar_categoria")
	private TextField barra_buscar_categoria;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("logo")
	private Image logo;

	/**
     * Creates a new VistaBuscarcategoria.
     */
    public VistaBuscarcategoria() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaBuscarcategoria and vista-buscarcategoria
     */
    public interface VistaBuscarcategoriaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public TextField getBarra_buscar_categoria() {
		return barra_buscar_categoria;
	}

	public void setBarra_buscar_categoria(TextField barra_buscar_categoria) {
		this.barra_buscar_categoria = barra_buscar_categoria;
	}

	public Button getVaadinButton() {
		return vaadinButton;
	}

	public void setVaadinButton(Button vaadinButton) {
		this.vaadinButton = vaadinButton;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
}
