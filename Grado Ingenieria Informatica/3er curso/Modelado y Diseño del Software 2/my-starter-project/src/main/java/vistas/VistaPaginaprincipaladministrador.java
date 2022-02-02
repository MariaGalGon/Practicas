package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-paginaprincipaladministrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-paginaprincipaladministrador")
@JsModule("./src/vista-paginaprincipaladministrador.js")
public class VistaPaginaprincipaladministrador extends PolymerTemplate<VistaPaginaprincipaladministrador.VistaPaginaprincipaladministradorModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("titulo")
	private H1 titulo;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("parte_derch")
	private Element parte_derch;
	@Id("parte_izq")
	private Element parte_izq;
	@Id("cuerpo")
	private HorizontalLayout cuerpo;
	@Id("bienvenida")
	private H2 bienvenida;
	@Id("logo_grande")
	private Image logo_grande;
	@Id("boton_logo")
	private Image boton_logo;
	@Id("foto_anuncios")
	private Image foto_anuncios;
	@Id("foto_cuentas")
	private Image foto_cuentas;
	@Id("foto_catalogo")
	private Image foto_catalogo;
	@Id("boton_catalogo")
	private Button boton_catalogo;
	@Id("foto_ofertas")
	private Image foto_ofertas;
	@Id("boton_ofertas")
	private Button boton_ofertas;
	@Id("foto_categorias")
	private Image foto_categorias;
	@Id("boton_categorias")
	private Button boton_categorias;
	@Id("foto_compras")
	private Image foto_compras;
	@Id("boton_compras")
	private Button boton_compras;
	@Id("boton_cuentas")
	private Button boton_cuentas;
	@Id("boton_anuncios")
	private Button boton_anuncios;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	/**
     * Creates a new VistaPaginaprincipaladministrador.
     */
    public VistaPaginaprincipaladministrador() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaPaginaprincipaladministrador and vista-paginaprincipaladministrador
     */
    public interface VistaPaginaprincipaladministradorModel extends TemplateModel {
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

	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Element getIcono_perfil() {
		return icono_perfil;
	}

	public void setIcono_perfil(Element icono_perfil) {
		this.icono_perfil = icono_perfil;
	}

	public Element getParte_derch() {
		return parte_derch;
	}

	public void setParte_derch(Element parte_derch) {
		this.parte_derch = parte_derch;
	}

	public Element getParte_izq() {
		return parte_izq;
	}

	public void setParte_izq(Element parte_izq) {
		this.parte_izq = parte_izq;
	}

	public HorizontalLayout getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(HorizontalLayout cuerpo) {
		this.cuerpo = cuerpo;
	}

	public H2 getBienvenida() {
		return bienvenida;
	}

	public void setBienvenida(H2 bienvenida) {
		this.bienvenida = bienvenida;
	}

	public Image getLogo_grande() {
		return logo_grande;
	}

	public void setLogo_grande(Image logo_grande) {
		this.logo_grande = logo_grande;
	}

	public Image getBoton_logo() {
		return boton_logo;
	}

	public void setBoton_logo(Image boton_logo) {
		this.boton_logo = boton_logo;
	}

	public Image getFoto_anuncios() {
		return foto_anuncios;
	}

	public void setFoto_anuncios(Image foto_anuncios) {
		this.foto_anuncios = foto_anuncios;
	}

	public Image getFoto_cuentas() {
		return foto_cuentas;
	}

	public void setFoto_cuentas(Image foto_cuentas) {
		this.foto_cuentas = foto_cuentas;
	}

	public Image getFoto_catalogo() {
		return foto_catalogo;
	}

	public void setFoto_catalogo(Image foto_catalogo) {
		this.foto_catalogo = foto_catalogo;
	}

	public Button getBoton_catalogo() {
		return boton_catalogo;
	}

	public void setBoton_catalogo(Button boton_catalogo) {
		this.boton_catalogo = boton_catalogo;
	}

	public Image getFoto_ofertas() {
		return foto_ofertas;
	}

	public void setFoto_ofertas(Image foto_ofertas) {
		this.foto_ofertas = foto_ofertas;
	}

	public Button getBoton_ofertas() {
		return boton_ofertas;
	}

	public void setBoton_ofertas(Button boton_ofertas) {
		this.boton_ofertas = boton_ofertas;
	}

	public Image getFoto_categorias() {
		return foto_categorias;
	}

	public void setFoto_categorias(Image foto_categorias) {
		this.foto_categorias = foto_categorias;
	}

	public Button getBoton_categorias() {
		return boton_categorias;
	}

	public void setBoton_categorias(Button boton_categorias) {
		this.boton_categorias = boton_categorias;
	}

	public Image getFoto_compras() {
		return foto_compras;
	}

	public void setFoto_compras(Image foto_compras) {
		this.foto_compras = foto_compras;
	}

	public Button getBoton_compras() {
		return boton_compras;
	}

	public void setBoton_compras(Button boton_compras) {
		this.boton_compras = boton_compras;
	}

	public Button getBoton_cuentas() {
		return boton_cuentas;
	}

	public void setBoton_cuentas(Button boton_cuentas) {
		this.boton_cuentas = boton_cuentas;
	}

	public Button getBoton_anuncios() {
		return boton_anuncios;
	}

	public void setBoton_anuncios(Button boton_anuncios) {
		this.boton_anuncios = boton_anuncios;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}
}
