package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
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
import vistas.VistaEditartrabajador;

public class Editar_trabajador extends VistaEditartrabajador{

	
	int id;
	iAdministrador adm = new BDPrincipal();
	String foto= "/img/perfil2.png";
	basedatos.Usuario bdUsuario;
	


	public Editar_trabajador() {
		inicializar();
	}
	
	public void inicializar() {
		this.getLogo().setSrc("/img/logo.png");
		this.getLogo().setHeight("2.5em");
		this.getPuesto().setVisible(false);
		this.getVaadinButton1().setVisible(false); //generar contrasenia
		actualizar_foto();
		upload();
	}
	
	public void trabajador_nuevo() {
		id = -1;
		this.getPuestoDeTrabajo().setVisible(true);
		this.getPuesto().setVisible(false);
		this.getVaadinButton1().setVisible(false); //generar contrasenia
		this.getIdentificador().setVisible(false);
		List<String> combobox = new ArrayList<String>();
		combobox.add("Encargado de compras");
		combobox.add("Repartidor");
		this.getPuestoDeTrabajo().setItems(combobox);
		
	}
	
	public boolean comprobar_campos() {
		if(this.getApellidos().getValue().equals("") || this.getNombre().getValue().equals("") || this.getCorreo().getValue().equals("") || (this.getPuestoDeTrabajo().getValue() == null && id == -1)) {
			Notification.show("Rellene todos los campos.");
			return false;
		}
		
		if (id == -1){
			if(this.getPuestoDeTrabajo().getValue().equals("Repartidor")){
				id = -3;
			}else if(this.getPuestoDeTrabajo().getValue().equals("Encargado de compras")) {
				id = -2;
			}
		}
		
		
		
		return true;
		
	}
	
	public void guardar_trabajador() {
		
		adm.guardar_trabajador(this.getNombre().getValue(), this.getApellidos().getValue(), this.getCorreo().getValue(), Integer.toString(id), foto);
	}
	
	public void cargar_trabajador() {
		this.getPuestoDeTrabajo().setVisible(false);
		
		this.getNombre().setValue(bdUsuario.getNombre());
		this.getApellidos().setValue(bdUsuario.getApellidos());
		this.getCorreo().setValue(bdUsuario.getCorreo());
		this.getIdentificador().setValue(Integer.toString(bdUsuario.getIdUsuario()));
		id = bdUsuario.getIdUsuario();
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

	public void actualizar_foto() {
		if(foto.equals("Foto")) {
			foto= "/img/perfil2.png";
		}
		
		
		this.getImagen_trabajador().setSrc(foto);
		this.getImagen_trabajador().setHeight("8em");

	}
	
}