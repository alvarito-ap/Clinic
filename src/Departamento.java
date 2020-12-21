import java.util.ArrayList;

public class Departamento {

	
	private String nombre;
	private int localizacion;
	public ArrayList<Sala> salas;
	public ArrayList<Habitacion> habitaciones;
	public ArrayList<Medico> medicos;
	
	public Departamento(String nombre, int localizacion) {
		this.setNombre(nombre);
		this.setLocalizacion(localizacion);
		this.salas = new ArrayList<Sala>();
		this.habitaciones = new ArrayList<Habitacion>();
		this.medicos = new ArrayList<Medico>();
	}
	
	public Departamento(String nombre, int localizacion, ArrayList<Sala> salas, ArrayList<Habitacion> habitaciones, ArrayList<Medico> medicos) {
		this.setNombre(nombre);
		this.setLocalizacion(localizacion);
		this.salas = salas;
		this.habitaciones = habitaciones;
		this.medicos = medicos;
	}
	
	public void añadirMedico(Medico medico) {
		if(estaM(medico)==false) {
			medicos.add(medico);
		}
	}
	
	private boolean estaM(Medico medico) {
		for (int i = 0; i < medicos.size(); i++) {
			if(medicos.get(i).equals(medico)==true) {
				return true;
			}
		}
		return false;
	}

	public void añadirSala(Sala sala) {
		if(estaS(sala)==false) {
			salas.add(sala);
		}
	}
	
	private boolean estaS(Sala sala) {
		for (int i = 0; i < salas.size(); i++) {
			if(salas.get(i).equals(sala)==true) {
				return true;
			}
		}
		return false;
	}

	public void añadirHabitacion(Habitacion habitacion) {
		if(estaH(habitacion)==false) {
			habitaciones.add(habitacion);
		}
	}

	private boolean estaH(Habitacion habitacion) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if(habitaciones.get(i).equals(habitacion)==true) {
				return true;
			}
		}
		return false;
	}
	
	
	public void eliminarH(Habitacion eliminar) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if(habitaciones.get(i).equals(eliminar)==true) {
				habitaciones.remove(i);
				break;
			}
		}
	}
	
	
	public void eliminarM(Medico eliminar) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if(medicos.get(i).equals(eliminar)==true) {
				medicos.remove(i);
				break;
			}
		}
	}
	
	
	public void eliminarS(Sala eliminar) {
		for (int i = 0; i < salas.size(); i++) {
			if(salas.get(i).equals(eliminar)==true) {
				medicos.remove(i);
				break;
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(int localizacion) {
		this.localizacion = localizacion;
	}
	
	
	
	
}
