package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the vista-listaofertascibernauta template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-listaofertascibernauta")
@JsModule("./src/vista-listaofertascibernauta.js")
public class VistaListaofertascibernauta extends PolymerTemplate<VistaListaofertascibernauta.VistaListaofertascibernautaModel> {

    @Id("cabecera_lista_ofertas")
	private HorizontalLayout cabecera_lista_ofertas;
	@Id("titulo_lista_ofertas")
	private H2 titulo_lista_ofertas;
	@Id("lista_ofertas")
	private HorizontalLayout lista_ofertas;

	/**
     * Creates a new VistaListaofertascibernauta.
     */
    public VistaListaofertascibernauta() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaListaofertascibernauta and vista-listaofertascibernauta
     */
    public interface VistaListaofertascibernautaModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCabecera_lista_ofertas() {
		return cabecera_lista_ofertas;
	}

	public void setCabecera_lista_ofertas(HorizontalLayout cabecera_lista_ofertas) {
		this.cabecera_lista_ofertas = cabecera_lista_ofertas;
	}

	public H2 getTitulo_lista_ofertas() {
		return titulo_lista_ofertas;
	}

	public void setTitulo_lista_ofertas(H2 titulo_lista_ofertas) {
		this.titulo_lista_ofertas = titulo_lista_ofertas;
	}


	public HorizontalLayout getLista_ofertas() {
		return lista_ofertas;
	}

	public void setLista_ofertas(HorizontalLayout lista_ofertas) {
		this.lista_ofertas = lista_ofertas;
	}


}
