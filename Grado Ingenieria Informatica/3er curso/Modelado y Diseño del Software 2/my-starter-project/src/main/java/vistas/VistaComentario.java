package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-comentario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-comentario")
@JsModule("./src/vista-comentario.js")
public class VistaComentario extends PolymerTemplate<VistaComentario.VistaComentarioModel> {

    @Id("cuadro_info_comentario")
	private HorizontalLayout cuadro_info_comentario;
	@Id("icono_perfil_comentario")
	private Image icono_perfil_comentario;
	@Id("nombre_usuario_comentario")
	private Label nombre_usuario_comentario;
	@Id("contador_valoracion")
	private Paragraph contador_valoracion;
	@Id("texto_comentario")
	private Paragraph texto_comentario;
	@Id("cuadro_comentario")
	private Element cuadro_comentario;

	/**
     * Creates a new VistaComentario.
     */
    public VistaComentario() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaComentario and vista-comentario
     */
    public interface VistaComentarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public HorizontalLayout getCuadro_info_comentario() {
		return cuadro_info_comentario;
	}

	public void setCuadro_info_comentario(HorizontalLayout cuadro_info_comentario) {
		this.cuadro_info_comentario = cuadro_info_comentario;
	}

	public Image getIcono_perfil_comentario() {
		return icono_perfil_comentario;
	}

	public void setIcono_perfil_comentario(Image icono_perfil_comentario) {
		this.icono_perfil_comentario = icono_perfil_comentario;
	}

	public Label getNombre_usuario_comentario() {
		return nombre_usuario_comentario;
	}

	public void setNombre_usuario_comentario(Label nombre_usuario_comentario) {
		this.nombre_usuario_comentario = nombre_usuario_comentario;
	}

	public Paragraph getContador_valoracion() {
		return contador_valoracion;
	}

	public void setContador_valoracion(Paragraph contador_valoracion) {
		this.contador_valoracion = contador_valoracion;
	}

	public Paragraph getTexto_comentario() {
		return texto_comentario;
	}

	public void setTexto_comentario(Paragraph texto_comentario) {
		this.texto_comentario = texto_comentario;
	}

	public Element getCuadro_comentario() {
		return cuadro_comentario;
	}

	public void setCuadro_comentario(Element cuadro_comentario) {
		this.cuadro_comentario = cuadro_comentario;
	}
}
