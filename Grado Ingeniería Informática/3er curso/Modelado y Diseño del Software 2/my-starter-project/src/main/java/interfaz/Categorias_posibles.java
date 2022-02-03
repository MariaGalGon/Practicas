package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.listbox.ListBox;

import vistas.VistaListacategoriasposibles;

public class Categorias_posibles extends VistaListacategoriasposibles{
	public ListBox<Categoria_producto> lista = this.getLista_categoria_posible().as(ListBox.class);
}