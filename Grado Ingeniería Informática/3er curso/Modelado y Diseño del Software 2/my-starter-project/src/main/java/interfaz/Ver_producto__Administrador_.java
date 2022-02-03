package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import imagenes.Uploader;

public class Ver_producto__Administrador_ extends Ver_producto {


	iAdministrador adm = new BDPrincipal();
	public VerticalLayout layout;
	public VerticalLayout contenido_tabs = this.getContenido_tabs().as(VerticalLayout.class);
	Ver_informacion__Administrador_ info = new Ver_informacion__Administrador_();	
	Ver_caracteristicas__Administrador_ caracteristica = new Ver_caracteristicas__Administrador_();
	Categorias_producto categorias = new Categorias_producto();
	Aniadir_categoria_producto aniadirCategoria;
	int id;
	basedatos.Producto p;
	Categoria_producto[] categoriaInterfaz;
	int[] idsCat;
	int[] idsCat_guardar;
	ArrayList<String> fotos;
	Imagenes lista_imagenes;
	basedatos.Foto[] fotosCargadas;

	public Ver_producto__Administrador_() {
		inicializar();
	}


	public void inicializar(){
		this.getContador_valoracion().setVisible(false);
		this.getBoton_carrito().setVisible(false);
		this.getContador_carrito().setVisible(false);
		this.getNombre_producto_cibernauta().setVisible(false);
		this.getPrecio().setVisible(false);
		this.getBoton_aniadir_carrito().setVisible(false);
		this.getDesp_derch().setVisible(false);
		this.getDesp_izq().setVisible(false);

		aniadirCategoria = new Aniadir_categoria_producto();
		fotos = new ArrayList<String>();

		lista_imagenes = new Imagenes();
		this.getHueco_lista_imagagenes().add(lista_imagenes);
		layout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		tabs();
		upload();
	}

	private void tabs() {
		VerticalLayout layout_tabs = this.getLayout_tabs().as(VerticalLayout.class);

		layout_tabs.removeAll();
		contenido_tabs.removeAll();
		contenido_tabs.add(info);

		Tab tab1 = new Tab("Informacion");
		tab1.setSelected(true);

		Tab tab2 = new Tab("Caracteristicas");

		Tab tab3 = new Tab("Categorias");

		Tabs tabs = new Tabs(true, tab1, tab2, tab3);

		tabs.addSelectedChangeListener(event -> {
			String seleccion = event.getSelectedTab().getLabel();

			if(seleccion.equals("Informacion")) {
				contenido_tabs.add(info);
				contenido_tabs.remove(caracteristica);
				contenido_tabs.remove(categorias);
			}else if(seleccion.equals("Caracteristicas")) {
				contenido_tabs.remove(info);
				contenido_tabs.add(caracteristica);
				contenido_tabs.remove(categorias);
			}else if(seleccion.equals("Categorias")) {
				contenido_tabs.remove(info);
				contenido_tabs.remove(caracteristica);
				contenido_tabs.add(categorias);
				mostrar_categorias();
			}

		});


		layout_tabs.add(tabs);	
	}



	public void cat_aniadida() { //Si hemos aniadido categorias nuevas
		idsCat_guardar = new int[aniadirCategoria.idsSeleccionados.size()]; 
		for(int i = 0; i<aniadirCategoria.idsSeleccionados.size(); i++) {
			idsCat_guardar[i] = aniadirCategoria.idsSeleccionados.get(i);
		}

		guardar();
	}

	public void cat_eliminada() { //Si hemos eliminado categorias
		ArrayList<Integer> idsEliminar = new ArrayList<Integer>();
		for(int i= 0; i < categoriaInterfaz.length; i++) {
			if(categoriaInterfaz[i].getCheckbox_categoria_producto().getValue()) {
				idsEliminar.add(idsCat[i]);
			}
		}

		idsCat_guardar = new int[idsEliminar.size()]; 
		for(int i = 0; i<idsEliminar.size(); i++) {
			idsCat_guardar[i] = -idsEliminar.get(i); //- para indicar que se deben eliminar
		}

		guardar();
	}

	public void guardar() {
		double precio = Double.parseDouble(this.getPrecio_admin().getValue());

		String[] fotosArray = new String[fotos.size()];
		for(int i = 0; i < fotos.size(); i++) {
			fotosArray[i] = fotos.get(i);
		}



		adm.guardar_producto(fotosArray, precio, this.getNombre_producto_admin().getValue(), info.getInfo().getValue(), caracteristica.getCaracteristicas().getValue(), idsCat_guardar, id);
		cargar_producto();
		tabs();
	}

	public void cargar_producto() {
		if(id == -1)
			return;
		
		p = adm.cargar_producto(id);

		this.info.getInfo().setValue(p.getInformacion());

		this.caracteristica.getCaracteristicas().setValue(p.getDescripcion());
		this.getPrecio_admin().setValue(Double.toString(p.getPrecio()));
		this.getNombre_producto_admin().setValue(p.getNombre());

		fotosCargadas = p.fotos.toArray();

		actualizar_imagenes();
		valoracion_media();

	}

	public void mostrar_categorias() {
		if(p == null) {
			return;
		}
		ListBox<Categoria> lista = categorias.getLista_categorias_producto().as(ListBox.class);
		basedatos.Categoria[] arrayCat = p.pertenece_a_categoria.toArray();
		categoriaInterfaz = new Categoria_producto[arrayCat.length];
		idsCat = new int[arrayCat.length];

		lista.removeAll();
		for(int i = 0; i<arrayCat.length; i++) {
			categoriaInterfaz[i] = new Categoria_producto();
			categoriaInterfaz[i].getCheckbox_categoria_producto().setLabel(arrayCat[i].getNombe());


			idsCat[i] = arrayCat[i].getIdCategoria();

			lista.add(categoriaInterfaz[i]);
		}
	}

	public void eliminar_producto_catalogo() {
		adm.eliminar_producto_catalogo(id);
	}

	public void upload() {
		MemoryBuffer buffer = new MemoryBuffer();
		Upload upload = new Upload(buffer);

		upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");
		Div output = new Div();

		upload.addSucceededListener(event -> {
			//  Component component = createComponent(event.getMIMEType(), event.getFileName(), buffer.getInputStream());
			File targetFile = new File("src/main/resources/targetFile.tmp");
			try {
				FileUtils.copyInputStreamToFile(buffer.getInputStream(), targetFile);
				//	FileUtils.copyInputStramtoFile(buffer.)
			}catch(IOException e) {
				e.printStackTrace();
			}
			//  showOutput(event.getFileName(), component, output);
			if(fotosCargadas != null && fotosCargadas.length + fotos.size() == 5) {
				Notification.show("Limite de 5 imagenes.");
			}else {
				String foto1 ="https://i.imgur.com/"+ Uploader.upload(targetFile).subSequence(15, 22)+".png";
				fotos.add(foto1);
				actualizar_imagenes();
			}
			
		});
		upload.addFileRejectedListener(event -> {
			Paragraph component = new Paragraph();
			showOutput(event.getErrorMessage(), component, output);
		});
		upload.getElement().addEventListener("file-remove", event -> {
			output.removeAll();
		});

		this.getHueco_upload().removeAll();
		this.getHueco_upload().add(upload, output);
	}

	private Component createComponent(String mimeType, String fileName,
			InputStream stream) {
		if (mimeType.startsWith("text")) {
			return createTextComponent(stream);
		} else if (mimeType.startsWith("image")) {
			Image image = new Image();
			try {

				byte[] bytes = IOUtils.toByteArray(stream);
				image.getElement().setAttribute("src", new StreamResource(
						fileName, () -> new ByteArrayInputStream(bytes)));
				try (ImageInputStream in = ImageIO.createImageInputStream(
						new ByteArrayInputStream(bytes))) {
					final Iterator<ImageReader> readers = ImageIO
							.getImageReaders(in);
					if (readers.hasNext()) {
						ImageReader reader = readers.next();
						try {
							reader.setInput(in);
							image.setWidth(reader.getWidth(0) + "px");
							image.setHeight(reader.getHeight(0) + "px");
						} finally {
							reader.dispose();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.setSizeFull();
			return image;
		}
		Div content = new Div();
		String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'",
				mimeType, MessageDigestUtil.sha256(stream.toString()));
		content.setText(text);
		return content;

	}
	private Component createTextComponent(InputStream stream) {
		String text;
		try {
			text = IOUtils.toString(stream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			text = "exception reading stream";
		}
		return new Text(text);
	}
	private void showOutput(String text, Component content,
			HasComponents outputContainer) {
		HtmlComponent p = new HtmlComponent(Tag.P);
		p.getElement().setText(text);
		outputContainer.add(p);
		outputContainer.add(content);
	}

	private void actualizar_imagenes() {
		lista_imagenes.getCuadro_imagenes().removeAll();
		if(fotosCargadas != null) {
			if(fotosCargadas.length > 0) {
				this.getFoto_producto().setSrc(fotosCargadas[0].getDireccion());
				if(fotosCargadas.length>=2) {
					for(int i = 1; i< fotosCargadas.length; i++) {
						Image image = new Image(fotosCargadas[i].getDireccion(), "");
						image.setHeight("2.5em");
						lista_imagenes.getCuadro_imagenes().add(image);
					}
				}
			}
		}
		
		
		if(fotos.size() > 0) {
			if(fotosCargadas == null) {
				this.getFoto_producto().setSrc(fotos.get(0));
			}else {
				for(int i = 1; i< fotos.size(); i++) {
					Image image = new Image(fotos.get(i), "");
					image.setHeight("2.5em");
					lista_imagenes.getCuadro_imagenes().add(image);
				}
			}
		}


	}
	
public void valoracion_media() {
		
		int suma = 0;
		for(int i = 0; i< p.comentarios.size(); i++) {
			suma += p.comentarios.toArray()[i].getValoracion();
		}
		
		double media = (double)suma/ p.comentarios.size();
		this.getContador_valoracion().setVisible(false);
		if(media <= 1) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_vacia.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_vacia.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_vacia.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 2) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_vacia.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_vacia.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 3) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_llena.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_vacia.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 4) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_llena.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_llena.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_vacia.png");
			getEstrella_5().setHeight("2.5em");
		}else if(media <= 5) {
			getEstrella_1().setSrc("/img/estrella_llena.png");
			getEstrella_1().setHeight("2.5em");
			getEstrella_2().setSrc("/img/estrella_llena.png");
			getEstrella_2().setHeight("2.5em");
			getEstrella_3().setSrc("/img/estrella_llena.png");
			getEstrella_3().setHeight("2.5em");
			getEstrella_4().setSrc("/img/estrella_llena.png");
			getEstrella_4().setHeight("2.5em");
			getEstrella_5().setSrc("/img/estrella_llena.png");
			getEstrella_5().setHeight("2.5em");
		}
	}

public boolean comprobar_campos() {
	if(this.getNombre_producto_admin().getValue().equals("") || info.getInfo().getValue().equals("") || caracteristica.getCaracteristicas().getValue().equals("") ) {
		Notification.show("Rellene todos los campos.");
		return false;
	}
	return true;
}

}