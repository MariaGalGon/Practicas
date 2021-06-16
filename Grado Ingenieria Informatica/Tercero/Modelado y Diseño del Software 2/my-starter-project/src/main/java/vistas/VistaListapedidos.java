package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-listapedidos template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listapedidos")
@JsModule("./src/vista-listapedidos.js")
public class VistaListapedidos extends PolymerTemplate<VistaListapedidos.VistaListapedidosModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("boton_menu")
	private Button boton_menu;

	@Id("seccion")
	private H1 seccion;
	@Id("elegir_estado")
	private ComboBox<String> elegir_estado;
	@Id("lista_pedidos")
	private Element lista_pedidos;
	@Id("logo")
	private Image logo;
	/**
     * Creates a new VistaListapedidos.
     */
    public VistaListapedidos() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListapedidos and vista-listapedidos
     */
    public interface VistaListapedidosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera() {
		return cabecera;
	}

	public void setCabecera(HorizontalLayout cabecera) {
		this.cabecera = cabecera;
	}

	public Button getBoton_menu() {
		return boton_menu;
	}

	public void setBoton_menu(Button boton_menu) {
		this.boton_menu = boton_menu;
	}



	public H1 getSeccion() {
		return seccion;
	}

	public void setSeccion(H1 seccion) {
		this.seccion = seccion;
	}

	public ComboBox<String> getElegir_estado() {
		return elegir_estado;
	}

	public void setElegir_estado(ComboBox<String> elegir_estado) {
		this.elegir_estado = elegir_estado;
	}

	public Element getLista_pedidos() {
		return lista_pedidos;
	}

	public void setLista_pedidos(Element lista_pedidos) {
		this.lista_pedidos = lista_pedidos;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
}
