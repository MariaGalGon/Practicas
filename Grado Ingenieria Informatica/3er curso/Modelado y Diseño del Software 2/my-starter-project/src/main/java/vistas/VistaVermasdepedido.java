package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import vistas.VistaListproductoscomprados;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;

/**
 * A Designer generated component for the vista-vermasdepedido template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vermasdepedido")
@JsModule("./src/vista-vermasdepedido.js")
public class VistaVermasdepedido extends PolymerTemplate<VistaVermasdepedido.VistaVermasdepedidoModel> {

    @Id("ver_mas_de_pedido")
	private Element ver_mas_de_pedido;
	@Id("nombre_pedido")
	private H2 nombre_pedido;
	@Id("resumen_estado")
	private Element resumen_estado;
	@Id("cuadro_resumen")
	private Element cuadro_resumen;
	@Id("titulo_resumen")
	private H3 titulo_resumen;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("h3")
	private H3 h3;
	@Id("boton_cancelar")
	private Button boton_cancelar;
	@Id("subtotal")
	private Paragraph subtotal;
	@Id("envio")
	private Paragraph p;
	@Id("envio")
	private Paragraph envio;
	@Id("total")
	private Paragraph total;
	@Id("estado")
	private Label estado;
	@Id("hueco_lista")
	private Element hueco_lista;
	/**
     * Creates a new VistaVermasdepedido.
     */
    public VistaVermasdepedido() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVermasdepedido and vista-vermasdepedido
     */
    public interface VistaVermasdepedidoModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getVer_mas_de_pedido() {
		return ver_mas_de_pedido;
	}

	public void setVer_mas_de_pedido(Element ver_mas_de_pedido) {
		this.ver_mas_de_pedido = ver_mas_de_pedido;
	}

	public H2 getNombre_pedido() {
		return nombre_pedido;
	}

	public void setNombre_pedido(H2 nombre_pedido) {
		this.nombre_pedido = nombre_pedido;
	}

	public Element getResumen_estado() {
		return resumen_estado;
	}

	public void setResumen_estado(Element resumen_estado) {
		this.resumen_estado = resumen_estado;
	}

	public Element getCuadro_resumen() {
		return cuadro_resumen;
	}

	public void setCuadro_resumen(Element cuadro_resumen) {
		this.cuadro_resumen = cuadro_resumen;
	}

	public H3 getTitulo_resumen() {
		return titulo_resumen;
	}

	public void setTitulo_resumen(H3 titulo_resumen) {
		this.titulo_resumen = titulo_resumen;
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

	public Button getBoton_cancelar() {
		return boton_cancelar;
	}

	public void setBoton_cancelar(Button boton_cancelar) {
		this.boton_cancelar = boton_cancelar;
	}

	public Paragraph getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Paragraph subtotal) {
		this.subtotal = subtotal;
	}

	public Paragraph getEnvio() {
		return envio;
	}

	public void setEnvio(Paragraph envio) {
		this.envio = envio;
	}

	public Paragraph getTotal() {
		return total;
	}

	public void setTotal(Paragraph total) {
		this.total = total;
	}

	public Label getEstado() {
		return estado;
	}

	public void setEstado(Label estado) {
		this.estado = estado;
	}

	public Paragraph getP() {
		return p;
	}

	public void setP(Paragraph p) {
		this.p = p;
	}

	public Element getHueco_lista() {
		return hueco_lista;
	}

	public void setHueco_lista(Element hueco_lista) {
		this.hueco_lista = hueco_lista;
	}


}
