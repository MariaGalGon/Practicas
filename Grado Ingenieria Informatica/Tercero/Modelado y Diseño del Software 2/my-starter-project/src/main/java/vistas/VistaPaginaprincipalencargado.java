package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-paginaprincipalencargado template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-paginaprincipalencargado")
@JsModule("./src/vista-paginaprincipalencargado.js")
public class VistaPaginaprincipalencargado extends PolymerTemplate<VistaPaginaprincipalencargado.VistaPaginaprincipalencargadoModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("titulo")
	private H1 titulo;
	@Id("cuerpo")
	private HorizontalLayout cuerpo;
	@Id("botones")
	private Element botones;
	@Id("icono_boton")
	private HorizontalLayout icono_boton;
	@Id("icono_boton1")
	private HorizontalLayout icono_boton1;
	@Id("logo")
	private Element logo;
	@Id("bienvenida")
	private H2 bienvenida;
	@Id("logo1")
	private Image logo1;
	@Id("boton_logo")
	private Image boton_logo;
	@Id("ver_pedidos")
	private Image ver_pedidos;
	@Id("perfil")
	private Image perfil;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("boton_ver_pedidos")
	private Button boton_ver_pedidos;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;

	/**
     * Creates a new VistaPaginaprincipalencargado.
     */
    public VistaPaginaprincipalencargado() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaPaginaprincipalencargado and vista-paginaprincipalencargado
     */
    public interface VistaPaginaprincipalencargadoModel extends TemplateModel {
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

	public H1 getTitulo() {
		return titulo;
	}

	public void setTitulo(H1 titulo) {
		this.titulo = titulo;
	}

	public HorizontalLayout getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(HorizontalLayout cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Element getBotones() {
		return botones;
	}

	public void setBotones(Element botones) {
		this.botones = botones;
	}

	public HorizontalLayout getIcono_boton() {
		return icono_boton;
	}

	public void setIcono_boton(HorizontalLayout icono_boton) {
		this.icono_boton = icono_boton;
	}

	public HorizontalLayout getIcono_boton1() {
		return icono_boton1;
	}

	public void setIcono_boton1(HorizontalLayout icono_boton1) {
		this.icono_boton1 = icono_boton1;
	}

	public Element getLogo() {
		return logo;
	}

	public void setLogo(Element logo) {
		this.logo = logo;
	}

	public Image getBoton_logo() {
		return boton_logo;
	}

	public H2 getBienvenida() {
		return bienvenida;
	}

	public void setBienvenida(H2 bienvenida) {
		this.bienvenida = bienvenida;
	}

	public Image getLogo1() {
		return logo1;
	}

	public void setLogo1(Image logo1) {
		this.logo1 = logo1;
	}

	public void setBoton_logo(Image boton_logo) {
		this.boton_logo = boton_logo;
	}

	public Image getVer_pedidos() {
		return ver_pedidos;
	}

	public void setVer_pedidos(Image ver_pedidos) {
		this.ver_pedidos = ver_pedidos;
	}

	public Image getPerfil() {
		return perfil;
	}

	public void setPerfil(Image perfil) {
		this.perfil = perfil;
	}

	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public Button getBoton_ver_pedidos() {
		return boton_ver_pedidos;
	}

	public void setBoton_ver_pedidos(Button boton_ver_pedidos) {
		this.boton_ver_pedidos = boton_ver_pedidos;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
	
	
	
}
