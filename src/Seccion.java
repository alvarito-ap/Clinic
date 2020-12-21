import java.util.ArrayList;

public class Seccion {
	private String nombre;
	private int total;
	private ArrayList<Articulo> articulos;
	
	public Seccion(String nombre) {
		this.nombre = nombre;
	}
	
	public Seccion(String nombre, ArrayList<Articulo> articulos) {
		this.nombre = nombre;
		this.articulos = articulos;
		this.setTotal(articulos.size());
	}
	
	public void añadirArticulos(Articulo articulo){
		if(articuloRepetido(articulo)==false) {
			articulos.add(articulo);
		}
	}
	
	public void eliminarArticulo(Articulo articulo) {
		
	}
	
	public void actualizarArticulo() {
		
	}
	
	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	
	public boolean equals (Seccion seccion) {
		if(this.nombre==seccion.nombre) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean articuloRepetido(Articulo articulo) {
		for(int i = 0; i < articulos.size(); i++) {
			if(articulos.get(i).equals(articulo)==true) {
				return true;
			}
		}
		return false;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
