package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaAnuncio;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-listaanuncios template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaanuncios")
@JsModule("./src/vista-listaanuncios.js")
public class VistaListaanuncios extends PolymerTemplate<VistaListaanuncios.VistaListaanunciosModel> {

    @Id("lista_anuncios")
	private Element lista_anuncios;
	@Id("boton_aniadir_anuncio")
	private Button boton_aniadir_anuncio;
	@Id("vaadinListBox")
	private Element vaadinListBox;

	/**
     * Creates a new VistaListaanuncios.
     */
    public VistaListaanuncios() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaanuncios and vista-listaanuncios
     */
    public interface VistaListaanunciosModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Element getLista_anuncios() {
		return lista_anuncios;
	}

	public void setLista_anuncios(Element lista_anuncios) {
		this.lista_anuncios = lista_anuncios;
	}

	public Button getBoton_aniadir_anuncio() {
		return boton_aniadir_anuncio;
	}

	public void setBoton_aniadir_anuncio(Button boton_aniadir_anuncio) {
		this.boton_aniadir_anuncio = boton_aniadir_anuncio;
	}

	public Element getVaadinListBox() {
		return vaadinListBox;
	}

	public void setVaadinListBox(Element vaadinListBox) {
		this.vaadinListBox = vaadinListBox;
	}
	
	
}
