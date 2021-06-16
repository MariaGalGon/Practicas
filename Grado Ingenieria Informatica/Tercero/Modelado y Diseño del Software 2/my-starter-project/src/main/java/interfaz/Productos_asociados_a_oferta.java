package interfaz;

import java.util.ArrayList;

import basedatos.BDPrincipal;
import basedatos.iAdministrador;

public class Productos_asociados_a_oferta extends Productos_asociados {

	public iAdministrador adm = new BDPrincipal();
	Producto_asociado[] pa;
	basedatos.Producto[] asociados;
	int idOferta;

	
	public void eliminar_producto_asociado() {
			
	
			
			ArrayList<Integer> idsSeleccionados = new ArrayList<Integer>();
			
			for(int i = 0; i < pa.length; i++) {
				if(pa[i].getCheckbox().getValue())
					idsSeleccionados.add(asociados[i].getIdProducto());
			}
			
			int[] idsAsociados = new int[idsSeleccionados.size()];
			
			for(int i = 0; i< idsSeleccionados.size(); i++) {
				idsAsociados[i] = idsSeleccionados.get(i);
			}
			
			adm.eliminar_producto_asociado(idsAsociados, idOferta);
			
			
			
		}
}