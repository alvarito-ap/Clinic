import java.util.ArrayList;

public class Secretario {
	private String nombre;
	private String direccion;
	private String telefono;
	private int sueldo;
	private Calendario calenSe;
	private Almacen almacen;

	public Secretario(String nombre, String direccion, String telefono, int sueldo, int idCalendario) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.calenSe = new Calendario(idCalendario);
	}

	public String consultarHorarios(String nombrePaciente) {
		return calenSe.obtenerCitasPaciente(nombrePaciente);
	}
	
	public void asignarCita(String nombreMedico, String nombrePaciente, String fecha, String hora) {
		calenSe.añadirCita(nombreMedico, nombrePaciente,fecha,hora );
	}
	
	
	public void cancelarCita(String nombreMedico, String nombrePaciente, String fecha, String hora) {
		calenSe.cancelarCita(nombreMedico, nombrePaciente, fecha, hora);
	}
	
	public void registroPaciente(String nombrePaciente, String telefono, String direccion, String correo, String password) {
		//habria que insertar un nuevo paciente en la base de datos
		Conector conector = new Conector();
		conector.insertar("INSERT INTO `Paciente`(`nombrePaciente`,`telefono`,`direccion`,`correo`,`nombreClinica`,`idCalendario`,`password`) VALUES ('"+nombrePaciente+"','"+telefono+"','"+direccion+"','"+correo+"',"
				+ "'Albar','1','"+password+"')");
		conector.insertar("INSERT INTO `HistorialIntervenciones`(`nombrePaciente`, `intervenciones`) VALUES ('"+nombrePaciente+"', ' ')");
	}
	
	public void actualizarInventario() {

	}
	
	public String consultarHistorial(Paciente paciente) {
		return paciente.getRegistro();
	}
	
	public String getInfo() {
		nombre.concat(" ");
		nombre.concat(direccion);
		nombre.concat(" ");
		nombre.concat(telefono);
		return nombre;
	}
	
	public int getSueldo() {
		return sueldo;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public String getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}
	
	public String getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}

	

}
