package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;
import imagenes.Uploader;
import vistas.VistaGestionaranuncios;

public class Gestionar_anuncios extends VistaGestionaranuncios{


	public Editar_anuncio editar;
	public Anuncios lista;
	public VerticalLayout layoutEditar;
	public VerticalLayout layoutLista;
	int id = -1;
	iAdministrador adm = new BDPrincipal();
	basedatos.Anuncio[] bdAnuncios;
	Anuncio[] anuncioInterfaz;
	String foto;

	public Gestionar_anuncios() {
		inicializar();
	}

	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		this.getImagen_vista().setSrc("/img/banner.png");
		this.getImagen_vista().setHeight("40.5em");
		id = -1;
		foto = "";
		layoutEditar = this.getLayout_editar().as(VerticalLayout.class);
		layoutLista = this.getLayout_lista().as(VerticalLayout.class);

		editar = new Editar_anuncio();
		lista = new Anuncios();

		layoutLista.removeAll();
		layoutEditar.removeAll();
		layoutLista.add(lista);
		layoutEditar.add(editar);
		cargar_anuncios();
		upload();
	}

	public boolean comprobar_campos() {
		//Falta foto
		if(editar.getNombre().getValue().equals("") || editar.getEnlace_anuncio().getValue().equals("") || editar.getAnchura_anuncio().getValue().equals("") || editar.getAltura_anuncio().getValue().equals("")) {
			Notification.show("Rellene todos los campos.");
			return false;
		}
		return true;
	}

	public void guardar_anuncio() {

		adm.guardar_anuncio(editar.getNombre().getValue(), editar.getEnlace_anuncio().getValue(), Integer.parseInt(editar.getAltura_anuncio().getValue()), Integer.parseInt( editar.getAnchura_anuncio().getValue()), foto, id);
		cargar_anuncios();
	}

	public void cargar_anuncios() {
		bdAnuncios = adm.cargar_anuncios();
		anuncioInterfaz = new Anuncio[bdAnuncios.length];

		ListBox<Anuncio> listaPares = lista.getVaadinListBox().as(ListBox.class);
		listaPares.removeAll();

		for(int i = 0; i< bdAnuncios.length; i++) {
			anuncioInterfaz[i] = new Anuncio();
			anuncioInterfaz[i].getNombre_par_anuncio().setText((bdAnuncios[i].getNombre()));
			basedatos.Anuncio anuncioLocal = bdAnuncios[i];
			anuncioInterfaz[i].getBoton_editar_anuncio().addClickListener(new ComponentEventListener(){
				@Override
				public void onComponentEvent(ComponentEvent event) {

					cargar_anuncio(anuncioLocal);
				}
			});		

			listaPares.add(anuncioInterfaz[i]);
		}
	}

	public void cargar_anuncio(basedatos.Anuncio anuncioLocal) {
		id =anuncioLocal.getID();

		editar.getNombre().setValue(anuncioLocal.getNombre());
		editar.getEnlace_anuncio().setValue(anuncioLocal.getEnlace());
		editar.getAltura_anuncio().setValue(Integer.toString(anuncioLocal.getAltura()));
		editar.getAnchura_anuncio().setValue(Integer.toString(anuncioLocal.getAnchura()));
		foto = "";
		foto = anuncioLocal.getImagen();
		actualizar_foto();
	}

	public void eliminar_anuncio() {
		adm.eliminar_anuncio(id);
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
			
				String foto1 ="https://i.imgur.com/"+ Uploader.upload(targetFile).subSequence(15, 22)+".png";
				foto = foto1;
				actualizar_foto();
		});
		upload.addFileRejectedListener(event -> {
			Paragraph component = new Paragraph();
			showOutput(event.getErrorMessage(), component, output);
		});
		upload.getElement().addEventListener("file-remove", event -> {
			output.removeAll();
		});
		
		editar.getHueco_upload().removeAll();
		editar.getHueco_upload().add(upload, output);

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
	
	public void actualizar_foto() {
		if(!foto.equals("")) {
			this.getImagen_vista().setSrc(foto);
			this.getImagen_vista().setHeight("40.5em");
		}else {
			this.getImagen_vista().setSrc("/img/banner.png");
			this.getImagen_vista().setHeight("40.5em");
		}
	}
}