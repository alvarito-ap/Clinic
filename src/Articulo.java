
public class Articulo {
	
	private String nombre;
	private int cantidad;
	private int cantidadMinima;
	private double precio;
	
	public Articulo(String nombre, int cantidad, int cantidadMinima, double precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.setCantidadMinima(cantidadMinima);
		this.setPrecio(precio);
	}
	
	public void modificarCantidad(int actualizar) {
			cantidad = cantidad + actualizar;
	}
	
	public boolean equals(Articulo articulo) {
		if(this.nombre == articulo.nombre) {
			return true;
		}else {
			return false;
		}
	}

	public int getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(int cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
