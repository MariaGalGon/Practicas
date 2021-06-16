package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-confirmar template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-confirmar")
@JsModule("./src/vista-confirmar.js")
public class VistaConfirmar extends PolymerTemplate<VistaConfirmar.VistaConfirmarModel> {

	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("texto")
	private Paragraph texto;
	@Id("boton_productos")
	private Button boton_productos;
	@Id("foto")
	private Image foto;

	/**
     * Creates a new VistaConfirmar.
     */
    public VistaConfirmar() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaConfirmar and vista-confirmar
     */
    public interface VistaConfirmarModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Paragraph getTexto() {
		return texto;
	}

	public void setTexto(Paragraph texto) {
		this.texto = texto;
	}

	public Button getBoton_productos() {
		return boton_productos;
	}

	public void setBoton_productos(Button boton_productos) {
		this.boton_productos = boton_productos;
	}

	public Image getFoto() {
		return foto;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

}
