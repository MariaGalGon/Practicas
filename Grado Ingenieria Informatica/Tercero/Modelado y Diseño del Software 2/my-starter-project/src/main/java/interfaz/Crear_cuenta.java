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
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;

import basedatos.BDPrincipal;
import basedatos.iCibernauta_no_identificado;
import imagenes.Uploader;
import vistas.VistaCrearcuenta;

public class Crear_cuenta extends VistaCrearcuenta{

	
	private iCibernauta_no_identificado cibernauta = new BDPrincipal();
	public boolean correcto;
	String foto = "Foto";
	
	public Crear_cuenta() {
		upload();
	}
	
	public void registrarse() {
		correcto = !(this.getContrasenia().isEmpty());
		if(!correcto) {
			Notification.show("Introduzca una contraseña");
			return;
		}
		correcto = this.getContrasenia().getValue().equals(this.getConfirma_cont().getValue());
		if(!correcto) {
			Notification.show("La contraseña es distinta de su confirmacion. Estas deben ser iguales");
			return;
		}
		
		String[] datos = new String[8];
		datos[0] = this.getUsuario().getValue();
		datos[1] = this.getCorreo().getValue();
		datos[2] = this.getContrasenia().getValue();
		datos[3] = this.getNombre().getValue();
		datos[4] = this.getApellidos().getValue();
		datos[5] = this.getDireccion().getValue();
		datos[6] = this.getCuenta().getValue();
		datos[7] = foto;
		
		correcto = cibernauta.registrarse(datos);
		
		if(correcto) {
			Notification.show("Cuenta creada");
		} else {
			Notification.show("Hubo un problema. Cuenta no creada");
		}
	}
	
	public boolean comprobar_campos() {
		if(this.getUsuario().getValue().equals("") || this.getNombre().getValue().equals("") || this.getCorreo().getValue().equals("") 
				|| this.getApellidos().getValue().equals("") || this.getDireccion().getValue().equals("") || this.getCuenta().getValue().equals("")) {
			Notification.show("Rellene todos los campos.");
			return false;
		}
		
		
		return true;
		
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
				actualizar_foto(foto1);
		});
		upload.addFileRejectedListener(event -> {
			Paragraph component = new Paragraph();
			showOutput(event.getErrorMessage(), component, output);
		});
		upload.getElement().addEventListener("file-remove", event -> {
			output.removeAll();
		});

		this.getHueco().removeAll();
		this.getHueco().add(upload, output);

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

	public void actualizar_foto(String foto) {
		
		this.foto = foto;
		this.getFoto().setSrc(foto);
		this.getFoto().setHeight("8em");

	}
}