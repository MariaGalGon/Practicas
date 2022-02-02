package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-pedidocibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-pedidocibernauta")
@JsModule("./src/vista-pedidocibernauta.js")
public class VistaPedidocibernauta extends PolymerTemplate<VistaPedidocibernauta.VistaPedidocibernautaModel> {

    @Id("pedido_cibernauta")
	private Element pedido_cibernauta;
	@Id("hor1")
	private HorizontalLayout hor1;
	@Id("titulo_pedido")
	private H4 titulo_pedido;
	@Id("estado_label")
	private Label estado_label;
	@Id("estado")
	private Paragraph estado;
	@Id("hor2")
	private HorizontalLayout hor2;
	@Id("num_productos_label")
	private Label num_productos_label;
	@Id("num_productod")
	private Paragraph num_productod;
	@Id("hor3")
	private HorizontalLayout hor3;
	@Id("precio_label")
	private Label precio_label;
	@Id("precio")
	private Paragraph precio;
	@Id("boton_mas_detalles")
	private Button boton_mas_detalles;

	/**
     * Creates a new VistaPedidocibernauta.
     */
    public VistaPedidocibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaPedidocibernauta and vista-pedidocibernauta
     */
    public interface VistaPedidocibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getPedido_cibernauta() {
		return pedido_cibernauta;
	}

	public void setPedido_cibernauta(Element pedido_cibernauta) {
		this.pedido_cibernauta = pedido_cibernauta;
	}

	public HorizontalLayout getHor1() {
		return hor1;
	}

	public void setHor1(HorizontalLayout hor1) {
		this.hor1 = hor1;
	}

	public H4 getTitulo_pedido() {
		return titulo_pedido;
	}

	public void setTitulo_pedido(H4 titulo_pedido) {
		this.titulo_pedido = titulo_pedido;
	}

	public Label getEstado_label() {
		return estado_label;
	}

	public void setEstado_label(Label estado_label) {
		this.estado_label = estado_label;
	}

	public Paragraph getEstado() {
		return estado;
	}

	public void setEstado(Paragraph estado) {
		this.estado = estado;
	}

	public HorizontalLayout getHor2() {
		return hor2;
	}

	public void setHor2(HorizontalLayout hor2) {
		this.hor2 = hor2;
	}

	public Label getNum_productos_label() {
		return num_productos_label;
	}

	public void setNum_productos_label(Label num_productos_label) {
		this.num_productos_label = num_productos_label;
	}

	public Paragraph getNum_productod() {
		return num_productod;
	}

	public void setNum_productod(Paragraph num_productod) {
		this.num_productod = num_productod;
	}

	public HorizontalLayout getHor3() {
		return hor3;
	}

	public void setHor3(HorizontalLayout hor3) {
		this.hor3 = hor3;
	}

	public Label getPrecio_label() {
		return precio_label;
	}

	public void setPrecio_label(Label precio_label) {
		this.precio_label = precio_label;
	}

	public Paragraph getPrecio() {
		return precio;
	}

	public void setPrecio(Paragraph precio) {
		this.precio = precio;
	}

	public Button getBoton_mas_detalles() {
		return boton_mas_detalles;
	}

	public void setBoton_mas_detalles(Button boton_mas_detalles) {
		this.boton_mas_detalles = boton_mas_detalles;
	}
}
