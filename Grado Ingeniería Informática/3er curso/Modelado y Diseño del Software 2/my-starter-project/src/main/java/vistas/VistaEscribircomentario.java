package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Image;

/**
 * A Designer generated component for the vista-escribircomentario template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-escribircomentario")
@JsModule("./src/vista-escribircomentario.js")
public class VistaEscribircomentario extends PolymerTemplate<VistaEscribircomentario.VistaEscribircomentarioModel> {

    @Id("area_texto_comentario")
	private TextArea area_texto_comentario;
	@Id("boton_publicar")
	private Button boton_publicar;
	@Id("valoracion_comentario")
	private HorizontalLayout valoracion_comentario;
	@Id("contador_valoracion")
	private Label contador_valoracion;
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

	/**
     * Creates a new VistaEscribircomentario.
     */
    public VistaEscribircomentario() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between VistaEscribircomentario and vista-escribircomentario
     */
    public interface VistaEscribircomentarioModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public TextArea getArea_texto_comentario() {
		return area_texto_comentario;
	}

	public void setArea_texto_comentario(TextArea area_texto_comentario) {
		this.area_texto_comentario = area_texto_comentario;
	}

	public Button getBoton_publicar() {
		return boton_publicar;
	}

	public void setBoton_publicar(Button boton_publicar) {
		this.boton_publicar = boton_publicar;
	}

	public HorizontalLayout getValoracion_comentario() {
		return valoracion_comentario;
	}

	public void setValoracion_comentario(HorizontalLayout valoracion_comentario) {
		this.valoracion_comentario = valoracion_comentario;
	}

	public Label getContador_valoracion() {
		return contador_valoracion;
	}

	public void setContador_valoracion(Label contador_valoracion) {
		this.contador_valoracion = contador_valoracion;
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
}
