package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.upload.Upload;

/**
 * A Designer generated component for the vista-editaranuncio template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-editaranuncio")
@JsModule("./src/vista-editaranuncio.js")
public class VistaEditaranuncio extends PolymerTemplate<VistaEditaranuncio.VistaEditaranuncioModel> {

    @Id("nombre")
	private TextField nombre;
	@Id("enlace_anuncio")
	private TextField enlace_anuncio;
	@Id("altura_anuncio")
	private TextField altura_anuncio;
	@Id("anchura_anuncio")
	private TextField anchura_anuncio;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("boton_guardar_anuncio")
	private Button boton_guardar_anuncio;
	@Id("boton_eliminar_anuncio")
	private Button boton_eliminar_anuncio;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("hueco_upload")
	private HorizontalLayout hueco_upload;

	/**
     * Creates a new VistaEditaranuncio.
     */
    public VistaEditaranuncio() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEditaranuncio and vista-editaranuncio
     */
    public interface VistaEditaranuncioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public TextField getNombre() {
		return nombre;
	}

	public void setNombre(TextField nombre) {
		this.nombre = nombre;
	}

	public TextField getEnlace_anuncio() {
		return enlace_anuncio;
	}

	public void setEnlace_anuncio(TextField enlace_anuncio) {
		this.enlace_anuncio = enlace_anuncio;
	}

	public TextField getAltura_anuncio() {
		return altura_anuncio;
	}

	public void setAltura_anuncio(TextField altura_anuncio) {
		this.altura_anuncio = altura_anuncio;
	}

	public TextField getAnchura_anuncio() {
		return anchura_anuncio;
	}

	public void setAnchura_anuncio(TextField anchura_anuncio) {
		this.anchura_anuncio = anchura_anuncio;
	}

	public HorizontalLayout getVaadinHorizontalLayout1() {
		return vaadinHorizontalLayout1;
	}

	public void setVaadinHorizontalLayout1(HorizontalLayout vaadinHorizontalLayout1) {
		this.vaadinHorizontalLayout1 = vaadinHorizontalLayout1;
	}

	public HorizontalLayout getVaadinHorizontalLayout() {
		return vaadinHorizontalLayout;
	}

	public void setVaadinHorizontalLayout(HorizontalLayout vaadinHorizontalLayout) {
		this.vaadinHorizontalLayout = vaadinHorizontalLayout;
	}

	public Button getBoton_guardar_anuncio() {
		return boton_guardar_anuncio;
	}

	public void setBoton_guardar_anuncio(Button boton_guardar_anuncio) {
		this.boton_guardar_anuncio = boton_guardar_anuncio;
	}

	public Button getBoton_eliminar_anuncio() {
		return boton_eliminar_anuncio;
	}

	public void setBoton_eliminar_anuncio(Button boton_eliminar_anuncio) {
		this.boton_eliminar_anuncio = boton_eliminar_anuncio;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getHueco_upload() {
		return hueco_upload;
	}

	public void setHueco_upload(HorizontalLayout hueco_upload) {
		this.hueco_upload = hueco_upload;
	}

}
