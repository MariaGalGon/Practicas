package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-vermasenvio template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vermasenvio")
@JsModule("./src/vista-vermasenvio.js")
public class VistaVermasenvio extends PolymerTemplate<VistaVermasenvio.VistaVermasenvioModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("titulo")
	private H2 h2;
	@Id("id_nombre")
	private Paragraph id_nombre;
	@Id("cliente")
	private Paragraph cliente;
	@Id("direccion")
	private Paragraph direccion;
	@Id("boton_entregado")
	private Button boton_entregado;
	@Id("logo")
	private Image logo;
	@Id("tab_envios")
	private Button tab_envios;
	@Id("tab_perfil")
	private Button tab_perfil;

	/**
     * Creates a new VistaVermasenvio.
     */
    public VistaVermasenvio() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVermasenvio and vista-vermasenvio
     */
    public interface VistaVermasenvioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera() {
		return cabecera;
	}

	public void setCabecera(HorizontalLayout cabecera) {
		this.cabecera = cabecera;
	}

	public H2 getH2() {
		return h2;
	}

	public void setH2(H2 h2) {
		this.h2 = h2;
	}

	public Paragraph getId_nombre() {
		return id_nombre;
	}

	public void setId_nombre(Paragraph id_nombre) {
		this.id_nombre = id_nombre;
	}

	public Paragraph getCliente() {
		return cliente;
	}

	public void setCliente(Paragraph cliente) {
		this.cliente = cliente;
	}

	public Paragraph getDireccion() {
		return direccion;
	}

	public void setDireccion(Paragraph direccion) {
		this.direccion = direccion;
	}

	public Button getBoton_entregado() {
		return boton_entregado;
	}

	public void setBoton_entregado(Button boton_entregado) {
		this.boton_entregado = boton_entregado;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Button getTab_envios() {
		return tab_envios;
	}

	public void setTab_envios(Button tab_envios) {
		this.tab_envios = tab_envios;
	}

	public Button getTab_perfil() {
		return tab_perfil;
	}

	public void setTab_perfil(Button tab_perfil) {
		this.tab_perfil = tab_perfil;
	}
}
