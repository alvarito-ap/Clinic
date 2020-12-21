import java.util.ArrayList;

public class Almacen {
	private int localizacion;
	private ArrayList<Seccion> secciones;
	
	public Almacen (int localizacion) {
		this.setLocalizacion(localizacion);
	}
	
	public Almacen (int localizacion, ArrayList<Seccion> secciones) {
		this.setLocalizacion(localizacion);
		this.secciones = secciones;
	}
	
	public void añadirSeccion(Seccion seccion) {
		secciones.add(seccion);
	}
	
	public void eliminarSeccion(Seccion seccion) {
		for(int i=0;i<secciones.size();i++) {
			if(secciones.get(i).equals(seccion)==true){
				secciones.remove(secciones.get(i));
				break;
			}
		}
	}
	
	@SuppressWarnings("null")
	public ArrayList<Articulo> getArticulos(){
		ArrayList<Articulo> articulos = null;
		for (int i = 0; i < secciones.size(); i++) {
			if(secciones.get(i).getArticulos().size()>0) {
				articulos.addAll(secciones.get(i).getArticulos());
			}
		}
		return articulos;
	}
	
	public ArrayList<Articulo> getArticuloSeccion(Seccion seccion){
	
		ArrayList<Articulo> articulos = null;
		for(int i=0; i<secciones.size(); i++) {
			if(secciones.get(i).equals(seccion)==true) {
				articulos = secciones.get(i).getArticulos();
				break;
			}
		}
		return articulos;
	}

	public int getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(int localizacion) {
		this.localizacion = localizacion;
	}


}
