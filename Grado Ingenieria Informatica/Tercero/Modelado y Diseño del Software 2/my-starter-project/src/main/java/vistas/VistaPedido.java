package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import vistas.VistaListaproductoscomprados;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-pedido template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-pedido")
@JsModule("./src/vista-pedido.js")
public class VistaPedido extends PolymerTemplate<VistaPedido.VistaPedidoModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("titulo_seccion")
	private H1 titulo_seccion;
	@Id("id_compra")
	private H2 id_compra;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("h3")
	private H3 h3;
	@Id("id_cliente")
	private Paragraph id_cliente;
	@Id("vaadinVerticalLayout1")
	private Element vaadinVerticalLayout1;
	@Id("h31")
	private H3 h31;
	@Id("combobox_estado")
	private ComboBox<String> combobox_estado;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("logo")
	private Image logo;
	/**
     * Creates a new VistaPedido.
     */
    public VistaPedido() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaPedido and vista-pedido
     */
    public interface VistaPedidoModel extends TemplateModel {
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

	public H1 getTitulo_seccion() {
		return titulo_seccion;
	}

	public void setTitulo_seccion(H1 titulo_seccion) {
		this.titulo_seccion = titulo_seccion;
	}

	public H2 getId_compra() {
		return id_compra;
	}

	public void setId_compra(H2 id_compra) {
		this.id_compra = id_compra;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public H3 getH3() {
		return h3;
	}

	public void setH3(H3 h3) {
		this.h3 = h3;
	}

	public Paragraph getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Paragraph id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Element getVaadinVerticalLayout1() {
		return vaadinVerticalLayout1;
	}

	public void setVaadinVerticalLayout1(Element vaadinVerticalLayout1) {
		this.vaadinVerticalLayout1 = vaadinVerticalLayout1;
	}

	public H3 getH31() {
		return h31;
	}

	public void setH31(H3 h31) {
		this.h31 = h31;
	}

	public ComboBox<String> getCombobox_estado() {
		return combobox_estado;
	}

	public void setCombobox_estado(ComboBox<String> combobox_estado) {
		this.combobox_estado = combobox_estado;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
}
