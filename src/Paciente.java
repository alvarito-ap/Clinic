import java.util.ArrayList;

public class Paciente {
	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	private Historial historial;
	private Calendario calendario;
	
	private Conector conector;
	private Object[][] ob;
	private String[][] resultados;


	public Paciente(String nombre, String correo, String telefono, String direccion, Calendario calendario ) {
		this.nombre=nombre;
		this.correo=correo;
		this.telefono=telefono;
		this.direccion=direccion;
		this.calendario = calendario;
		historial = new Historial(nombre);
		conector = new Conector();
	}
	
	public String consultarHorarios() {
		
		return calendario.obtenerCitasPaciente(nombre);
		
	}
	public void solicitarConsulta(String nombreMedico, String nombrePaceinte, String fecha, String hora) {
		calendario.añadirCita(nombreMedico, nombrePaceinte, fecha, hora);
	}
	
	public void cancelarConsulta(String nombreMedico, String nombrePaciente, String fecha, String hora) {
		calendario.cancelarCita(nombreMedico,nombrePaciente,fecha,hora);
	}
	public void actualizaHistorial(String registro) {
		this.historial.actualizarRegistro(registro);
		
	}
	public String getDireccion() {
		return this.direccion;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getCorreo() {
		return this.correo;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	public String getRegistro() {
		return historial.getRegistro();
	}
	
}