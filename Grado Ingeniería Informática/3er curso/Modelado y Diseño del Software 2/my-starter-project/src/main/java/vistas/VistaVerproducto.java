package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tab;
import vistas.VistaListaimagenes;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.upload.Upload;

/**
 * A Designer generated component for the vista-verproducto template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-verproducto")
@JsModule("./src/vista-verproducto.js")
public class VistaVerproducto extends PolymerTemplate<VistaVerproducto.VistaVerproductoModel> {

    @Id("cabecera")
	private HorizontalLayout cabecera;
	@Id("boton_menu")
	private Button boton_menu;
	@Id("barra_busqueda")
	private TextField barra_busqueda;
	@Id("boton_buscar")
	private Button boton_buscar;
	@Id("boton_carrito")
	private Button boton_carrito;
	@Id("contador_carrito")
	private Label contador_carrito;
	@Id("boton_perfil")
	private Button boton_perfil;
	@Id("icono_menu")
	private Element icono_menu;
	@Id("icono_carrito")
	private Element icono_carrito;
	@Id("icono_perfil")
	private Element icono_perfil;
	@Id("cuerpo")
	private HorizontalLayout cuerpo;
	@Id("parte_izquierda")
	private Element parte_izquierda;
	@Id("nombre_producto_cibernauta")
	private Label nombre_producto_cibernauta;
	@Id("nombre_producto_admin")
	private TextField nombre_producto_admin;
	@Id("cuadro_imagen")
	private HorizontalLayout cuadro_imagen;
	@Id("desp_izq")
	private Button desp_izq;
	@Id("foto_producto")
	private Image foto_producto;
	@Id("desp_derch")
	private Button desp_derch;
	@Id("icono_desp_derech")
	private Element icono_desp_derech;
	@Id("valoracion_media")
	private HorizontalLayout valoracion_media;
	@Id("estrella_1")
	private Image estrella_1;
	@Id("estrella_2")
	private Image estrella_2;
	@Id("estrella_3")
	private Image estrella_3;
	@Id("estrella_4")
	private Image estrella_4;
	@Id("estrella_5")
	private Image estrella_5;
	@Id("contador_valoracion")
	private Label contador_valoracion;
	@Id("fondo_precio")
	private Image fondo_precio;
	@Id("cuadro_precio")
	private Element cuadro_precio;
	@Id("precio")
	private Label precio;
	@Id("boton_aniadir_carrito")
	private Button boton_aniadir_carrito;
	@Id("parte_derecha")
	private Element parte_derecha;
	@Id("cuadro_seleccion_imagen")
	private Element cuadro_seleccion_imagen;
	@Id("precio_admin")
	private TextField precio_admin;
	@Id("boton_guardar")
	private Button boton_guardar;
	@Id("boton_eliminar")
	private Button boton_eliminar;
	@Id("logo")
	private Image logo;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("layout_tabs")
	private Element layout_tabs;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("contenido_tabs")
	private Element contenido_tabs;
	@Id("hueco_upload")
	private HorizontalLayout hueco_upload;
	@Id("hueco_lista_imagagenes")
	private HorizontalLayout hueco_lista_imagagenes;
	/**
     * Creates a new VistaVerproducto.
     */
    public VistaVerproducto() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVerproducto and vista-verproducto
     */
    public interface VistaVerproductoModel extends TemplateModel {
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

	public TextField getBarra_busqueda() {
		return barra_busqueda;
	}

	public void setBarra_busqueda(TextField barra_busqueda) {
		this.barra_busqueda = barra_busqueda;
	}

	public Button getBoton_buscar() {
		return boton_buscar;
	}

	public void setBoton_buscar(Button boton_buscar) {
		this.boton_buscar = boton_buscar;
	}

	public Button getBoton_carrito() {
		return boton_carrito;
	}

	public void setBoton_carrito(Button boton_carrito) {
		this.boton_carrito = boton_carrito;
	}

	public Label getContador_carrito() {
		return contador_carrito;
	}

	public void setContador_carrito(Label contador_carrito) {
		this.contador_carrito = contador_carrito;
	}

	public Button getBoton_perfil() {
		return boton_perfil;
	}

	public void setBoton_perfil(Button boton_perfil) {
		this.boton_perfil = boton_perfil;
	}

	public Element getIcono_menu() {
		return icono_menu;
	}

	public void setIcono_menu(Element icono_menu) {
		this.icono_menu = icono_menu;
	}

	public Element getIcono_carrito() {
		return icono_carrito;
	}

	public void setIcono_carrito(Element icono_carrito) {
		this.icono_carrito = icono_carrito;
	}

	public Element getIcono_perfil() {
		return icono_perfil;
	}

	public void setIcono_perfil(Element icono_perfil) {
		this.icono_perfil = icono_perfil;
	}

	public HorizontalLayout getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(HorizontalLayout cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Element getParte_izquierda() {
		return parte_izquierda;
	}

	public void setParte_izquierda(Element parte_izquierda) {
		this.parte_izquierda = parte_izquierda;
	}

	public Label getNombre_producto_cibernauta() {
		return nombre_producto_cibernauta;
	}

	public void setNombre_producto_cibernauta(Label nombre_producto_cibernauta) {
		this.nombre_producto_cibernauta = nombre_producto_cibernauta;
	}

	public TextField getNombre_producto_admin() {
		return nombre_producto_admin;
	}

	public void setNombre_producto_admin(TextField nombre_producto_admin) {
		this.nombre_producto_admin = nombre_producto_admin;
	}

	public HorizontalLayout getCuadro_imagen() {
		return cuadro_imagen;
	}

	public void setCuadro_imagen(HorizontalLayout cuadro_imagen) {
		this.cuadro_imagen = cuadro_imagen;
	}

	public Button getDesp_izq() {
		return desp_izq;
	}

	public void setDesp_izq(Button desp_izq) {
		this.desp_izq = desp_izq;
	}

	public Image getFoto_producto() {
		return foto_producto;
	}

	public void setFoto_producto(Image foto_producto) {
		this.foto_producto = foto_producto;
	}

	public Button getDesp_derch() {
		return desp_derch;
	}

	public void setDesp_derch(Button desp_derch) {
		this.desp_derch = desp_derch;
	}

	public Element getIcono_desp_derech() {
		return icono_desp_derech;
	}

	public void setIcono_desp_derech(Element icono_desp_derech) {
		this.icono_desp_derech = icono_desp_derech;
	}

	public HorizontalLayout getValoracion_media() {
		return valoracion_media;
	}

	public void setValoracion_media(HorizontalLayout valoracion_media) {
		this.valoracion_media = valoracion_media;
	}

	public Image getEstrella_1() {
		return estrella_1;
	}

	public void setEstrella_1(Image estrella_1) {
		this.estrella_1 = estrella_1;
	}

	public Image getEstrella_2() {
		return estrella_2;
	}

	public void setEstrella_2(Image estrella_2) {
		this.estrella_2 = estrella_2;
	}

	public Image getEstrella_3() {
		return estrella_3;
	}

	public void setEstrella_3(Image estrella_3) {
		this.estrella_3 = estrella_3;
	}

	public Image getEstrella_4() {
		return estrella_4;
	}

	public void setEstrella_4(Image estrella_4) {
		this.estrella_4 = estrella_4;
	}

	public Image getEstrella_5() {
		return estrella_5;
	}

	public void setEstrella_5(Image estrella_5) {
		this.estrella_5 = estrella_5;
	}

	public Label getContador_valoracion() {
		return contador_valoracion;
	}

	public void setContador_valoracion(Label contador_valoracion) {
		this.contador_valoracion = contador_valoracion;
	}

	public Image getFondo_precio() {
		return fondo_precio;
	}

	public void setFondo_precio(Image fondo_precio) {
		this.fondo_precio = fondo_precio;
	}

	public Element getCuadro_precio() {
		return cuadro_precio;
	}

	public void setCuadro_precio(Element cuadro_precio) {
		this.cuadro_precio = cuadro_precio;
	}

	public Label getPrecio() {
		return precio;
	}

	public void setPrecio(Label precio) {
		this.precio = precio;
	}

	public Button getBoton_aniadir_carrito() {
		return boton_aniadir_carrito;
	}

	public void setBoton_aniadir_carrito(Button boton_aniadir_carrito) {
		this.boton_aniadir_carrito = boton_aniadir_carrito;
	}

	public Element getParte_derecha() {
		return parte_derecha;
	}

	public void setParte_derecha(Element parte_derecha) {
		this.parte_derecha = parte_derecha;
	}

	

	public Element getCuadro_seleccion_imagen() {
		return cuadro_seleccion_imagen;
	}

	public void setCuadro_seleccion_imagen(Element cuadro_seleccion_imagen) {
		this.cuadro_seleccion_imagen = cuadro_seleccion_imagen;
	}


	public TextField getPrecio_admin() {
		return precio_admin;
	}

	public void setPrecio_admin(TextField precio_admin) {
		this.precio_admin = precio_admin;
	}

	public Button getBoton_guardar() {
		return boton_guardar;
	}

	public void setBoton_guardar(Button boton_guardar) {
		this.boton_guardar = boton_guardar;
	}

	public Button getBoton_eliminar() {
		return boton_eliminar;
	}

	public void setBoton_eliminar(Button boton_eliminar) {
		this.boton_eliminar = boton_eliminar;
	}

	

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public Element getLayout_tabs() {
		return layout_tabs;
	}

	public void setLayout_tabs(Element layout_tabs) {
		this.layout_tabs = layout_tabs;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Element getContenido_tabs() {
		return contenido_tabs;
	}

	public void setContenido_tabs(Element contenido_tabs) {
		this.contenido_tabs = contenido_tabs;
	}

	public HorizontalLayout getHueco_upload() {
		return hueco_upload;
	}

	public void setHueco_upload(HorizontalLayout hueco_upload) {
		this.hueco_upload = hueco_upload;
	}

	public HorizontalLayout getHueco_lista_imagagenes() {
		return hueco_lista_imagagenes;
	}

	public void setHueco_lista_imagagenes(HorizontalLayout hueco_lista_imagagenes) {
		this.hueco_lista_imagagenes = hueco_lista_imagagenes;
	}



	
}
