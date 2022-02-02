package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import vistas.VistaListacomentarios;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-vercomentariosgeneral template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-vercomentariosgeneral")
@JsModule("./src/vista-vercomentariosgeneral.js")
public class VistaVercomentariosgeneral extends PolymerTemplate<VistaVercomentariosgeneral.VistaVercomentariosgeneralModel> {

    @Id("boton_escribir_comentario")
	private Button boton_escribir_comentario;
	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("hueco_lista_comentarios")
	private HorizontalLayout hueco_lista_comentarios;

	/**
     * Creates a new VistaVercomentariosgeneral.
     */
    public VistaVercomentariosgeneral() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaVercomentariosgeneral and vista-vercomentariosgeneral
     */
    public interface VistaVercomentariosgeneralModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Button getBoton_escribir_comentario() {
		return boton_escribir_comentario;
	}

	public void setBoton_escribir_comentario(Button boton_escribir_comentario) {
		this.boton_escribir_comentario = boton_escribir_comentario;
	}

	public Element getVaadinVerticalLayout() {
		return vaadinVerticalLayout;
	}

	public void setVaadinVerticalLayout(Element vaadinVerticalLayout) {
		this.vaadinVerticalLayout = vaadinVerticalLayout;
	}

	public HorizontalLayout getHueco_lista_comentarios() {
		return hueco_lista_comentarios;
	}

	public void setHueco_lista_comentarios(HorizontalLayout hueco_lista_comentarios) {
		this.hueco_lista_comentarios = hueco_lista_comentarios;
	}


}
